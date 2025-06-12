package com.pharmacity.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

import java.time.Duration;
import java.util.Set;

//import javax.xml.ws.Action;

public class BrowserHelper {

    // --------------------- Hàm sử dụng thường
    public static String removeSpaces(String input) {
        return input.replaceAll("\\s+", "");
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // best practice
            System.out.println("Sleep bị gián đoạn: " + e.getMessage());
        }
    }

    // -----------------------Hàm sử dụng liên quan đến Browser

    public static void closeOldTab(WebDriver driver) {
        String currentTab = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String currentHandle : windowHandles) {
            if (currentHandle.equals(currentTab)) {
                driver.switchTo().window(currentTab);
                driver.close();

            }
        }
    }

    public static void closeOpenNewTab(WebDriver driver) {
        String currentTab = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String currentHandle : windowHandles) {
            if (!currentHandle.equals(currentTab)) {
                driver.switchTo().window(currentHandle);
                driver.close();
            }
        }
    }

    public static void checkURLOpenNewTab(WebDriver driver, String newTab) {
        String currentTab = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String currentHandle : windowHandles) {
            if (!currentHandle.equals(currentTab)) {
                driver.switchTo().window(currentHandle);
                isGetURLSuccess(driver, newTab, 1000);
                System.out.println(driver.getCurrentUrl());
            }
        }
    }

    public static void directToCurrentURL(WebDriver driver) {
        Set<String> currentURLList = driver.getWindowHandles();
        for (String urlNow : currentURLList) {
            if (!urlNow.isEmpty())
                ;
            driver.switchTo().window(urlNow);
        }
    }

    // xuyên-------------------------------------------------

    // private static WebElement waitForElement(WebDriver driver, String
    // xpathLocator, int timeoutInSecond) {
    // WebDriverWait wait = new WebDriverWait(driver,
    // Duration.ofSeconds(timeoutInSecond));
    // return
    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
    // }

    // private static void clickElement(WebElement element) {
    // element.click();
    // }

    private static void handleError(Exception e, int timeoutInSecond) {
        if (e instanceof org.openqa.selenium.TimeoutException) {
            System.err.println("Element not found to click after " + timeoutInSecond + " seconds.");
        } else {
            System.err
                    .println("An error occurred while checking visibility of the element to click: " + e.getMessage());
        }
    }

    // --------- Hàm sử dụng liên quan excel

    private static void updateExcel(ExcelStatus excelStatus, String status, String sheetName, int row, int col) {
        if (excelStatus != null) {
            excelStatus.onStatusUpdate(status);
            ExcelHelper excelHelper = new ExcelHelper(
                    "F:\\automation\\Project\\Pharmacity-Selenium\\TestCase_Automation.xlsx");
            excelHelper.updateCell(row - 1, col - 1, status, sheetName); // <-- chỉnh -1 ở đây
        } else {
            System.out.println("Không cập nhật Excel vì ExcelStatus = null.");
        }
    }

    public interface ExcelStatus {
        void onStatusUpdate(String status);
    }

    // ---------Hàm sử dụng chính

    public static void isGetURLSuccessExcel(WebDriver driver, String url, int timeoutInSecond, String sheetName,
            int row,
            int col,
            ExcelStatus excelStatus) {
        try {
            driver.get(url);
            updateExcel(excelStatus, "PASSED", sheetName, row, col);
        } catch (Exception e) {
            updateExcel(excelStatus, "FAILED", sheetName, row, col);
            handleError(e, timeoutInSecond);
            throw e;
        }
    }

    public static void isGetURLSuccess(WebDriver driver, String url, int timeoutInSecond) {
        try {
            driver.get(url);
        } catch (Exception e) {
            handleError(e, timeoutInSecond);
            throw e;
        }
    }

    public static void isDisplayedSuccessExcel(WebDriver driver, String xpathLocator, int timeoutInSecond,
            String sheetName,
            int row, int col,
            ExcelStatus excelStatus) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
            updateExcel(excelStatus, "PASSED", sheetName, row, col);
        } catch (Exception e) {
            updateExcel(excelStatus, "FAILED", sheetName, row, col);
            handleError(e, timeoutInSecond);
            throw e;
        }
    }
    @Step("Get Locator '{xpathLocator}' ")
    public static void isDisplayedSuccess(WebDriver driver, String xpathLocator, int timeoutInSecond) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
        } catch (Exception e) {
            handleError(e, timeoutInSecond);
            throw e;
        }
    }

    // -----------------------------------------
    public static void waitAndClickElementExcel(WebDriver driver, String xpathLocator, int timeoutInSecond,
            String sheetName,
            int row, int col,
            ExcelStatus excelStatus) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator))).click();
            ;
            updateExcel(excelStatus, "PASSED", sheetName, row, col);
        } catch (Exception e) {
            updateExcel(excelStatus, "FAILED", sheetName, row, col);
            handleError(e, timeoutInSecond);
            throw e;
        }
    }

    public static void waitAndClickElement(WebDriver driver, String xpathLocator, int timeoutInSecond) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator))).click();
        } catch (Exception e) {
            handleError(e, timeoutInSecond);
            throw e;
        }
    }

    // ----------------------------------------------

    public static void waitAndSendKeyElementExcel(WebDriver driver, String xpathLocator, String keyString,
            int timeoutInSecond,
            String sheetName,
            int row, int col,
            ExcelStatus excelStatus) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator))).sendKeys(keyString);
            updateExcel(excelStatus, "PASSED", sheetName, row, col);
        } catch (Exception e) {
            updateExcel(excelStatus, "FAILED", sheetName, row, col);
            handleError(e, timeoutInSecond);
            throw e;
        }
    }

    public static void waitAndSendKeyElement(WebDriver driver, String xpathLocator, String keyString,
            int timeoutInSecond) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator))).sendKeys(keyString);
        } catch (Exception e) {
            handleError(e, timeoutInSecond);
            throw e;
        }
    }
    // --------------------------------------------------------------------------

    public static void waitandHoverElement(WebDriver driver, String xpathLocator,String xpathPopup, int timeoutInSecond) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator))).isDisplayed();
            WebElement element = driver.findElement(By.xpath(xpathLocator));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathPopup))).isDisplayed();

        } catch (Exception e) {
            handleError(e, timeoutInSecond);
            throw e;
        }

    }

    // -------------------------------------------------------------------------

    public static void compareLengthNumberByXpathExcel(WebDriver driver, String xpathLocator, int lengthNumber,
            int timeoutInSecond, String sheetName,
            int row, int col,
            ExcelStatus excelStatus) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
            String phoneString = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)))
                    .getAttribute("value");
            int lengthPhone = removeSpaces(phoneString).length();

            if (lengthPhone != (lengthNumber)) {
                throw new AssertionError("So sánh text thất bại! Actual: '" + removeSpaces(phoneString)
                        + "', Expected: '" + lengthNumber + "'");
            }
            updateExcel(excelStatus, "PASSED", sheetName, row, col);

        } catch (Exception e) {
            updateExcel(excelStatus, "FAILED", sheetName, row, col);
            handleError(e, timeoutInSecond);
            throw e;
        }
    }

    public static void compareLengthNumberByXpath(WebDriver driver, String xpathLocator, int lengthNumber,
            int timeoutInSecond) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
            String phoneString = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)))
                    .getAttribute("value");
            int lengthPhone = removeSpaces(phoneString).length();
            if (lengthPhone != (lengthNumber)) {
                throw new AssertionError("So sánh text thất bại! Actual: '" + removeSpaces(phoneString)
                        + "', Expected: '" + lengthNumber + "'");
            }

        } catch (Exception e) {
            handleError(e, timeoutInSecond);
            throw e;
        }
    }

    // ------------------------------------------------------------------------

    public static void compareTextExcel(WebDriver driver, String xpathLocator, String textString, int timeoutInSecond,
            String sheetName,
            int row, int col,
            ExcelStatus excelStatus) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
            String textCurrent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)))
                    .getText();
            textCurrent.equals(textString);
            if (!textCurrent.equals(textString)) {
                throw new AssertionError(
                        "So sánh text thất bại! Actual: '" + textCurrent + "', Expected: '" + textString + "'");
            }
            updateExcel(excelStatus, "PASSED", sheetName, row, col);

        } catch (Exception e) {
            updateExcel(excelStatus, "FAILED", sheetName, row, col);
            handleError(e, timeoutInSecond);
            throw e;
        }

    }

    public static void compareText(WebDriver driver, String xpathLocator, String textString, int timeoutInSecond) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
            String textCurrent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)))
                    .getText();
            textCurrent.equals(textString);
            if (!textCurrent.equals(textString)) {
                throw new AssertionError(
                        "So sánh text thất bại! Actual: '" + textCurrent + "', Expected: '" + textString + "'");
            }
        } catch (Exception e) {
            handleError(e, timeoutInSecond);
            throw e;
        }

    }

    // -------------------------------------------------------------------------

    public static void waitAndClearElementExcel(WebDriver driver, String xpathLocator, int timeoutInSecond,
            String sheetName,
            int row, int col,
            ExcelStatus excelStatus) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator))).clear();
            updateExcel(excelStatus, "PASSED", sheetName, row, col);

        } catch (Exception e) {
            updateExcel(excelStatus, "FAILED", sheetName, row, col);
            handleError(e, timeoutInSecond);
            throw e;
        }
    }

    public static void waitAndClearElement(WebDriver driver, String xpathLocator, int timeoutInSecond) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator))).clear();

        } catch (Exception e) {
            handleError(e, timeoutInSecond);
            throw e;
        }
    }

}
