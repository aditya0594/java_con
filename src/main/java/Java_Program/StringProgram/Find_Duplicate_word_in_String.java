package Java_Program.StringProgram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Find_Duplicate_word_in_String {

   public static void main(String[] args) {
        String str = "Aditya pawar Aditya";
        String[] arr = str.split(" ");
        //int arr[] = {1,2,5,3,4,5};
        boolean flag = false;
        HashSet<String> hasint = new HashSet<>();
       HashMap<String,Integer> hashMap = new HashMap<>();
        for(String l: arr) {

            if (hasint.add(l)==false)
            {
                System.out.println("Found duplicate integer :"+ l);
                flag= true;
            }
            if(hashMap.containsKey(l)){
                hashMap.put(l,hashMap.get(l)+1);
            }
            else{
                hashMap.put(l,1);
            }
        }
        if(flag==false){

            System.out.println("Not content duplicate");
        }
        for(Map.Entry<String,Integer> ls : hashMap.entrySet()){
            System.out.println(" The number : " + ls.getKey() + " Count is : "+ ls.getValue());
        }


       System.out.println("--------------------using the stream function to remove the duplicate element --------------");
      //  List list = Arrays.stream(arr).distinct().collect(Collectors.toList());
      // System.out.println(list);

    }


/*
    public static void main(String[] args) {
        String str = "this java java";
        String[] word =str.split(" ");
        boolean flag= false;
        HashSet<String> hashSet = new HashSet<>();
        for(String w : word){
            if(hashSet.add(w)==false){
                flag = true;
                System.out.println("Found duplicate");
            }
        }
        if(flag == false){
            System.out.println("No duplicate found");
        }

    }
*/






}
