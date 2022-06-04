package PO;

import Decorators.CustomFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HistoryPO {
    @FindBy(xpath = "//a[contains(@class,\"src ltr\")]")
    private List<WebElement> searchedWords;

    private WebDriver driver;

    public HistoryPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(this.driver), this);
    }

    public Boolean getSearchedWord(String searchedWord){
        for(WebElement word : searchedWords){
            if(word.getText().equals(searchedWord)){
                return true;
            }
        }
        return false;
    }
}
