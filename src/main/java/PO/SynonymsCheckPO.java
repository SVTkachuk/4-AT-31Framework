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

import java.time.Duration;
import java.util.List;

public class SynonymsCheckPO {
    @FindBy(xpath = "//textarea")
    private WebElement textArea;
    @FindBy(xpath = "//div[contains(@class,\"word-opt\")]")
    private List<WebElement> synonymsContainer;
    @FindBy(xpath = "//button[contains(@id,\"search-button\")]")
    private WebButton buttonSearch;


    private String SYNONYM_XPATH = "//li";

    private WebDriver driver;


    public SynonymsCheckPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(this.driver), this);
    }

    public void textAreaIsPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOf(textArea));
        } catch (TimeoutException e) {
            System.out.println("Time out");
        }
    }

    public void insertWord(String word) {
        textArea.sendKeys(word);
    }

    public void searchSynonyms(){
        buttonSearch.buttonClick();
    }

    public Boolean getSynonyms(String expectedResult) {
        List<WebElement> synonyms = synonymsContainer.get(0).findElements(By.xpath(".//li"));
        List<String> s = null;
       for(WebElement synonym : synonyms){
           System.out.println(synonym.getText());
           if(synonym.getText().equals(expectedResult)){
               return true;
           }
       }
       return false;
    }
}
