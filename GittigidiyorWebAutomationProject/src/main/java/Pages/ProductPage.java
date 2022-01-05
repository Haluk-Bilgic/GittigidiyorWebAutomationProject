package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductPage extends BasePage{

    WebDriver driver;
    JavascriptExecutor js;

    public ProductPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"sp-desktopDescription\"]/table/tbody")
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
        File myObj = new File("C:\\Users\\ahbil\\my\\GittigidiyorWebAutomationProject\\" +
                "GittigidiyorWebAutomationProject\\src\\main\\java\\utilities\\filename.txt");
        try {
            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write("Product price:"+Productprice.getText()+"\n");

            List< WebElement > rows_table = myTable.findElements(By.tagName("tr"));

            int rows_count = rows_table.size();

            for (int row = 0; row < rows_count; row++) {

                List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

                int columns_count = Columns_row.size();

                for (int column = 0; column < columns_count; column++) {

                    String celltext = Columns_row.get(column).getText();
                    myWriter.write(celltext+"\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (
                IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void clickAddSepet() throws InterruptedException {
        Thread.sleep(2000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        clickFunction(sepeteEkle);
    }
    public void verifyPrices(){
        assertion(Productprice,priceOnSepet.getText());
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
