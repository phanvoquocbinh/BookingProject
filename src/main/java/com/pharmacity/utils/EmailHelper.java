package com.pharmacity.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.regex.*;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class EmailHelper {

    private final WebDriver driver;

    public EmailHelper(WebDriver driver) {
        this.driver = driver;
    }

    @Test(description = "Test Email")
    public static String fetchOTPFromGmail(String user, String password) throws Exception {
        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");

        Session session = Session.getDefaultInstance(props, null);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com", user, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();
        for (int i = messages.length - 1; i >= 0; i--) {
            Message message = messages[i];

            // Kiểm tra nếu email chứa từ "verification code"
            if (message.getSubject().contains("verification code")
                    || message.getContent().toString().contains("Enter this code")) {

                String content = getTextFromMessage(message);

                System.out.println("Email Content: " + content); 

                // Trích xuất OTP
                String otp = extractOtp(content);
                if (otp != null) {
                    return otp;
                }
            }
        }

        return null;
    }

    // Hàm để trích xuất nội dung email (bao gồm cả HTML)
    private static String getTextFromMessage(Message message) throws Exception {
    String result = null;

    if (message.isMimeType("text/plain")) {
        result = message.getContent().toString();
    } else if (message.isMimeType("multipart/*")) {
        Multipart multipart = (Multipart) message.getContent();
        
        // Duyệt qua các phần của nội dung email (text/plain và text/html)
        for (int i = 0; i < multipart.getCount(); i++) {
            BodyPart part = multipart.getBodyPart(i);
            if (part.isMimeType("text/plain")) {
                result = part.getContent().toString();
            } else if (part.isMimeType("text/html")) {
                result = part.getContent().toString(); // Nếu không có text/plain, lấy nội dung HTML
            }
        }
    }

    // Loại bỏ dấu cách và ký tự không cần thiết
    if (result != null) {
        result = result.replaceAll("\\s+", " ").trim();  // Xóa khoảng trắng thừa
    }

    return result;
}

private static String extractOtp(String emailContent) {

    String otpPattern = "(?<=account without a password\\.\\s*)\\b[A-Za-z0-9]{6}\\b";  
    
    Pattern pattern = Pattern.compile(otpPattern);
    Matcher matcher = pattern.matcher(emailContent);

    if (matcher.find()) {
        return matcher.group();  
    }
    return null; 
}
}
