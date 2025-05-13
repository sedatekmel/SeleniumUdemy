package MiscellaneousTopics;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeOptionsExerc {
    public static void main(String[] args) {

        // FirefoxOptions opt1=new FirefoxOptions();
        //EdgeOptions opt2=new EdgeOptions();
        //SafariOptions opt3=new SafariOptions();

        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        options.setAcceptInsecureCerts(true); // SSL sertifikalarını atlama
        System.out.println(driver.getTitle());

        /*
        Amaç:
        Tarayıcı trafiğini belirli bir IP/port üzerinden yönlendirmek, genellikle test,
                IP gizleme veya bölgesel içerik kontrolü için yapılır.
                */
        Proxy proxy = new Proxy();  //  Yeni bir Proxy nesnesi oluşturur.
        proxy.setHttpProxy("ipaddress:4444"); // HTTP proxy adresini ve portunu ayarlar (örnek: 123.45.67.89:4444 gibi).
        options.setCapability("proxy",proxy); // Tanımlanan proxy'yi tarayıcı seçeneklerine (options) ekler, böylece Selenium bu proxy üzerinden çalışır.

        /*Amaç:
        Kullanıcıdan onay almadan veya "Nereye kaydedilsin?" penceresi çıkmadan dosyaların
        otomatik olarak belirtilen klasöre inmesini sağlar.
        */
        Map<String,Object> prefs=new HashMap<String,Object>(); // Tarayıcıya özel ayarları tutacak bir Map (anahtar-değer yapısı) oluşturur.
        prefs.put("download.default_directory", "/directory/path"); //Chrome'un dosyaları otomatik olarak indireceği klasör yolunu belirler. (Örn: "C:/Downloads/Test" gibi)
        options.setExperimentalOption("prefs",prefs); // Bu tercihleri (prefs) Chrome seçeneklerine uygular.
    }
}
