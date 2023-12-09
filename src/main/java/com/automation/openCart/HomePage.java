package com.automation.openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final By myAccount = By.xpath("//a[@title='My Account']");
    private final By registerLink = By.linkText("Register");
    private final By firstName = By.name("firstname");
    private final By registrationContinue = By.xpath("//input[@type='submit']");

    WebDriver driver;
    public HomePage(WebDriver driver){
     this.driver=driver;
     System.out.println("WebDriver object is initialized for this class");
    }

    public void clickMyAccount() throws Exception{
        driver.findElement(myAccount).click();
        Thread.sleep(2000);
    }

    public void clickRegisterLink(){
        driver.findElement(registerLink).click();
    }

    public boolean validateRegistrationFormDisplayed(){
        return driver.findElement(firstName).isDisplayed();
    }

    public void clickContinue(){
        driver.findElement(registrationContinue).click();
    }


}
