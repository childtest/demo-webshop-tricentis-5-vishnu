package com.tricentis.demowebshop.testsuite;

import com.tricentis.demowebshop.customlisteners.CustomListeners;
import com.tricentis.demowebshop.pages.HomePage;
import com.tricentis.demowebshop.pages.LoginPage;
import com.tricentis.demowebshop.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity"})
    public void userShouldNavigateToLoginPageSuccessFully() {

        homePage.clickOnLoginLink();
        Assert.assertEquals(loginPage.getLoginPageTitle(), "Welcome, Please Sign In!");
    }

    @Test(groups = {"smoke"})
    public void verifyTheErrorMessageWithInValidCredentials() {

        homePage.clickOnLoginLink();
        loginPage.enterEmailAndPasswordForLogin("primetest@test.com", "test123");
        Assert.assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailAndPasswordForLogin("testtest@tests.com", "test123");
        Assert.assertEquals(homePage.getLogOutText(), "Log out");
    }

    @Test(groups = "regression")
    public void VerifyThatUserShouldLogOutSuccessFully() throws InterruptedException {
        homePage.clickOnLoginLink();
        loginPage.enterEmailAndPasswordForLogin("testtest@tests.com", "test123");
        homePage.clickOnLogout();
        Thread.sleep(3000);
        Assert.assertEquals(homePage.getLogInText(), "Log in");
    }

}
