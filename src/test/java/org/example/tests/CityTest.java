package org.example.tests;

import io.qameta.allure.*;
import org.example.ConfProperties;
import org.example.TestListener;
import org.example.pages.DeliveryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
@Epic("Citilink Tests")
@Feature("City Test")

public class CityTest extends BaseTest{
    DeliveryPage cityPage;

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

    @Test(priority = 1, description = "Invalid Scenario in Change-city form", dataProvider = "cityChange")
    @Severity(SeverityLevel.MINOR)
    @Description("Test Description: Changing city works wrong.")
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
