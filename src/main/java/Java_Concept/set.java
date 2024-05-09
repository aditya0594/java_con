package Java_Concept;

import java.util.HashSet;
import java.util.Set;

public class set {

    public static void main(String[] args) {
        //HashSet implements Set interface in Java.
        //HashSet doesn’t allow duplicates values.
        //HashSet is an unordered collection and doesn’t maintain any order.
        //HashSet is completely object based. HashSet  does not provide get() method.

        Set setlist = new HashSet();

        setlist.add(1);
        setlist.add("Aditya");
        setlist.add(2);

        //duplicate value
        setlist.add(2);

        for(Object list : setlist){
            System.out.println("This is the list " + list);
        }
        System.out.println("The size of setlist : "+ setlist.size());






    }
}
