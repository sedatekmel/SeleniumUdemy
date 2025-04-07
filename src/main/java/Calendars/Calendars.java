package Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendars
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/sedat.ekmel/OneDrive - TESTINIUM Teknoloji Yazılım A.Ş/Masaüstü/IntellijIDEA Projects/SeleniumProjects/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.xpath("//div[@id='']/button")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        //Get all days in a month of calendar
        //List<WebElement> daysInMonth= driver.findElements(By.cssSelector(".ui-datepicker-group.ui-datepicker-group-first .ui-state-default")); //ayın günlerini çekme
        //Thread.sleep(2000);
        /* for (WebElement day :daysInMonth)
        {System.out.println(day.getText());}
        */
    }
}
