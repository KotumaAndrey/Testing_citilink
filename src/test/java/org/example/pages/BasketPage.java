package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasketPage {
    public WebDriver driver;

    public BasketPage(WebDriver drivers) {
        this.driver = drivers;
    }

    private By brush_price = By.cssSelector(".cart_item.cart_item_1429644__js td span.price ins.num");
    private By basket_price = By.cssSelector(".payment_block p span ins.num.order_amount_field");
    private By count_change = By.cssSelector(".product_amount_control");
    private int one_brush;
    private int count = 2;


    @Step("Check prices in basket")
    public void checkPrice() {

        Assert.assertEquals(true, Integer.parseInt(driver.findElement(brush_price).getText()) == Integer.parseInt(driver.findElement(basket_price).getText()));
    }

    @Step("Add the same toothbrush")
    public void addOne()
    {
        one_brush = Integer.parseInt(driver.findElement(brush_price).getText());
        WebElement changer_count = driver.findElement(count_change);
        changer_count.click();
        changer_count.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        changer_count.sendKeys(String.valueOf(count));
    }

    @Step("Try to do price more, while it is lower then 2999")
    public void doPriceMore() throws InterruptedException {
        while (count * one_brush < 2999)
        {
            count++;
            WebElement changer_count = driver.findElement(count_change);
            changer_count.click();
            changer_count.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            changer_count.sendKeys(String.valueOf(count));
        }
        Thread.sleep(5000);
        Assert.assertEquals(true, Integer.parseInt(driver.findElement(brush_price).getText()) > 2999);
    }

    @Step("Check that basketform show real price")
    public void checkSummary()
    {
        Assert.assertEquals(one_brush * count, Integer.parseInt(driver.findElement(basket_price).getText()));
    }
}
