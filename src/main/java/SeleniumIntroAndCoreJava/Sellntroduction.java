package SeleniumIntroAndCoreJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sellntroduction {

    public static void main(String[] args)
    {
        //Invoking Browser(Tarayıcıyı çağırma)
        //Chrome - ChromeDriver  -> Methods
        //ChromeDriver driver=new ChromeDriver(); // webDriver methods +chrome methods
        //SeleniumManager


        //Chrome
        System.setProperty("webdriver.chrome.driver","C:/Users/sedat.ekmel/OneDrive - TESTINIUM Teknoloji Yazılım A.Ş/Masaüstü/IntellijIDEA Projects/SeleniumProjects/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //Firefox
       // System.setProperty("webdriver.gecko.driver","C:/Users/sedat.ekmel/OneDrive - TESTINIUM Teknoloji Yazılım A.Ş/Masaüstü/IntellijIDEA Projects/SeleniumProjects/geckodriver.exe");
        //WebDriver driver1=new FirefoxDriver();

        //Microsoft Edge
        //System.setProperty("webdriver.edge.driver","C:/Users/sedat.ekmel/OneDrive - TESTINIUM Teknoloji Yazılım A.Ş/Masaüstü/IntellijIDEA Projects/SeleniumProjects/msedgedriver.exe");
        //WebDriver driver2 =new EdgeDriver();

        driver.get("https://rahulshettyacademy.com/"); //urle git.
        System.out.println("URL Title : "+ driver.getTitle()); //sitenin başlığını alır.
        System.out.println("Current URL : "+driver.getCurrentUrl()); //sitenin urlini alır
        driver.close(); //current browserı kapatır ilişkili browser kapatmaz. Bir url gitti ve orada bir link var ona tıkladı başka sekme açıldı. Bu yöntem sadece ilk açılanı kapatır.
        //driver.quit(); //multiplepage -> ilişkili browserları kapatır.Bir url gitti ve orada bir link var ona tıkladı başka sekme açıldı. Bu yöntem ikisinide kapatır.


    }
}
