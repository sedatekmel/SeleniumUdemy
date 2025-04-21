package AjaxCallsChildWindowsIFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();

        WebElement move=driver.findElement(By.xpath("//div[@id='nav-link-accountList']"));
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        Actions a =new Actions(driver);

        //***Moves to spesific element***
        //mouse imlecini belirtilen elemente götürür
        a.moveToElement(move)
                .contextClick() // sağ click
                .build().perform(); // hazırla ve çalıştır

        //Composite action
        a.moveToElement(searchBox)
                .click()  //searche tıkla
                .keyDown(Keys.SHIFT) //SHIFT'e basılı tut(amac: büyük harfle yazmaya zorlamaktır)
                .sendKeys("hello") //hello yaz . Ekranda HELLO olarak büyük harfle yazar
                .doubleClick() // çift tıklama yazılanı seçmek içindir
                .build().perform(); // hazırla ve çalıştır
    }
}
