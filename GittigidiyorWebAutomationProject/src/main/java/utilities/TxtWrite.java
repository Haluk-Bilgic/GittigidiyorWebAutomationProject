package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TxtWrite {


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
}
