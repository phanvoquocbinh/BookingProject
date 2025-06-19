package com.pharmacity.utils;

import com.microsoft.cognitiveservices.speech.*;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.time.Duration;
import java.util.Base64;
import java.util.concurrent.ExecutionException;
import java.util.regex.*;

public class CaptchaHandlingHelper {
    private final SpeechConfig config = SpeechConfig.fromSubscription(
            "Ev9TFy1v0uxAWS1cdVJJlpusmlU9ExDdjWEzd0lPq6B6iOsKDP7YJQQJ99BFACYeBjFXJ3w3AAAYACOGJW71", "eastus");
    private final WebDriver driver;

    public CaptchaHandlingHelper(WebDriver driver) {
        this.driver = driver;
    }

    @Test(description = "Test reCAPTCHA audio functionality")
    public void recaptchaTestAudio() throws ExecutionException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.switchTo().defaultContent();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("awswaf-captcha")));

        int attempts = 0;
        while (attempts < 5) {
            attempts++;
            System.out.println("\n Try it again for : " + attempts + " times");

            Object audioBtn = js.executeScript(
                    "let captcha = document.querySelector('awswaf-captcha');" +
                            "if (!captcha) return null;" +
                            "let shadow = captcha.shadowRoot;" +
                            "if (!shadow) return null;" +
                            "let btn = shadow.querySelector('#amzn-btn-audio-internal');" +
                            "return btn;");

            if (audioBtn != null) {
                js.executeScript("arguments[0].scrollIntoView(true);", audioBtn);
                Thread.sleep(300);
                js.executeScript("arguments[0].click();", audioBtn);
            } else {
                System.out.println("⚠️ Không tìm thấy nút audio CAPTCHA.");
                return;
            }

            Thread.sleep(3000);

            Object playBtn = js.executeScript(
                    "let host = document.querySelector('awswaf-captcha');" +
                            "if (!host) return null;" +
                            "let shadow = host.shadowRoot;" +
                            "if (!shadow) return null;" +
                            "let btn = shadow.querySelector('button.amzn-captcha-audio-play-btn');" +
                            "return btn;");

            if (playBtn != null) {
                js.executeScript("arguments[0].scrollIntoView(true);", playBtn);
                Thread.sleep(300);
                js.executeScript("arguments[0].click();", playBtn);
            }

            String audioUrl = (String) js.executeScript(
                    "let host = document.querySelector('awswaf-captcha');" +
                            "let audio = host?.shadowRoot?.querySelector('audio');" +
                            "return audio?.src;");

            if (audioUrl == null || audioUrl.isEmpty()) {
                System.out.println("Không tìm thấy link audio.");
                return;
            }

            try {
                Path mp3Path = Paths.get("audio_captcha.mp3");
                if (audioUrl.startsWith("data:audio")) {
                    byte[] data = Base64.getDecoder().decode(audioUrl.substring(audioUrl.indexOf(",") + 1));
                    Files.write(mp3Path, data);
                } else {
                    URL url = new URL(audioUrl);
                    Files.copy(url.openStream(), mp3Path, StandardCopyOption.REPLACE_EXISTING);
                }

                Process ffmpeg = new ProcessBuilder("ffmpeg", "-y", "-i", "audio_captcha.mp3",
                        "-ac", "1", "-ar", "16000", "-acodec", "pcm_s16le", "audio_captcha.wav")
                        .inheritIO().start();
                ffmpeg.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                return;
            }

            config.setSpeechRecognitionLanguage("en-US");
            AudioConfig audioInput = AudioConfig.fromWavFileInput("audio_captcha.wav");
            SpeechRecognizer recognizer = new SpeechRecognizer(config, audioInput);

            StringBuilder fullText = new StringBuilder();
            recognizer.recognized.addEventListener((s, e) -> {
                if (e.getResult().getReason() == ResultReason.RecognizedSpeech) {
                    String text = e.getResult().getText();
                    System.out.println("📥 Đoạn: " + text);
                    fullText.append(text).append(" ");
                }
            });

            recognizer.startContinuousRecognitionAsync().get();
            Thread.sleep(10000);
            recognizer.stopContinuousRecognitionAsync().get();

            String rawResult = fullText.toString().trim();
            String recognizedText = extractTextAfterPrompt(rawResult);
            System.out.println("✅ Đã trích: " + recognizedText);

            WebElement inputElement = (WebElement) js.executeScript(
                    "let host = document.querySelector('awswaf-captcha');" +
                            "if (!host || !host.shadowRoot) return null;" +
                            "return host.shadowRoot.querySelector('input[placeholder=\"Answer\"]');");
            if (inputElement != null) {
                inputElement.clear();
                inputElement.sendKeys(recognizedText);
            }
            Thread.sleep(5000);

            Object confirmBtn = js.executeScript(
                    "let host = document.querySelector('awswaf-captcha');" +
                            "if (!host) return null;" +
                            "let shadow = host.shadowRoot;" +
                            "if (!shadow) return null;" +
                            "let btn = shadow.querySelector('button#amzn-btn-verify-internal');" +
                            "return btn;");

            if (confirmBtn != null) {
                js.executeScript("arguments[0].scrollIntoView(true);", confirmBtn);
                Thread.sleep(300);
                js.executeScript("arguments[0].click();", confirmBtn);
            }

            Thread.sleep(3000);

            Boolean hasError = (Boolean) js.executeScript(
                    "let host = document.querySelector('awswaf-captcha');" +
                            "if (!host || !host.shadowRoot) return false;" +
                            "return Array.from(host.shadowRoot.querySelectorAll('div'))" +
                            ".some(el => el.textContent.includes('Incorrect. Please try again.'));");

            if (!hasError) {
                System.out.println("🎉 CAPTCHA passed on attempt " + attempts);
                return;
            } else {
                System.out.println("❌ CAPTCHA failed on attempt " + attempts);
            }
        }

        System.out.println("💥 Đã thử 5 lần nhưng vẫn sai. Dừng lại.");
    }

    private String extractTextAfterPrompt(String fullText) {
        String pattern = "(?i)type one of the two following words spoken by me[\\.:]?\\s+(\\w+)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(fullText);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "";
    }
}
