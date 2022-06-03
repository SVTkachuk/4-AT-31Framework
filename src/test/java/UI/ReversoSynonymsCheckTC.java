package UI;

import BrowserFactory.BrowserFactory;
import ReversoBO.ReversoBO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReversoSynonymsCheckTC {
    private WebDriver driver;

    @DataProvider
    Object[][] synonyms() {
        return new Object[][]{
                {"programmer", "coder"},
                {"programmer", "builder"},
                {"hello","hi"}
        };
    }

    @BeforeTest
    void init() {
        driver = BrowserFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "synonyms")
    void synonymsCheck(String word, String expectedSynonym){
        ReversoBO reversoBO = new ReversoBO(driver);

        reversoBO.homePage();

        reversoBO.goSynonymsCheckPage();

        reversoBO.writeWordToCheckSynonym(word);

        reversoBO.searchSynonyms();

        Assert.assertTrue(reversoBO.getSynonyms(expectedSynonym));

    }

    @AfterTest
    void driverClose(){
        driver.close();
        driver.quit();
    }

}
