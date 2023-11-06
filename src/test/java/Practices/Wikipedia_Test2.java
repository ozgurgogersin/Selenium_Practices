package Practices;

import Utilities.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Go to "https://en.wikipedia.org/wiki/FIFA_World_Cup"
 * Click on "World Football – All timetable"    in the Contents
 * Print out participation count of Argentina
 * Not: This table might change in time. Don't print the absolute location
 */
public class Wikipedia_Test2 extends BaseDriver {
    @Test
    public void test() {
        //TODO Note:Old link seems not have "World Football – All time table" , so I changed it.
        driver.get("https://en.wikipedia.org/wiki/National_team_appearances_in_the_FIFA_World_Cup#");

        WebElement appearances = driver.findElement(By.xpath("//a[@href='#Ranking_of_teams_by_number_of_appearances']"));
        appearances.click();
        WebElement argentinaParticipations = driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter'and@style='text-align: center']//tbody//tr[3]//td[2]"));
        System.out.println("Argentina Participated to WorldCup " + argentinaParticipations.getText() + " times.");
    }
}
