package com.pharmacity.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.pharmacity.locators.HomePageLocator.TXT_REGISTER;
import static com.pharmacity.locators.LoginPageLocator.*;
import static com.pharmacity.data.CommonData.*;
import static com.pharmacity.data.LoginTestData.*;
import com.pharmacity.utils.BrowserHelper;

import io.qameta.allure.Step;

public class LoginPage {

    private WebDriver driver;
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to the button: {name}")
    public void clickToButton(String name) {
        name = BrowserHelper.waitAndGetText(driver, TXT_REGISTER, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_REGISTER,name, 1);
        BrowserHelper.waitAndClickElement(driver, TXT_REGISTER,name,1);
    }

    @Step("Click to the button: {name}")
    public void submitEmail(String name){
        BrowserHelper.waitAndSendKeyElement(driver, ATR_EMAIL, EMAIL_EXISTED, 5);
        name=BrowserHelper.waitAndGetText(driver, TXT_SUBMIT, 1);
        BrowserHelper.waitAndClickElement(driver, BTN_SUBMIT,name,1);
    }


    
    // @Step("Input not enough the number to phone number field")
    // public void validateInputNotEnoughNumber(){
    //     // 5.4 Nhập số điện thoại không đủ ký tự
    //     BrowserHelper.waitAndClearElement(driver, TXT_PHONE_INPUT, 1);
    //     BrowserHelper.waitAndSendKeyElement(driver, TXT_PHONE_INPUT, PHONE_TOO_SHORT, 1);
    //     BrowserHelper.isDisplayedSuccess(driver, BTN_LOGIN_DISABLED, 1);
    // }


}
