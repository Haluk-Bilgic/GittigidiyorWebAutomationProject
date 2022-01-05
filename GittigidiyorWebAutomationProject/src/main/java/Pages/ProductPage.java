package Pages;


import org.junit.ComparisonFailure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TxtWrite;

public class ProductPage extends BasePage{

    WebDriver driver;
    JavascriptExecutor js;

    public ProductPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"catalog-info-details\"]/div[2]/div/table[2]")
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

        String filePath="C:\\Users\\ahbil\\my\\GittigidiyorWebAutomationProject\\" +
                "GittigidiyorWebAutomationProject\\src\\main\\java\\utilities\\filename.txt";

            TxtWrite.ProductWriteToFile(myTable,Productprice,filePath);
        }
    public void clickAddSepet() throws InterruptedException {
        Thread.sleep(2000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        clickFunction(sepeteEkle);
    }
    public void verifyPrices(){
        try {
            assertion(Productprice,priceOnSepet.getText());
        }catch (AssertionError exception){
            System.out.println("****The price of Product on Sepet has changed****");
        }
    }
    public void artır() throws InterruptedException {
        Thread.sleep(2000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        clickFunction(add);
    }
     public  void deleteSepet() throws InterruptedException{
         actionFunction(sepetim,driver);
         clickFunction(goSepet);
         clickFunction(deleteSepetButton);
     }
     public void verifySepetIsEmpty() {
        assertion(text,"Ürün Sepetten Silindi");
    }

}
