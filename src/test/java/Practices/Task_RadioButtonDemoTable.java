package Practices;
import Utilities.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
/**
 * Go to "http://demo.seleniumeasy.com/basic-first-form-demo.html"
 * Click on Input Forms
 * Click on Radio buttons Demo
 * On the Group Radio Buttons Demo table
 * Click on Male
 * Click on 0 to 5
 * Print out the result
 * Result should be "Sex : Male   Age group: 0 - 5"
 * Click on 5 to 15
 * Print out the result
 * Result should be "Sex : Male   Age group: 5 - 15"
 * Click on 15 to 50
 * Print out the result
 * Result should be "Sex : Male   Age group: 15 - 50"
 * Click on Female
 * Click on 0 to 5
 * Print out the result
 * Result should be "Sex : Female   Age group: 0 - 5"
 * Click on 5 to 15
 * Print out the result
 * Result should be "Sex : Female   Age group: 5 - 15"
 * Click on 5 to 15
 * Print out the result
 * Result should be "Sex : Female   Age group: 5 - 15"
 */

public class Task_RadioButtonDemoTable extends BaseDriver {
    @Test
    public void RadioButtonDemoTable() {
        driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");

        WebElement inputForm = driver.findElement(By.linkText("Input Forms"));
        inputForm.click();

        WebElement radioButtonDemo = driver.findElement(By.linkText("Radio Buttons Demo"));
        radioButtonDemo.click();

        WebElement male = driver.findElement(By.xpath("//input[@value='Male'and@name='gender']"));
        WebElement female = driver.findElement(By.xpath("//input[@value='Female'and@name='gender']"));
        WebElement firstAgeGroup = driver.findElement(By.xpath("//input[@value='0 - 5'and@name='ageGroup']"));
        WebElement secondAgeGroup = driver.findElement(By.xpath("//input[@value='5 - 15'and@name='ageGroup']"));
        WebElement thirdAgeGroup = driver.findElement(By.xpath("//input[@value='15 - 50'and@name='ageGroup']"));

        WebElement getCheckedValue = driver.findElement(By.xpath("//button[text()='Get values']"));

        male.click();
        firstAgeGroup.click();
        getCheckedValue.click();
        WebElement text = driver.findElement(By.xpath("//div//p[@class='groupradiobutton']/text()//.."));
        System.out.println(text.getText());

        secondAgeGroup.click();
        getCheckedValue.click();
        System.out.println(text.getText());

        thirdAgeGroup.click();
        getCheckedValue.click();
        System.out.println(text.getText());

        female.click();
        firstAgeGroup.click();
        getCheckedValue.click();
        System.out.println(text.getText());

        secondAgeGroup.click();
        getCheckedValue.click();
        System.out.println(text.getText());

        thirdAgeGroup.click();
        getCheckedValue.click();
        System.out.println(text.getText());

        driver.quit();
    }
}
