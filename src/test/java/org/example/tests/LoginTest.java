package org.example.tests;



import io.qameta.allure.*;
import org.example.ConfProperties;
import org.example.TestListener;
import org.example.pages.ProfilePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
@Epic("Citilink Tests")
@Feature("Login Test")

public class LoginTest extends BaseTest{
    LoginPage loginPage;
    ProfilePage profilePage;

    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty(("chromedriver")));
        driver = new ChromeDriver();
        driver.get(ConfProperties.getProperty("loginpage"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }
    @Test(priority = 0, description = "Invalid Scenario in Login form")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login test with wrong username and wrong password.")
    public void loginTest() throws InterruptedException {
        loginPage.inButton();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        Thread.sleep(10000);
        loginPage.clickLoginBtn();
        Assert.assertEquals("Андрей", profilePage.getUserName());
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
