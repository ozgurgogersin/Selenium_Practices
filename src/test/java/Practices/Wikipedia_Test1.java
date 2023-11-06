package Practices;
import Utilities.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
/**
Go to "https://en.wikipedia.org/wiki/FIFA_World_Cup"
Print out all Hosts in the Attendance table
 */
public class Wikipedia_Test1 extends BaseDriver {
    @Test
    public void test() {
        driver.get("https://en.wikipedia.org/wiki/FIFA_World_Cup");
        WebElement attendance=driver.findElement(By.xpath("//div[@class='vector-toc-text'][text()='Attendance']"));
        attendance.click();
        List<WebElement>hosts=driver.findElements(By.xpath("//td[@style='text-align:left']//a"));
        for (WebElement e:hosts){
            System.out.println(e.getText());
        }
        driver.quit();
    }
}
