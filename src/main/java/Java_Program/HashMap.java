package Java_Program;


public class HashMap {
    public static void main(String[] args) {
       java.util.HashMap hm = new java.util.HashMap();
       hm.put(1, "Selenium");
       hm.put(2,"QTP");
       hm.put(3, "Testcomplete");
       hm.put(3,"Appium");

        System.out.println("---------------------------------");
        System.out.println("HashMap value with the key : " + hm.get(1));

        System.out.println("---------------------------------");
        // To print all the value of HASHMAP 

        System.out.println("HashMap value with the key :" + hm.get(3));

        System.out.println("---------------------------------");
        // iterating through key/value mappings
        System.out.println("Entries through the for each : ");
        for(Object entry: hm.entrySet()) {
            System.out.print(" " +entry);
        }
        System.out.println("---------------------------------");
        // iterating through keys
        System.out.print("Only the Keys showing using the for each loop : ");
        for(Object key: hm.keySet()) {
            System.out.print(" "+ key);

        }
        System.out.println("---------------------------------");
        // iterating through values
        System.out.print("Only the Keys showing using the for each loop values: ");
        for(Object values: hm.values()) {
            System.out.print(" "+ values);
            System.out.print(", ");
        }
        //hm.entrySet() - returns the set view of all the entries
       // hm.keySet() - returns the set view of all the keys
       // hm.values() - returns the set view of all the values
    }
}
