package com.pharmacity.tests;

import com.pharmacity.base.BaseTest;
import com.pharmacity.pages.EmailPage;
import com.pharmacity.pages.HomePage;
import com.pharmacity.pages.LoginPage;
import com.pharmacity.utils.BrowserHelper;
import com.pharmacity.utils.CaptchaHandlingHelper;
import com.pharmacity.utils.EmailHelper;

import static com.pharmacity.data.LoginTestData.*;
import static com.pharmacity.data.CommonData.*;
import static com.pharmacity.locators.LoginPageLocator.*;
import static com.pharmacity.locators.HomePageLocator.*;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import io.qameta.allure.*;
@Epic("Login Feature")
@Feature("Login Work Flow")
@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class LoginTest extends BaseTest {

    public HomePage homePage;
    public LoginPage loginPage;
    public CaptchaHandlingHelper captchaHandlingTests;
    public EmailHelper emailHelper;
    public EmailPage emailPage;

    @BeforeClass
    public void setupTest() {
        setup();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        captchaHandlingTests = new CaptchaHandlingHelper(driver);
        emailHelper = new EmailHelper(driver);
        emailPage = new EmailPage(driver);
        //driver.get(URL_PROD_BOOKING_PAGE);
    }

    @Test(priority = 1, description = "Check open correct the URL")
    @Severity(SeverityLevel.NORMAL)
    @Story("1. Open and compare the URL")
    @Description("Open the the URL and compare the URL")
    public void accessBookingWebsite() {
        homePage.accessWebsite();
        homePage.compareURL();
    }

    @Test(priority = 2, description = "Check displayed pop-up")
    @Severity(SeverityLevel.NORMAL)
    @Story("2. Check displayed pop-up")
    @Description("If the pop-up is displayed, turn off it")
    public void checkPopup() {
        homePage.checkPopupHomePage();
    }

    @Test(priority = 3, description = "Check the displayed of Login button and login it")
    @Severity(SeverityLevel.NORMAL)
    @Story("3. Login to the Booking page")
    @Description("Check the displayed of Login button and login it")
    public void Login() {
        loginPage.clickToButton(BTN_REGISTER);
    }

    @Test(priority = 4, description = "Check the displayed of Login button and login it")
    @Severity(SeverityLevel.NORMAL)
    @Story("3. Login to the Booking page")
    @Description("Check the displayed of Login button and login it")
    public void InputEmailAndSubmit() throws Exception {
        loginPage.submitEmail(BTN_REGISTER);
        Thread.sleep(3000);
        captchaHandlingTests.recaptchaTestAudio();
        emailPage.loginWithEmailOtp();
    }
    

    

}
