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
        //homePage.checkPopHomePage();
    }

    
}
