package AutomationPractice.Pages;

import AutomationPractice.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends BasePage {

    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]")
    WebElement proceedBtn;
    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/span[2]")
    WebElement navTitle;

    public OrderSummaryPage(){
        PageFactory.initElements(driver,this);
    }

    public void clickProceedBtn(){
        Utils.scrollTo(0,600);
        proceedBtn.click();
    }

    public boolean isOrderPageOpen(){
        return navTitle.getText().equalsIgnoreCase("Your shopping cart");
    }
}
