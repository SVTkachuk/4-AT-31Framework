package UI;

import Allure.AllureTestListener;
import BrowserFactory.BrowserFactory;
import ReversoBO.ReversoBO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({
        AllureTestListener.class
})

public class ReversoGrammarCheckTC {
    private WebDriver driver;

    @DataProvider
    Object[][] grammarSentence() {
        return new Object[][]{
                {"I is student", "I am a student"},
                {"I likes these course", "I like this course"},
                {"It are funny to do","It is fun to do"}
        };
    }

    @BeforeTest
    void init() {
        driver = BrowserFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "grammarSentence")
    void grammarCheck(String sentence, String expectedSentence){
        ReversoBO reversoBO = new ReversoBO(driver);

        reversoBO.homePage();

        reversoBO.goGrammarCheckPage();

        reversoBO.wrightSentence(sentence);

        reversoBO.checkSentence();

        Assert.assertEquals(reversoBO.getCorrectSentence(),expectedSentence);


    }

    @AfterTest
    void close() {
        driver.close();
        driver.quit();
    }
}
