package Java_Concept;


import com.aventstack.extentreports.gherkin.model.ScenarioOutline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Array_list {
    public static void main(String[] args) {
        // non-generic

        //ArrayList Class implements List interface.
        //ArrayList allows duplicate elements (remember that Set in Java won't allow duplicate values.)
        //ArrayList maintains the order of the object in which they are inserted
        //ArrayList is index based we can retrieve object by calling get(index) method or remove objects by calling remove(index) method
        //ArrayList not apply any restriction, we can add any number of null value
        //You can access and insert value in any index

        // ArrayList, LinkdedList, Vector ---implementing the List interface

        System.out.println("----------------1111-----------------");



        List<String> ar = new ArrayList<String>();
        ar.add("10");
        ar.add("20");
        ar.add("Aditya");
        ar.add("Remove value");
        ar.add(0,"replace 10");
        System.out.println(ar);
        ar.add(0, "first");
        System.out.println(ar);
        ar.remove(1);
        System.out.println(ar);
        System.out.println(ar.contains("10")); //boolean value it will return..
        System.out.println(ar.indexOf("Aditya"));
        System.out.println(ar.isEmpty()); // boolean value  it will return.

        System.out.println("--------------111111-------------------");

        System.out.println("Size of array is : "+ ar.size());
        System.out.println("Size of array is : "+ ar.get(0));

        // printing the value of array
        //for loop
        for (int i=0; i<ar.size();i++){
            System.out.println("This the list of arraylist : " + ar.get(i));
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
        System.out.println("---------------lamda------------------");
        ar1.forEach(value -> System.out.println(value));
        System.out.println("---------------lamda------------------");
        //
        Employee e1 = new Employee("aditya",25,"QA");
        Employee e2 = new Employee("tom",26,"dev");
        Employee e3 = new Employee("jack",27,"Admin");

        ArrayList<Employee> ar3 = new ArrayList<Employee>();
        ar3.add(e1);
        ar3.add(e2);
        ar3.add(e3);


        for(int i=0; i<ar3.size();i++ ){
            System.out.println("The value of this Ar3 : "+ ar3.get(e1.age));


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
