public class StaticVar {

    // String name;
    //String address   >> Instance variable  variable
    String name;
    String address;
    static  String city;; // Static variable is not dependant on the instance variable, static variable independant of objects
                        // This staic variable not change the value, this is called os class varisble
                        // Whenever we declare varible as static then that variable is part of class not object
    static int i = 0;

    // StaticVar(String name, String address,String city) >> this is the local variable because the scope of the this variable inside the Method only.
    // Now we have to assign this varible to the instance varible so we will user the "This" keyword
    //this is the local variable because the scope of the this variable inside the class only.
    // constructor, Constructor name should same as the class name
    // if we are passing the parameter to the constuctor thenit is a parameterize constructor
    StaticVar(String name, String address) {
        this.name = name;
        this.address = address;
        i++;
        System.out.println(i);

    }
    public void getAddress(){

        System.out.println(address+ " "+ city);
    }
    public static void getCity(){    //static method only accept the static variable. //this call the class methods
        System.out.println(city);  // it accpect the static variable only.
    }



    public static void main(String[] args) {

        // Object for the class
        // Object of class should not be created out side the main method
        // if yoou want to access method or varible it is mandatory to creat the object

        StaticVar obj = new StaticVar("adtya", "chatrapati");
        StaticVar obj1 = new StaticVar("pawar", "dev nagar");
        obj.getAddress();
        StaticVar.getCity(); // static method call directly by the class name as they are objject independent
    }



}
