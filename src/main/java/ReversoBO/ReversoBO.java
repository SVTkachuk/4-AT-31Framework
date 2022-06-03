package ReversoBO;

import PO.HomePO;
import PO.SignUpPO;
import PO.TranslationPO;
import org.openqa.selenium.WebDriver;

public class ReversoBO {

    private WebDriver driver;

    private HomePO homePO;
    private SignUpPO signUpPO;
    private TranslationPO translationPO;


    public ReversoBO(WebDriver driver) {
        this.driver = driver;
        this.homePO = new HomePO(this.driver);
        this.signUpPO = new SignUpPO(this.driver);
        this.translationPO = new TranslationPO(this.driver);
    }


    public void homePage() {
        homePO.homePage();
    }

    public void clickLogin() {
        homePO.clickLogin();
    }

    public void signUp(String login, String password) {
        signUpPO.signUp(login, password);
    }

    public Boolean checkLogged() {
        return homePO.checkLogged();
    }

    public void goTranslationPage(){
        homePO.goTranslationPage();
    }

    public void selectFirstLanguage(String language){
        translationPO.clickFirstDropdown();
        translationPO.selectFirstLanguage(language);
    }

    public void selectSecondLanguage(String language){
        translationPO.clickSecondDropdown();
        translationPO.selectSecondLanguage(language);
    }

    public void inputWord(String word){
        translationPO.inputWord(word);
    }

    public Boolean getTranslatedWord(String word){
        return translationPO.getTranslatedWord(word);
    }

}
