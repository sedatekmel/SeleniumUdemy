package OOPPrinciples;

import org.testng.annotations.Test;

public class Ps1 extends Ps {

    Ps2 ps2=new Ps2(3);

    @Test
    public void testRun()
    {
        doThis();
    }

    @Test(dependsOnMethods = {"testRun"})
    public void mathFunc()
    {
        System.out.println(ps2.increment());
        System.out.println(ps2.decrement());
        System.out.println(ps2.multiplyThree());
    }



}
