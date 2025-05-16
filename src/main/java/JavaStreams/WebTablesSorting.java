package JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTablesSorting {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on column
        driver.findElement(By.cssSelector("th[aria-label*='Veg/fruit name']")).click();

        //capture all webelements into the list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

        //capture text of all webelements into new(original) list
        List<String> actualList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

        //sort on original list of step 3 -> sorted list
        List<String> expectedList = actualList.stream().sorted().collect(Collectors.toList());

        //compare original list vs sorted list
        Assert.assertTrue(actualList.equals(expectedList));

    }
}
