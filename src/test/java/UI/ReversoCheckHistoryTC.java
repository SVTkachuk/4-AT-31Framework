package UI;

import BrowserFactory.BrowserFactory;
import ReversoBO.ReversoBO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ReversoCheckHistoryTC {
    private WebDriver driver;
    private String login = "testikVisim@gmail.com";
    private String password ="d232Fasd";
    private ReversoBO reversoBO;

    @DataProvider
    Object[][] words() {
        return new Object[][]{
                {"code"},
                {"day"},
                {"hard"}
        };
    }


    @BeforeTest
    void init() {
        driver = BrowserFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @BeforeTest
    void login(){
        reversoBO = new ReversoBO(driver);

        reversoBO.homePage();

        reversoBO.clickLogin();

        reversoBO.signUp(login, password);

        reversoBO.homePage();

        reversoBO.closeModalWindow();

    }



    @Test(dataProvider = "words")
    void checkHistory(String word){
        reversoBO.homePage();

        reversoBO.searchWord(word);

        reversoBO.homePage();

        reversoBO.goHistoryPage();

        Assert.assertTrue(reversoBO.getSearchedWord(word));
    }



    @AfterTest
    void driverClose(){
        driver.close();
        driver.quit();
    }

}
