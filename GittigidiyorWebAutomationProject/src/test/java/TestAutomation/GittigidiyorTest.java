package TestAutomation;

import Helper.BrowserSetup;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultsPage;
import Pages.SecondSearchResultsPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Log4j;

import java.util.concurrent.TimeUnit;

public class GittigidiyorTest {

    public static WebDriver driver;

    HomePage homePage=new HomePage(driver);
    SearchResultsPage firstPage=new SearchResultsPage(driver);
    SecondSearchResultsPage secondPage=new SecondSearchResultsPage(driver);
    ProductPage productPage=new ProductPage(driver);

    @BeforeClass
    public static void setUp() {
        driver= BrowserSetup.startBrowser("chrome","https://www.gittigidiyor.com/");
    }
    @Test
    public void test() throws InterruptedException{

        Log4j.startLog("Test is Starting");

        driver.get("https://www.gittigidiyor.com/");

        Log4j.info("Opening HomePage");

        homePage.typeTextBox("Bilgisayar");
        homePage.clickBulButton();

        Log4j.info("Opening SecondPage");

        firstPage.clickOnSecondPage();

        Log4j.info("Verifying SecondPage");

        secondPage.verifySecondPage();

        Log4j.info("Selecting product");

        secondPage.selectProduct();

        Log4j.info("Typing products information and price to file");

        productPage.ProductInfoWriteToFile();

        Log4j.info("The Product adding to Sepet");

        productPage.clickAddSepet();

        // Log4j.info("Verifying prices");

        //  productPage.verifyPrices();
        productPage.artır();

        Log4j.info("Sepet emptying");

        productPage.deleteSepet();
        productPage.verifySepetIsEmpty();

    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Log4j.endLog("Test is Ending");
        Thread.sleep(3000);
        driver.quit();

    }

}