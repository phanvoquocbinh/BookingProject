package com.pharmacity.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.pharmacity.locators.LoginPageLocator.*;

import com.pharmacity.utils.BrowserHelper;

public class LoginPage {

    // Constructor
    public LoginPage(WebDriver driver) {
    }


    // ------------------- Xử lý
    public void checkPhoneNumberLogic(WebDriver driver, int timeout) {
        BrowserHelper.isDisplayedSuccess(driver, TXT_PHONE_INPUT, 5);

        // 5. Kiểm tra nhập số điện thoại dài quá 10 ký tự
        BrowserHelper.waitAndSendKeyElement(driver, TXT_PHONE_INPUT, "09167419599999", 1);
        BrowserHelper.compareLengthNumberByXpath(driver, TXT_PHONE_INPUT, 10, 1);

        // Check số điện thoại không đúng định dạng
        BrowserHelper.isDisplayedSuccess(driver, BTN_OTP_BACK, timeout);
    }

    public void checkOTPLogic(WebDriver driver, int timeout) {
        for (int i = 1; i <= 3; i++) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
            String minuteText = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TXT_OTP_MINUTES)))
                    .getText();
            String secondText = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TXT_OTP_SECONDS)))
                    .getText();
            int minute = Integer.parseInt(minuteText);
            int second = Integer.parseInt(secondText);
            int totalTime = minute * 60 + second;

            if (totalTime <= 120) {
                BrowserHelper.isDisplayedSuccess(driver, MSG_OTP_EXPIRED, (totalTime + 3));
                BrowserHelper.compareText(driver, MSG_OTP_EXPIRED, "Mã xác thực đã hết hiệu lực", 3);
                BrowserHelper.isDisplayedSuccess(driver, BTN_OTP_RESEND, 1);
                BrowserHelper.waitAndClickElement(driver, BTN_OTP_RESEND, 1);

                boolean timerVisible;
                try {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TXT_OTP_MINUTES)));
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TXT_OTP_SECONDS)));

                    boolean minuteVisible = driver.findElement(By.xpath(TXT_OTP_MINUTES))
                            .isDisplayed();
                    boolean secondVisible = driver.findElement(By.xpath(TXT_OTP_SECONDS))
                            .isDisplayed();
                    timerVisible = minuteVisible && secondVisible;
                } catch (Exception e) {
                    timerVisible = false;
                }

                if (timerVisible) {
                    System.out.println("Đã request OTP lần thứ " + i);
                } else {
                    System.out.println("Tối đa có thể request lần này là: " + i);
                    BrowserHelper.isDisplayedSuccess(driver, FORM_OTP_ERROR, 5);
                    BrowserHelper.compareText(driver, LINK_PHONE_SUPPORT, "18006821", 1);
                    BrowserHelper.isDisplayedSuccess(driver, BTN_ERROR_OK, 1);
                    BrowserHelper.waitAndClickElement(driver, BTN_ERROR_OK, 1);
                    break;
                }
            }
        }
        BrowserHelper.isDisplayedSuccess(driver, FORM_OTP, 1);
        BrowserHelper.waitAndClickElement(driver, BTN_OTP_BACK, 1);
    }

}
