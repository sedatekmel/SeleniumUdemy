package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWaitAssignment {
    public static void main(String[] args) throws InterruptedException {
        String username="rahulshettyacademy";
        String password="learning";
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        signIn(driver,username,password,w);
        addItemsToBasket(driver,w);
        driver.close();
    }

    public static void signIn(WebDriver driver,String username, String password,WebDriverWait w) throws InterruptedException {

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click(); // alternatif yöntem bak
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        WebElement occupationsElement=driver.findElement(By.cssSelector("select.form-control"));
        Select occupation=new Select(occupationsElement);
        occupation.selectByValue("consult");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
    }

    public static void addItemsToBasket(WebDriver driver,WebDriverWait w)
    {
        //Add butonu tıklanabilir olana kadar signInBtn sonrası beklemeye al.
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));  Alternatif Shutty Çözümü
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));
        List<WebElement> addItemButtons=driver.findElements(By.xpath("//button[@class='btn btn-info']"));
        for (WebElement addItemButton : addItemButtons)
        {
            addItemButton.click();
        }
        int addedItemCount=addItemButtons.size();
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
    }

}
