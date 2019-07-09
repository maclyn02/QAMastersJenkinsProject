package AutomationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BasePage {

    @FindBy(css="#cgv")
    WebElement tncCheckBox;

    @FindBy(xpath="//p[@class=\"cart_navigation clearfix\"]/button/span")
    WebElement proceedBtn;

    @FindBy(css=".navigation_page")
    WebElement navTitle;

    public ShippingPage(){
        PageFactory.initElements(driver,this);
    }

    public void acceptTermsnConditions(){
        tncCheckBox.click();
    }

    public void clickProceedBtn(){
        proceedBtn.click();
    }

    public boolean isShippingPageOpen(){
        return navTitle.getText().equalsIgnoreCase("Shipping");
    }

}
