package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private By userMenu = By.cssSelector(".auth-user-popup__text.dropdown__toggle span");



    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".auth-user-popup__text.dropdown__toggle")));
        String userName = driver.findElement(userMenu).getText();
        return userName;
    }

}
