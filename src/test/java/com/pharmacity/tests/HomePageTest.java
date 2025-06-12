package com.pharmacity.tests;

import com.pharmacity.base.BaseTest;
import com.pharmacity.pages.HomePage;
import com.pharmacity.pages.LoginPage;
import com.pharmacity.utils.BrowserHelper;
import com.pharmacity.utils.ScreenshotHelper;

import static com.pharmacity.data.LoginTestData.*;
import static com.pharmacity.data.CommonData.*;
import static com.pharmacity.locators.LoginPageLocator.*;
import static com.pharmacity.locators.HomePageLocator.*;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import io.qameta.allure.*;

@Epic("Home Page")
@Feature("Home Page UI Verification")
@Listeners({
        io.qameta.allure.testng.AllureTestNg.class,
        com.pharmacity.report.AllureListener.class
})
public class HomePageTest extends BaseTest {
    @Override
    public String toString() {
        //return this.getClass().getName();
        return "HomePageTest";
    }

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void setupTest() {
        setup();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        //driver.get(URL_PROD_PAGE);
    }

    @Test(priority = 1, description = "Check popup on Home Page and close it if present")
    @Severity(SeverityLevel.NORMAL)
    @Story("Check pop-up on Home Page")
    @Description("Occasionally, the operations team sets up a pop-up to appear on the home page when the website is first opened. Therefore, the system will check: if the pop-up is present, it will display it; otherwise, it will close or skip it.")
    public void checkPopHomePage() {
        homePage.accessWebsite();
        homePage.checkPopHomePage();
    }

    @Test(priority = 2, description = "Test 2")
    @Severity(SeverityLevel.MINOR)
    @Story("Verify TOP Header of Home Page")
    @Description("Kiểm tra top banner")
    public void TC01_TOP_HomePage_Header() {
        BrowserHelper.isDisplayedSuccess(driver, BANNER_HEADER_TOP, 1);
        System.out.println("Step thực hiện: Kiểm tra TOP banner");
    }

    @Test(priority = 3, description = "Test 3")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Login to system for testing")
    @Description("Login thành công")
    public void loginToTest() {
        try {

            BrowserHelper.isDisplayedSuccess(driver, BTN_OPEN_LOGIN_FORM, 5);
            BrowserHelper.waitAndClickElement(driver, BTN_OPEN_LOGIN_FORM, 5);
            BrowserHelper.waitAndSendKeyElement(driver, TXT_PHONE_INPUT, PHONE_EXISTED, 1);
            BrowserHelper.waitAndClickElement(driver, BTN_FORM_LOGIN_SUBMIT, 5);
            BrowserHelper.waitAndClickElement(driver, BTN_LOGIN_BY_PASSWORD, 5);
            BrowserHelper.waitAndSendKeyElement(driver, TXT_PASSWORD_HIDDEN, PHONE_EXISTED_PASSWORD, 1);
            BrowserHelper.waitAndClickElement(driver, BTN_PASSWORD_SUBMIT, 1);
            Thread.sleep(5000);
            //executeStep(this::loginToTest, "Login process details");
        } catch (Exception e) {
            ScreenshotHelper.takeScreenshot(driver);
            String errorMessage = "Login failed at step: " + getCurrentStep() + "\nError: " + e.getMessage();
            ScreenshotHelper.saveLog(errorMessage);
            Assert.fail(errorMessage);

            throw new RuntimeException(e);
        }
    }

    // Helper method để xác định step hiện tại bị lỗi
    private String getCurrentStep() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // Logic để xác định step hiện tại (có thể điều chỉnh theo nhu cầu)
        return stackTrace[3].getMethodName(); // Điều chỉnh index tùy theo stack trace thực tế
    }
    @Test(priority = 4, description = "Test 4")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Login thành công")
    @Story("Verify MIDDLE Header of Home Page")
    public void TC02_MIDDLE_HomePage_Header() {
        BrowserHelper.waitandHoverElement(driver, ATR_DOWNLOAD_HEADER_MIDDLE, POPUP_DOWNLOAD_HEADER_MIDDLE, 5);
        homePage.checkAndChangLanguage(driver, ATR_LANGUAGE_HEADER_MIDDLE, POPUP_LANGUAGE_HEADER_MIDDLE);
        BrowserHelper.isDisplayedSuccess(driver, ATR_HOTLINE_HEADER_MIDDLE, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_BIZ_HEADER_MIDDLE, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_HOTDEAL_HEADER_MIDDLE, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_ORDER_RESEARCH_HEADER_MIDDLE, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_HEALTH_HEADER_MIDDLE, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_MEDICAL_SYSTEM_HEADER_MIDDLE, 1);
    }

    @Story("Verify BOTTOM Header of Home Page")
    public void TC03_BOTTOM_HomePage_Header() {
        // Chưa implement
    }

    private void executeStep(Runnable step, String stepName) {
        try {
            Allure.step(stepName, () -> {
                step.run();
            });
        } catch (Exception e) {
            ScreenshotHelper.takeScreenshot(driver);
            Allure.addAttachment("Error", "text/plain", "Failed in step: " + stepName + "\n" + e.getMessage());
            throw e;
        }
    }

    // @Test
    // @Severity(SeverityLevel.CRITICAL)
    // @Description("End-to-end flow test for Home Page: check popup, login, verify TOP & MIDDLE header")
    // @Story("User logs in with correct username and password")
    // public void allTestHomePageFlow() {
    //     checkPopHomePage();
    //     loginToTest();
    //     getCurrentStep();
    //     TC02_MIDDLE_HomePage_Header();
    // }
}
