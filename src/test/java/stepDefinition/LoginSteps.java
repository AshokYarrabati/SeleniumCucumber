package stepDefinition;

import CommonSteps.BaseTest;
import com.automation.openCart.AccountsPage;
import com.automation.openCart.HomePage;
import com.automation.openCart.LoginPage;
import com.automation.openCart.RegistrationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class LoginSteps  {
    WebDriver driver;
    LoginPage loginPage;
    AccountsPage accountsPage;
    HomePage homePage;
    RegistrationPage registrationPage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }


    @Given("User is on landing page")
    public void user_is_on_landing_page() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        System.out.println("User navigated to Landing page");
        loginPage = new LoginPage(driver);
        accountsPage = new AccountsPage(driver);
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);

    }

    @When("User enters uname and password")
    public void userEntersUnameAndPassword() {
        loginPage.typeUserName("yarrabatiashok411@gmail.com");
        loginPage.typePassword("Bahubali12$");
    }


    @When("Click on Login button")
    public void click_on_login_button() throws Exception {
        loginPage.clickLogin();
        Thread.sleep(3000);
        System.out.println("user clicked cn Login button");
    }

    @Then("User navigated to my orders section")
    public void userNavigatedToMyOrdersSection() {
        Assert.assertTrue(loginPage.validateOrderSectionDisplayed());
    }

    @When("User type {string} and {string}")
    public void userTypeAnd(String userName, String password) {
        loginPage.typeUserName(userName);
        loginPage.typePassword(password);
    }

    @Then("error message should trigger")
    public void errorMessageShouldTrigger() {
        Assert.assertTrue(loginPage.validateErrorDisplayed());
    }

    @When("User clicks on your wish list")
    public void userClicksOnYourWishList() {
        accountsPage.clickModifyWishList();
    }

    @Then("user should navigate to wishlist page")
    public void userShouldNavigateToWishlistPage() {
        Assert.assertTrue(accountsPage.validateMyWishListDisplayed());
        accountsPage.clickContinue();
    }

    @When("user clicks on My Account")
    public void userClicksOnMyAccount() throws Exception {
        homePage.clickMyAccount();
    }
    @When("Register link is clicked")
    public void registerLinkIsClicked() {
        homePage.clickRegisterLink();
    }


    @Then("validate Registration form opens and fill the form")
    public void validateRegistrationFormOpens(DataTable table) {
        Assert.assertTrue(homePage.validateRegistrationFormDisplayed());
        List<Map<String, String>> registrationData = table.asMaps(String.class, String.class);
        for(Map<String, String> regData: registrationData){
            String fname = regData.get("fname");
            String lname = regData.get("lname");
            String email = regData.get("email");
            String phnumber = regData.get("phno");
            String password = regData.get("pwd");
            String conPassword = regData.get("conpwd");
            try {
                registrationPage.doRegistration(fname, lname, email, phnumber, password, conPassword);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

//        String fname = registrationData.get(0).get(0);
//        String lastname = registrationData.get(0).get(1);
//        String email = registrationData.get(0).get(2);
//        String phoneNumber = registrationData.get(0).get(3);
//        String password = registrationData.get(0).get(4);
//        String confirmPassword = registrationData.get(0).get(5);


    }


    @And("validate your account has been created text")
    public void validateYourAccountHasBeenCreatedText() {
        Assert.assertTrue(registrationPage.validateAccountCreationSuccessful());
    }
}
