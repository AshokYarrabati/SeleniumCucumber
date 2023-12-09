package stepDefinition;

import CommonSteps.BaseTest;
import com.automation.openCart.ForgotPasswordPage;
import com.automation.openCart.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.xml.crypto.Data;

public class ForgotPasswordSteps {
    ForgotPasswordPage passwordPage;
    LoginPage loginPage;

//    @When("user clicks on Forgot password link")
//    public void user_clicks_on_forgot_password_link() {
//        loginPage.clickForgetPassword();
//    }
//
//    @Then("User should see Forgot Your Password Header")
//    public void user_should_see_forgot_your_password_header() throws Exception {
//        loginPage = new LoginPage();
//        passwordPage = new ForgotPasswordPage();
//        loginPage.clickForgetPassword();
//        Thread.sleep(3000);
//
//    }
//
//    @Then("user type email address")
//    public void user_type_email_address() {
//        Assert.assertTrue("Forgot password page was not displayed", passwordPage.validateForgotPassword());
//        passwordPage.typeEmail();
//    }
//
//    @Then("click continue button")
//    public void click_continue_button() {
//        passwordPage.clickContinue();
//    }
}
