package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage{

     WebDriver driver;
    JavascriptExecutor js;

    public SearchResultsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".sc-12aj18f-2.jwZJjs")
    private WebElement secondPage;


    @FindBy(xpath= "//*[@id=\"__next\"]/main/div[2]/div/div/div[2]/div/div[3]/div[4]/nav/ul/li[3]/a/span")
    private  WebElement getSecondPage;


    public void clickOnSecondPage() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", secondPage);
        Thread.sleep(2000);
        clickFunction(getSecondPage);

    }




}
