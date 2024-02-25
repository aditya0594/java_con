package Java_Concept;

public class static_and_nonStatic {

         static int nonStaticVariable = 20;

          void nonStaticMethod() {
              int nonStaticVariable = 10;
            System.out.println("This is as non-static method." + nonStaticVariable);
        }

        public static void main(String[] args) {
            static_and_nonStatic obj = new static_and_nonStatic();
            obj.nonStaticMethod();
        }
    }
