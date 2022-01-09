package Pages;


import org.junit.ComparisonFailure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Log4j;
import utilities.TxtWrite;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "sp-productTabFeatures")
    private WebElement myTable;
    @FindBy(css = "#sp-price-lowPrice")
    private WebElement Productprice;
    @FindBy(css =".control-button.gg-ui-button.plr10.gg-ui-btn-default")
    private  WebElement sepeteEkle;
    @FindBy(css = ".product-new-price")
    private WebElement priceOnSepet;
    @FindBy(css = ".IncNumber.gg-icon.gg-icon-plus")
    private WebElement add;
    @FindBy(xpath = "//*[@id=\"header_wrapper\"]/div[4]/div[3]/a")
    private WebElement sepetim;
    @FindBy(xpath = "//*[@id=\"header_wrapper\"]/div[4]/div[3]/div/div/div/div[2]/div[4]/div[1]/a")
    private WebElement goSepet;
    @FindBy(css = ".gg-icon.gg-icon-bin-medium")
    private WebElement deleteSepetButton;
    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/span")
    private WebElement text;


    public void ProductInfoWriteToFile() {
        Log4j.info("Typing products information and price to file");
        String filePath="C:\\Users\\ahbil\\my\\GittigidiyorWebAutomationProject\\" +
                "GittigidiyorWebAutomationProject\\src\\main\\java\\utilities\\filename.txt";

            TxtWrite.ProductWriteToFile(myTable,Productprice,filePath);
        }
    public void clickAddSepet(){
        waitFor(2);
        jsScrollBy("window.scrollBy(0,800)");
        clickFunction(sepeteEkle);
        Log4j.info("The Product adding to Sepet");
    }
    public void verifyPrices(){
        try {
            assertion(Productprice,priceOnSepet.getText());
            Log4j.info("Verifying prices");
        }catch (AssertionError exception){
            System.out.println("****The price of Product on Sepet has changed****");
            Log4j.error("Prices are not the same");
        }
    }
    public void artır() {
        waitFor(2);
        jsScrollBy("window.scrollBy(0,700)");
        clickFunction(add);
    }
     public  void deleteSepet(){
         actionFunction(sepetim);
         clickFunction(goSepet);
         clickFunction(deleteSepetButton);
         Log4j.info("Sepet emptying");
     }
     public void verifySepetIsEmpty() {
        assertion(text,"Ürün Sepetten Silindi");
    }

}
