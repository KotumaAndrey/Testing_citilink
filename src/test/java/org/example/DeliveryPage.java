package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DeliveryPage {
    public WebDriver driver;

    public DeliveryPage(WebDriver drivers) {
        this.driver = drivers;
    }
    private By userMenu = By.cssSelector(".pseudo.pseudo_dashed.popup_close.city-popup_toggle-button__js");
    private By cityNameCheck = By.className("popup_close");
    private By cityDeliveryFind = By.cssSelector("#content > div > div > h1:nth-child(1) > span");
    private By deliveryPage = By.cssSelector("#layout > header > div > div:nth-child(1) > div > div.header_inner__section-list > div:nth-child(5) > a");


    public void ChangeCity(String cityname) {
        driver.findElement(userMenu).click();
        driver.findElement(By.partialLinkText(cityname)).click();
    }

    public void CheckChange(String cityname) {
        Assert.assertEquals(cityname, driver.findElement(cityNameCheck).getText());
    }

    public void CheckDelivery(String cityname) {
        driver.findElement(deliveryPage).click();
        String name = driver.findElement(cityDeliveryFind).getText();
        Assert.assertEquals(name.contains(cityname), true);
    }

}
