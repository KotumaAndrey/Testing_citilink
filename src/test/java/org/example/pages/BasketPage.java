package org.example.pages;

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

    private By brush_price = By.cssSelector(".cart_item.cart_item_705901__js td span.price ins.num");
    private By basket_price = By.cssSelector(".payment_block p span ins.num.order_amount_field");
    private By count_change = By.cssSelector("#product_705901");
    private int one_brush;
    private int count = 2;


    public void checkPrice() {

        Assert.assertEquals(true, Integer.parseInt(driver.findElement(brush_price).getText()) == Integer.parseInt(driver.findElement(basket_price).getText()));
    }

    public void addOne()
    {
        one_brush = Integer.parseInt(driver.findElement(brush_price).getText());
        WebElement changer_count = driver.findElement(count_change);
        changer_count.click();
        changer_count.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        changer_count.sendKeys(String.valueOf(count));
    }

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

    public void checkSummary()
    {
        Assert.assertEquals(one_brush * count, Integer.parseInt(driver.findElement(basket_price).getText()));
    }
}
