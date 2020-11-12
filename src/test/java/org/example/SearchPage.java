package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Collection;

public class SearchPage {
    public WebDriver driver;

    public SearchPage(WebDriver drivers) {
        this.driver = drivers;
    }
    private By catalog_1 = By.cssSelector("#page > footer > div.footer__inner > div > div:nth-child(2) > p:nth-child(7) > a");
    private By catalog_2 = By.cssSelector("#content > div > div:nth-child(4) > ul:nth-child(1) > li > div > div > ul > li:nth-child(10) > a");
    private By catalog_3 = By.cssSelector("#category_id_216 > li > a");
    private By min = By.className("min min-input_js");
    private By max = By.className("max max-input_js");
    private By costs = By.cssSelector(".subcategory-product-item__price-num");



    public void OpenCatalog(){
        driver.findElement(catalog_1).click();
        driver.findElement(catalog_2).click();
        driver.findElement(catalog_3).click();
    }

    public void FindByCost(){
        driver.findElement(min).clear();
        driver.findElement(max).clear();
        driver.findElement(min).sendKeys("999");
        driver.findElement(max).sendKeys("1999");
        for ( WebElement x: driver.findElements(costs)) {
            Assert.assertEquals(true, Integer.parseInt(x.toString()) < 1999 && Integer.parseInt(x.toString()) > 999);
        }


    }

}
