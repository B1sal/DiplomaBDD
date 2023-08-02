import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.AdminPage;
import pageObject.LoginPage;

import java.time.Duration;

public class StepDefinitions {

    public Platform platform;

    @Before
    public void init() {
        platform = new Platform();
    }

    @After
    public void tearDown() {
        platform.getDriver().quit();
    }

    @Given("user opens orange hrm website")
    public void openUrl() {
        platform.hitURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @And("^user enters username (.*) and password (.*)$")
    public void login(String userName, String password) {
        platform.loginUsingUsernameAndPassword(userName, password);
    }


    @And("^user enters username (.*), password (.*) and submit$")
    public void enterLoginAndValidate(String userName, String password) {
        platform.loginUsingUsernameAndPassword(userName, password);
    }

    @And("user clicks on login button")
    public void clickLogin(){
        platform.clickOnLoginButton();
    }

    @Then("user validates Invalid credentials error message")
    public  void validateMessage() {
        platform.validateErrorMessages("Invalid credentials");
    }

    @When("^user clicks on navTab (.*)$")
    public void clickNavTab(String linkText){
        platform.clickOnNavLink(linkText);
    }

    @Then("^page title should be text (.*)$")
    public void validateHeader(String headerText){
        platform.validateHeaderText(headerText);
    }

    @When("^user enters userID (.*), employeeName (.*), userRole (.*) and status (.*)$")
    public void enterExistingUserDetails(String userName, String employeeName, String userRole, String stat){
        platform.fillUserName(userName);
        platform.fillEmployeeName(employeeName);
        platform.selectUserRole(userRole);
        platform.selectStatus(stat);
    }
    @When("^user enters userID (.*), employeeName (.*), userRole (.*), status (.*) and password (.*)$")
    public void enterNewEmployeeDetails(String userName, String employeeName, String userRole, String stat, String pswd){
        platform.fillUserName(userName);
        platform.fillEmployeeName(employeeName);
        platform.selectUserRole(userRole);
        platform.selectStatus(stat);
        platform.fillUserPwd(pswd);

    }

    @Then("user validates error messages for missing username and password")
    public void validateErrorMessageForMissingFields(){
        platform.validateEmptyUserErrorMsg("Required");
        platform.validateEmptyPswdErrorMsg("Required");
    }

    @When("user clicks on forgot your password link")
    public void clickForgotPassword(){
        platform.clickOnResetPswd();
    }

    @Then("user is redirected to reset password page")
    public void validateResetPage(){
        platform.validateResetPswdPage("Reset Password");
    }

    @And("user clicks on search button")
    public void clickOnSearchButton() {
        platform.clickSearch();
    }

    @Then("^user validates correct employee record of (.*) is displayed$")
    public void validateDisplayedRecord(String userName){
        platform.validateUserRecord(userName);
    }

    @When("user clicks on add new button")
    public void clickAddButton(){
        platform.clickOnAddNew();
    }

    @And("user clicks on save button")
    public void clickSaveButton(){
        platform.clickOnSave();
    }

    @Then("^user validates new employee record of (.*) is added$")
    public void validateAddedEmployeeRecord(String userName){
        platform.validateUserRecord(userName);
    }

    @And("user clicks on logout button")
    public void clickLogOutButton(){
        platform.clickOnProfileIcon();
        platform.clickOnLogOut();
    }

    @Then("user validates that login page is shown again")
    public void validateLoginPageTitle(){
        platform.validateLoginPage("Login");
    }

    @And("^user clicks on delete button of user (.*)$")
    public void deleteExistingUser(String userName){
        platform.deleteUserRecord(userName);
        platform.confirmDelete();
    }

    @Then("user validates the successful deletion message")
    public void successfulDeleteMessage(){
        platform.validateDeleteMessage("Successfully Deleted");
    }

    @Then ("^user validates all error messages (.*) are shown while adding new user$")
    public void validateAddUserErrorMsg(String msg){
        platform.validateInputErrorMsg(msg);
    }

    @When ("^user clicks on search filters (.*) from dropdown menu$")
    public void clickSearchFilterOptions(String filterName){
        platform.selectFilter(filterName);
    }

    @Then ("^user validates selected (.*) page is displayed$")
    public void validateFilteredPageTitle(String pageTitle){
        platform.validateFilteredPage(pageTitle);
    }

    @Then ("^user validates all the info sections (.*) are displayed$")
    public void validateInfoSections(String sectionTitle){
        platform.validateSectionTitle(sectionTitle);
    }

    @When ("user clicks on help button")
    public void clickHelpButton(){
        platform.clickOnHelpButton();
    }

    @Then ("user should be redirected to help page")
    public void validateHelpPage(){
        platform.validateHelpPageUrl();
    }

    @When ("user clicks on About option")
    public void clickAboutOption(){
        platform.clickOnAbout();
    }

    @Then ("user validates About popup is displayed")
    public void validateAboutPopUp(){
        platform.validateAboutPopUp();
    }

    @And ("^user clicks on edit button of user (.*)$")
    public void clickOnEditButton(String userName){
        platform.editUserRecord(userName);
    }

    @And ("^user renames username to (.*)$")
    public void renameUser(String userID){
        platform.fillEmployeeName(userID);
    }

    @Then ("^user validates edited employee record of user (.*)$")
    public void validatedEditedRecord(String userName){
        platform.validateUserRecord(userName);
    }
}
