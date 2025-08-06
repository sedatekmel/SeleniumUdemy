package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeLoan {

    @Parameters({"URL","APIKey/username"})
    @Test(timeOut = 4000)
    public void WebLoginHomeLoan(String urlname,String apikey) throws InterruptedException {
        System.out.println("webLoginHome");
        System.out.println(urlname);
        System.out.println(apikey);
    }
    @Test(enabled = false)
    public void MobileLoginHomeLoan()
    {
        System.out.println("mobileLoginHome");
    }
    @Test(dependsOnMethods = {"WebLoginHomeLoan"})
    public void APILoginHomeAlone()
    {
        System.out.println("APILoginHome");
    }
}
