package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/sedat.ekmel/OneDrive - TESTINIUM Teknoloji Yazılım A.Ş/Masaüstü/IntellijIDEA Projects/SeleniumProjects/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        int expectedPassengerCount=5;
         /* int i=1;
         while(i<passengerCount){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }*/

        for(int i=1;i<expectedPassengerCount;i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        String actualPassengerCount=driver.findElement(By.id("divpaxinfo")).getText();
        //Assert.assertEquals(actualPassengerCount,expectedPassengerCount+" Adult");
        System.out.println(actualPassengerCount);

    }
}
