package Java_Concept;

public class This_keyword {
    private String name;
    private int age;
    // Constructor
    public This_keyword(String name) {
                                      // Use "this" to refer to the instance variable "name"
          this.name = name;
    }
    private This_keyword(int age){

        this.age = age;
    }
    public void getAge()  // Method to print the name of the person
    {
        System.out.println(this.age);
    }


    public void printName() {
        // Use "this" to refer to the instance variable "name"
        System.out.println("My name is " + this.name);
    }

    // Main method
    public static void main(String[] args) {
        // Create a new Person object
        This_keyword person = new This_keyword("John");
        This_keyword personAge = new This_keyword(1);
        // Call the printName method
        person.printName();
        personAge.getAge();
    }


/**
 Q1 Why do we use this.name = name; instead of just name = name; in the constructor?
 ✅ Answer:
 We use this.name = name; to differentiate between the instance variable (this.name) and the constructor parameter (name).
 If we write name = name;, both refer to the constructor parameter — the instance variable remains unchanged.


 Q2: Can we use this() to call another constructor from inside a constructor?
 ✅ Answer:
 Yes, we can use this() to call another constructor in the same class.
 But it must be the first statement in the constructor.

 📌 Example:
 public This_keyword(String name, int age) {
 this(age);         // calls the constructor with int parameter //this is the parameter contructor
 this.name = name;
 }


 Q3: What will happen if you don't use this in your constructors?
 ✅ Answer:
 If parameter names are same as instance variables, and this is not used,
 the compiler assumes you're referring to the parameter, not the instance variable.
 So, the instance variable won't be initialized.

 Q5: What is the difference between this.name and name inside the class?
 ✅ Answer:
 this.name → refers to the instance variable.
 name → refers to the local variable or method/constructor parameter (if one exists with the same name).


 Q6: Can we return this from a method?
 ✅ Answer:
 Yes, this can be returned from a method. It is often used in method chaining.

 📌 Example:
 public This_keyword setName(String name) {
 this.name = name;
 return this;
 }

 Q7. Can you use this inside a static method?
 No, You cannot use this inside a static method — in any version of Java — because static methods belong to the class, not to any object.
 Since this refers to the current object, and static methods have no object context, it's not allowed.


 Q8. What is the main reason for using this in a class?
 Your Answer: B. To refer to instance variables when there's a naming conflict
 ✔️ Correct!

 Explanation:
 this is used when a method or constructor parameter has the same name as an instance variable. It helps Java know that you're referring to the instance variable, not the parameter.



 Q9`. What is the main reason for using this in a class?
 Your Answer: B. To refer to instance variables when there's a naming conflict
 ✔️ Correct!
 Explanation:
 this is used when a method or constructor parameter has the same name as an instance variable.
 It helps Java know that you're referring to the instance variable, not the parameter.




 */

}
