package PO;

import Decorators.CustomFieldDecorator;
import Decorators.WebButton;
import Decorators.WebInput;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckGrammarPO {
    @FindBy(xpath = "//textarea")
    private WebInput textArea;
    @FindBy(xpath = "//button[contains(@type, \"correct\")]")
    private WebButton correctButton;
    @FindBy(xpath = "//span[contains(@class,\"corrected-phrase__displayed\")]")
    private List<WebElement> correctedPhrase;

    private WebDriver driver;

    public CheckGrammarPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(this.driver), this);
    }

    public void insertSentence(String sentence){
        textArea.inputText(sentence);
    }

    public void pressCheckButton(){
        correctButton.buttonClick();
    }

    public String getCorrectedPhrase(){
        String sentence="";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(correctedPhrase));
        }
        catch (TimeoutException e){
            System.out.println("Time out");
        }
        for (WebElement word: correctedPhrase){
            sentence+=word.getText();
        }
       return sentence;
    }
}
