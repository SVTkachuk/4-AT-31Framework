package UI;

import ReversoBO.ReversoBO;
import BrowserFactory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReversoLogInTC {
    private WebDriver driver;

    @DataProvider
    Object[][] loginProvider() {
        return new Object[][]{
                {"testikVisim@gmail.com", "dfwew33"},
                {"testikVisim@gmail.com", "d232Fasd"},
                {"mrWf", "fdger"}
        };
    }

    @BeforeTest
    void init() {
        driver = BrowserFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "loginProvider")
    void loginTest(String login, String password) {
        ReversoBO reversoBO = new ReversoBO(driver);

        reversoBO.homePage();

        reversoBO.clickLogin();

        reversoBO.signUp(login, password);

        Assert.assertTrue(reversoBO.checkLogged());

    }

    @AfterTest
    void close() {
         driver.quit();
        driver.close();

    }
}
