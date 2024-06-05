package Java_Streams;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Stream_program {
    @Test
            public void regular(){
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

        Long c = names.stream().filter(s->s.startsWith("A")).count(); //.forEach(s -> System.out.println(s)
        System.out.println(c);                        // Stream is nothing but the collection streams ,all arraylist collect in stream


       long d = Stream.of("Don","Aditya","john","jack").filter(s->
       {
           s.startsWith("A");
            return true;
       }).count();
        System.out.println(d);

       names.forEach(s-> System.out.println(s));
    }
}
