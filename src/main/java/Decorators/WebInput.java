package Decorators;

import org.openqa.selenium.WebElement;

public class WebInput extends Element {

    public WebInput(WebElement webElement) {
        super(webElement);
        this.webElement = webElement;
    }

    public void inputText(String text){
        webElement.sendKeys(text);
    }
}
