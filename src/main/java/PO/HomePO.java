package PO;

import Decorators.CustomFieldDecorator;
import Decorators.WebButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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
}
