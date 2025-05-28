package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAssignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.linkText("Nested Frames")).click();

        driver.switchTo().frame("frame-top"); //üst frame
        driver.switchTo().frame("frame-middle"); //alt frame
        System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());

        //driver.switchTo().parentFrame(); // bunu kulllanırsam alt framden üst frame e geçer
        driver.switchTo().defaultContent(); //en üst sayfaya geçer

    }
}
