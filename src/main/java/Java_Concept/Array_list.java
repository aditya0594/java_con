package Java_Concept;


import java.util.ArrayList;
import java.util.Iterator;

public class Array_list {
    public static void main(String[] args) {
        // non-generic
        System.out.println("----------------1111-----------------");
        ArrayList <String>ar = new ArrayList<String>();
        ar.add("10");
        ar.add("20");
        ar.add("Aditya");
        System.out.println("Size of array is : "+ ar.size());


        // printing the value of array
        //for loop
        for (int i=0; i<ar.size();i++){
            System.out.print(ar.get(i));
        }


        System.out.println("--------------22222-------------------");
        //Generic
        ArrayList<String>ar1 = new ArrayList<String>();
        ar1.add("QA");
        ar1.add("Dev");
        ar1.add("Admin");
        //advance for
        for(String str : ar1){
            System.out.println(str);
        }

        System.out.println("---------------3333------------------");

        //
        Employee e1 = new Employee("aditya",25,"QA");
        Employee e2 = new Employee("tom",26,"dev");
        Employee e3 = new Employee("jack",27,"Admin");

        ArrayList<Employee> ar3 = new ArrayList<Employee>();
        ar3.add(e1);
        ar3.add(e2);
        ar3.add(e3);


        for(int i=0; i<ar3.size();i++ ){
            System.out.println("The value of this Ar3 "+ ar3.get(i));
        }


        //iterator
        Iterator<Employee> it = ar3.iterator();
        while(it.hasNext()){
           Employee emp = it.next();
           System.out.println(emp.name);
            System.out.println(emp.age);
            System.out.println(emp.dept);
        }
        System.out.println("---------------------------------");

        ArrayList<String> ar4 = new ArrayList<String>();
        ar4.add("First Value of ar4");
        ar4.add("Second Value of ar4 ");

        ArrayList<String> ar5 = new ArrayList<String>();
        ar4.add("Adding in the array 4");
        ar4.add("This is adding in array 4 ");

        ar5.addAll(ar4);

        for(int i =0; i< ar5.size(); i++){
            System.out.println("This is adding the a5 to a4 by addall method : " + ar5.get(i));

        }

        System.out.println("---------------------------------");
        ArrayList<Integer> ar6 = new ArrayList<Integer>();
        ar6.add(15);
        ar6.add(16);

        // While Loop
        int num=0;
        while (ar6.size()>num){
            System.out.println("Print the value of the ar4 : " + ar6.get(num));
            num++;
        }


    }



}
