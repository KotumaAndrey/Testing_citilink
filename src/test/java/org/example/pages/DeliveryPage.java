package org.example.pages;

import io.qameta.allure.Step;
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
    private By cityDeliveryFind = By.cssSelector(".about_content.inside_block h1:first-child span");
    private By deliveryPage = By.cssSelector("[data-link-type = \"Delivery\"] a");


    @Step("Change city to cityname {0}")
    public void changeCity(String cityname) {
        driver.findElement(userMenu).click();
        driver.findElement(By.partialLinkText(cityname)).click();
    }

    @Step("Check change to cityname {0}")
    public void checkChange(String cityname) {
        Assert.assertEquals(cityname, driver.findElement(cityNameCheck).getText());
    }

    @Step("Check deliverypage by cityname {0}")
    public void checkDelivery(String cityname) {
        driver.findElement(deliveryPage).click();
        String name = driver.findElement(cityDeliveryFind).getText();
        Assert.assertEquals(name.contains(cityname), true);
    }

}
