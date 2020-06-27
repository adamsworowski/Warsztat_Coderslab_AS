package pageObjectPattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClothesPage {
    private static WebDriver driver;

    @FindBy(id = "category-3")
    WebElement clothesCategorySelection;

    public ClothesPage(WebDriver driver) {
        ClothesPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectClothesCathegory() {clothesCategorySelection.click();}
}
