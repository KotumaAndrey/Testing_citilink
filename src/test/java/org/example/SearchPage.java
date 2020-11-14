package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class SearchPage {
    public WebDriver driver;

    public SearchPage(WebDriver drivers) {
        this.driver = drivers;
    }
    private By catalog_1 = By.cssSelector("#page > footer > div.footer__inner > div > div:nth-child(2) > p:nth-child(7) > a");
    private By catalog_2 = By.cssSelector("#content > div > div:nth-child(4) > ul:nth-child(1) > li > div > div > ul > li:nth-child(10) > a");
    private By catalog_3 = By.cssSelector("#category_id_216 > li > a");
    private By menu = By.cssSelector("#layout > div.main_content > div > aside > div.helper > div.helper_view.helper_view_short > section.section3");
    private By min = By.cssSelector("#layout > div.main_content > div > aside > div.helper > div.helper_view.helper_view_short > section.section3 > div > div > div > input.min.min-input_js");
    private By max = By.cssSelector("#layout > div.main_content > div > aside > div.helper > div.helper_view.helper_view_short > section.section3 > div > div > div > input.max.max-input_js");
    private By costs = By.cssSelector(".subcategory-product-item__price-num");
    private By basket = By.cssSelector(".add_to_cart.pretty_button.type4.add_to_cart_text_for_user");
    private By go_basket = By.cssSelector(".pretty_button.type4.pretty_button_link.popup-basket__action-btn.js--popup-basket__action-btn_checkout");


    public void OpenCatalog(){
        driver.findElement(catalog_1).click();
        driver.findElement(catalog_2).click();
        driver.findElement(catalog_3).click();
    }

    public void FindByCost() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(menu));
        WebElement minima = driver.findElement(min);
        minima.click();
        //Clear doesn't work and we use the combination of keys
        minima.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        minima.sendKeys("999");
        //Waiting reload of filters
        Thread.sleep(3000);
        WebElement maxima = driver.findElement(max);
        maxima.click();
        maxima.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        maxima.sendKeys("1999");
        Thread.sleep(3000);
    }

    public void CheckPrices()
    {
        for ( WebElement x: driver.findElements(costs)) {
            Assert.assertEquals(true, Integer.parseInt(x.getText()) < 1999 && Integer.parseInt(x.getText()) > 999);
        }
    }

    public void TakePrelast()
    {
        int count = driver.findElements(basket).size();
        driver.findElements(basket).get(count - 2).click();
    }

    public void ToBasket()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(go_basket));
        driver.findElement(go_basket).click();
    }

}
