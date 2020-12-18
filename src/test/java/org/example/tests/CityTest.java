package org.example.tests;

import org.example.ConfProperties;
import org.example.pages.DeliveryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    public Object[][] cityChange() {
        return new Object[][]{
                {"Курск"},
                {"Киров"},
                {"Чебоксары"}
        };
    }

    @Test(dataProvider = "cityChange")
    public void cityTest(String city){
        cityPage.changeCity(city);
        cityPage.checkChange(city);
        cityPage.checkDelivery(city);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
