package com.booking.pages;

import static com.booking.data.CommonData.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.booking.utils.EmailHelper;

public class EmailPage {

    private WebDriver driver;

    // Constructor
    public EmailPage(WebDriver driver) {
        this.driver = driver;
    }

    @Test(description = "Login test using OTP from Gmail")
    public void loginWithEmailOtp() throws Exception {
        Thread.sleep(10000);  // Đợi trang load đầy đủ

        // Lấy mã OTP từ Gmail
        String otp = EmailHelper.fetchOTPFromGmail(EMAIL_USERNAME, EMAIL_PASSWORD);

        if (otp == null || otp.isEmpty()) {
            System.out.println("Cannot get the OTP from the Email.");
            return;
        }

        System.out.println("OTP get from Email: " + otp);

        // Lấy các ô input OTP từ HTML (tìm các ô có name bắt đầu bằng 'code_')
        List<WebElement> otpInputs = driver.findElements(By.cssSelector("input[name^='code_']"));

        // Kiểm tra số lượng ô input
        if (otpInputs.size() < 6) {
            System.out.println("Cannot find the OTP input (checked: " + otpInputs.size() + ").");
            return;
        }

        // Điền từng ký tự OTP vào từng ô input
        char[] digits = otp.toCharArray();
        for (int i = 0; i < digits.length && i < otpInputs.size(); i++) {
            otpInputs.get(i).sendKeys(Character.toString(digits[i]));
        }

        Thread.sleep(1000);

        // Click nút xác nhận
        Object submitBtn = ((JavascriptExecutor) driver).executeScript(
                "let inputs = document.querySelectorAll('button[type=submit]');" +
                        "for (let btn of inputs) {" +
                        "  if (btn.innerText.trim().toLowerCase().includes('verify email')) return btn;" +
                        "}" +
                        "return null;");

        if (submitBtn != null) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
            Thread.sleep(300);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
        } else {
            System.out.println("❌ Không tìm thấy nút Verify email.");
        }
    }
}
