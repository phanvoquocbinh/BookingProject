package com.pharmacity.data;

public class LoginTestData {

    public static final String PHONE_NEW = "0355544722";
    public static final String PHONE_EXISTED = "0916741959";
    public static final String PHONE_EXISTED_PASSWORD = "123456789";

    // Các trường hợp invalid phone number
    public static final String PHONE_INVALID_CHAR = "0916abcdxy";
    public static final String PHONE_TOO_LONG = "09167419599999";
    public static final String PHONE_INVALID = "8765456123";
    public static final String PHONE_TOO_SHORT = "0654";

    // Các câu message cho phone number
    public static final String PHONE_MSG_INVALID = "Số điện thoại không đúng, vui lòng nhập lại";

}
