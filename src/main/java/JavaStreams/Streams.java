package JavaStreams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    @Test
    public void regular() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Ahmet");
        names.add("Deniz");
        names.add("Ali");
        names.add("Alex");
        names.add("Robert");
        int count = 0;
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (name.startsWith("A")) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Ahmet");
        names.add("Deniz");
        names.add("Ali");
        names.add("Alex");
        names.add("Robert");

        //kısa ifade -otomatik return
        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);

        //Küpe parantezli stream - return koymak şart
        Long d = Stream.of("Ahmet", "Deniz", "Ali", "Alex", "Robert").filter(s ->
        {
            return s.startsWith("A");
        }).count();
        System.out.println(d);

        //Print all the names of arrayList - foreach
        names.stream()
                .filter(s -> s.length() > 4)
                .forEach(s -> System.out.println(s));

        //print the limited name of arrayList : limit-2
        names.stream().
                filter(s -> s.length() > 4).
                limit(2)
                .forEach(s -> System.out.println(s));
    }

    @Test
    public void streamMap() {
        //data manipülasyon için map kullanılır.
        //print names which have last letter "t" with uppercase
        Stream.of("Ahmet", "Deniz", "Ali", "Alex", "Robert")
                .filter(s -> s.endsWith("t"))
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        System.out.println("----------------------------------------");
        //print names which have first letter as "a" with uppercase and sorted
        List<String> names1 = Arrays.asList("Ahmet", "Deniz", "Ali", "Alex", "Robert");
        names1.stream()
                .filter(s -> s.startsWith("A"))
                .sorted()
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        ArrayList<String> names2 = new ArrayList<String>();
        names2.add("George");
        names2.add("Mike");
        names2.add("Ronaldo");

        System.out.println("----------------------------------------");
        //İki arrayi stream ile birleştirmek  - Merging 2 different lists
        Stream<String> newStream = Stream.concat(names1.stream(), names2.stream());
        newStream
                .sorted()
                .forEach(s -> System.out.println(s));

        System.out.println("----------------------------------------");
        //Liste içinden arama yapmak -- anyMatch
        Stream<String> newStream2 = Stream.concat(names1.stream(), names2.stream());
        boolean flag = newStream2.anyMatch(s -> s.equalsIgnoreCase("Mike"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect() {

        System.out.println("----------------------------------------");
        List<String> ls = Stream.of("Ahmet", "Deniz", "Ali", "Alex", "Robert")
                .filter(s -> s.endsWith("t"))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(ls.get(0));

        System.out.println("----------------------------------------");
        List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
        values.stream().distinct().forEach(s -> System.out.println(s)); //3,2,7,5,1,9

        System.out.println("----------------------------------------");
        //1,2,3,5,7,9 olarak sırala ve 3. elemanı al yani 3 değerin ekrana bas
        List<Integer> sortedVal=values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(sortedVal.get(2));
    }

}
