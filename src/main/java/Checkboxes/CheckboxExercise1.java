package Checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxExercise1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:/Users/sedat.ekmel/OneDrive - TESTINIUM Teknoloji Yazılım A.Ş/Masaüstü/IntellijIDEA Projects/SeleniumProjects/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //check
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected()); //if checked, true, test pass

        //uncheck
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected()); //if unchecked, false,test pass

        //the count of the checkboxes
        int countOfCheckboxes=driver.findElements(By.xpath("//input[@type='checkbox']")).size();
        Assert.assertEquals(countOfCheckboxes,3); //if the count of checkboxes is 3, test pass


    }
}
