package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BuyTest {
    SearchPage cearchPage;
    WebDriver driver;

    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty(("chromedriver")));
        driver = new ChromeDriver();
        driver.get(ConfProperties.getProperty("loginpage"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        cearchPage = new SearchPage(driver);
    }

    @Test
    public void cearchTest() {
        cearchPage.OpenCatalog();
        cearchPage.FindByCost();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
