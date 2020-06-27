package pageObjectPattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private static WebDriver driver;

    @FindBy(name = "confirm-addresses")
    WebElement confirmAddressButton;
    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[3]/div/div[2]/form/div/div[1]/div[1]/label/div/div[1]")
    WebElement shippingMethod;
    @FindBy(name = "confirmDeliveryOption")
    WebElement confirmDeliveryOption;
    @FindBy(id = "payment-option-1")
    WebElement paymentMethodSelect;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement conditionsCheckbox;
    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button")
    WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        CheckoutPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContinue() {confirmAddressButton.click();}

    public void selectShippingMethod() {shippingMethod.click();}

    public void clickContinue2() {confirmDeliveryOption.click();}

    public void selectPaymentMethod() {paymentMethodSelect.click();}

    public void acceptConditions() {conditionsCheckbox.click();}

    public void placeOrder() {placeOrderButton.click();}


}
