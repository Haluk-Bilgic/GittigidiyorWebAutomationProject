package TestAutomation;

import Helper.BrowserSetup;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import utilities.Log4j;

public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver= BrowserSetup.startBrowser("chrome","https://www.gittigidiyor.com/");
        Log4j.startLog("Test is Starting");
    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Log4j.endLog("Test is Ending");
        Thread.sleep(3000);
        driver.quit();

    }
}
