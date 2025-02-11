package AutomationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css=".login")
    WebElement loginBtn;

    @FindBy(css=".account")
    WebElement welcomeText;

    @FindBy(css=".search_query ")
    WebElement searchBox;

    @FindBy(css=".button-search")
    WebElement searchBtn;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }


    public void clickLoginBtn(){
        loginBtn.click();
    }

    public boolean isLoginButtonDisplayed(){return loginBtn.isDisplayed();}

    public boolean isUserLoggedIn(){return welcomeText.isDisplayed();}
    public String getAccountName(){
        return welcomeText.getText();
    }
    public boolean isUserOnHomePage(){
        if(getTitle().equalsIgnoreCase("My Store"))
            return true;
        else
            return false;
    }
    public void typeKeywordInSearchBox(String keyword){
        searchBox.sendKeys(keyword);
    }

    public void clickSearchBtn(){
        searchBtn.click();
    }
}

