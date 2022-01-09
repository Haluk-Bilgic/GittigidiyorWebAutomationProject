package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BrowserUtils {



    public static void ProductWriteToFile(WebElement myTable,WebElement Productprice,String path){

        File myObj = new File(path);
        try {
            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write("Product price:"+Productprice.getText()+"\n");

            List<WebElement> rows_table = myTable.findElements(By.tagName("tr"));

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

    public static String getScreenshot(String name,WebDriver driver) {

        TakesScreenshot ts= ((TakesScreenshot)driver);
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = "C:/Users/ahbil/my/GittigidiyorWebAutomationProject/GittigidiyorWebAutomationProject" +
                "/Test-output/Screenshots/" + name + ".png";
        File finalDestination = new File(target);

        try {
            FileUtils.copyFile(source, finalDestination);
            Log4j.info("Screenshot taken");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;

    }
}
