package org.example.tests;

import org.example.ConfProperties;
import org.example.pages.DeliveryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CityTest {
    DeliveryPage cityPage;
    WebDriver driver;

    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty(("chromedriver")));
        driver = new ChromeDriver();
        driver.get(ConfProperties.getProperty("loginpage"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        cityPage = new DeliveryPage(driver);
    }

    @Test
    public void cityTest(){
        cityPage.changeCity("Курск");
        cityPage.checkChange("Курск");
        cityPage.checkDelivery("Курск");
        cityPage.changeCity("Киров");
        cityPage.checkChange("Киров");
        cityPage.checkDelivery("Киров");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
