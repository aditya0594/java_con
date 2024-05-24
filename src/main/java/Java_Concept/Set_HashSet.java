package Java_Concept;

import java.util.*;

public class Set_HashSet {

    public static  void main(String[] args) {
        //HashSet implements Set interface in Java.
        //HashSet doesn’t allow duplicates values.
        //HashSet is an unordered collection and doesn’t maintain any order.
        //HashSet is completely object based. HashSet  does not provide get() method.
        //There is no guarantee element stored in the sequential order .. They may store in random order.
        //HashSet , treeSet, LinkedHashSet implements the Set interface.
        // .add(), .remove(),

        HashSet<String> setlist = new HashSet<String>();

        setlist.add("USA");
        setlist.add("INDIA");
        setlist.add("UK");
        setlist.add("He");
        setlist.add("is");
        //duplicate value
        setlist.add("INDIA");
        System.out.println(setlist);
       //setlist.remove("UK");

        System.out.println(setlist.isEmpty()); //it will give the boolean value
        System.out.println("-----------------Lamda---------------------");

        setlist.forEach(values ->System.out.println(values));

        System.out.println("--------------------------------------");

        for(Object list : setlist){
            System.out.println("This is the list " + list);
        }
        System.out.println("The size of setlist : "+ setlist.size());

        System.out.println("--------------------------------------");

      Iterator<String> i = setlist.iterator();
      while(i.hasNext()){
          System.out.println(i.next());
      }











    }
}
