package SeleniumIntroAndCoreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp2
{
    public static void main(String[] args) {
        int[] arr2={1,2,4,5,6,7,8,9,10,122};

        //2,4,6,8,10,122
        //check if array has multiple
        for (Integer i:arr2)
        {
            if(i%2==0) {System.out.println(i);break;}
            else {System.out.println(i+"is not multiple of 2");}
        }

        ArrayList<String> a=new ArrayList<String>();
        //create object of the class - object.method
        a.add("Sedat");
        a.add("Ekmel");
        a.add("Academy");
        a.add("Selenium");
        System.out.println(a);
        System.out.println("------------");
        System.out.println(a.get(3));
        System.out.println("------------");

        //Normal for döngüsü
        for (int i=0;i<a.size();i++){System.out.println(a.get(i));}
        System.out.println("------------");

        //Gelişmiş for döngüsü
        for( String val  :a)
        {System.out.println(val);}
        System.out.println("------------");

        //item is present in ArrayList -- contains()

        System.out.println (a.contains("Selenium"));
        System.out.println("------------");

        //array to arraylist convert
        String[] name ={"mavi","kırmızı","selenium"};
        List<String> nameArrayList=Arrays.asList(name);
        nameArrayList.contains("selenium");


    }
}
