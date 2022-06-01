package PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePO {
    private WebDriver driver;

    public HomePO(WebDriver driver){
        this.driver=driver;
    }

    public void homePage(){
        driver.get("https://context.reverso.net/translation/");
    }

    public void clickLogin(){
        driver.findElement(By.xpath("//*[@id=\"reverso-user-menu\"]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"reverso-user-menu\"]/div[2]/a[2]")).click();
    }

    public Boolean checkLogged(){
        driver.findElement(By.xpath("//*[@id=\"reverso-user-menu\"]/div[1]")).click();
        return driver.findElement(By.xpath("//*[@id=\"reverso-user-menu\"]/div[2]/a[1]/span[2]")).isDisplayed();
    }

}
