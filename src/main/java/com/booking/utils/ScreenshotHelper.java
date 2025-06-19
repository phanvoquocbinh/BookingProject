package com.booking.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

// File: utils/ScreenshotUtils.java
public class ScreenshotHelper {

    @Attachment(value = "Page Screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Error Log", type = "text/plain")
    public static String saveLog(String message) {
        return message;
    }
}