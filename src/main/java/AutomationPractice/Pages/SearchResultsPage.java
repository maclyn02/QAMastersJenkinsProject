package AutomationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage {

    @FindBy(css=".product_list")
    WebElement productList;

    @FindBy(css=".alert")
    WebElement errorMessage;

    public SearchResultsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isProductListDisplayed(){
        if(productList.isDisplayed())
            return true;
        else
            return false;
    }
    public boolean isUserOnSearchPage(){
        if(driver.getTitle().equalsIgnoreCase("Search - My Store"))
            return true;
        else
            return false;
    }
    public boolean checkErrorMessage(String errMsg){
        if(errorMessage.getText().contains(errMsg))
            return true;
        else
            return false;
    }
}
