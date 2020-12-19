package org.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
}
