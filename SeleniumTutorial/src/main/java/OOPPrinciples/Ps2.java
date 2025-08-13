package OOPPrinciples;

public class Ps2 extends Ps3 {

    int a;
    //default constructor
    public Ps2(int a) {
        super(a);
        this.a = a;
    }

    public int increment() {
        a = a + 1;
        return a;
    }

    public int decrement() {
        a = a - 1;
        return a;
    }
}
