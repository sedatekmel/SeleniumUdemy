package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowsHandlesAssignment {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        driver.findElement(By.cssSelector(".example a")).click(); //driver.findElement(By.linkText("Multiple Windows")).click(); alternatif

        Set<String> windows = driver.getWindowHandles(); //get windows
        Iterator<String> it = windows.iterator(); //iterators of windows
        String parentID=it.next(); //parentPage
        String childID=it.next(); //childPage
        driver.switchTo().window(childID); //Open the childPage
        System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
        driver.switchTo().window(parentID); //Open the parentPage
        System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());

    }
}

