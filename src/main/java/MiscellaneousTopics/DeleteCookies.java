package MiscellaneousTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteCookies {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //driver.manage().deleteCookieNamed("sessionKey");  cookie ismini biliyorsak kullanabiliriz.
        /*
        Örnek senaryo:
        //Giriş yaptıktan sonra bağlantılara tıkla.
        //Sonra sessionKey cookiesini silip giriş bilgilerini temizle
        //Sonra bir bağlantıya tıkla
        //Beklenen: sessionKey cookie temizlenmesi sonrası bağlantıya tıklandığında bizi griş sayfasına yönlendirmeisni bekleriz.
        */
        driver.get("https://www.google.com/");

    }
}
