package Selenium40;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class InvokeNewWindowOrTab {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB); //Yeni sekme açar ama locator hala ana sayfadadır
        //Yeni pencere için ise WindowType.WINDOW yazılır.

        Set<String> handlesWindows = driver.getWindowHandles();
        Iterator<String> it = handlesWindows.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();

        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");
        String txtInput = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();

        driver.switchTo().window(parentWindowId);

        WebElement nameInput = driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input"));
        nameInput.sendKeys(txtInput);

    }
}
