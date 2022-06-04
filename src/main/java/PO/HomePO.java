package PO;

import Decorators.CustomFieldDecorator;
import Decorators.WebButton;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.tree.ExpandVetoException;
import java.sql.Time;
import java.time.Duration;
import java.util.List;


public class HomePO {

    @FindBy(xpath = "//span[contains(@class, \"icon user\")]/..")
    private WebButton loginButtonFirst;
    @FindBy(xpath = "//a[contains(@class, \"option login sep-24\")]")
    private WebButton getLoginButtonSecond;
    @FindBy(xpath = "//span[contains(@class, \"icon user-dot\")]/..")
    private WebButton profileButton;
    @FindBy(xpath = "//span[contains(@class, \"text username\")]")
    private WebElement profile;
    @FindBy(xpath = "//a[contains(@class, \"translation-link product\")]")
    private WebButton translationLink;
    @FindBy(xpath = "//a[contains(@class, \"speller-link product\")]")
    private WebButton checkGrammarLink;
    @FindBy(xpath = "//a[contains(@class, \"synonyms-link product\")]")
    private WebButton synonymsCheckLink;
    @FindBy(xpath = "//*[@id=\"entry\"]")
    private WebElement wordSearchInput;
    @FindBy(xpath = "//*[@id=\"search-button\"]")
    private WebButton searchButtonSubmit;
    @FindBy(xpath = "//a[contains(@title,\"History\")]")
    private WebButton historyLink;
    @FindBy(xpath = "//button[contains(@class, \"close\")]")
    private WebElement buttonClose;

    private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(this.driver), this);
    }

    public void homePage() {
        driver.get("https://context.reverso.net/translation/");
    }

    public void clickLogin() {
        loginButtonFirst.buttonClick();
        getLoginButtonSecond.buttonClick();
    }

    public Boolean checkLogged() {
        profileButton.buttonClick();
        return profile.isDisplayed();
    }

    public void goTranslationPage() {
        translationLink.buttonClick();
    }

    public void goCheckGrammarPage() {
        checkGrammarLink.buttonClick();
    }


    public void goSynonymsCheckPage() {
        synonymsCheckLink.buttonClick();
    }

    public void checkVisibilityOfWordInput(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try{
            wait.until(ExpectedConditions.visibilityOf(wordSearchInput));
        }
        catch (TimeoutException e){
            System.out.println("Time out");
        }
    }

    public void closeModalWindow(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try{
            wait.until(ExpectedConditions.visibilityOf(buttonClose));
            buttonClose.click();
        }
        catch (TimeoutException e){
        }

    }

    public void searchWord(String word){
        wordSearchInput.sendKeys(word);
    }

    public void submitWordSearch(){
        searchButtonSubmit.buttonClick();
    }

    public void goHistoryPage(){
        historyLink.buttonClick();
    }


}
