package com.tricentis.demowebshop.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demowebshop.customlisteners.CustomListeners;
import com.tricentis.demowebshop.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement login;

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement register;

    @CacheLookup
    @FindBy(linkText = "Log out")
    WebElement logout;

    @CacheLookup
    @FindBy(linkText = "Computers")
    WebElement clickOnComputers;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement verifyLoginLink;

    public void clickOnLoginLink() {
        clickOnElement(login);
        Reporter.log("Click on Login Link : " + login.toString());
        CustomListeners.test.log(Status.PASS, "Click on Login Link : " + login.toString());
    }

    public void clickOnRegisterLink() {
        clickOnElement(register);
        Reporter.log("Click On RegisterLink : " + register.toString());
        CustomListeners.test.log(Status.PASS, "Click On RegisterLink : " + register.toString());
    }

    public void clickOnLogout() {
        clickOnElement(logout);
        Reporter.log("Click on logoutLink : " + logout.toString());
        CustomListeners.test.log(Status.PASS, "Click on logoutLink : " + logout.toString());
    }

    public String getLogInText(){
        Reporter.log("get log in link text : " + verifyLoginLink.toString());
        CustomListeners.test.log(Status.PASS, "get log in link text : " + verifyLoginLink.toString());
        return getTextFromElement(verifyLoginLink);
    }

    public String getLogOutText(){
        Reporter.log("get log out link text : " + logout.toString());
        CustomListeners.test.log(Status.PASS, "get log out link text : " + logout.toString());
        return getTextFromElement(logout);
    }

    public void clickOnComputersTab() {
        clickOnElement(clickOnComputers);
        Reporter.log("Click on computer tab" + clickOnComputers.toString());
        CustomListeners.test.log(Status.PASS, "Click on computer tab");
    }
}
