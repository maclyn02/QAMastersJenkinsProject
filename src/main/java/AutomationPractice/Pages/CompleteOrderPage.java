package AutomationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompleteOrderPage extends BasePage {

    @FindBy(xpath="//p[@class=\"cart_navigation clearfix\"]/button/span[text()=\"I confirm my order\"]")
    WebElement confirmBtn;

    @FindBy(xpath="//div/h1[@class=\"page-heading\"]")
    WebElement orderConfirmationMsg;

    public CompleteOrderPage(){
        PageFactory.initElements(driver,this);
    }

    public void clickConfirmBtn(){
        confirmBtn.click();
    }
    public boolean isOrderConfirmationDisplayed(){
        return orderConfirmationMsg.getText().equalsIgnoreCase("ORDER CONFIRMATION");
    }
}
