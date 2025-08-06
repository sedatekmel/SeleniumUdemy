package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGIntro {

    @Test(groups = {"Smoke"})
    public void sayHello()
    {
        System.out.println("Hello");
    }

    @Test
    public void sayGoodBye()
    {
        System.out.println("Good Bye");
    }

    @Test(dataProvider = "getData")
    public void BaseLogin(String username,String password)
    {
        System.out.println("BaseLogin");
        System.out.println(username);
        System.out.println(password);
    }

    @AfterTest
    public void lastExecution()
    {
        System.out.println("I will execute last");
    }

    @DataProvider
    public Object[][] getData()
    {
         //1st set : Good credit history       : username1 , password1
         //2th set : No credit history         : username2 , password2
         //3th set : Fraudulent credit history : username3 , password3

        Object[][] data =new Object[3][2]; // 3:set sayısı(row) , 2: parametre sayısı(column)

        //1st set
        data[0][0]="username1";
        data[0][1]="password1";

        //2th set
        data[1][0]="username2";
        data[1][1]="password2";

        //3th set
        data[2][0]="username3";
        data[2][1]="password3";

        return data;
    }
}

