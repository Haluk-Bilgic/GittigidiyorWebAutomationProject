package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

   public WebDriver driver;

   public  HomePage(WebDriver driver){

    this.driver=driver;
    PageFactory.initElements(driver,this);
}

@FindBy(xpath = "//input[@data-cy='header-search-input']")
    private WebElement textBox;


@FindBy(css = ".qjixn8-0.sc-1bydi5r-0.gaMakD")
    private  WebElement bulButton;



    public void typeTextBox(String message){
        sendKeysFunction(textBox,message);
    }
    public void clickBulButton(){
        clickFunction(bulButton);
    }


}
