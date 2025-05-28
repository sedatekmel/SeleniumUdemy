package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SpiceJetE2E {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //From :Departure City
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA'] ")).click();
        String actualDepartureCity = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getDomAttribute("selectedvalue");
        Assert.assertEquals(actualDepartureCity, "MAA");
        Thread.sleep(2000);

        //To: Arrival City
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BKK']")).click();
        String actualArrivalCity = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getDomAttribute("selectedvalue");
        Assert.assertEquals(actualArrivalCity, "BKK");

        //Depart Date:
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
        String actualDepartDate = driver.findElement(By.id("ctl00_mainContent_txt_Fromdate")).getDomAttribute("value");
        Assert.assertEquals(actualDepartDate, "05-05-2019");

        //Is Return Date is disabled?
        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
            System.out.println("Return date is disabled");
            Assert.assertTrue(true);
        } else {
            System.out.println("Return date is enabled");
            Assert.assertTrue(false);
        }

        //Passengers:
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        int expectedPassengerCount = 5;
        for (int i = 1; i < expectedPassengerCount; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        String actualPassengerCount = driver.findElement(By.id("divpaxinfo")).getText();
        Assert.assertEquals(actualPassengerCount, expectedPassengerCount + " Adult");

        //Currency
        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropDown);
        dropdown.selectByVisibleText("USD");
        String actualCurrency = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualCurrency, "USD");

        //checkbox:
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

        //Search submit
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        Thread.sleep(2000);
        driver.close();

    }
}
