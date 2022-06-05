package PO;

import Decorators.CustomFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HistoryPO {
    @FindBy(xpath = "//a[contains(@class,\"src ltr\")]")
    private List<WebElement> searchedWords;
    @FindBy(xpath = "//div[@class=\"results\"]")
    private WebElement searchedWordsContainer;

    private WebDriver driver;

    public HistoryPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(this.driver), this);
    }

    public Boolean getSearchedWord(String searchedWord){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(searchedWordsContainer));

        for(WebElement word : searchedWords){
            if(word.getText().equals(searchedWord)){
                System.out.println(word.getText());
                return true;
            }
        }
        return false;
    }
}
