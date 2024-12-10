package com.tricentis.demowebshop.testsuite;

import com.tricentis.demowebshop.customlisteners.CustomListeners;
import com.tricentis.demowebshop.pages.ComputerPage;
import com.tricentis.demowebshop.pages.DesktopsPage;
import com.tricentis.demowebshop.pages.HomePage;
import com.tricentis.demowebshop.pages.ProductDetailsPage;
import com.tricentis.demowebshop.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {

    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    ProductDetailsPage productDetailsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        productDetailsPage = new ProductDetailsPage();
    }

    @Test(groups = "sanity")
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        homePage.clickOnComputersTab();
        Assert.assertEquals(computerPage.getComputerPageTitle(), "Computers");
    }

    @Test(groups = "Smoke")
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.clickOnComputersTab();
        computerPage.clickOnDesktops();
        Assert.assertEquals(desktopsPage.getDesktopsPageTitle(), "Desktops");

    }

    @Test(groups = "regression", dataProvider = "productDetails", dataProviderClass = TestData.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully
            (String processor, String ram, String hdd, String os, String software) {

        homePage.clickOnComputersTab();
        computerPage.clickOnDesktops();
        desktopsPage.clickOnBuildYourOwnComputer();
        productDetailsPage.selectProcessorInDropDown(processor);
        productDetailsPage.selectRamInDropDown(ram);

        if (hdd.equalsIgnoreCase("320 GB "))
            productDetailsPage.selectHDD("18");
        else
            productDetailsPage.selectHDD("19");

        if (os.equalsIgnoreCase("Ubuntu "))
            productDetailsPage.selectOs("44");
        else if (os.equalsIgnoreCase("Windows 7  [+50.00]"))
            productDetailsPage.selectOs("20");
        else
            productDetailsPage.selectOs("21");

        if (software.equalsIgnoreCase("Microsoft Office  [+50.00]"))
            productDetailsPage.selectSoftware("22");
        else if (software.equalsIgnoreCase("Acrobat Reader  [+10.00]"))
            productDetailsPage.selectSoftware("23");
        else
            productDetailsPage.selectSoftware("24");

        productDetailsPage.clickOnAddToCartButton();
        Assert.assertEquals(productDetailsPage.getSuccessMessageToAddProductInCart(),
                "The product has been added to your shopping cart");

    }
}
