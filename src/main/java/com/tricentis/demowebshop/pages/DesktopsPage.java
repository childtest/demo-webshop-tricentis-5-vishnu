package com.tricentis.demowebshop.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demowebshop.customlisteners.CustomListeners;
import com.tricentis.demowebshop.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DesktopsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(linkText = "Build your own computer")
    WebElement buildYourOwnComputer;

    public String getDesktopsPageTitle() {
        CustomListeners.test.log(Status.PASS, "get desktops page title");
        Reporter.log("get desktops page title");
        return getTextFromElement(pageTitle);
    }

    public void clickOnBuildYourOwnComputer() {
        clickOnElement(buildYourOwnComputer);
        CustomListeners.test.log(Status.PASS, "click on : " + buildYourOwnComputer.toString());
        Reporter.log("click on : " + buildYourOwnComputer.toString());
    }
}
