package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectPattern.pages.*;

import java.util.concurrent.TimeUnit;

public class CreateNewAddressTest {
    private final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private final String CHROME_DRIVER_PATH = "src/main/resources/drivers/chromedriver";
    private final String URL = "https://prod-kurs.coderslab.pl/index.php?controller=authentication";
    private final String USER = "TadzioKrol@rhyta.com";
    private final String PASSWORD = "Password";
    private final String address = "Obłuska 16";
    private final String phoneNumber = "123456789";
    private final String city = "Gdynia";
    private final String postalCode = "81-157";
    MyAccountPage myAccountPage;
    HeaderComponent headerComponent;
    LoginPage loginPage;
    AddressPage addressesPage;
    NewAddressPage newAddressPage;
    WebDriver driver;

    @Before
    public void prepareEnvironment() {
        System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        headerComponent = new HeaderComponent(driver);
        addressesPage = new AddressPage(driver);
        newAddressPage = new NewAddressPage(driver);
        loginPage.loginAs(USER, PASSWORD);


    }

    @Test
    public void testAddNewUserAddress() {
        headerComponent.goToUserInformationView();
        myAccountPage.goToAddressesPage();
        addressesPage.createNewAddress();
        newAddressPage.fillUpAlias();
        newAddressPage.fillUpAddress(address);
        newAddressPage.fillUpCity(city);
        newAddressPage.fillUpPostalCode(postalCode);
        newAddressPage.fillUpPhoneNumber(phoneNumber);
        newAddressPage.selectByCountry();
        newAddressPage.clickOnSaveButton();
        addressesPage.isAddressCorrect(address,city,postalCode,phoneNumber);
        addressesPage.isSuccessInformationIsDisplay();


    }

    @After
    public void closeBrowser() {
        driver.close();
    }

}
