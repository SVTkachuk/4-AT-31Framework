package Decorators;

import org.openqa.selenium.WebElement;

public class WebButton extends Element{

    public WebButton(WebElement webElement) {
        super(webElement);
        this.webElement = webElement;
    }

    public void buttonClick(){
        webElement.click();
    }
}
