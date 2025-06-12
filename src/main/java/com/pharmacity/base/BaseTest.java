package com.pharmacity.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public static WebDriver driver;;

    public void setup() {
        WebDriverManager.chromedriver().setup();  // Tự động tải ChromeDriver mới nhất
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public void teardown() {
        if (driver != null) {
            driver.quit(); // Đóng trình duyệt
        }
    }
}

