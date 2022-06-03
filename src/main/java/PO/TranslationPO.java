package PO;

import Decorators.CustomFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TranslationPO {
    @FindBy(xpath = "//app-language-select")
    private List<WebElement> dropDowns;
    @FindBy(xpath = "//div[contains(@class, \"language-select-options\")]")
    private List<WebElement> languagesList;
    @FindBy(xpath = "//textarea")
    private List<WebElement> textArea;

    private WebDriver driver;
    private final String LANGUAGE_XPATH = ".//span[contains(text(),\"%s\") and contains(@class, \"lang-label\")]/..";

    public TranslationPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(this.driver), this);
    }

    public void clickFirstDropdown() {
        dropDowns.get(0).click();
    }


    public void clickSecondDropdown() {
        dropDowns.get(1).click();
    }

    public void selectFirstLanguage(String language) {
        languagesList.get(0).findElement(By.xpath(LANGUAGE_XPATH.formatted(language))).click();
    }

    public void selectSecondLanguage(String language) {
        languagesList.get(1).findElement(By.xpath(LANGUAGE_XPATH.formatted(language))).click();
    }

    public void inputWord(String word){
        textArea.get(0).sendKeys(word);
    }

    public Boolean getTranslatedWord(String word){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/app-root/app-translation/div/app-translation-box/div[1]/div[1]/div[2]/div[2]/div[1]/textarea")));
        textArea = driver.findElements(By.xpath("//textarea"));
        try {
            wait.until(ExpectedConditions.attributeToBeNotEmpty(textArea.get(1),"value"));
        }
        catch (TimeoutException e){
            System.out.println("Time Out");
        }
         return textArea.get(1).getAttribute("value").equals(word);
    }
}
