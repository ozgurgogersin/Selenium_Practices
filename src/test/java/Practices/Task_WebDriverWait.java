package Practices;
import Utilities.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Task_WebDriverWait extends BaseDriver {
    @Test
    public void WebDriverWait(){
        driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");

        WebElement inputForms=driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputForms.click();
        WebElement ajaxFormSubmit=driver.findElement(By.linkText("Ajax Form Submit"));
        ajaxFormSubmit.click();
        WebElement name=driver.findElement(By.id("title"));
        name.sendKeys("Ozgur");
        WebElement comment=driver.findElement(By.id("description"));
        comment.sendKeys("Type a Comment!");
        WebElement submit=driver.findElement(By.id("btn-submit"));
        submit.click();
        WebElement message=driver.findElement(By.xpath("//div[text()='Form submited Successfully!']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[text()='Form submited Successfully!']"),"Form submited Successfully!"));
        Assert.assertTrue("failed",message.getText().contains("orm submited"));
        driver.quit();
    }
}
