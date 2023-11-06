package Practices;
import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
/**
Go to "http://demo.seleniumeasy.com/table-search-filter-demo.html"
In the Listed Users table type "an" in the First name box and search for the users
Print out the users
Remove First Name box
Type "ar" in the Username box and search for the usernames
Print out the usernames
 */

public class Task_SearchBoxFilter extends BaseDriver {
    @Test
    public void SearchBoxFilter() {
        driver.get("http://demo.seleniumeasy.com/table-search-filter-demo.html");
        WebElement filter = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-filter']"));
        filter.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstName.sendKeys("an");
        MyMethods.myWait(3);
        List<WebElement> anNames = driver.findElements(By.xpath("//div[@class='panel panel-primary filterable']//table[@class='table']//tbody"));
        for (WebElement e : anNames) {
            System.out.println(e.getText());

        }
        System.out.println("------------------------");
        firstName.clear();
        firstName.sendKeys("ar");
        MyMethods.myWait(3);
        List<WebElement> arNames = driver.findElements(By.xpath("//div[@class='panel panel-primary filterable']//table[@class='table']//tbody"));
        for (WebElement e : arNames) {
            System.out.println(e.getText());
        }
        driver.quit();
    }
}
