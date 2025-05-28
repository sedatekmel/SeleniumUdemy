package Radiobuttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Radiobuttons {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/sedat.ekmel/OneDrive - TESTINIUM Teknoloji Yazılım A.Ş/Masaüstü/IntellijIDEA Projects/SeleniumProjects/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        //System.out.println( driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled()); // if enable, true
        //isEnabled , false da olsa true dönüyor çünkü disable ddurumunda üzerine geldiğinde etkinleştirilebilyorsa selenium onu true olarak algılıyor.

        //getAttribute yerini yeni sürümle getDomAttribute'a bırakmıştır.
       if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5"))
       {Assert.assertTrue(true);}

       else{Assert.assertTrue(false);}

    }
}
