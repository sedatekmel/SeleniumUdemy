package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FormPage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name']")).sendKeys("Sedat");
        driver.findElement(By.xpath("//div[@class='form-group']/input[@name='email']")).sendKeys("sedatekmel1@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        driver.findElement(By.id("exampleCheck1")).click();

        WebElement genderElement = driver.findElement(By.id("exampleFormControlSelect1"));
        Select gender = new Select(genderElement);
        gender.selectByVisibleText("Male");

        driver.findElement(By.id("inlineRadio2")).click();
        driver.findElement(By.xpath("//div[@class='form-group']/input[@name='bday']")).sendKeys("27.09.1991");
        driver.findElement(By.cssSelector(".btn.btn-success")).click();

        String[] actualSuccessMessage = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText().split("×");
        Assert.assertEquals(actualSuccessMessage[1].trim(), "Success! The Form has been submitted successfully!.");


    }
}
