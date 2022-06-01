package PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPO {

    private WebDriver driver;

    public SignUpPO(WebDriver driver){
        this.driver=driver;
    }

    public void signUp(String login, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Email\"]")));
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(login);
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"account\"]/div[7]/button")).click();
    }

}
