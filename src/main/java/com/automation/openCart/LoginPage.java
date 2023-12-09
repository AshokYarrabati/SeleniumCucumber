package com.automation.openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    private By email = By.name("email");
    private By password = By.id("input-password");
    private By loginBtn = By.xpath("//input[@type='submit']");
    private By forgotPassword = By.linkText("Forgotten Password");
    private By  myOrders = By.xpath("//h2[text()='My Orders']");

    private By errorMessage = By.xpath("//div[text()=' Warning: No match for E-Mail Address and/or Password.']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void typeUserName(String userEmail){
        driver.findElement(email).sendKeys(userEmail);
    }
    public void typePassword(String emailPassword){
        driver.findElement(password).sendKeys(emailPassword);
    }

    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }

    public boolean validateErrorDisplayed(){
        if(driver.findElement(errorMessage).isDisplayed()){
            return true;
        }else{
            return false;
        }
    }

    public boolean validateOrderSectionDisplayed(){
       return driver.findElement(myOrders).isDisplayed();
    }

    public ForgotPasswordPage clickForgetPassword(){
        driver.findElement(forgotPassword).click();
        return  new ForgotPasswordPage(driver);
    }

}
