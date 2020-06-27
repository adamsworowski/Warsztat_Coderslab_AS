package pageObjectPattern.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ConfirationPage {
    private static WebDriver driver;

    public ConfirationPage(WebDriver driver) {
        ConfirationPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void takeScreenCapture() throws Exception{
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/Users/adam/Desktop/Warsztat_Coderslab_AS/screenshot.png"));
    }

}
