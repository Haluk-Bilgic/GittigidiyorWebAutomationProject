package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Log4j;


public class SecondSearchResultsPage extends BasePage{

    public SecondSearchResultsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
   @FindBy(xpath = "//a[@title='2. sayfa']")
    private WebElement title;
   @FindBy(xpath = "//*[@id=\"__next\"]/main/div[2]/div/div/div[2]/div/div[3]/div[3]/ul/li[31]/article/div[2]/a")
   private  WebElement product;


    public void verifySecondPage(){
        Log4j.info("Verifying SecondPage");
        assertion(title,"2");
    }
    public void selectProduct()  {
        waitFor(2);
        clickFunction(product);
        Log4j.info("Selecting product");
    }


}
