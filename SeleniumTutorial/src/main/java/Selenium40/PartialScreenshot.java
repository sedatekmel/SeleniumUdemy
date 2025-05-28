package Selenium40;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class PartialScreenshot {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameInput = driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input"));
        nameInput.sendKeys("Sedat Ekmel -Selenium Udemy Eğitim");

        File file=nameInput.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("/Users/sedatekmel/Desktop/screenshots/nameInputSS.png"));
    }
}
