package com.tricentis.demowebshop.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demowebshop.customlisteners.CustomListeners;
import com.tricentis.demowebshop.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComputerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktops;

    public String getComputerPageTitle() {
        CustomListeners.test.log(Status.PASS, "get computer page title");
        Reporter.log("get computer page title");
        return getTextFromElement(pageTitle);
    }

    public void clickOnDesktops() {
        clickOnElement(desktops);
        CustomListeners.test.log(Status.PASS, "click on desktops : " + desktops.toString());
        Reporter.log("click on desktops : " + desktops.toString());
    }
}
