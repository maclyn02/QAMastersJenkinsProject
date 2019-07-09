package AutomationPractice.StepDefinitions;

import AutomationPractice.Pages.HomePage;
import AutomationPractice.Pages.SearchResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SearchSteps {

    HomePage homepage = new HomePage();
    SearchResultsPage searchpage = new SearchResultsPage();

    @Given("^User opens home page$")
    public void isUserOnHomePage() {
        Assert.assertTrue(homepage.isUserOnHomePage());
    }

    @When("^User types search keyword as \"([^\"]*)\"$")
    public void typeKeyword(String keyword) {
        homepage.typeKeywordInSearchBox(keyword);
    }

    @When("^User leaves search field blank$")
    public void isSearchFieldBlank() {

    }

    @Then("^User should be redirected to search page$")
    public void isUserOnSearchPage(){
        Assert.assertTrue(searchpage.isUserOnSearchPage());
    }

    @And("^User should see product list$")
    public void isProductListDispalyed() {
        Assert.assertTrue(searchpage.isProductListDisplayed());
    }

    @And("^User clicks on search icon$")
    public void clickSearchBtn() {
        homepage.clickSearchBtn();
    }

    @And("^User should see search error message as \"([^\"]*)\"$")
    public void checkErrorMessage(String errorMsg) {
        Assert.assertTrue(searchpage.checkErrorMessage(errorMsg));
    }

    @And("^User should see search message as \"([^\"]*)\"$")
    public void isMessageDisplayed(String errorMsg) {
        Assert.assertTrue(searchpage.checkErrorMessage(errorMsg));
    }
}
