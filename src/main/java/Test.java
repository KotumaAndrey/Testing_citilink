
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
            //Вуз
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\kotumaaa\\Downloads\\chromedriver_win32\\chromedriver.exe");
            //Дом
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://www.citilink.ru/");

            driver.findElement(By.id("login_form_show_js")).click();

            WebElement LoginForm = (new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.className("auth-popup__form-body"))));

            LoginForm.findElement(By.id("login")).click();
            LoginForm.findElement(By.id("login")).sendKeys("kotumaaa@gmail.com");

            LoginForm.findElement(By.id("pass")).click();
            LoginForm.findElement(By.id("pass")).sendKeys("provn123");

            Thread.sleep(10000);
            LoginForm.submit();

            WebElement web = driver.findElement(By.className("item auth-user-popup__text dropdown__toggle"));
            Assert.assertEquals(web.getText(), "Андрей");


    }
}
