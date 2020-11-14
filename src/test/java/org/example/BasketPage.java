package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BasketPage {
    public WebDriver driver;

    public BasketPage(WebDriver drivers) {
        this.driver = drivers;
    }

    private By brush_price = By.cssSelector("#content > div > div.cart_list.order_page_block > table > tbody:nth-child(3) > tr.cart_item.cart_item_1432126__js > td.price > span > ins.num");
    private By basket_price = By.cssSelector("#layout > div.main_content > div > aside > div > div > div:nth-child(2) > div > p:nth-child(1) > span.price.cart_cost > ins.num.order_amount_field");
    private By count_change = By.cssSelector("#product_1432126");
    private int one_brush;
    private int count = 2;


    public void CheckPrice()
    {
        Assert.assertEquals(true, Integer.parseInt(driver.findElement(brush_price).getText()) == Integer.parseInt(driver.findElement(basket_price).getText()));
    }

    public void AddOne()
    {
        one_brush = Integer.parseInt(driver.findElement(brush_price).getText());
        WebElement changer_count = driver.findElement(count_change);
        changer_count.click();
        changer_count.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        changer_count.sendKeys(String.valueOf(count));
    }

    public void DoPriceMore() throws InterruptedException {
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

    public void CheckSummary()
    {
        Assert.assertEquals(one_brush * count, Integer.parseInt(driver.findElement(basket_price).getText()));
    }
}
