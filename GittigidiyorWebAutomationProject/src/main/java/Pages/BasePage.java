package Pages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class BasePage {



public void clickFunction(WebElement clickElement){

    clickElement.click();
}
public void sendKeysFunction(WebElement sendKeysElement,String value){

    sendKeysElement.sendKeys(value);
}
public void selectElementFromDropDown(WebElement dropdown,String element){
    Select slc=new Select(dropdown);
    slc.selectByVisibleText(element);
}
public void assertion(WebElement actual,String expected){
    Assert.assertEquals(actual.getText(),expected);
    System.out.println("My Message:"+actual.getText());
}
public void actionFunction(WebElement element, WebDriver driver){
    Actions builder=new Actions(driver);
    Action mouse=builder
            .moveToElement(element)
            .build();
    mouse.perform();
}


}
