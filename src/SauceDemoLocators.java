import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLocators extends BaseTest{

    public SauceDemoLocators(){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name") WebElement username;
    @FindBy(id = "password") WebElement password;
    @FindBy(id = "login-button") WebElement loginButton;
    @FindBy(id = "inventory_container") WebElement inventoryContainer;
    @FindBy(id = "add-to-cart-sauce-labs-backpack") WebElement sauceLabsBackpackAddToCart;
    @FindBy(id = "remove-sauce-labs-backpack") WebElement removeSauceLabsBackpackButton;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket") WebElement sauceLabsFleeceJacketAddToCart;
    @FindBy(id = "remove-sauce-labs-fleece-jacket") WebElement removeSauceLabsFleeceJacketButton;
    @FindBy(id = "shopping_cart_container") WebElement shoppingCart;
    @FindBy(id = "checkout") WebElement checkoutButton;
    @FindBy(id = "cart_contents_container") WebElement cartContentsContainer;
    @FindBy(id = "checkout_info_container") WebElement checkoutInfoContainer;
    @FindBy(id = "checkout_summary_container") WebElement checkoutSummaryContainer;
    @FindBy(id = "first-name") WebElement firstName;
    @FindBy(id = "last-name") WebElement lastName;
    @FindBy(id = "postal-code") WebElement postalCode;
    @FindBy(id = "continue") WebElement checkoutContinueButton;
    @FindBy(id = "finish") WebElement checkoutFinishButton;
    @FindBy(id = "checkout_complete_container") WebElement checkoutCompleteContainer;
    @FindBy(id = "root") WebElement loginPage;
    @FindBy(css = ".error-message-container") WebElement loginErrorMessage;
    @FindBy(css = ".footer") WebElement footer;
}
