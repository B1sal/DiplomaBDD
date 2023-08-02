package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$x;

public class AdminPage {



    public String newUserAdd = "//button[text()=\" Add \"]";
    public String inputFields = "//label[text()='%s']//../following-sibling::div/descendant::input";
    public String dropDownList = "//label[text()='%s']//../following-sibling::div/descendant::i";
    public String selectListOptions = "//*[text()='%s']";
    public String inputUserPwd = "(//*[@type=\"password\"])[1]";
    public String buttonSearch = "//button[@type=\"submit\"]";
    public String inputUserPwdConfirm = "(//*[@type=\"password\"])[2]";
    public String newUserSave = "//button[text()=\" Save \"]";
    public String buttonProfile = "//span[@class=\"oxd-userdropdown-tab\"]";
    public String buttonLogOut = "//a[text()=\"Logout\"]";
    public String userNameRow = "//div[text()='%s']";
    public String employeeList = "//div[@class=\"oxd-autocomplete-text-input--after\"]//../following-sibling::div";
    public String buttonDelete = "(//*[text()='%s']//../following-sibling::div/descendant::button)[1]";
    public String buttonEdit = "(//*[text()='%s']//../following-sibling::div/descendant::button)[2]";
    public String buttonConfirmDelete = "//button[text()=\" Yes, Delete \"]";
    public String successDeleteMessage = "//*[text()=\"Successfully Deleted\"]";
    public String inputErrorMsg = "//label[text()='%s']//../following-sibling::span";
    public String filterDropDown = "//span[text()=\"Job \"]";
    public String filterList = "//a[text()='%s']";
    public String filterPageTitle = "//h6[text()='%s']";
    public String buttonAbout = "//a[text()=\"About\"]";
    public String titleAboutPopUP = "//h6[text()=\"About\"]";

    private WebDriver driver;

//    public AdminPage(WebDriver driver) {
//        this.driver=driver;
//    }

    public SelenideElement getAddUser() {return $x(newUserAdd);}
    public SelenideElement getInputBox(String fieldLabel) {
        return $x(inputFields.replace("%s", fieldLabel));
    }
    public SelenideElement getDropDownLIst(String listLabel) {
        return $x(dropDownList.replace("%s", listLabel));
    }
    public SelenideElement getUserPwd() {return $x(inputUserPwd);}
    public SelenideElement getUserPwdConfirm() {return $x(inputUserPwdConfirm);}
    public SelenideElement getSaveButton() {return $x(newUserSave);}
    public SelenideElement getDropDownOption(String userRole) {return $x(selectListOptions.replace("%s", userRole));}
    public SelenideElement getSearchButton(){
        return $x(buttonSearch);
    }
    public SelenideElement getProfileOption(){
        return $x(buttonProfile);
    }
    public SelenideElement getLogOut(){
        return $x(buttonLogOut);
    }
    public SelenideElement getRecordUserName(String userText){
        return $x(userNameRow.replace("%s", userText));
    }
    public SelenideElement getEmployeeSuggest() {
        return $x(employeeList);
    }
    public SelenideElement getDeleteAction(String userName){
        return $x(buttonDelete.replace("%s", userName));
    }
    public SelenideElement getEditAction(String userName){
        return $x(buttonEdit.replace("%s", userName));
    }
    public SelenideElement getConfirmDelete(){
        return $x(buttonConfirmDelete);
    }
    public SelenideElement getDeleteMessage(){
        return $x(successDeleteMessage);
    }
    public SelenideElement getInputErrorMsg(String inputName){
        return $x(inputErrorMsg.replace("%s", inputName));
    }
    public SelenideElement getFilterDropDown(){
        return $x(filterDropDown);
    }
    public SelenideElement getFilterList(String filterName){
        return $x(filterList.replace("%s", filterName));
    }
    public SelenideElement getFilteredPageTitle(String pageTitle){
        return $x(filterPageTitle.replace("%s", pageTitle));
    }
    public SelenideElement getAboutButton(){
        return $x(buttonAbout);
    }
    public SelenideElement getAboutTitle(){
        return $x(titleAboutPopUP);
    }
}
