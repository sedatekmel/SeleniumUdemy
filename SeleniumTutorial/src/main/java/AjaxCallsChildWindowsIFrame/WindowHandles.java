package AjaxCallsChildWindowsIFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();

        Set<String> windows = driver.getWindowHandles(); //[parentId,childId]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        //System.out.println(driver.findElement(By.cssSelector("p.im-para.red strong a")).getText());  //email adresini direkt veren locator
        System.out.println("Text: " + driver.findElement(By.cssSelector(".im-para.red")).getText()); //uzun metini veren locator
        String emailAddress = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        //uzun metinden email adresini çekip alan satır.
        System.out.println("Email adress: " + emailAddress);

        driver.switchTo().window(parentId); //childPage'dan metni aldık tekrar parentPage'a gidiyoruz
        driver.findElement(By.id("username")).sendKeys(emailAddress);
    }
}
