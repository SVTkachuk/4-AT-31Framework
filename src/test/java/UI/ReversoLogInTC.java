package UI;

import ReversoBO.ReversoBO;
import BrowserFactory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReversoLogInTC {
    private WebDriver driver;

    @BeforeTest
    void init(){
        driver = BrowserFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @Test
    void loginTest(){
        ReversoBO reversoBO = new ReversoBO(driver);

        reversoBO.homePage();

        reversoBO.clickLogin();

        reversoBO.signUp("testikVisim@gmail.com","d232Fasd");

        Assert.assertTrue(reversoBO.checkLogged());

    }

    @AfterTest
    void close(){
        driver.close();
        driver.quit();
    }
}
