package AutoSuggestive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestive {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a")); //xpath --> //li[@class='ui-menu-item']/a
        //List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));         // css selector -->  li[class='ui-menu-item'] a
        for (WebElement option : options)
        {
            if(option.getText().equals("India")){   //equalsIgnoreCase
                option.click();
                break;
            }
        }



    }
}
