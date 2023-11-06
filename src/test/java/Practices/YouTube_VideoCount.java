package Practices;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Go to "https://www.youtube.com/"
 * Search for the videos with "Selenium" keyword
 * Make sure at least 80 videos are displayed
 * Print out the title of the last video
 */
public class YouTube_VideoCount extends BaseDriver {
    @Test
    public void test() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.youtube.com/");

        WebElement element = driver.findElement(By.xpath("//input[@id='search']"));
        element.sendKeys("selenium");
        element.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        MyMethods.myWait(5);
        List<WebElement> links = driver.findElements(By.xpath(
                "//a[@class='yt-simple-endpoint style-scope ytd-playlist-renderer']"));
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath(
                "//a[@class='yt-simple-endpoint style-scope ytd-playlist-renderer']"), 80));
        int count1 = 0;
        for (WebElement e : links) {
            count1++;
        }
        MyMethods.myWait(5);
        js.executeScript("window.scrollTo(0, 3000)");
        MyMethods.myWait(5);
        js.executeScript("window.scrollTo(3000, 6000)");
        MyMethods.myWait(5);
        js.executeScript("window.scrollTo(6000, 9000)");
        MyMethods.myWait(5);
        js.executeScript("window.scrollTo(9000, 12000)");
        MyMethods.myWait(5);
        js.executeScript("window.scrollTo(12000, 15000)");
        MyMethods.myWait(5);
        js.executeScript("window.scrollTo(15000, 18000)");
        MyMethods.myWait(5);
        js.executeScript("window.scrollTo(18000, 21000)");
        MyMethods.myWait(5);

        List<WebElement> links2 = driver.findElements(By.xpath("//a[@id='video-title']"));
        int count2 = 0;
        String lastLink = "";
        for (WebElement e : links2) {
            lastLink = e.getAttribute("href");
            count2++;
        }

        int totalVideoCount = count1 + count2;
        if (totalVideoCount > 80) {
            System.out.println("Count1: " + count1);
            System.out.println("Count2: " + count2);
            System.out.println("Total Video Count: " + totalVideoCount);
            System.out.println("Last Link : " + lastLink);
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//a[@id='video-title']"), totalVideoCount));
        } else {
            System.out.println("Less than 80 videos are displayed.");
        }

    }
}

