package com.pharmacity.tests;

import com.pharmacity.base.BaseTest;
import com.pharmacity.pages.HomePage;
import com.pharmacity.pages.LoginPage;
import com.pharmacity.utils.BrowserHelper;
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

    @BeforeClass
    public void setupTest() {
        setup();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.get(URL_DEV_PAGE);
    }
    @Test(priority = 1, description = "Test 1")
    @Severity(SeverityLevel.NORMAL)
    @Story("Access the Pharmacity website")
    @Description("Mở và tắt banner")
    public void accessWebsite() {
        BrowserHelper.isGetURLSuccessExcel(driver, URL_DEV_PAGE, 1, EXCEL_SHEET_NAME, 5, 5, status -> {});
        BrowserHelper.sleep(1000);
    }

    @Step("2. Kiểm tra và đóng pop-up quảng cáo")
    public void checkPopHomePage() {
        BrowserHelper.isDisplayedSuccess(driver, BANNER_ADS, 10);
        BrowserHelper.waitAndClickElementExcel(driver, BTN_ADS_BANNER_CLOSE, 5, EXCEL_SHEET_NAME, 6, 5, status -> {});
    }

    @Step("3. Kiểm tra form đăng nhập và validate số điện thoại")
    public void checkLoginForm() {
        // 3- Mở form login thành công
        BrowserHelper.isDisplayedSuccess(driver, BTN_OPEN_LOGIN_FORM, 5);
        BrowserHelper.waitAndClickElement(driver, BTN_OPEN_LOGIN_FORM, 5);
        BrowserHelper.isDisplayedSuccessExcel(driver, FORM_LOGIN, 5, EXCEL_SHEET_NAME, 7, 5, status -> {
        });

        // 4. Kiểm tra xem có trường thông tin phone number không
        
        BrowserHelper.isDisplayedSuccessExcel(driver, TXT_PHONE_INPUT, 5, EXCEL_SHEET_NAME, 8, 5, status -> {
        });

        // 5. Check validate Phone Number
        // 5.1 Nhập quá 10 ký tự
        BrowserHelper.waitAndSendKeyElement(driver, TXT_PHONE_INPUT, PHONE_TOO_LONG, 1);
        BrowserHelper.compareLengthNumberByXpathExcel(driver, TXT_PHONE_INPUT, 10, 1, EXCEL_SHEET_NAME, 9, 5,
                status -> {
                });

        // 5.2 Nhập số điện thoại không đúng
        BrowserHelper.waitAndClearElement(driver, TXT_PHONE_INPUT, 1);
        BrowserHelper.waitAndSendKeyElement(driver, TXT_PHONE_INPUT, PHONE_INVALID, 1);
        BrowserHelper.waitAndClickElement(driver, BTN_FORM_LOGIN_SUBMIT, 1);
        BrowserHelper.isDisplayedSuccess(driver, MSG_ERROR_INVALID_PHONE, 2);
        BrowserHelper.compareTextExcel(driver, MSG_ERROR_INVALID_PHONE, PHONE_MSG_INVALID, 1, EXCEL_SHEET_NAME, 9, 5,
                status -> {
                });

        System.out.println("5.2 PASSED");

        // 5.3 Nhập số điện thoại có chữ
        BrowserHelper.waitAndClearElement(driver, TXT_PHONE_INPUT, 1);
        BrowserHelper.waitAndSendKeyElement(driver, TXT_PHONE_INPUT, PHONE_INVALID_CHAR, 1);
        BrowserHelper.isDisplayedSuccessExcel(driver, BTN_LOGIN_DISABLED, 1, EXCEL_SHEET_NAME, 10, 5, status -> {
        });
        System.out.println("5.3 PASSED");

        // 5.4 Nhập số điện thoại không đủ ký tự
        BrowserHelper.waitAndClearElement(driver, TXT_PHONE_INPUT, 1);
        BrowserHelper.waitAndSendKeyElement(driver, TXT_PHONE_INPUT, PHONE_TOO_SHORT, 1);
        BrowserHelper.isDisplayedSuccess(driver, BTN_LOGIN_DISABLED, 1);
        System.out.println("5.4 PASSED");

        // 7. Check hiển thị nút Login bằng Google
        BrowserHelper.isDisplayedSuccessExcel(driver, BTN_GOOGLE_LOGIN, 10, EXCEL_SHEET_NAME, 11, 5, status -> {
        });

        // 8. Check hiển thị nút Login bằng VNEID
        BrowserHelper.isDisplayedSuccessExcel(driver, BTN_VNEID_LOGIN, 10, EXCEL_SHEET_NAME, 12, 5, status -> {
        });

    }
    @Step("4. Kiểm tra form Thỏa thuận người dùng (TnC)")
    public void checkTnCForm() {
        // 9. Mở form Thỏa thuận người dùng thành công
        BrowserHelper.waitAndClearElement(driver, TXT_PHONE_INPUT, 1);
        BrowserHelper.waitAndSendKeyElement(driver, TXT_PHONE_INPUT, PHONE_NEW, 1);
        BrowserHelper.sleep(3000);
        BrowserHelper.waitAndClickElement(driver, BTN_FORM_LOGIN_SUBMIT, 1);
        BrowserHelper.isDisplayedSuccessExcel(driver, FORM_TNC, 5, EXCEL_SHEET_NAME, 13, 5, status -> {
        });

        // 10. Ẩn nút điều khoản
        BrowserHelper.isDisplayedSuccessExcel(driver, CHECKBOX_TNC_UNCHECKED, 10, EXCEL_SHEET_NAME, 14, 5, status -> {
        });

        // 11. Ẩn nút "Tôi đồng ý"
        BrowserHelper.isDisplayedSuccessExcel(driver, BTN_TNC_DISABLED, 10, EXCEL_SHEET_NAME, 15, 5, status -> {
        });

        // 12. Tắt thử form T&C và mở lại
        BrowserHelper.waitAndClickElement(driver, BTN_TNC_CLOSE, 10);
        BrowserHelper.waitAndClickElement(driver, BTN_FORM_LOGIN_SUBMIT, 1);
        BrowserHelper.isDisplayedSuccessExcel(driver, FORM_LOGIN, 1, EXCEL_SHEET_NAME, 16, 5, status -> {
        });
        BrowserHelper.sleep(5000);

        // 13. Click vào link thỏa thuận người dùng
        BrowserHelper.waitAndClickElement(driver, LINK_TNC_TEXT, 10);
        BrowserHelper.checkURLOpenNewTab(driver, URL_TNC);
        BrowserHelper.closeOldTab(driver);
        BrowserHelper.directToCurrentURL(driver);
        System.out.println("URL Now" + driver.getCurrentUrl());
        BrowserHelper.isDisplayedSuccessExcel(driver, FORM_TNC, 0, EXCEL_SHEET_NAME, 17, 5, status -> {
        });

        // 14. Đồng ý với điều khoản
        BrowserHelper.waitAndClickElement(driver, CHECKBOX_TNC_CLICKABLE, 1);
        BrowserHelper.isDisplayedSuccess(driver, BTN_TNC_ENABLED, 1);
        BrowserHelper.waitAndClickElement(driver, BTN_TNC_ENABLED, 1);
        BrowserHelper.isDisplayedSuccessExcel(driver, FORM_REQUEST_OTP, 1, EXCEL_SHEET_NAME, 18, 5, status -> {
        });

    }
    @Step("5. Kiểm tra form nhập OTP")
    public void checkOTPForm() {
        // 16. Check hiển thị các nút trong request OTP Form
        driver.findElement(By.xpath("//input[@inputmode='numeric']")).getAttribute("value").equals(PHONE_NEW);
        BrowserHelper.isDisplayedSuccess(driver, BTN_OTP_ZALO, 1);
        BrowserHelper.isDisplayedSuccess(driver, BTN_OTP_SMS, 1);
        BrowserHelper.isDisplayedSuccessExcel(driver, BTN_FORM_REQUEST_OTP_CLOSE, 1, EXCEL_SHEET_NAME, 19, 5,
                status -> {
                });

        // 17. Request OTP by zalo button
        BrowserHelper.waitAndClickElement(driver, BTN_OTP_SMS, 1);
        BrowserHelper.isDisplayedSuccess(driver, BTN_OTP_BACK, 3);
        BrowserHelper.compareText(driver, TXT_OTP_PHONE, PHONE_NEW, 1);
        BrowserHelper.waitAndClickElement(driver, BTN_OTP_BACK, 1);
        BrowserHelper.isDisplayedSuccess(driver, FORM_LOGIN, 1);
        // loginPage.checkOTPLogic(driver,3);
    }
    @Step("6. Kiểm tra form chọn phương thức login")
    public void checkLoginMethodForm() {

        // 18. Check login account
        BrowserHelper.waitAndClearElement(driver, TXT_PHONE_INPUT, 1);
        BrowserHelper.waitAndSendKeyElement(driver, TXT_PHONE_INPUT, PHONE_EXISTED, 1);
        BrowserHelper.waitAndClickElement(driver, BTN_FORM_LOGIN_SUBMIT, 1);
        BrowserHelper.isDisplayedSuccess(driver, BTN_OTP_SMS, 1);
        BrowserHelper.isDisplayedSuccess(driver, BTN_OTP_ZALO, 1);
        BrowserHelper.isDisplayedSuccess(driver, BTN_LOGIN_BY_PASSWORD, 1);
        System.out.println("PASS 18");
    }
    @Step("7. Kiểm tra login bằng mật khẩu")
    public void checkLoginByPasswordMethod() {
        // 19. Click vào nút "Login bằng password"
        BrowserHelper.waitAndClickElement(driver, BTN_LOGIN_BY_PASSWORD, 1);
        BrowserHelper.isDisplayedSuccess(driver, BTN_LOGIN_DISABLED, 1);
        System.out.println("PASS 19");

        // 20. Nhập sai password để test
        BrowserHelper.waitAndSendKeyElement(driver, TXT_PASSWORD_HIDDEN, "123", 1);
        BrowserHelper.waitAndClickElement(driver, BTN_PASSWORD_SUBMIT, 1);
        BrowserHelper.compareText(driver, MSG_PASSWORD_INVALID, "Mật khẩu không chính xác, vui lòng thử lại", 2);
        System.out.println("PASS 20");

        // 21. Check password hidden và unhidden
        BrowserHelper.waitAndClearElement(driver, TXT_PASSWORD_HIDDEN, 1);
        BrowserHelper.waitAndSendKeyElement(driver, TXT_PASSWORD_HIDDEN, PHONE_EXISTED_PASSWORD, 1);
        BrowserHelper.waitAndClickElement(driver, ICON_PASSWORD_TOGGLE, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_PASSWORD_VISIBLE, 1);

        BrowserHelper.waitAndClickElement(driver, ICON_PASSWORD_TOGGLE, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_PASSWORD_HIDDEN, 1);
        System.out.println("PASS 21");
    }

    @Step("8. Kiểm tra forgot password")
    public void checkForgotPassword() {
        // 22. Kiểm tra Forgot Password
        BrowserHelper.waitAndClickElement(driver, BTN_FORGOT_PASSWORD, 1);
        BrowserHelper.isDisplayedSuccess(driver, TXT_FORGOT_PASSWORD, 1);
        BrowserHelper.isDisplayedSuccess(driver, BTN_OTP_ZALO, 1);
        BrowserHelper.isDisplayedSuccess(driver, BTN_OTP_SMS, 1);
        System.out.println("PASS 22");

        // 23. Quay lại màn hình login password
        BrowserHelper.waitAndClickElement(driver, BTN_CLOSE_POPUP, 1);
        BrowserHelper.isDisplayedSuccess(driver, FORM_PASSWORD, 1);
        System.out.println("PASS 23");

    }

    @Step("9. Kiểm tra đăng nhập thành công bằng mật khẩu")
    public void checkLoginSuccessByPassword() {
        // 24. Cuối cùng: login thành công
        BrowserHelper.waitAndClickElement(driver, BTN_PASSWORD_SUBMIT, 1);
        System.out.println("PASS 24");
    }

    // @Test
    // @Severity(SeverityLevel.BLOCKER)
    // @Description("Toàn bộ flow kiểm tra đăng nhập: Từ form số điện thoại → TnC → OTP → Login thành công")
    // public void allLoginFlow() {
    //     accessWebsite();
    //     checkPopHomePage();
    //     checkLoginForm();
    //     checkTnCForm();
    //     checkOTPForm();
    //     checkLoginMethodForm();
    //     checkLoginByPasswordMethod();
    //     checkForgotPassword();
    //     checkLoginSuccessByPassword();
    // }

    // @AfterEach
    // public void tearDownTest() {
    // teardown(); // trong đây nên có driver.quit();
    // }

}
