package test;

import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.SQLOutput;

public class CarLoan {

    @Parameters("URL")
    @Test
    public void WebLoginCarLoan(String urlname) {
        System.out.println("webLoginCar");
        System.out.println(urlname);
    }


    @Test(groups = {"Smoke"})
    public void MobileLoginCarLoan() {
        System.out.println("mobileLoginCar");
    }

    @Test
    public void MobileLoginSignInLoan() {
        System.out.println("mobileSignInCar");
    }

    @Test
    public void MobileSignUpCarLoan() {
        System.out.println("mobileSignUpCar");
    }

    @Test
    public void MobileSignOutLoan() {
        System.out.println("mobileSignOutCar");
    }

    @Test(groups = {"Smoke"})
    public void APILoginCarAlone() {
        System.out.println("APILoginCar");
        Assert.assertTrue(false);
    }

    @AfterSuite
    public void myAfterSuite() {System.out.println("It's after suite. End of the test");}

    @BeforeMethod
    public void myBeforeMethod() {
        System.out.println("I'am Before Method. I execute before each test method.");
    }

    @AfterMethod
    public void myAfterMethod() {
        System.out.println("I'am After Method. I execute after each test method.");
    }


}
    
