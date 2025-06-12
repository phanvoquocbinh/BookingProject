package com.pharmacity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pharmacity.utils.BrowserHelper;

import io.qameta.allure.Step;

import static com.pharmacity.locators.LoginPageLocator.*;
import static com.pharmacity.locators.HomePageLocator.*;
import static com.pharmacity.data.CommonData.*;
import java.util.List;
import static com.pharmacity.locators.HomePageLocator.*;

public class HomePage {

    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step ("Open website pharmacity")
    public void accessWebsite() {
        BrowserHelper.isGetURLSuccessExcel(driver, URL_PROD_PAGE, 1, EXCEL_SHEET_NAME, 5, 5, status -> {});
        BrowserHelper.sleep(1000);
    }

    @Step ("Check pop-up and close it If have")
    public void checkPopHomePage() {
        try {
            BrowserHelper.isDisplayedSuccess(driver, BANNER_ADS, 10);
            BrowserHelper.waitAndClickElementExcel(driver, BTN_ADS_BANNER_CLOSE, 5, EXCEL_SHEET_NAME, 6, 5, status -> {});
        } catch (Exception e) {
            throw e;
        }
        
    }












    public void checkAndChangLanguage(WebDriver driver, String xpathLocator, String popupLocator) {
        BrowserHelper.isDisplayedSuccess(driver, xpathLocator, 1);
        BrowserHelper.waitAndClickElement(driver, xpathLocator, 1);
        BrowserHelper.isDisplayedSuccess(driver, popupLocator, 2);
        List<WebElement> listLangButton = driver.findElements(By.xpath(LIST_BUTTON_LANGUAGE_HEADER_MIDDLE));
        if (listLangButton.size() == 3) {
            BrowserHelper.isDisplayedSuccess(driver, BTN_VIETNAMESE_LANGUAGE_HEADER_MIDDLE, 1);
            BrowserHelper.isDisplayedSuccess(driver, BTN_ENGLISH_LANGUAGE_HEADER_MIDDLE, 1);
            BrowserHelper.isDisplayedSuccess(driver, BTN_OK_LANGUAGE_HEADER_MIDDLE, 1);
        }else{
            System.out.println("List button đang có: " + listLangButton.size() + " nút");
        }

        BrowserHelper.waitAndClickElement(driver, BTN_CLOSE_LANGUAGE_HEADER_MIDDLE, 1);
    }

}
