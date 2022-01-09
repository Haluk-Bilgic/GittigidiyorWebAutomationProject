package TestAutomation;


import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultsPage;
import Pages.SecondSearchResultsPage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


public class GittigidiyorTest extends BaseTest {

    HomePage homePage;
    SearchResultsPage firstPage;
    SecondSearchResultsPage secondPage;
    ProductPage productPage;

    @Test
    @DisplayName("HomePage")
    public void test1() {
        homePage=new HomePage(driver);
        homePage.typeTextBox("Bilgisayar");
        homePage.clickBulButton();
    }
    @Test
    @DisplayName("SearchResultPage")
    public void test2(){
        firstPage=new SearchResultsPage(driver);
        firstPage.clickOnSecondPage();
    }
    @Test
    @DisplayName("SecondSearchResultPage")
    public void test3(){
        secondPage=new SecondSearchResultsPage(driver);
        secondPage.verifySecondPage();
        secondPage.selectProduct();
    }
    @Test
    @DisplayName("ProductPage")
    public void test4(){
        productPage=new ProductPage(driver);
        productPage.ProductInfoWriteToFile();
        productPage.clickAddSepet();
        productPage.verifyPrices();
        productPage.artır();
        productPage.deleteSepet();
        productPage.verifySepetIsEmpty();
    }

}