package Checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkboxes {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/sedat.ekmel/OneDrive - TESTINIUM Teknoloji Yazılım A.Ş/Masaüstü/IntellijIDEA Projects/SeleniumProjects/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); //test pass
        //System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());  //false döner

        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // test pass
        //System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); //true döner

        //Count the number of checkboxes
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());




    }
}
