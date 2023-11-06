package Practices;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Go to "http://demo.seleniumeasy.com/basic-select-dropdown-demo.html"
 * Write a code that selects random days from Select a day dropdown menu
 * and stops after it selects Wednesday for the 5th time.
 * Print that how many times it selected Wednesday
 * The result should be 5.
 */
public class Task_Select extends BaseDriver {
    @Test
    public void Select() {
        driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        WebElement option = driver.findElement(By.xpath("//select[@id='select-demo']"));
        Select dropdownMenu = new Select(option);
        List<WebElement> optList = dropdownMenu.getOptions();
        int count = 0;
        while (count < 5) {
            int random = (int) (Math.random() * optList.size() - 1) + 1;
            if (optList.get(random).getText().equals("Wednesday")) {
                MyMethods.myWait(1);
                dropdownMenu.selectByVisibleText("Wednesday");
                MyMethods.myWait(1);
                count++;
            }
            System.out.println(optList.get(random).getText());
        }
        System.out.println("count: " + count);
        driver.quit();
    }
}
