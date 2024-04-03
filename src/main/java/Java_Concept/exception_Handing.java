package Java_Concept;

public class exception_Handing {

    public static void fun(){
        try {
            throw new NullPointerException("Demo");
        }
        catch(NullPointerException e){
            System.out.println("find inside the method");
            throw e;
        }
    }
    public static void main(String[] args) {
        try {
            fun();
        }
        catch (NullPointerException e){
            System.out.println("Find in the main method");
            throw e;
        }

    }
}
