package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators2 {

    public static void main(String[] args) throws InterruptedException {
        String name ="Sedat";
        System.setProperty("webdriver.chrome.driver","/Users/sedatekmel/Documents/GitHub/SeleniumUdemy");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Her komuttan sonra max.5 saniye bekleme
        String password=getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        String successLoginText=driver.findElement(By.tagName("p")).getText();
        System.out.println(successLoginText);
        Assert.assertEquals(successLoginText,"You are successfully logged in.");

        String nameMainPage=driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        Assert.assertEquals(nameMainPage,"Hello "+name+",");

        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        driver.close();

    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText= driver.findElement(By.cssSelector("form p")).getText();

        //Please use temporary password 'rahulshettyacademy' to Login.
        String[] passwordArray=passwordText.split("'");
        //0th index : Please use temporary password
        //1st index : rahulshettyacademy' to Login.
        //---------------------------------------
        //1st index : rahulshettyacademy' to Login.
        String password= passwordArray[1].split("'")[0];
        //0th index : rahulshettyacademy
        //1st index :  to Login.
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        return password;

    }
}
