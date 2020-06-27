package pageObjectPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HummingbirdSweaterPage {
    private static WebDriver driver;

    @FindBy(id = "group_1")
    WebElement sizeSelection;
    @FindBy(id = "quantity_wanted")
    WebElement quantitySelection;
    @FindBy(xpath = "/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button")
    WebElement addToCardButton;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a")
    WebElement proceedToCheckoutButton;


    public HummingbirdSweaterPage(WebDriver driver) {
        HummingbirdSweaterPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectSize() { sizeSelection.click();
        Select size = new Select(driver.findElement(By.id("group_1")));
        size.selectByVisibleText("M"); }

    public void selectQuantity() {
        for(int i = 1; i < 5; i++) {
            quantitySelection.sendKeys(Keys.ARROW_UP);
        }
    }

    public void clickAddToCard() {addToCardButton.click();}

    public void clickProceedToCheckout() {proceedToCheckoutButton.click();}

}
