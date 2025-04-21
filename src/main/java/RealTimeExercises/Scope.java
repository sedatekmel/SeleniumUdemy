package RealTimeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        //1-Give me the count of links on the page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        //2-Count of footer section

        //Birinci yöntem
        /* System.out.println(driver.findElement(By.id("gf-BIG"))
                .findElements(By.tagName("a")).size());*/
        //İkinci yöntem
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));  // Limiting webdriver scope
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //3-Count of column section
        WebElement columndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());

        //4-Click on  each link in the column and check if the pages are opening
        Actions a=new Actions(driver);
        //for döngüsü linktextler tıklayıp sekmeleri açmak içindir.
        for (int i=1;i<columndriver.findElements(By.tagName("a")).size();i++)
        {
            //Klavyede iki tuşla birleşik yapılacak işlemlerde Keys.chord kullanılır
            /*
            String clickonLinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
            Thread.sleep(5000);
            */
            a.moveToElement(columndriver.findElements(By.tagName("a")).get(i)).keyDown(Keys.COMMAND).click().build().perform();
            Thread.sleep(5000);
        }
        //Get Titles 1.yöntem
        /*
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        it.next(); //parentId
        if(columndriver.findElements(By.tagName("a")).size()==windows.size()) {
            for (int i = 1; i < windows.size(); i++) {
                System.out.println(driver.switchTo().window(it.next()).getTitle());
            }
        }
        else{
            System.out.println("Link sayısı ile açılan sekme eşit değildir!");
        }
        */

        //Get Titles 2.yöntem-- Daha güzel yöntem hasNext mevcut.
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it=windows.iterator();

        while (it.hasNext()){  //hasNext() --> Bir sonraki pencere mevcut mu ?
            driver.switchTo().window(it.next()).getTitle();
            System.out.println(driver.getTitle());
        }







    }
}
