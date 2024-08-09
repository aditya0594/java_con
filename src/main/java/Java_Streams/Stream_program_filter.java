package Java_Streams;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Stream_program_filter {
    @Test
    public void regular(){
        // COunt the number of name start with "A"
        List<String> names  =  new LinkedList<>();
        names.add("Don");
        names.add("Aditya");
        names.add("john");
        names.add("jack");
        int count = 0;
        for(int i = 0; i<names.size();i++){
            String original = names.get(i);
            if(original.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }
    @Test
    public void streamFilter(){
        List<String> names  =  new LinkedList<>();
        names.add("Don");
        names.add("Aditya");
        names.add("john");
        names.add("jack");
        names.add("Adam");
        names.add("m");
        names.add("nn");

        long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);


        Stream.of("Aditya","pawar","geeta");

        // Stream is nothing but the collection streams ,
        // all arraylist collect in stream


        // How to print the all the value of array which is grater then 4

        names.stream().filter(s->s.length()>1).forEach(s-> System.out.println(s));
        System.out.println("-------------------------------------------------------------------------------");
        // For the single result
        names.stream().filter(s->s.length()>1).limit(1).forEach(s-> System.out.println(s));
    }
}
