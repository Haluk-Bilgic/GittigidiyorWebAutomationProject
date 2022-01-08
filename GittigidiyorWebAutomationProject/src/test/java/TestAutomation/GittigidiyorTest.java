package TestAutomation;

import Helper.BrowserSetup;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultsPage;
import Pages.SecondSearchResultsPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import utilities.Log4j;



public class GittigidiyorTest {

    public static WebDriver driver;

    HomePage homePage;
    SearchResultsPage firstPage;
    SecondSearchResultsPage secondPage;
    ProductPage productPage;

    @BeforeClass
    public static void setUp() {
        driver= BrowserSetup.startBrowser("chrome","https://www.gittigidiyor.com/");
        Log4j.startLog("Test is Starting");
    }
    @Test
    @DisplayName("HomePage")
    public void test1() throws InterruptedException {
        homePage=new HomePage(driver);
        homePage.typeTextBox("Bilgisayar");
        homePage.clickBulButton();
    }
    @Test
    @DisplayName("SearchResultPage")
    public void test2() throws InterruptedException {
        firstPage=new SearchResultsPage(driver);
        firstPage.clickOnSecondPage();
    }
    @Test
    @DisplayName("SecondSearchResultPage")
    public void test3() throws InterruptedException {
        secondPage=new SecondSearchResultsPage(driver);
        secondPage.verifySecondPage();
        secondPage.selectProduct();
    }
    @Test
    @DisplayName("ProductPage")
    public void test4() throws InterruptedException{
        productPage=new ProductPage(driver);
        productPage.ProductInfoWriteToFile();
        productPage.clickAddSepet();
        productPage.verifyPrices();
        productPage.artır();
        productPage.deleteSepet();
        productPage.verifySepetIsEmpty();
    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        Log4j.endLog("Test is Ending");
    }

}