package com.automation.openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final By firstName = By.id("input-firstname");
    private final By lastName = By.id("input-lastname");
    private final By email = By.id("input-email");
    private final By telephone = By.id("input-telephone");
    private final By emailPassword = By.name("password");
    private final By confPassword = By.xpath("//input[@placeholder='Password Confirm']");
    private final By agreeTerm = By.name("agree");
    private final By continueBtn = By.xpath("//input[@type='submit']");
    private final By accountCreatedText = By.xpath("//h1[text()='Your Account Has Been Created!']");

    public WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver=driver;
    }

    public void doRegistration(String fname, String last, String emailID, String phn, String pass, String confirmPwd) throws Exception {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(email).sendKeys(emailID);
        driver.findElement(telephone).sendKeys(phn);
        driver.findElement(emailPassword).sendKeys(pass);
        driver.findElement(confPassword).sendKeys(confirmPwd);
        driver.findElement(agreeTerm).click();
        driver.findElement(continueBtn).click();
        Thread.sleep(4000);
    }

    public boolean validateAccountCreationSuccessful(){
        return driver.findElement(accountCreatedText).isDisplayed();
    }


}
