package Collection;

import java.util.Iterator;
import java.util.LinkedList;

public class Linked_List {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(10);
        ll.add(20);
        ll.add(30);

        // For Loop
        for(int i =0; i<ll.size(); i++){
            System.out.println(ll.get(i));
        }
        System.out.println("---------------------------------");
        //Iterator loop
        Iterator<Integer> tt =ll.iterator();
        while(tt.hasNext()){
            System.out.println(tt.next());
        }
        System.out.println("---------------------------------");
        //While loop
        int num =0;
        while(ll.size()>num){
            System.out.println("Print the value of ll :  "+ ll.get(num));
            num++;
        }

    }
}
