package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public WebDriver driver;

    public  HomePage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@data-cy='header-search-input']")
    @CacheLookup
    private WebElement textBox;


    @FindBy(css = ".qjixn8-0.sc-1bydi5r-0.gaMakD")
    @CacheLookup
    private  WebElement bulButton;



    public void typeTextBox(String message){
        sendKeysFunction(textBox,message);
    }
    public void clickBulButton(){
        clickFunction(bulButton);
    }


}
