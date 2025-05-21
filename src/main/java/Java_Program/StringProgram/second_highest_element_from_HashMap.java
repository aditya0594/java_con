package Java_Program.StringProgram;

import com.google.common.collect.HashBiMap;

import java.util.*;

public class second_highest_element_from_HashMap {
    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A",100);
        hashMap.put("B",200);
        hashMap.put("C",300);

        List<Integer> values = new ArrayList<>(hashMap.values());
       Collections.sort(values,Collections.reverseOrder());
        int secondHighest = values.get(1);
        hashMap.values().removeIf(val -> val == secondHighest);
        System.out.println(hashMap);
    }
}
