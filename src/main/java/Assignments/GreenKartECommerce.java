package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GreenKartECommerce {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5)); //5 saniye bekleme süresi olan , WebDriverWait classından w object oluşturuldu.

        /* IMPLICIT WAIT */
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   Selenium 3 eski yöntem
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  //Selenium 4 modern yöntem

        driver.manage().window().maximize();
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot", "Tomato"}; //Farklı productlara tıklamak istersen bu productları bir arraye al
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        //Thread.sleep(3000);
        addItems(driver, itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));//promoCode classına sahip element görünene kadar 5 saniye bekler.
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        /* EXPLICIT WAIT */
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));//span.promoInfo locatorını DOM'da görene kadar 5 saniye bekler
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }
    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name")); //ürün isimlerini aldı
        int j = 0;
        //****Tek bir product ekleme
        /* for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().contains("Cucumber")) {
                //driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[" + (i + 1) + "]")).click();
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break;
            }
        }*/
        //****Farklı productlar ekleme
        for (int i = 0; i < productNames.size(); i++) {
            //format it to get actual vegetable name
            //Brocolli - 1 Kg
            String[] name = productNames.get(i).getText().split("-"); //name[0] : Brocolli, name[1]:1 Kg
            String formattedName = name[0].trim();

            //convert array into array list for easy search  --> bunun sebebi bellekten tasarruf etmektir. O yüzden dizi tanımlayıp sonra arrayliste çevirdik.
            //check whether name you extracted is present in array or not
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {
                j++;
                //driver.findElements(By.xpath("//button[contains(text()='ADD TO CART')]")).get(i).click();  //ADD TO CHART'a tıklayınca text ADDED oluyor o yüzden patlar.
                //driver.findElements(By.xpath("//button[contains(text(), 'ADD')]")).get(i).click(); //Bu çalışıyor 1.yöntemdir dinamik text aramak
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); //Bu çalışıyor 2.yöntemdir üst classtan gidili.
                if (j == itemsNeeded.length) { // bu koşul 30 üründen sadece 3 tanesine tıklanacak. Bu yüzden tıklanmayacaklar için döngünün devam etmesine gerek kalmasın diye .
                    break;                  //NOT: Size of Array --> length , Size of ArrayList --> size()
                }
            }
        }
    }
}


