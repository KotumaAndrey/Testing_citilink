package org.example.tests;

import io.qameta.allure.*;
import org.example.ConfProperties;
import org.example.TestListener;
import org.example.pages.SearchPage;
import org.example.pages.BasketPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
@Epic("Citilink Tests")
@Feature("Buy Test")

public class BuyTest extends BaseTest{
    SearchPage searchPage;
    BasketPage basketPage;

    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty(("chromedriver")));
        driver = new ChromeDriver();
        driver.get(ConfProperties.getProperty("loginpage"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPage = new SearchPage(driver);
        basketPage = new BasketPage(driver);
    }

    @Test(priority = 1, description = "Invalid Scenario in dding to basket and filtration by cost")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Failure with adding thing to basket or fining by filtration.")
    public void priceTest() throws InterruptedException {
        searchPage.openCatalog();
        searchPage.findByCost();
        searchPage.checkPrices();
        searchPage.takePrelast();
        searchPage.toBasket();
        basketPage.checkPrice();
        basketPage.addOne();
        basketPage.doPriceMore();
        basketPage.checkPrice();
        basketPage.checkSummary();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
