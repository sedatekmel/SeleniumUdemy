package test;

import org.testng.annotations.*;

import java.sql.SQLOutput;

public class Test2Intro {

    @Test(groups = {"Smoke"})
    public void askSomething()
    {
        System.out.println("Can I ask you something ?");
    }

    @BeforeTest
    public void preRequest()
    {
        System.out.println("I will execute first");
    }

    @BeforeSuite
    public void myBeforeSuite()
    {
        System.out.println("It's before suite. Number 1");
    }

    @BeforeClass
    public void myBeforeClass()
    {
        System.out.println("It's before class.");
    }

    @AfterClass
    public void myAfterClass()
    {
        System.out.println("It's after class.");
    }
}
