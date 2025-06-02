package contructor;



public class Default_Contructor extends constructor{
    String Firstname ;


    Default_Contructor(){
        super();
        System.out.println("Child class default constructor called");
    }


    public static void main(String[] args) {

        Default_Contructor obj = new Default_Contructor();

    }
}
