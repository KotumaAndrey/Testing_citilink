package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver drivers) {
        this.driver = drivers;
    }



    private By LoginForm =  By.className("auth-popup__form-body");
    private By loginField = By.id("login");
    private By passwdField = By.id("pass");

    @Step("Open LoginForm")
    public void inButton(){
        driver.findElement(By.id("login_form_show_js")).click();
    }

    @Step("Input login in loginform")
    public void inputLogin(String login) {
        driver.findElement(loginField).click();
        driver.findElement(loginField).sendKeys(login);
    }

    @Step("Input password to loginform")
    public void inputPasswd(String passwd) {
        driver.findElement(passwdField).click();
        driver.findElement(passwdField).sendKeys(passwd);
    }

    @Step("Click button to loginning in system")
    public void clickLoginBtn() {
        driver.findElement(LoginForm).submit();
    }


}
