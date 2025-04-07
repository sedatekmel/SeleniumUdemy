package SeleniumIntroAndCoreJava;

public class ArrayExploration {
    public static void main(String[] args) {

                int[] number={5,10,15,20,25};

                System.out.println(number[0]);
                System.out.println(number[4]);


                for(int i=number.length-1;i>=0;i--)
                {
                    System.out.println("i.number: "+number[i]);
                }

                int sum=0;
                for(int i=0;i<number.length;i++)
                {
                    sum=sum+number[i];
                }
                System.out.println("Total count: "+sum);
            }

        }

