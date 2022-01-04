package Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SecondSearchResultsPage extends BasePage{

    WebDriver driver;
    JavascriptExecutor js;

    public SecondSearchResultsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
   @FindBy(xpath = "//a[@title='2. sayfa']")
    private WebElement title;
   @FindBy(xpath = "//*[@id=\"__next\"]/main/div[2]/div/div/div[2]/div/div[3]/div[3]/ul/li[31]/article/div[2]/a")
   private  WebElement product;


    public void verifySecondPage(){
        assertion(title,"2");
    }
    public void selectProduct() throws InterruptedException {
        Thread.sleep(3000);
        clickFunction(product);
    }


}
