package org.example.tests;

import org.example.ConfProperties;
import org.example.pages.SearchPage;
import org.example.pages.BasketPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BuyTest {
    SearchPage searchPage;
    BasketPage basketPage;
    WebDriver driver;

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

    @Test
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
        // allure serve /C/Users/Admin/Documents/Testing_citilink/target/surefire-reports/
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
