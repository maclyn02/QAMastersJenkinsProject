package AutomationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {

    @FindBy(css=".bankwire")
    WebElement bankwireMode;
    @FindBy(css=".cheque")
    WebElement chequeMode;
    @FindBy(xpath="//form/div/h3[@class=\"page-subheading\"]")
    WebElement selectedPaymentMethod;
    @FindBy(css=".navigation_page")
    WebElement navTitle;

    public PaymentPage(){
        PageFactory.initElements(driver,this);
    }

    public void selectBankwirePayment(){
        bankwireMode.click();
    }
    public void selectChequePayment(){
        chequeMode.click();
    }
    public boolean isBankwirePaymentModeSelected(){
        String expectedStr = "BANK-WIRE PAYMENT";
        return expectedStr.equalsIgnoreCase(selectedPaymentMethod.getText());
    }
    public boolean isChequePaymentModeSelected(){
        String expectedStr = "CHECK PAYMENT";
        return expectedStr.equalsIgnoreCase(selectedPaymentMethod.getText());
    }

    public boolean isPaymentPageOpen(){
        return navTitle.getText().equalsIgnoreCase("Your payment method");
    }
}
