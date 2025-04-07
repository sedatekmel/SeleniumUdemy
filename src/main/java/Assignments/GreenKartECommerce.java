package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GreenKartECommerce {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/sedat.ekmel/OneDrive - TESTINIUM Teknoloji Yazılım A.Ş/Masaüstü/IntellijIDEA Projects/SeleniumProjects/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));


        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().contains("Cucumber")){
                //driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[" + (i + 1) + "]")).click();
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break;
            }
        }
        driver.close();
    }
}


