package com.booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.booking.utils.BrowserHelper;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static com.booking.data.CommonData.*;
import static com.booking.locators.HomePageLocator.*;
import static com.booking.locators.LoginPageLocator.*;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open website booking")
    public void accessWebsite() {
        BrowserHelper.isGetURLSuccess(driver, URL_PROD_BOOKING_PAGE, 1);
        BrowserHelper.sleep(1000);
    }

    @Step("Compare the URL")
    public void compareURL() {
        BrowserHelper.isGetURLSuccess(driver, URL_PROD_BOOKING_PAGE, 1);
        BrowserHelper.sleep(1000);
    }

    @Step("Check the pop-up is displayed")
    public void checkPopupHomePage() {
        try {
            BrowserHelper.isDisplayedSuccess(driver, ATR_POP_UP, "Pop-up Home Page", 10);
            BrowserHelper.waitAndClickElement(driver, BTN_CLOSE_POP_UP, "Close pop-up button", 5);
        } catch (Exception e) {
            Allure.step("The pop-up does not existed");
        }

    }

}
