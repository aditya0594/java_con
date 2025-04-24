package Interface;

interface Vehical {
    
    int variable = 0;
    void start();

     String stop(); //this is the abstracted method


    default void fualType(){ // Default method after the java 8 introduce
        System.out.println("petrol or disel");

    }

    static void generalMethod(){
        System.out.println("Vehical is use for transportation");
    }


}
