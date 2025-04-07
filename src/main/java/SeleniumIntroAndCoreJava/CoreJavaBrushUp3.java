package SeleniumIntroAndCoreJava;

public class CoreJavaBrushUp3 {
    public static void main(String[] args) {

        //string is an object

        //string literal
        String s1="Sedat Ekmel"; //Ramde String tipinde s kadar yer ayrılır.
        String s2="Sedat Ekmel"; //s1, s ile aynı değere sahip olduğundan ikinci bir bellekte yer ayırma olmaz. s1, s yi işaret eder.

        //new
        String s3=new String("Welcome");
        String s4=new String("Welcome");

        String s="Rahal Shetty Academy";
        String[] splittedString=s.split(" ");
        System.out.println(splittedString[0]);//Rahal
        System.out.println(splittedString[1]);//Shetty
        System.out.println(splittedString[2]);//Academy

        System.out.println("---------------------");
        String[] splittedString2=s.split("Shetty");
        System.out.println(splittedString2[0]); //Rahal
        System.out.println(splittedString2[1]); // Academy
        System.out.println(splittedString2[1].trim()); // sağ ve solundaki boşlukları keser
        System.out.println("---------------------");

        //tersten yazdırma
        for (int i=s.length()-1;i>=0;i--)
        {
           System.out.println(s.charAt(i));
        }





    }
}
