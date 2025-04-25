package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableRowAndColumnExerc {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        WebElement table = driver.findElement(By.cssSelector("table[name='courses']")); //tabloyu yakaladı

        //Rows count
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println("Rows count : " + rows.size());

        //Columns count
        List<WebElement> columns = table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th"));
        System.out.println("Columns count : " + columns.size());

        //Second row value
        List<WebElement> secondRowValue = table.findElements(By.tagName("tr")).get(2).findElements(By.cssSelector("td"));
        for (WebElement value : secondRowValue) {
            System.out.println(value.getText());
        }
        driver.close();
    }
}
