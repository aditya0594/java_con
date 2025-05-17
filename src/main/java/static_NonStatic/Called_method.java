package static_NonStatic;

public class Called_method extends static_and_nonStatic{


    @Override
    public void nonStaticMethod() {  // we can override only nonstatic method we cannot override static method
        super.nonStaticMethod();

        System.out.println("This is the called method");
    }
    public static void myMethod(int num ){
        System.out.println("This is the static method");
        static_and_nonStatic obj1=new static_and_nonStatic();  // you can call the non-static method in static method
        // but by creating instance of it. not directly
        obj1.nonStaticMethod();
        System.out.println("This is the called method in the static method" + num);
    }


    public static void main(String[] args) {
        Called_method obj = new Called_method();
        obj.nonStaticMethod();
        obj.myMethod("Aditya");// this is the static method call in the nonstatic method
        myMethod(10); // this is the static method call in the nonstatic method

    }
}
