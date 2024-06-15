package Java_Concept;

public class static_Local_variable {

    String name;
    static String city = "Nagpur";
    String address;



    public static_Local_variable(String name,String address){ // this is local variable

        this.name = name;
        this.address = address;

    }
    public void getAddress(){
        System.out.println(address + " " + city);
    }

    public static void main(String[] args) {
        static_Local_variable obj = new static_Local_variable("aditya","Chatrapati");
        static_Local_variable obj1 = new static_Local_variable("Ram","khamal");

    }

}
