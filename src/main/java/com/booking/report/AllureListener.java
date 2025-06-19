package com.booking.report;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.booking.base.BaseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureListener implements ITestListener {

    // Chụp màn hình và đính kèm vào Allure Report
    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Xử lý khi test fail
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            // Kiểm tra driver tồn tại và đang hoạt động
            if (BaseTest.driver != null) {
                // Chụp màn hình và đính kèm an toàn
                byte[] screenshot = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES);
                Allure.getLifecycle().addAttachment("Screenshot on Failure","image/png","png", screenshot);
            }

            // Ghi thông tin lỗi
            if (result.getThrowable() != null) {
                Allure.addAttachment("Test Error",
                        "text/plain",
                        result.getThrowable().toString());
            }
        } catch (Exception e) {
            Allure.addAttachment("Attachment Error",
                    "text/plain",
                    "Failed to capture screenshot: " + e.getMessage());
        }
    }
}