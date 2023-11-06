package Practices;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

/**
 * Go to "https://testsheepnz.github.io/BasicCalculator.html"
 * Generate 2 random numbers between 0-100
 * Run all the functions of the calculator with these numbers
 * Check the if the results are correct
 * Repeat these steps 5 times with different numbers
 */
public class BasicCalculator_Test extends BaseDriver {
    @Test
    public void test() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        WebElement firstNumber;
        WebElement secondNumber;

        WebElement selectBuild = driver.findElement(By.id("selectBuild"));
        Select buildOptions = new Select(selectBuild);
        List<WebElement> buildList = buildOptions.getOptions();

        WebElement dropDown = driver.findElement(By.id("selectOperationDropdown"));
        Select options = new Select(dropDown);
        List<WebElement> optionsList = options.getOptions();

        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        WebElement errorMessageField = driver.findElement(By.xpath("//form[@id='errorForm']//h3//font[@color='red']//i//label[@id='errorMsgField']"));
        int count = 0;

        Random rand = new Random();
        while (count < 5) {
            String n1 = String.valueOf(rand.nextDouble() * 100);
            String n2 = String.valueOf(rand.nextDouble() * 100);
            for (int i = 0; i < buildList.size(); i++) {
                firstNumber = driver.findElement(By.id("number1Field"));
                secondNumber = driver.findElement(By.id("number2Field"));

                for (int j = 0; j < optionsList.size(); j++) {
                    if (errorMessageField.isDisplayed()) {
                        Assert.assertTrue("Test Failed", errorMessageField.isDisplayed());
                    }
                    if (secondNumber.isEnabled()) {
                        firstNumber.sendKeys(n1);
                        secondNumber.sendKeys(n2);
                        optionsList.get(j).click();
                        MyMethods.myWait(1);
                        calculateButton.click();
                        firstNumber.clear();
                        secondNumber.clear();
                    } else if (!secondNumber.isEnabled()) {
                        Assert.assertTrue("Test Failed", !secondNumber.isEnabled());
                        buildList.get(0);
                    }
                }
                buildList.get(i).click();
            }
            buildList.get(0);
            count++;
        }
        System.out.println(count);
    }
}
