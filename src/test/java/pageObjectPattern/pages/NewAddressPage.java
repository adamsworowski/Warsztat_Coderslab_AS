package pageObjectPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Instant;

public class NewAddressPage {
    private static WebDriver driver;
    @FindBy(name = "alias")
    WebElement aliasInput;
    @FindBy(name = "address1")
    WebElement addressInput;
    @FindBy(name = "city")
    WebElement cityInput;
    @FindBy(name = "postcode")
    WebElement postcodeInput;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div/div/form/section/div[10]/div[1]/select")
    WebElement countrySelect;
    @FindBy(name = "phone")
    WebElement phoneInput;
    @FindBy(xpath = "//*[@id='content']/div/div/form/footer/button")
    WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        NewAddressPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillUpAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void fillUpAlias() {
        aliasInput.sendKeys(getRandomAlias());
    }

    public void fillUpPhoneNumber(String phoneNumber) {
        phoneInput.sendKeys(phoneNumber);
    }

    public void fillUpCity(String city) { cityInput.sendKeys(city); }

    public void selectByCountry() { countrySelect.click();
    Select country = new Select(driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[10]/div[1]/select")));
    country.selectByVisibleText("United Kingdom"); }


    public void fillUpPostalCode(String postCode) { postcodeInput.sendKeys(postCode); }

    public void clickOnSaveButton() { saveButton.click(); }

    private String getRandomAlias(){
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli() / 1000;
        return "Alias " + timeStampMillis;
    }
}