package com.automation.openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    WebDriver driver;
    private By forgotHeader = By.xpath("//h1[text()='Forgot Your Password?']");
    private By emailId = By.id("input-email");
    private By conitnue = By.xpath("//input[@type='submit']");
    public ForgotPasswordPage(WebDriver driver){
        this.driver=driver;
    }

    public boolean validateForgotPassword(){
        return driver.findElement(forgotHeader).isDisplayed();
    }

    public void typeEmail(){
        driver.findElement(emailId).sendKeys("Naveen@gmail.com");
    }

    public void clickContinue(){
        driver.findElement(conitnue).click();
    }


}
