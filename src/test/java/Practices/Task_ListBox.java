package Practices;
import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
/**
 * Go to "http://demo.seleniumeasy.com/basic-first-form-demo.html"
 * Click on List box
 * Click on Bootstrap List Box
 * Click on "bootstrap-duallist" and move it right by clicking on ">" button
 * Click on "Dapibus ac facilisis in" and move it right by clicking on ">" button
 * Click on the elements that were moved right one more time to turn them white
 * Click on "Cras husto odio" and move it left by clicking on "<" button
 * Click on "Dapibus ac facilisis in" and move it left by clicking on "<" button
 * The list in the box on lthe left should be like
 * - Morbi leo risus
 * - Porta ac consectetur ac
 * - Vestibulum at eros
 * - Cras justo odio
 * - Dapibus ac facilisis in
 * The list in the box on lthe right should be like
 * Morbi leo risus
 * - Porta ac consectetur ac
 * - Vestibulum at eros
 * - bootstrap-duallist
 * - Dapibus ac facilisis in
 **/
public class Task_ListBox extends BaseDriver {
    @Test
    public void ListBox() {

        driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
        WebElement listBox = driver.findElement(By.linkText("List Box"));
        listBox.click();

        WebElement bootStrapListBox = driver.findElement(By.linkText("Bootstrap List Box"));
        bootStrapListBox.click();

        List<WebElement> leftList = driver.findElements(By.xpath("//div[@class='well text-right']//ul[@class='list-group']//li"));
        List<WebElement> rightList = driver.findElements(By.xpath("//div[@class='dual-list list-right col-md-5']//ul[@class='list-group']//li"));
        WebElement rightClick = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-chevron-right']"));
        WebElement leftClick = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-chevron-left']"));

        for (int i = 0; i < leftList.size(); i++) {
            if (i < 2) {
                MyMethods.myWait(1);
                leftList.get(i).click();
                MyMethods.myWait(1);
                rightClick.click();
            }
        }
        WebElement deselectRight = driver.findElement(By.xpath("//div[@class='dual-list list-right col-md-5']//i[@class='glyphicon glyphicon-unchecked']"));
        deselectRight.click();
        deselectRight.click();
        for (int i = 0; i < rightList.size(); i++) {
            if (i < 2) {
                MyMethods.myWait(1);
                rightList.get(i).click();
                MyMethods.myWait(1);
                leftClick.click();
            }
        }
        driver.quit();
    }
}
