package pageObjectPattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseItemPage {
    private static WebDriver driver;

    @FindBy(xpath = "/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[2]/div/div[1]/h2/a")
    WebElement hummingbirdSweaterSelection;

    public ChooseItemPage(WebDriver driver) {
        ChooseItemPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectHummingbirdSweater() {hummingbirdSweaterSelection.click();}
}
