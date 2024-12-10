package com.tricentis.demowebshop.testsuite;

import com.tricentis.demowebshop.customlisteners.CustomListeners;
import com.tricentis.demowebshop.pages.HomePage;
import com.tricentis.demowebshop.pages.RegisterPage;
import com.tricentis.demowebshop.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT(){
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test(groups = "sanity")
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickOnRegisterLink();
        Assert.assertEquals(registerPage.getPageTitle(), "Register");
    }

    @Test(groups = "smoke")
    public void  verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory(){
        homePage.clickOnRegisterLink();
        registerPage.clickOnRegisterButton();
        Assert.assertEquals(registerPage.getErrorMessageOfFirstNameIsRequired(),
                "First name is required.");
        Assert.assertEquals(registerPage.getErrorMessageOfLastNameIsRequired(),
                "Last name is required.");
        Assert.assertEquals(registerPage.getErrorMessageOfEmailIsRequired(),
                "Email is required.");
        Assert.assertEquals(registerPage.getErrorMessageOfPasswordIsRequired(),
                "Password is required.");
        Assert.assertEquals(registerPage.getErrorMessageOfConfirmPasswordIsRequired(),
                "Password is required.");
    }

    @Test(groups = "regression")
    public void verifyThatUserShouldCreateAccountSuccessfully(){
        homePage.clickOnRegisterLink();
        registerPage.selectGenderOfFemale();

        registerPage.enterFirstName("prime");
        registerPage.enterLastName("test");
        registerPage.enterEmailAddress("primetest"+generateRandomNumber()+"@gmail.com");
        registerPage.enterPassword("test123");
        registerPage.enterConfirmPassword("test123");
        registerPage.clickOnRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),
                "Your registration completed");
        registerPage.clickOnContinueButton();

    }
}
