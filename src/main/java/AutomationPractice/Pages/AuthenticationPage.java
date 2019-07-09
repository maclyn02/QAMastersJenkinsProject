package AutomationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage {

    @FindBy(css="#email")
    WebElement emailField;
    @FindBy(css="#passwd")
    WebElement passwordField;
    @FindBy(css="#SubmitLogin")
    WebElement signInBtn;

    @FindBy(css=".navigation_page")
    WebElement navTitle;

    public AuthenticationPage(){
        PageFactory.initElements(driver,this);
    }

    public void enterCredentials(String email,String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void clickSignInBtn(){
        signInBtn.click();
    }

    public boolean isAuthenticationPageOpen(){
        return navTitle.getText().equalsIgnoreCase("\tAuthentication");
    }
}
