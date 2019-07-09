package AutomationPractice.StepDefinitions;

import AutomationPractice.Pages.*;
import AutomationPractice.Utils.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CheckoutSteps {

    HomePage homepage = new HomePage();
    ProductPage productPage = new ProductPage();
    LoginPage loginpage = new LoginPage();
    OrderSummaryPage osp = new OrderSummaryPage();
    AuthenticationPage authpage = new AuthenticationPage();
    AddressPage ap = new AddressPage();
    ShippingPage sp = new ShippingPage();
    PaymentPage pp = new PaymentPage();
    CompleteOrderPage cop = new CompleteOrderPage();

    @Given("^User opens the home page$")
    public void isUserOnHomePage(){
        Assert.assertTrue(homepage.isUserOnHomePage());
    }

    @When("^User hovers over cart icon and clicks checkout button$")
    public void clickCheckoutBtn() {
        Utils.scrollTo(0,-600);
        Utils.wait(10);
        productPage.hoverCartClickCheckout();
    }

    @When("^User clicks proceed to checkout button on order summary page$")
    public void clickProceedBtnOrderSummaryStep(){
        osp.clickProceedBtn();
    }

    @When("^User enters email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enterCredentials(String email,String passwd){
        authpage.enterCredentials(email,passwd);
    }

    @When("^User verifies delivery address$")
    public void verifyAddress() {
    }

    @When("^User ticks checkbox for terms and conditions$")
    public void tickMarkTermsAndConditions(){
        sp.acceptTermsnConditions();
    }

    @When("^User clicks on Pay by Bank Wire link$")
    public void clickBankWireOption() {
        pp.selectBankwirePayment();
    }

    @When("^User clicks on Pay by Cheque link$")
    public void clickChequeOption() {
        pp.selectChequePayment();
    }

    @When("^User clicks I confirm my order button$")
    public void confirmOrder() {
        cop.clickConfirmBtn();
    }

    @Then("^User should see order page$")
    public void verifyOrderSummaryDisplayed(){
        Assert.assertTrue(osp.getTitle().equalsIgnoreCase("Order - My Store"));
        osp.isOrderPageOpen();
    }

    @Then("^User should see authentication page$")
    public void verifyAuthenticationPageDisplayed(){
        authpage.isAuthenticationPageOpen();
    }

    @Then("^User should see delivery address options$")
    public void verifyAddressPageDisplayed(){
        ap.isAddressPageOpen();
    }

    @Then("^User should see shipping information$")
    public void verifyShippingPageDisplayed(){
        sp.isShippingPageOpen();
    }

    @Then("^User should be payment options$")
    public void verifyPaymentPageDisplayed(){
        pp.isPaymentPageOpen();
    }

    @Then("^User should see bank wire payment details$")
    public void verifyBankwireDetailsDisplayed() {
        pp.isBankwirePaymentModeSelected();
    }

    @Then("^User should see cheque payment details$")
    public void verifyChequeDetailsDisplayed() {
        pp.isChequePaymentModeSelected();
    }

    @Then("^User should see order confirmation$")
    public void verifyOrderConfirmationDisplayed(){
        cop.isOrderConfirmationDisplayed();
    }

    @And("^User is logged in with email as \"([^\"]*)\" and password as \"([^\"]*)\" and prepared to checkout$")
    public void loginAndPrepare(String email, String passwd) {
        homepage.clickLoginBtn();
        Assert.assertTrue(loginpage.isUserOnLoginPage());
        Assert.assertTrue(loginpage.isLoginFormDisplayed());
        loginpage.enterCredentials(email,passwd);
        loginpage.clickLoginBtn();
        homepage.isUserLoggedIn();
        productPage.addToCart("DRESSES","CASUAL DRESSES");
    }

    @And("^User is prepared to checkout$")
    public void prepare(){
        productPage.addToCart("DRESSES","CASUAL DRESSES");
    }

    @And("^User clicks on sign-in button$")
    public void clickSignInBtn(){
        authpage.clickSignInBtn();
    }

    @And("^User clicks proceed to checkout button on address page$")
    public void clickProceedBtnAddressStep() {
        ap.clickProceedBtn();
    }

    @And("^User clicks proceed to checkout button on shipping page$")
    public void clickProceedBtnShippingStep(){
        sp.clickProceedBtn();
    }

}

