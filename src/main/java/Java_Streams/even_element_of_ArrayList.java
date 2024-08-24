package Java_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface even_element_of_ArrayList {
    public static void main(String[] args) {

        List<Integer> arr = List.of(1,2,3,4,5,6,7,8,9);
        List<Integer> list = arr.stream().filter(s->s%2==0).collect(Collectors.toList());
        List<Integer> list1 = arr.stream().filter(s->s%2==0).toList();
        System.out.println(list);

    }
}