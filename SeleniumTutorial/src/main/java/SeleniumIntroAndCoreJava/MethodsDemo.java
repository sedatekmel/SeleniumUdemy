package SeleniumIntroAndCoreJava;

public class MethodsDemo {
    public static void main(String[] args) {

        MethodsDemo d=new MethodsDemo();
        String name= d.getData();
        System.out.println(name);
        MethodsDemo2 d1=new MethodsDemo2();
        d1.getUserData();
        getData2();//bu method static olduğundan object ile çağrılmaz. Classa bağlandığından direkt çağırabilir.
    }

    public String getData()
    {
        System.out.println("hello world");
        return "Rahul Shetty";
    }

    public static String getData2()
    {
        System.out.println("hello world 2");
        return "Rahul Shetty";
    }
}
