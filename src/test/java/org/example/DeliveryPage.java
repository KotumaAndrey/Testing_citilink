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
    private String cityName = "Курск";

    public void ChangeCity() {
        driver.findElement(userMenu).click();
        driver.findElement(By.partialLinkText(cityName)).click();
    }

    public void CheckChange()
    {
        Assert.assertEquals(cityName, driver.findElement(cityNameCheck).getText());
    }


}
