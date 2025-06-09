package com.pharmacity.tests;

import com.pharmacity.base.BaseTest;
import com.pharmacity.pages.HomePage;
import com.pharmacity.pages.LoginPage;
import com.pharmacity.utils.BrowserHelper;
import static com.pharmacity.data.LoginTestData.*;
import static com.pharmacity.data.CommonData.*;
import static com.pharmacity.locators.LoginPageLocator.*;
import static com.pharmacity.locators.HomePageLocator.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class HomePageTest extends BaseTest{
    public HomePage homePage;
    public LoginPage loginPage;

     @BeforeEach
     public void setupTest() {
         setup();
         homePage = new HomePage(driver);
         loginPage = new LoginPage(driver);
         driver.get(URL_PROD_PAGE);
    }
    public void checkPopHomePage() {
        // Kiểm tra có pop-up hay không và tắt nó
        BrowserHelper.isDisplayedSuccess(driver, BANNER_ADS, 10);
        BrowserHelper.waitAndClickElementExcel(driver, BTN_ADS_BANNER_CLOSE, 5, EXCEL_SHEET_NAME, 6, 5,
                status -> {
                });
    }
    public void TC01_TOP_HomePage_Header(){

        BrowserHelper.isDisplayedSuccess(driver, BANNER_HEADER_TOP, 1);
    }
    
    public void loginToTest(){
        try {
        BrowserHelper.isDisplayedSuccess(driver, BTN_OPEN_LOGIN_FORM, 5);
        BrowserHelper.waitAndClickElement(driver, BTN_OPEN_LOGIN_FORM, 5);
        BrowserHelper.waitAndSendKeyElement(driver, TXT_PHONE_INPUT, PHONE_EXISTED, 1);
        BrowserHelper.waitAndClickElement(driver, BTN_FORM_LOGIN_SUBMIT, 5);
        BrowserHelper.waitAndClickElement(driver,BTN_LOGIN_BY_PASSWORD, 5);
        BrowserHelper.waitAndSendKeyElement(driver, TXT_PASSWORD_HIDDEN, PHONE_EXISTED_PASSWORD, 1);
        BrowserHelper.waitAndClickElement(driver, BTN_PASSWORD_SUBMIT, 1);

        Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        ;
        
    }
    public void TC02_MIDDLE_HomePage_Header(){
        BrowserHelper.waitandHoverElement(driver, ATR_DOWNLOAD_HEADER_MIDDLE, POPUP_DOWNLOAD_HEADER_MIDDLE, 5);
        homePage.checkAndChangLanguage(driver, ATR_LANGUAGE_HEADER_MIDDLE, POPUP_LANGUAGE_HEADER_MIDDLE);
        BrowserHelper.isDisplayedSuccess(driver, ATR_HOTLINE_HEADER_MIDDLE, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_BIZ_HEADER_MIDDLE, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_HOTDEAL_HEADER_MIDDLE, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_ORDER_RESEARCH_HEADER_MIDDLE, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_HEALTH_HEADER_MIDDLE, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_MEDICAL_SYSTEM_HEADER_MIDDLE, 1);  

    }

    public void TC03_BOTTOM_HomePage_Header(){
        
    }

    @Test
    public void allTestHomePageFlow(){
        checkPopHomePage();
        loginToTest();
        TC01_TOP_HomePage_Header();
        TC02_MIDDLE_HomePage_Header();
    }
}
