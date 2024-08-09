package Java_Streams;

import groovy.lang.ObjectRange;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMAp {

    @Test
    public void StreamMAp() {
        List<String> names = new LinkedList<>();
        names.add("Don");
        names.add("Aditya");
        names.add("john");
        names.add("jack");
        names.add("Adam");
        names.add("m");
        names.add("nn");

        long c = names.stream().filter(s -> s.contains("nn")).count();
        System.out.println(c);

        // Get a  name Which have the last name as "A"
        // this s have aditya first then it is map to
        System.out.println("----------------------start with a and to upperCase-------------------------");
       Stream.of("Aditya", "pawar", "geeta").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
                .forEach(s-> System.out.println(s));
        System.out.println("----------------------find the repeated name-------------------------");

        String str = "This is aditya and aditya is good";
        String[] words = str.split(" ");
      Long count = Arrays.stream(words).filter(s->s.equalsIgnoreCase("aditya")||s.equalsIgnoreCase("is")).count();
        System.out.println(count);

        System.out.println("----------------------Find name which has first letter with uppercase and sort -------------------------");

        List<String> list = new ArrayList<>(names);
        //List<String> list = Arrays.asList("Aditya", "pawar", "geeta","Amol","pooja","Alex");
        list.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
    }
    @Test
    public void StreamMatch() {
        List<String> str = new LinkedList<>();
        str.add("Aditya");
        str.add("Pawar");
        List<String> name = Arrays.asList("first","Second","third");
        // mergeing to different list.
      Stream<String> newstream = Stream.concat(str.stream(),name.stream());
      newstream.sorted().forEach(s-> System.out.println(s));

      Stream<String> newstream1 = Stream.concat(str.stream(),name.stream());
      boolean flag = newstream1.anyMatch(s->s.equalsIgnoreCase("first"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }
    @Test
    public void StreamCollect() {

      List <String> ls = Stream.of("Aditya", "pawar", "geeta","one","Two").map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(ls.get(0));
        ls.stream().filter(s -> s.length()>4).limit(1).forEach(s -> System.out.println(s));

        List <Integer> values = Arrays.asList(2,1,7,4,9,5,6,6);
        //print the unique number from the array
        values.stream().distinct().forEach(s-> System.out.println(s));

        //print this in sorted order
        //OR
        //Print this in the sorted array and give me third index
        List<Integer> valueList = values.stream().distinct().sorted().distinct().collect(Collectors.toList());
        System.out.println("this is the values 3rd " + valueList.get(3));
                //limit(3).forEach(s->System.out.println("this the 3 indexed number : "+ s));



    }





}
