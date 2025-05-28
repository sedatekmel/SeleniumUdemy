package SeleniumIntroAndCoreJava;

public class CoreJavaBrushUp1 {

    public static void main(String[] args) {
        int myNum=5;
        String website="Sedat Ekmel Academy";
        char letter='s';
        double dec=5.99;
        boolean myCard=true;

        //primitive ve non primitive arasındaki fark araştır ?

        System.out.println(myNum + " is the value stored in the myNum variable");
        System.out.println(website);

        //Arrays
        int[] arr=new int[5]; //bellekte beş elemanı saklamak için integer tipinde bellek ayırdık
        arr[0]=1;
        arr[1]=2;
        arr[2]=4;
        arr[3]=5;
        arr[4]=6;

        int[] arr2={1,2,4,5,6,7,8,9,10,122};
        System.out.println(arr2[2]);

        //For Loop
        for (int i=0;i<arr.length;i++) {System.out.println(i+".indis:"+arr[i]);}

        for (int i=0;i<arr2.length;i++) {System.out.println(arr2[i]);}

        String[] name={"sedat","ekmel","selenium"};

        //klasik for döngüsü
        for(int i=0;i<name.length;i++){System.out.println(name[i]);}

        //For döngüsünün gelişmiş hali ve daha hızlı
        for (String s:name){System.out.println(s);}



    }

}
