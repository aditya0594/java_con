package polymorphism;

public class MethodOverridingChildClass extends MethodOverridingParentClass {


    @Override
    public void myMethodParent(){
        System.out.println("this the overiding method in the child class");
    }

    public static void main(String[] args) throws Exception {

        /* When parent class reference refers to the child class object
         * then the method of the child class (overriding method) is called.
         * This we call as runtime polymorphism
         */
        MethodOverridingParentClass obj = new MethodOverridingChildClass();
        // It calls the child class method myMethod()
        obj.myMethodParent();


        /* When Parent class reference refers to the parent class object
         * then the method of parent class (overriden method) is called.
         */
        MethodOverridingParentClass obj1 = new MethodOverridingParentClass();
        obj1.myMethodParent();

    }

    /**
     Can a static method be overridden?
    Answer: No, static methods cannot be overridden because they belong to the class, not instances of the class.
    However, they can be hidden if a subclass defines a static method with the same signature.

    What happens if you declare a static method with the same signature in the subclass?
    Answer: The static method in the subclass hides the static method in the superclass.
    This is not true method overriding but method hiding.

     Can you override a method if the method in the superclass is declared as private or final?
    Answer: No, a private method cannot be overridden because it is not visible to the subclass.
    A final method cannot be overridden because it is explicitly marked to prevent modification.

     What is @Override?
     The @Override annotation is a label that tells Java:
     “This method is overriding a method from the parent class.”

     Why is it @Override is useful?
     ✅ It checks for mistakes at compile time.
     ❌ If the method name or parameters are wrong, the compiler gives an error.


    What is the use of the @Override annotation?

    Answer: The @Override annotation indicates that a method is intended to override a method in the superclass.
    It helps catch errors at compile time, such as incorrect method signatures.

     What happens if you do not use the @Override annotation when overriding a method?
    Answer: The code will still compile and run correctly if the method is properly overridden.
    However, omitting the annotation may allow mistakes to go unnoticed, such as incorrect method signatures.

     */
}