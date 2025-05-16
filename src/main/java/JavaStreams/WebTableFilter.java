package JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableFilter {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]")); // 1 result

        List<WebElement> filteredVeggies = veggies.stream()
                .filter(veggie -> veggie.getText().contains("Rice"))
                .collect(Collectors.toList());  //1 result

        Assert.assertEquals(veggies.size(),filteredVeggies.size());


    }
}
