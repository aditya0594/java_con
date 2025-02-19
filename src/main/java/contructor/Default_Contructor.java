package contructor;



public class Default_Contructor extends constructor{
    String Firstname ;


    Default_Contructor(){
        super();
        System.out.println("Child class default constructor called");
    }
    Default_Contructor(String Firstname){
        super(Firstname);
        this.Firstname = Firstname;
        System.out.println("This is the child class constructor" + Firstname);
    }

    public static void main(String[] args) {
          //constructor.getConstructor(20 , 30);
        Default_Contructor obj = new Default_Contructor();
        getConstructor(10,20);
    }
}
