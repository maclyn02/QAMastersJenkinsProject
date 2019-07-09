package AutomationPractice.Pages;

import AutomationPractice.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    @FindBy(css=".shopping_cart")
    WebElement cart;

    @FindBy(css="#button_order_cart")
    WebElement checkout;


    @FindBy(css=".ajax_block_product")
    WebElement productBlock;
    @FindBy(css=".ajax_add_to_cart_button")
    WebElement addToCartBtn;
    @FindBy(xpath="/html/body/div[1]/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span")
    WebElement productInfoModal;
    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span")
    WebElement addToCartBtnOnModal;
    @FindBy(linkText = "DRESSES")
    WebElement dresses;
    @FindBy(linkText = "CASUAL DRESSES")
    WebElement casual_dresses;
    @FindBy(linkText = "EVENING DRESSES")
    WebElement evening_dresses;

    public ProductPage(){
        PageFactory.initElements(driver,this);
    }
    public void addToCart(String category,String subCategory){

        //Select Category on nav bar
        if(category.equals("DRESSES"))
            dresses.click();
        /*else if(category.equals("T-SHIRTS"))
            tees.click();*/

        //Select sub-category
        if(subCategory.equals("CASUAL DRESSES"))
            casual_dresses.click();
        else if(subCategory.equals("EVENING DRESSES"))
            evening_dresses.click();
        /*else if(subCategory.equals("SUMMER DRESSES"))
            summer_dresses.click();*/


        Utils.wait(10);
        //Scroll to make cart element visible
        Utils.scrollTo(0,600);
        Utils.wait(10);
        //Hover on cart and click checkout
        Utils.hoverAndClick(productBlock,addToCartBtn);
        Utils.wait(10);
        //Wait for popup and click continue shopping button on it
        Utils.waitForElement(productInfoModal,10);
        addToCartBtnOnModal.click();
        Utils.wait(10);
    }

    public void hoverCartClickCheckout(){
        Utils.hoverAndClick(cart,checkout);
    }

}
