package Practices;
import Utilities.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
/**
Go to "http://demo.seleniumeasy.com/basic-first-form-demo.html"
Click on Input Forms
Click on Radio buttons Demo
Click on Get checked value
"Radio button is Not checked" should be displayed
Click on Male Radio button
Click on Get checked value
"Radio button 'Male' is checked" should be displayed
Click on Female Radio button
Click on Get checked value
"Radio button 'Female' is checked" should be displayed
 */
public class Task_RadioButton extends BaseDriver {
    @Test
    public void RadioButton() {
        driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        WebElement inputForm = driver.findElement(By.linkText("Input Forms"));
        inputForm.click();
        WebElement radioButtonDemo = driver.findElement(By.linkText("Radio Buttons Demo"));
        radioButtonDemo.click();
        WebElement getCheckedValue = driver.findElement(By.xpath("//button[text()='Get Checked value']"));
        getCheckedValue.click();
        WebElement radioButtonIsNotChecked = driver.findElement(By.xpath("//p[text()='Radio button is Not checked']"));
        WebElement male = driver.findElement(By.xpath("//input[@value='Male'and@name='optradio']"));
        WebElement text=driver.findElement(By.xpath("//p[text()='Radio button is Not checked']"));
        if (radioButtonIsNotChecked.isDisplayed()) {
            male.click();
            getCheckedValue.click();
        }
        WebElement female = driver.findElement(By.xpath("//input[@value='Female'and@name='optradio']"));
        female.click();
        getCheckedValue.click();
        System.out.println(text.getText());
        Assert.assertTrue("Fails",text.isDisplayed());
        driver.quit();
    }
}
