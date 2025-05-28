package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:/Users/sedat.ekmel/OneDrive - TESTINIUM Teknoloji Yazılım A.Ş/Masaüstü/IntellijIDEA Projects/SeleniumProjects/chromedriver.exe");
        WebDriver driver=new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // From : //a[@value='MAA']
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //driver.findElement(By.xpath("//a[@value='MAA']")).click(); // 1.yöntem
        //Xpath ve child xpath-->    //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']  //2.yöntem

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA'] ")).click();

        Thread.sleep(2000);

        // To   : (//a[@value='BKK'])[2]
        //driver.findElement(By.xpath("(//a[@value='BKK'])[2]")).click(); // 1.yöntem
        // Xpath ve child xpath-->  //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BKK']//2.yöntem

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BKK']")).click();
    }
}
