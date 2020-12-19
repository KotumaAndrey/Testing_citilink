package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class SearchPage {
    public WebDriver driver;

    public SearchPage(WebDriver drivers) {
        this.driver = drivers;
    }
    private By catalog_1 = By.cssSelector("[href=\"https://www.citilink.ru/catalog/\"]");
    private By catalog_2 = By.cssSelector("[href=\"https://www.citilink.ru/catalog/beauty_and_health/toothbrushes_and_aks/\"]");
    private String catalog_3 = "https://www.citilink.ru/catalog/beauty_and_health/toothbrushes_and_aks/toothbrushes/";
    private By menu = By.cssSelector(".section3");
    private By min = By.cssSelector(".min.min-input_js");
    private By max = By.cssSelector(".max.max-input_js");
    private By costs = By.cssSelector("span.subcategory-product-item__price.subcategory-product-item__price_standart ins.subcategory-product-item__price-num");
    private By basket = By.cssSelector(".add_to_cart.pretty_button.type4.add_to_cart_text_for_user");
    private By go_basket = By.cssSelector(".pretty_button.type4.pretty_button_link.popup-basket__action-btn.js--popup-basket__action-btn_checkout");

    @Step("Go to catalog with toothbrushes.")
    public void openCatalog(){
        driver.findElement(catalog_1).click();
        driver.findElement(catalog_2).click();
        driver.get(catalog_3);
    }

    @Step("Filter toothbrushes by cost from 999 to 1999")
    public void findByCost() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(menu));
        WebElement minima = driver.findElement(min);
        minima.click();
        //Clear doesn't work and we use the combination of keys
        minima.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        minima.sendKeys("999", Keys.ENTER);
        //Waiting reload of filters
        WebElement maxima = driver.findElement(max);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#filter-loader-animation[style =\"display: block;\"]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#filter-loader-animation[style =\"display: none;\"]")));
        maxima.click();
        maxima.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        maxima.sendKeys("1999", Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#filter-loader-animation[style =\"display: block;\"]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#filter-loader-animation[style =\"display: none;\"]")));
    }

    @Step("Check that prices is right after filtration")
    public void checkPrices()
    {
        for ( WebElement x: driver.findElements(costs)) {
            Assert.assertEquals(true, Integer.parseInt(x.getText()) <= 1999 && Integer.parseInt(x.getText()) >= 999);
        }
    }

    @Step("Take prelate toothbrush")
    public void takePrelast()
    {
        List<WebElement> baskets = driver.findElements(basket);
        baskets.get(baskets.size() - 2).click();
    }

    @Step("Add toothbrush to basket.")
    public void toBasket()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(go_basket));
        driver.findElement(go_basket).click();
    }

}
