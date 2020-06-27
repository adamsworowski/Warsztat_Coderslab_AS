package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectPattern.pages.*;

import java.util.concurrent.TimeUnit;

public class ShoppingTest {
    private final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private final String CHROME_DRIVER_PATH = "src/main/resources/drivers/chromedriver";
    private final String URL = "https://prod-kurs.coderslab.pl/index.php?controller=authentication";
    private final String USER = "TadzioKrol@rhyta.com";
    private final String PASSWORD = "Password";
    LoginPage loginPage;
    ClothesPage clothesPage;
    ChooseItemPage chooseItemPage;
    HummingbirdSweaterPage hummingbirdSweaterPage;
    CardPage cardPage;
    CheckoutPage checkoutPage;
    ConfirationPage confirationPage;
    WebDriver driver;

    @Before
    public void prepareEnvironment() {
        System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        loginPage = new LoginPage(driver);
        clothesPage = new ClothesPage(driver);
        chooseItemPage = new ChooseItemPage(driver);
        hummingbirdSweaterPage = new HummingbirdSweaterPage(driver);
        cardPage = new CardPage(driver);
        checkoutPage = new CheckoutPage(driver);
        confirationPage = new ConfirationPage(driver);
        loginPage.loginAs(USER, PASSWORD);
    }

    @Test
    public void testShopping() throws Exception {
    clothesPage.selectClothesCathegory();
    chooseItemPage.selectHummingbirdSweater();
    hummingbirdSweaterPage.selectSize();
    hummingbirdSweaterPage.selectQuantity();
    hummingbirdSweaterPage.clickAddToCard();
    hummingbirdSweaterPage.clickProceedToCheckout();
    cardPage.clickProceedToCheckout2();
    checkoutPage.clickContinue();
    checkoutPage.selectShippingMethod();
    checkoutPage.clickContinue2();
    checkoutPage.selectPaymentMethod();
    checkoutPage.acceptConditions();
    checkoutPage.placeOrder();
    confirationPage.takeScreenCapture();


    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}
