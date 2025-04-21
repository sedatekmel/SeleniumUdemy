package Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DynamicTextPractise {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sedatekmel/Desktop/web drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice");

        //click any checkboxes
        driver.findElement(By.id("checkBoxOption3")).click();
        String checkedBxLabel = getCbLabel(driver);

        //select dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select option = new Select(dropdown);
        option.selectByVisibleText(checkedBxLabel);

        //enter the text
        driver.findElement(By.id("name")).sendKeys(checkedBxLabel);

        //click the alert btn
        driver.findElement(By.id("alertbtn")).click();

        //get the text on alert pop-up
        String alertMessage = driver.switchTo().alert().getText();
        String actualTxtPopUp = alertMessage.split(",")[0].split(" ")[1].trim();
        driver.switchTo().alert().accept();
        Assert.assertEquals(actualTxtPopUp, checkedBxLabel); //verify the text on alert message
        //2.yöntem alertmessage.contains(checkedBxLabel)

        driver.close();
    }

    //get the checkbox
    private static String getCbLabel(WebDriver driver) {
        {
            String label = "";
            List<WebElement> cboxes = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label/input"));
            for (WebElement cbx : cboxes) {
                if (cbx.isSelected()) {
                    label = cbx.findElement(By.xpath("parent::label")).getText();
                    break;
                }
            }
            return label;
        }
    }
}
