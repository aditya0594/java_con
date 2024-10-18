package Java_Streams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Multiply_by_two {
    @Test
    public void Multiple(){
        List<Integer> arr = List.of(1,2,3,4,5,6,7,8,9);
        List<Integer> list = arr.stream().map(s->s*2).toList();
        System.out.println(list);
    }
    @Test
    public void Grace()
    {
        List<Integer> arr = List.of(25,86,36,96,88,6,7,8,9);

    }

}
