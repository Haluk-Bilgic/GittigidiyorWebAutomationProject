package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BasePage {

    WebDriverWait wait;

    public BasePage(WebDriver driver){
        wait=new WebDriverWait(driver,10);
    }

public void clickFunction(WebElement clickElement){
    wait.until(ExpectedConditions.elementToBeClickable(clickElement));
    clickElement.click();
}
public void sendKeysFunction(WebElement sendKeysElement,String value){
    wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
    sendKeysElement.sendKeys(value);
}
public void selectElementFromDropDown(WebElement dropdown,String element){
    wait.until(ExpectedConditions.visibilityOf(dropdown));
    Select slc=new Select(dropdown);
    slc.selectByVisibleText(element);
}
public void assertion(WebElement actual,String expected){
    wait.until(ExpectedConditions.visibilityOf(actual));
    Assert.assertEquals(actual.getText().trim(),expected);
    System.out.println("My Message:"+actual.getText());
}
public void actionFunction(WebElement element, WebDriver driver){
    wait.until(ExpectedConditions.visibilityOf(element));
        Actions builder=new Actions(driver);
    Action mouse=builder
            .moveToElement(element)
            .build();
    mouse.perform();
}


}
