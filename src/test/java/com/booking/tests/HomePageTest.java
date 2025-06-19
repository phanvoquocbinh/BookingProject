package com.booking.tests;

import org.testng.annotations.Test;

import com.booking.base.BaseTest;
import com.booking.pages.HomePage;
import com.booking.pages.LoginPage;
import com.booking.utils.BrowserHelper;
import com.booking.utils.ScreenshotHelper;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static com.booking.data.CommonData.*;
import static com.booking.data.LoginTestData.*;
import static com.booking.locators.HomePageLocator.*;
import static com.booking.locators.LoginPageLocator.*;

import org.openqa.selenium.By;
import io.qameta.allure.*;

@Epic("Home Page")
@Feature("Home Page UI Verification")
@Listeners({
        io.qameta.allure.testng.AllureTestNg.class,
        com.booking.report.AllureListener.class
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
        //homePage.checkPopHomePage();
    }

    
}
