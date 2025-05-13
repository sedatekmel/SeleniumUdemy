package JavaStreams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test1 {

    @Test
    public void Regular() {
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
    public void StreamFilter() {
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
                .filter(s->s.length()>4)
                .forEach(s-> System.out.println(s));

        //print the limited name of arrayList : limit-2
        names.stream().
                filter(s->s.length()>4).
                limit(2)
                .forEach(s-> System.out.println(s));
    }

    @Test
    public void StreamMap()
    {
        //data manipülasyon için map kullanılır.
        //print names which have last letter "t" with uppercase
        Stream.of("Ahmet", "Deniz", "Ali", "Alex", "Robert")
                .filter(s->s.endsWith("t"))
                .map(s->s.toUpperCase())
                .forEach(s-> System.out.println(s));

        System.out.println("----------------------------------------");
        //print names which have first letter as "a" with uppercase and sorted
        List<String> names=Arrays.asList("ahmet", "deniz", "ali", "alex", "robert");
        names.stream()
                .filter(s->s.startsWith("a"))
                .sorted()
                .map(s->s.toUpperCase())
                .forEach(s-> System.out.println(s));
    }

}
