package com.tricentis.demowebshop.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demowebshop.customlisteners.CustomListeners;
import com.tricentis.demowebshop.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1")
    WebElement registerPageTitle;

    @CacheLookup
    @FindBy(xpath = "//input[@id='register-button']")
    WebElement btnRegister;

    @CacheLookup
    @FindBy(xpath = "//span[@for='FirstName']")
    WebElement firstNameIsRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@for='LastName']")
    WebElement lastNameIsRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@for='Email']")
    WebElement emailIsRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@for='Password']")
    WebElement passwordIsRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@for='ConfirmPassword']")
    WebElement confirmPasswordRequired;

    @CacheLookup
    @FindBy(id = "gender-female")
    WebElement genderFemale;

    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement enterFirstName;

    @CacheLookup
    @FindBy(id = "LastName")
    WebElement enterLastName;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement enterEmailId;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement enterConfirmPassword;

    @CacheLookup
    @FindBy(xpath = "//div[@class='result']")
    WebElement successfullyRegisterMessage;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    public String getPageTitle() {
        Reporter.log("get register page title : " + registerPageTitle.toString());
        CustomListeners.test.log(Status.PASS, "get register page title : " + registerPageTitle.toString());
        return getTextFromElement(registerPageTitle);
    }

    public String getErrorMessageOfFirstNameIsRequired() {
        Reporter.log("Firstname is required : " + firstNameIsRequired.toString());
        CustomListeners.test.log(Status.PASS, "Firstname is required : " + firstNameIsRequired.toString());
        return getTextFromElement(firstNameIsRequired);
    }

    public String getErrorMessageOfLastNameIsRequired() {
        Reporter.log("Last name is required : " + lastNameIsRequired.toString());
        CustomListeners.test.log(Status.PASS, "Last name is required : " + lastNameIsRequired.toString());
        return getTextFromElement(lastNameIsRequired);
    }

    public String getErrorMessageOfEmailIsRequired() {
        Reporter.log("Email is required : " + emailIsRequired.toString());
        CustomListeners.test.log(Status.PASS, "Email is required : " + emailIsRequired.toString());
        return getTextFromElement(emailIsRequired);
    }

    public String getErrorMessageOfPasswordIsRequired() {
        Reporter.log("Password is required : " + passwordIsRequired.toString());
        CustomListeners.test.log(Status.PASS, "Password is required : " + passwordIsRequired.toString());
        return getTextFromElement(passwordIsRequired);
    }

    public String getErrorMessageOfConfirmPasswordIsRequired() {
        Reporter.log("Confirm Password is required : " + confirmPasswordRequired.toString());
        CustomListeners.test.log(Status.PASS, "Confirm Password is required : " + confirmPasswordRequired.toString());
        return getTextFromElement(confirmPasswordRequired);
    }

    public void selectGenderOfFemale() {
        Reporter.log("Click on gender of Female");
        CustomListeners.test.log(Status.PASS, "Click on gender of Female");
        clickOnElement(genderFemale);
    }

    public void enterFirstName(String fName) {
        Reporter.log("Enter first name : " + fName);
        CustomListeners.test.log(Status.PASS, "Enter first name : " + fName);
        sendTextToElement(enterFirstName, fName);
    }

    public void enterLastName(String lName) {
        Reporter.log("Enter last name : " + lName);
        CustomListeners.test.log(Status.PASS, "Enter last name : " + lName);
        sendTextToElement(enterLastName, lName);
    }

    public void enterEmailAddress(String email) {
        Reporter.log("Enter email : " + email);
        CustomListeners.test.log(Status.PASS, "Enter email : " + email);
        sendTextToElement(enterEmailId, email);
    }

    public void enterPassword(String pass) {
        Reporter.log("Enter password : " + pass);
        CustomListeners.test.log(Status.PASS, "Enter password : " + pass);
        sendTextToElement(enterPassword, pass);
    }

    public void enterConfirmPassword(String confirmPass) {
        Reporter.log("Enter confirm password : " + confirmPass);
        CustomListeners.test.log(Status.PASS, "Enter confirm password : " + confirmPass);
        sendTextToElement(enterConfirmPassword, confirmPass);
    }

    public void clickOnRegisterButton() {
        clickOnElement(btnRegister);
        Reporter.log("Click on register button : " + btnRegister.toString());
        CustomListeners.test.log(Status.PASS, "Click on register button : " + btnRegister.toString());
    }

    public String getRegisterSuccessMessage() {
        Reporter.log("get register Success message : ");
        CustomListeners.test.log(Status.PASS, "get register Success message : ");
        return getTextFromElement(successfullyRegisterMessage);
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue button : " + btnContinue.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button : " + btnContinue.toString());
        clickOnElement(btnContinue);
    }
}
