package Java_Concept;

public class static_and_nonStatic {
         // To share a single copy of a variable among all instances of a class
        //the static keyword in Java is used to share the same variable or method of a given class.
         //When you want all instances of a class to share the same data.
         static int StaticVariable = 20;

          public void nonStaticMethod() {
              int nonStaticVariable = 10;
            System.out.println("This is as non-static method." + StaticVariable);
        }
        public static void myMethod(){
            System.out.println("This is the static method");
            //static_and_nonStatic obj1=new static_and_nonStatic();  // you can call the non-static method in static method but
                                                                    //but by creating instance of it. not directly.
            //obj1.nonStaticMethod();
        }


        public static void main(String[] args) {
            myMethod();
            /*static_and_nonStatic obj = new static_and_nonStatic();
            obj.nonStaticMethod();*/
        }
    }
