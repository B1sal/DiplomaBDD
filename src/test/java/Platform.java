import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pageObject.AdminPage;
import pageObject.DashboardPage;
import pageObject.LoginPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;

public class Platform {

    private WebDriver driver;
    private Util util;
    private LoginPage loginPage;
    private AdminPage adminPage;
    private DashboardPage dashboardPage;
    private DriverFactory driverFactory;

    public Platform(){
        driverFactory = new DriverFactory();
        driver = driverFactory.createDriver("Chrome");
        if(driver!=null){
            util = new Util();
//            util.myImplicitWait(driver,10);

            loginPage = new LoginPage();
            adminPage = new AdminPage();
            dashboardPage = new DashboardPage();
            WebDriverRunner.setWebDriver(driver);
            Configuration.timeout = 5000;
        }
        else{
            System.out.println("the driver entered is invalid!!!");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void hitURL(String urlValue) {
        driver.get(urlValue);
    }

    public void loginUsingUsernameAndPassword(String loginName, String password) {
        loginPage.getUserName().should(visible, Duration.ofSeconds(5)).sendKeys(loginName);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLoginButton().click();
    }

    public void clickOnLoginButton(){
        loginPage.getLoginButton().should(visible, Duration.ofSeconds(5)).click();
    }

    public void validateErrorMessages(String Message){
        loginPage.getErrorMessage().shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(text(Message));

    }

    public void clickOnNavLink(String linkValue){
        dashboardPage.getLeftNavigationLink(linkValue).should(visible, Duration.ofSeconds(5)).click();
    }

    public void validateHeaderText(String headText){
       dashboardPage.getHeader(headText).shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(text(headText));
    }

    public void fillUserName(String user){
        adminPage.getInputBox("Username").should(visible, Duration.ofSeconds(5)).sendKeys(user);
    }

    public void fillEmployeeName(String employeeId){
        adminPage.getInputBox("Employee Name").sendKeys(employeeId);
        adminPage.getEmployeeSuggest().shouldHave(exactText(employeeId), Duration.ofSeconds(5)).click();
    }

    public void fillUserPwd(String pwd){
        adminPage.getUserPwd().should(visible, Duration.ofSeconds(5)).sendKeys(pwd);
        adminPage.getUserPwdConfirm().sendKeys(pwd);
    }
    public void selectUserRole(String role){
        adminPage.getDropDownLIst("User Role").click();
        adminPage.getDropDownOption(role).should(visible, Duration.ofSeconds(5)).click();
    }
    public void selectStatus(String stat){
        adminPage.getDropDownLIst("Status").click();
        adminPage.getDropDownOption(stat).should(visible, Duration.ofSeconds(5)).click();
    }
    public void clickOnResetPswd(){
        loginPage.getForgotPswdButton().should(visible, Duration.ofSeconds(5)).click();
    }

    public void validateResetPswdPage(String pageTitle){
        loginPage.getResetPswdTitle().shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(text(pageTitle));
    }

    public void validateEmptyUserErrorMsg(String errMsg1){
        loginPage.getEmptyUserError().shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(text(errMsg1));
    }

    public void validateEmptyPswdErrorMsg(String errMsg2){
        loginPage.getEmptyPswdError().shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(text(errMsg2));
    }

    public void clickOnProfileIcon(){
        adminPage.getProfileOption().should(visible, Duration.ofSeconds(5)).click();
    }

    public void clickOnLogOut(){
        adminPage.getLogOut().click();
    }

    public void validateLoginPage(String pageHeader){
        loginPage.getLoginPageTitle().shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(text(pageHeader));
    }

    public void clickSearch(){
        adminPage.getSearchButton().click();
    }

    public void validateUserRecord(String userId){
        adminPage.getRecordUserName(userId).shouldBe(Condition.visible, Duration.ofSeconds(8)).shouldHave(text(userId));
    }

    public void clickOnSave(){
        adminPage.getSaveButton().click();
    }

    public void clickOnAddNew(){
        adminPage.getAddUser().click();
    }

    public void deleteUserRecord(String userId){
        adminPage.getDeleteAction(userId).click();
    }
    public void editUserRecord(String userId){
        adminPage.getEditAction(userId).click();
    }
    public void confirmDelete(){
        adminPage.getConfirmDelete().click();
    }
    public void validateDeleteMessage(String msg){
        adminPage.getDeleteMessage().shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(text(msg));
    }

    public void validateInputErrorMsg(String msg){
        adminPage.getInputErrorMsg("User Role").shouldHave(text(msg));
        adminPage.getInputErrorMsg("Employee Name").shouldHave(text(msg));
        adminPage.getInputErrorMsg("Status").shouldHave(text(msg));
        adminPage.getInputErrorMsg("Username").shouldHave(text(msg));
        adminPage.getInputErrorMsg("Password").shouldHave(text(msg));
        adminPage.getInputErrorMsg("Confirm Password").shouldHave(text(msg));
    }

    public void selectFilter(String listName){
        adminPage.getFilterDropDown().click();
        adminPage.getFilterList(listName).click();
    }

    public void validateFilteredPage(String pageName){
        adminPage.getFilteredPageTitle(pageName).shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(text(pageName));
    }

    public void validateSectionTitle(String infoTitle){
        dashboardPage.getInfoSectionTitle(infoTitle).shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(text(infoTitle));
    }

    public void clickOnHelpButton(){
        dashboardPage.getHelpButton().should(visible, Duration.ofSeconds(5)).click();
    }

    public void validateHelpPageUrl(){
        switchTo().window(1);
        String currentUrl = url();
        assert currentUrl.contains("https://starterhelp.orangehrm.com/hc/en-us");
    }

    public void clickOnAbout(){
        adminPage.getProfileOption().click();
        adminPage.getAboutButton().click();
    }

    public void validateAboutPopUp(){
        adminPage.getAboutTitle().shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(text("About"));
    }

}
