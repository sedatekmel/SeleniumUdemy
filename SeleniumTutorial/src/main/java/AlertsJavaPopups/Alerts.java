package AlertsJavaPopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) {

        String name="Sedat Ekmel";
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        driver.findElement(By.id("name")).sendKeys(name);

        //Alert  . OK button
        driver.findElement(By.id("alertbtn")).click();
        System.out.println( driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.id("name")).sendKeys(name);

        //Confirm  . OK and Cancel button.
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        //driver.switchTo().alert().accept();  //Ok or Yes button
        driver.switchTo().alert().dismiss(); //Cancel or No button


    }
}
