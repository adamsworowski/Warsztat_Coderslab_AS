package pageObjectPattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardPage {
    private static WebDriver driver;

    @FindBy(xpath = "/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a")
    WebElement proceedToCheckoutButton2;

    public CardPage(WebDriver driver) {
        CardPage.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickProceedToCheckout2() {proceedToCheckoutButton2.click();}
}
