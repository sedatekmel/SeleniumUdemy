package JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class WebTablePagination {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        List<String> price;
        do {
            List<WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
            price = elementsList.stream()
                    .filter(s -> s.getText().contains("Apple"))
                    .map(s -> getVeggiePrice(s))
                    .collect(Collectors.toList());
            if (price.size() < 1) {
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
                Thread.sleep(2000);
            }
        } while (price.size() < 1);

        price.stream().forEach(s -> System.out.println(s));
    }

    private static String getVeggiePrice(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}