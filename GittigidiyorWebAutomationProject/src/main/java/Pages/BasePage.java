package Pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver=driver;
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
        Select slc=new Select(dropdown);
        slc.selectByVisibleText(element);
    }
    public void assertion(WebElement actual,String expected){
        wait.until(ExpectedConditions.visibilityOf(actual));
        Assert.assertEquals(actual.getText(),expected);
        System.out.println("My Message:"+actual.getText());
    }
    public void jsFunction(String parameter){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(parameter);
    }
    public void jsWithElment(String parameter,WebElement element){
        JavascriptExecutor jselement = (JavascriptExecutor) driver;
        jselement.executeScript(parameter,element);
    }
    public void actionFunction(WebElement element, WebDriver driver){
        Actions builder=new Actions(driver);
        Action mouse=builder
                .moveToElement(element)
                .build();
        mouse.perform();
    }

}
