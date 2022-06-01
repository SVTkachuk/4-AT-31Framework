package ReversoBO;

import PO.HomePO;
import PO.SignUpPO;
import org.openqa.selenium.WebDriver;

public class ReversoBO {

    private WebDriver driver;

    private HomePO homePO;
    private SignUpPO signUpPO;


    public ReversoBO(WebDriver driver) {
        this.driver=driver;
        this.homePO = new HomePO(this.driver);
        this.signUpPO = new SignUpPO(this.driver);
    }


    public void homePage(){
        homePO.homePage();
    }

    public void clickLogin(){
        homePO.clickLogin();
    }

    public void signUp(String login, String password){
        signUpPO.signUp(login,password);
    }

    public Boolean checkLogged(){
        return homePO.checkLogged();
    }


}
