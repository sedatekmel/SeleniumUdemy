package MiscellaneousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws MalformedURLException, IOException {

        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        //broken URL
        //Step 1 - IS to get all urls tied up to the links using Selenium
        //Java methods will call URL's and gets you the status code
        //if status code >400 then that url is not working-> link which tied to url is broken
        //a[href*="soapui"]'.

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        /*Bir linke tıklanmadan connection yapıp http status code alma*/
        //String url=driver.findElement(By.cssSelector("a[href*='soapui']")).getDomAttribute("href");
        //HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
        //conn.setRequestMethod("HEAD");
        //conn.connect();
        //int respCode=conn.getResponseCode();
        //System.out.println(respCode);
        //System.out.println(url);

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert sa = new SoftAssert();

        for (WebElement link : links) {
            String url = link.getDomAttribute("href");
            if(!url.contains("#")) {
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();
                int respCode = conn.getResponseCode();
                System.out.println(respCode);
                //Assert.assertTrue(respCode<400,"The link with text " + link.getText() + " is broken with response code " + respCode); //Hard assertion
                sa.assertTrue(respCode < 400, "The link with text " + link.getText() + " is broken with response code " + respCode); //Soft assertion
            }
            else{
                System.out.println("Atlanan geçersiz url : " + url);
            }
        }
        sa.assertAll(); // yakalanan hataları raporlamak için . olmazsa raporlanmaz.



    }
}
