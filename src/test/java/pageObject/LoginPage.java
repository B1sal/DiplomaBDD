package pageObject;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage{

    public String inputUsername = "//input[@placeholder=\"Username\"]";
    public String inputPassword = "//input[@name=\"password\"]";
    public String buttonLogin = "//button[text()=\" Login \"]";
    public String textInvalidCredit = "//p[text()=\"Invalid credentials\"]";
    public String buttonForgotPswd = "//*[text()=\"Forgot your password? \"]";
    public String textResetPswd = "//h6[text()=\"Reset Password\"]";
    public String errorMsgUser = "(//span[text()=\"Required\"])[1]";
    public String errorMsgPswd = "(//span[text()=\"Required\"])[2]";
    public String textPageTile = "//h5[text()=\"Login\"]";

    private WebDriver driver;


//    public LoginPage(WebDriver driver){
//        this.driver=driver;
//    }

    public SelenideElement getUserName() {
       return $x(inputUsername);
    }

    public SelenideElement getPassword() {

        return $x(inputPassword);
    }

    public SelenideElement getLoginButton() {
       return $x(buttonLogin);
    }

    public SelenideElement getErrorMessage() {
        return $x(textInvalidCredit);
    }

    public SelenideElement getForgotPswdButton(){
        return $x(buttonForgotPswd);
    }

    public SelenideElement getResetPswdTitle(){
        return $x(textResetPswd);
    }

    public SelenideElement getEmptyUserError(){
        return $x(errorMsgUser);
    }

    public SelenideElement getEmptyPswdError(){
        return $x(errorMsgPswd);
    }

    public SelenideElement getLoginPageTitle(){
        return $x(textPageTile);
    }
}
