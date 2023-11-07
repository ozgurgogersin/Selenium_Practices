package Practices;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

        MyMethods.myWait(2);
        for (int i = 0; i < 7; i++) {
            int start = i * 3000;
            int end = (i + 1) * 3000;
            js.executeScript("window.scrollTo(" + start + ", " + end + ")");
            MyMethods.myWait(2);
        }

        List<WebElement> links2 = driver.findElements(By.xpath("//a[@id='video-title']"));
        int count2 = 0;
        String lastLink = "";
        for (WebElement e : links2) {
            lastLink = e.getAttribute("href");
            count2++;
        }
        int totalVideoCount = count1 + count2;
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//a[@id='video-title']"), totalVideoCount));
        if (totalVideoCount > 80) {
            System.out.println("Count1: " + count1);
            System.out.println("Count2: " + count2);
            System.out.println("Total Video Count: " + totalVideoCount);
            System.out.println("At least 80 Selenium videos Counted.");
            System.out.println("Last Link : " + lastLink);
        } else {
            System.out.println("Less than 80 videos are displayed.");
        }

    }
}

