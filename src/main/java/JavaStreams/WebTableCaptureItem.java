package JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableCaptureItem {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //capture all webelements into the list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

        //capture Bean's price on the table
        List<String> price = elementsList.stream()
                .filter(s -> s.getText().contains("Beans"))
                .map(s -> getVeggiePrice(s))
                .collect(Collectors.toList());
        price.forEach(a -> System.out.println(a));

    }
    private static String getVeggiePrice(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}

