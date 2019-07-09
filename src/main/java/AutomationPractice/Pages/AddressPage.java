package AutomationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BasePage {

    @FindBy(xpath="//form/p[@class=\"cart_navigation clearfix\"]/button/span[text()=\"Proceed to checkout\"]")
    WebElement proceedBtn;
    @FindBy(css=".navigation_page")
    WebElement navTitle;

    public AddressPage(){
        PageFactory.initElements(driver,this);
    }

    public void clickProceedBtn(){
        proceedBtn.click();
    }

    public boolean isAddressPageOpen(){
        return navTitle.getText().equalsIgnoreCase("Addresses");

    }
}
