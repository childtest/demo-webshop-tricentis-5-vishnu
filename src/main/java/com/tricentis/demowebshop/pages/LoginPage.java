package com.tricentis.demowebshop.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demowebshop.customlisteners.CustomListeners;
import com.tricentis.demowebshop.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1")
    WebElement loginPageTitle;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement email;

    @CacheLookup
    @FindBy(name = "Password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//input[@value = 'Log in']")
    WebElement btnLogin;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'validation-summary-errors']")
    WebElement errorMessage;

    public String getLoginPageTitle() {
        Reporter.log("get login page title : " + loginPageTitle.toString());
        CustomListeners.test.log(Status.PASS, "get login page title : " + loginPageTitle.toString());
        return getTextFromElement(loginPageTitle);
    }

    public void enterEmailId(String emailId) {
        sendTextToElement(email, emailId);
        Reporter.log("Enter EmailId" + email);
        CustomListeners.test.log(Status.PASS, "Enter EmailId" + email);
    }

    public void enterPassword(String pass) {
        sendTextToElement(password, pass);
        Reporter.log("Enter Password " + password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);
    }

    public void clickOnLoginButton() {
        clickOnElement(btnLogin);
        Reporter.log("Click on loginButton :" + btnLogin.toString());
        CustomListeners.test.log(Status.PASS, "Click on loginButton :" + btnLogin.toString());
    }

    public void enterEmailAndPasswordForLogin(String email, String pass){
        enterEmailId(email);
        enterPassword(pass);
        clickOnLoginButton();
    }

    public String getErrorMessage() {
        CustomListeners.test.log(Status.PASS, "Get errorMessage : " + errorMessage.toString());
        return getTextFromElement(errorMessage);
    }


}
