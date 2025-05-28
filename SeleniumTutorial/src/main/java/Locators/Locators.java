package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/sedat.ekmel/OneDrive - TESTINIUM Teknoloji Yazılım A.Ş/Masaüstü/IntellijIDEA Projects/SeleniumProjects/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Her komuttan sonra max.5 saniye bekleme

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();
        String errorMessageLoginPage=driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(errorMessageLoginPage);

        driver.findElement(By.linkText("Forgot your password?")).click();
        //Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); //elementi temizler
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("5529789176");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

       String infoMsgInForgotPswPage= driver.findElement(By.cssSelector("form p")).getText();
       System.out.println(infoMsgInForgotPswPage);

       driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

       driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
       driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
       Thread.sleep(1000);
       driver.findElement(By.id("chkboxOne")).click();
       driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

    }
}
