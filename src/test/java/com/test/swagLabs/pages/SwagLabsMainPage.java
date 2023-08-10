package com.test.swagLabs.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class SwagLabsMainPage {
    public SwagLabsMainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }@FindBy (xpath = "//button[contains(@id,'backpack')]")
    WebElement backpack;
    @FindBy (xpath = "//button[contains(@id,'bike-light')]")
    WebElement bikeLight;
    @FindBy(xpath = "//button[contains(@id,'bolt-t-shirt')]")
    WebElement boltTShirt;
    @FindBy(xpath = "//button[contains(@id,'jacket')]")
    WebElement jacket;
    @FindBy (xpath = "//button[contains(@id,'onesie')]")
    WebElement onesie;
    @FindBy (xpath = "//button[contains(@id,'red')]")
    WebElement redTShirt;
    @FindBy (css = ".shopping_cart_link")
    WebElement cartIcon;
    @FindBy (xpath = "//button[.='Checkout']")
    WebElement checkoutButton;
    @FindBy (css =".inventory_item_name")
    List<WebElement> allProducts;
    public void chooseProductWithForLoop(String item){
        for (WebElement oneItem :allProducts){
            if (BrowserUtils.getText(oneItem).equalsIgnoreCase(item)){
                oneItem.click();// that is the same thing with the SWITCH below.
                break;
            }}}
    public void selectItem(String item) throws InterruptedException {
        //backpack.click(); it is inactive to break the validation of isEmpty()
        Thread.sleep(500);
        Assert.assertTrue("The shopping cart icon is not empty initially",BrowserUtils.getText(cartIcon).isEmpty());
        item=item.toLowerCase();
        switch (item) {
            case "backpack":
                backpack.click();
                break;
            case "bike light":
                bikeLight.click();
                break;
            case "bolt tee":
                boltTShirt.click();
                break;
            case "jacket":
                jacket.click();
                break;
            case "baby":
                onesie.click();
                break;
            case "red tee":
                redTShirt.click();
                break;
            default:
                Assert.fail("wrong item");
        }
        Thread.sleep(500);
        Assert.assertFalse("The shopping cart icon is still empty after adding an item",BrowserUtils.getText(cartIcon).isEmpty());
    }
    public void cart(WebDriver driver) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        cartIcon=wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIcon.click();
    }
    public void checkout() throws InterruptedException {
        Thread.sleep(500);
        checkoutButton.click();
    }

}
