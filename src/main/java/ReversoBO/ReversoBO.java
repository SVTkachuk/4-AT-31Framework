package ReversoBO;

import PO.CheckGrammarPO;
import PO.HomePO;
import PO.SignUpPO;
import PO.TranslationPO;
import org.openqa.selenium.WebDriver;

public class ReversoBO {

    private WebDriver driver;

    private HomePO homePO;
    private SignUpPO signUpPO;
    private TranslationPO translationPO;
    private CheckGrammarPO checkGrammarPO;


    public ReversoBO(WebDriver driver) {
        this.driver = driver;
        this.homePO = new HomePO(this.driver);
        this.signUpPO = new SignUpPO(this.driver);
        this.translationPO = new TranslationPO(this.driver);
        this.checkGrammarPO = new CheckGrammarPO(this.driver);
    }


    public void homePage() {
        homePO.homePage();
    }

    public void clickLogin() {
        homePO.clickLogin();
    }

    public void signUp(String login, String password) {
        signUpPO.insertLogin(login);
        signUpPO.insertPassword(password);
        signUpPO.clickSubmit();
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

    public void goGrammarCheckPage(){
        homePO.goCheckGrammarPage();
    }

    public void wrightSentence(String sentence){
        checkGrammarPO.insertSentence(sentence);
    }

    public void checkSentence(){
        checkGrammarPO.pressCheckButton();
    }

    public String getCorrectSentence(){
       return checkGrammarPO.getCorrectedPhrase();
    }

}
