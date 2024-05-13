public class StaticVar {

    // String name;

    String name;  //String name   >> Instance variable , As this varible is instance dependent that we call this variable as instance variable.
    String address; //String address   >> Instance variable  variable
    static  String city = "Nagpur";    // Static variable is not dependant on the instance variable, static variable independant of objects
                            // This staic variable not change the value, this is also called os class varisble
                            // Whenever we declare varible as static then that variable is part of class not an object
    static int i = 0;

    // StaticVar(String name, String address, String city ) >> this is the local variable because the scope of the this variable inside the Method only.
    // Now we have to assign this varible to the instance varible, so For that we have use the "This" keyword
    //these all is the local variable because the scope of the this variable inside the class only.
    // constructor, Constructor name should same as the class name
    // if we are passing the parameter to the constuctor then it is a parameterize constructor
    StaticVar(String name, String address) {
        this.name = name;
        this.address = address;
        i++;
        System.out.println(i);

    }
    public void getAddress(){

        System.out.println(address+ " "+ city);
    }


    public static void getCity(){                  //static method only accept the static variable. //this call the class methods
        System.out.println(city) ;          // it accpect only static variable .
        //System.out.println(address;);     //Static methods belong to the class rather than any specific instance of the class..
                                            // They are associated with the class definition itself rather than any particular object created from that class.
        // Why static methods not accept instance variable ?
        //When you call a static method, you don't need to instantiate an object of the class.
        // Static methods are invoked using the class name directly, without reference to any specific object.
        // Since static methods are not associated with any particular instance of the class,
        // they cannot access instance variables directly because they might not have any specific instance to refer to.
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
