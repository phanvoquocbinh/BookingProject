package com.pharmacity.locators;

public class LoginPageLocator {

    // --- Header & Login Form
    public static final String BTN_OPEN_LOGIN_FORM = "//div[@class='hidden md:ml-2 md:inline-flex']//button[@type='button']";
    public static final String TXT_LOGIN_HEADER = "//span[text()='Đăng nhập/ Đăng ký']";
    public static final String FORM_LOGIN = "//div[@class='grid focus-visible:outline-0 md:block px-4 md:px-6 pt-28 pb-6 left-0 fixed bottom-0 right-0 top-0 z-50 w-full gap-4 border bg-background shadow-lg duration-200 md:left-[50%] md:h-fit md:max-h-[90%] md:w-full md:translate-x-[-50%] md:rounded-lg overflow-x-hidden border-white md:top-[15%] md:max-w-[413px] md:translate-y-0 md:border-neutral-200 md:pt-6']";
    public static final String TXT_PHONE_INPUT = "//div[@class='relative flex']//input[@inputmode='numeric']";
    public static final String BTN_FORM_LOGIN_SUBMIT = "//button[@data-size='md' and @type='submit']";
    public static final String BTN_LOGIN_DISABLED = "//button[@data-size='md' and @type='submit' and @disabled]";
    public static final String BTN_LOGIN_BY_PASSWORD = "//button[@type='button']//span[text()='Nhập mật khẩu']";
    public static final String MSG_ERROR_INVALID_PHONE = "//p[text()='Số điện thoại không đúng, vui lòng nhập lại']";
    public static final String URL_TNC = "https://www.pharmacity.vn/page/chinh-sach-bao-mat";

    // --- Social login buttons
    public static final String BTN_GOOGLE_LOGIN = "//button[@type='button' and text()='Tiếp tục với Google']";
    public static final String BTN_VNEID_LOGIN = "//button[@type='button']//span[text()='Tài khoản định danh điện tử']";

    // --- TNC Form
    public static final String FORM_TNC = "//span[text()='Thỏa thuận người dùng Pharmacity, chính sách bảo mật.']";
    public static final String CHECKBOX_TNC_CHECKED = "//label[@data-checked='true']";
    public static final String CHECKBOX_TNC_UNCHECKED = "//label[@data-checked='false']";
    public static final String CHECKBOX_TNC_CLICKABLE = "//input[@class='peer absolute opacity-0']//following-sibling::span";
    public static final String BTN_TNC_ENABLED = "//button[@type='button']//span[text()='Tôi đồng ý']";
    public static final String BTN_TNC_DISABLED = "//button[@type='button' and @disabled]//span[text()='Tôi đồng ý']";
    public static final String BTN_TNC_CLOSE = "//div[@class='flex w-full flex-col space-y-1.5 md:pt-7 fixed left-0 top-0 bg-white p-4 md:px-6']/following-sibling::button";
    public static final String LINK_TNC_TEXT = "//a[text()='Thoả thuận người dùng Pharmacity, chính sách bảo mật.']";

    // --- OTP Form
    public static final String FORM_OTP = "//h2[text()='Nhập mã xác thực']";
    public static final String FORM_REQUEST_OTP = "//h2[text()='Xác thực OTP']";
    public static final String BTN_FORM_REQUEST_OTP_CLOSE = "//button[@type='button' and @class='fixed right-2 rounded-sm opacity-100 outline-0 ring-offset-background transition-opacity hover:opacity-80 md:right-4 md:top-6 top-5']";
    public static final String TXT_OTP_TIMER = "//span[@class='inline-block text-primary-500']//span[@class='flex items-center']";
    public static final String TXT_OTP_MINUTES = "//span[@class='inline-block text-primary-500']//span[@class='flex items-center']//span[1]";
    public static final String TXT_OTP_SECONDS = "//span[@class='inline-block text-primary-500']//span[@class='flex items-center']//span[3]";
    public static final String MSG_OTP_EXPIRED = "//p[@class='text-sm font-normal text-red-500']";
    public static final String TXT_OTP_PHONE = "//h2[text()='Nhập mã xác thực']//following-sibling::p//span";
    public static final String BTN_OTP_BACK = "//button[@type='button' and contains(@class,'ml-[-1rem]')]";
    public static final String BTN_OTP_RESEND = "//span[text()='Gửi lại mã OTP']";
    public static final String BTN_OTP_RESEND_VOICE = "//span[text()='Nhận mã qua cuộc gọi']";
    public static final String FORM_OTP_ERROR = "//span[text()='Gửi mã xác thực thất bại!']";
    public static final String LINK_PHONE_SUPPORT = "//a[text()='18006821']";
    public static final String BTN_ERROR_OK = "//button[@type='button']//span[text()='OK']";

    // --- Method Login Options
    public static final String DIALOG_METHOD_LOGIN = "//div[@role='dialog']//h2[text()='Vui lòng chọn phương thức']";
    public static final String FORM_PASSWORD = "//h2[text()='Nhập mật khẩu']";
    public static final String BTN_OTP_SMS = "//button[@type='button']//span[text()='Gửi mã xác thực qua SMS']";
    public static final String BTN_OTP_ZALO = "//button[@type='button']//span[text()='Gửi mã xác thực qua Zalo']";
    public static final String TXT_PASSWORD_HIDDEN = "//div[@class='relative flex']//input[@type='password']";
    public static final String TXT_PASSWORD_VISIBLE = "(//div[@class='relative flex']//input[@type='text'])[2]";
    public static final String MSG_PASSWORD_INVALID = "//p[text() ='Mật khẩu không chính xác, vui lòng thử lại']";
    public static final String BTN_PASSWORD_SUBMIT = "//button[@type='submit']//span[text()='Đăng nhập']";
    public static final String ICON_PASSWORD_TOGGLE = "//span[@class='absolute right-0 flex h-full items-center px-3']//span[@class='p-icon inline-flex align-[-0.125em] justify-center max-h-full max-w-full w-6 h-6']";
    public static final String BTN_FORGOT_PASSWORD = "//button[@type='button']//span[text()='Quên mật khẩu?']";
    public static final String TXT_FORGOT_PASSWORD = "//p[text()='Pharmacity sẽ gửi cho bạn 1 mã xác thực (OTP) qua số điện thoại']";
    public static final String BTN_CLOSE_POPUP = "//button[@type='button' and @class='fixed right-2 rounded-sm opacity-100 outline-0 ring-offset-background transition-opacity hover:opacity-80 md:right-4 md:top-6 top-5']";

}