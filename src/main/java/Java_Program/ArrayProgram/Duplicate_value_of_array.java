package Java_Program.ArrayProgram;

import org.apache.commons.collections4.map.HashedMap;
import org.bouncycastle.jcajce.provider.digest.MD2;

import java.util.HashSet;
import java.util.Map;

public class Duplicate_value_of_array {
    public static void main(String[] args) {
/*        int[] value = {1,2,3,4,5,6,2};
        boolean flag = false;
        HashSet<Integer> integers = new HashSet<>();
        for (Integer integerseparate : value) {
            if (integers.add(integerseparate) == false) {
                flag = true;
                System.out.println("Duplicate found");
            }
        }
            if(flag == false){
                System.out.println("No Duplicate found");
            }*/


        int[] arr = {1, 2, 3, 4, 4};
        HashSet<Integer> hashSet = new HashSet<>();
        HashedMap<Integer,Integer > hashedMap = new HashedMap<>();

        boolean flag = false;
        for(Integer values : arr ) {
            if(hashedMap.containsKey(values)){
                hashedMap.put(values,hashedMap.get(values)+1);
            }else {
                hashedMap.put(values,1);
            }
            if (hashSet.add(values) == false) {
                System.out.println("Duplicate value found " + values);
                flag = true;
                break;
            }

        }

        if(flag==false) {
            System.out.println("No duplicate found");
        }
        for(Map.Entry<Integer,Integer> map : hashedMap.entrySet()){
            System.out.println("the count of the element "+  map.getKey()+ " is : "+ map.getValue() );
        }

    }
}




