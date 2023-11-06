package Practices;
import Utilities.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
/**
 Go to "http://demo.seleniumeasy.com/table-search-filter-demo.html"
 In the Task table
 Search for In progress
 Find and print out all tasks in the table.
 Print out all Assignees
 */

public class Task_SearchBox extends BaseDriver {
    @Test
    public void SearchBox() {
        driver.get("http://demo.seleniumeasy.com/table-search-filter-demo.html");
        WebElement taskSearch=driver.findElement(By.id("task-table-filter"));
        taskSearch.sendKeys("In progress");
        List<WebElement>allTask=driver.findElements(By.id("task-table"));
        for (WebElement e:allTask) {
            System.out.println(e.getText());
        }
        driver.quit();
    }
}
