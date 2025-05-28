package JavaScriptExecutorDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import java.util.List;

public class ScrollBar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int actualSum = 0;
        for (WebElement value : values) {
            actualSum += Integer.parseInt(value.getText());
        }

        // Total Amount Collected: 296
        int expectedSum = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount"))
                .getText()
                .split(":")[1].trim()); //296

        Assert.assertEquals(actualSum, expectedSum);


    }
}
