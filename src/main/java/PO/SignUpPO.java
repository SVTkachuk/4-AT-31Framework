package PO;

import Decorators.CustomFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPO {
    @FindBy(xpath = "//*[@id=\"Email\"]")
    private WebElement loginInput;
    @FindBy(xpath = "//*[@id=\"Password\"]")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(@type, \"submit\")]")
    private WebElement submitButton;

    private WebDriver driver;

    public SignUpPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(this.driver), this);
    }

    public void insertLogin(String login) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(loginInput));
        loginInput.sendKeys(login);
    }

    public void insertPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickSubmit(){
        submitButton.click();
    }

}
