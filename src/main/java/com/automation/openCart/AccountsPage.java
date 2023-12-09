package com.automation.openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage {
    private final By modifySearch = By.linkText("Modify your wish list");
    private final By myWishListText = By.xpath("//h2[text()='My Wish List']");
    private final By continueBtn = By.linkText("Continue");

    WebDriver driver;
    public AccountsPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickModifyWishList(){
        driver.findElement(modifySearch).click();
    }

    public boolean validateMyWishListDisplayed(){
        return driver.findElement(myWishListText).isDisplayed();
    }

    public void clickContinue(){
        driver.findElement(continueBtn).click();
    }
}
