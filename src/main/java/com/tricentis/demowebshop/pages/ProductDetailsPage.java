package com.tricentis.demowebshop.pages;

import com.tricentis.demowebshop.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDetailsPage extends Utility {

    @CacheLookup
    @FindBy(id = "product_attribute_16_5_4")
    WebElement processor;

    @CacheLookup
    @FindBy(id = "product_attribute_16_6_5")
    WebElement ram;

    @CacheLookup
    @FindBy(xpath = "//input[@type='radio'][@name='product_attribute_16_3_6']")
    List<WebElement> selectHDD;

    @CacheLookup
    @FindBy(xpath = "//input[@type='radio'][@name='product_attribute_16_4_7']")
    List<WebElement> selectOs;

    @CacheLookup
    @FindBy(xpath = "//input[@type='checkbox'][@name='product_attribute_16_8_8']")
    List<WebElement> selectSoftware;

    @CacheLookup
    @FindBy(xpath = "//input[@class='button-1 add-to-cart-button']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement successMessage;


    public void selectProcessorInDropDown(String name) {
        selectByVisibleTextFromDropDown(processor, name);
    }

    public void selectRamInDropDown(String name) {
        selectByVisibleTextFromDropDown(ram, name);
    }

    public void selectHDD(String value) {
        for (WebElement radioButton : selectHDD) {
            if (radioButton.getAttribute("value").equals(value)) {
                radioButton.click();
                break;
            }
        }
    }

    public void selectOs(String value) {
        for (WebElement radioButton : selectOs) {
            if (radioButton.getAttribute("value").equals(value)) {
                radioButton.click();
                break;
            }
        }
    }

    public void selectSoftware(String value) {
        for (WebElement checkboxButton : selectSoftware) {
            if (checkboxButton.getAttribute("value").equals(value)) {
                checkboxButton.click();
                break;
            }
        }
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCart);
    }

    public String getSuccessMessageToAddProductInCart() {
        return getTextFromElement(successMessage);
    }

}
