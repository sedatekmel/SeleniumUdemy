package AjaxCallsChildWindowsIFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");


        System.out.println(driver.findElements(By.tagName("iframe")).size()); //ekrandaki frame sayısını verir

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']"))); //frame e girer.

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));
        source.click();

        Actions a=new Actions(driver);
        a.dragAndDrop(source,target).build().perform(); //sürükle ve bırak
        driver.switchTo().defaultContent(); // frame'den çıkıp ana sayfaya geçer.



    }
}
