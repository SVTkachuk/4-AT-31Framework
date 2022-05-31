package test;

import BrowserFactory.BrowserFactory;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Testik {
    public WebDriver driver;

    @BeforeTest
    void init(){
        driver = BrowserFactory.getDriver("Chrome");

    }

    @Test
    void kuka(){
        driver.get("https://stackoverflow.com/");
    }

    @AfterTest
    void close(){
        driver.close();
        driver.quit();
    }
}
