package OOPPrinciples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ps {

    public void doThis() {
        System.out.println("I'm here");
    }

    @BeforeMethod
    public void beforeTest() {
        System.out.println("I'm first");
    }

    @AfterMethod
    public void afterTest() {
        System.out.println("I'm last");
    }

    @Test(enabled = false)
    public void secondTest() {
        System.out.println("I'm here but 2th");
    }


}
