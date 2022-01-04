package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSetup {

    static WebDriver driver;

    public static WebDriver startBrowser(String browserName,String url){

        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:/Program Files/selenium/chromeDriver/chromedriver.exe");
            driver=new ChromeDriver();

        }
        if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:/Program Files/selenium/firefoxDriver/geckodriver.exe");
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }

}
