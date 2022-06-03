package UI;

import BrowserFactory.BrowserFactory;
import ReversoBO.ReversoBO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReversoUkrainianTranslationTC {
    private WebDriver driver;

    @DataProvider
    Object[][] translationWords() {
        //There must be Ukrainian to translate or be translated
        return new Object[][]{
                {"English", "Ukrainian","ball","м'яч"},
                {"Ukrainian", "Polish","привіт","cześć"},
                {"Ukrainian","French","собака","chien"}
        };
    }

    @BeforeTest
    void init() {
        driver = BrowserFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "translationWords")
    void TranslationTest(String firstLanguage,String secondLanguage,String word,String translatedWord){
        ReversoBO reversoBO = new ReversoBO(driver);

        reversoBO.homePage();

        reversoBO.goTranslationPage();

        reversoBO.selectFirstLanguage(firstLanguage);

        reversoBO.selectSecondLanguage(secondLanguage);

        reversoBO.inputWord(word);

        Assert.assertTrue(reversoBO.getTranslatedWord(translatedWord));

    }

    @AfterTest
    void close() {
        driver.close();
        driver.quit();
    }
}
