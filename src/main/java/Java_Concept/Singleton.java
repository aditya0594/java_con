package Java_Concept;

public class Singleton {
    // Private static variable of the same class that is the only instance of the class
    private static Singleton singleInstance;

    // Private constructor to restrict instantiation of the class from other classes
    private Singleton() {
        // Initialize any required resources
    }

    // Public static method that returns the instance of the class, creating it if necessary
    public static Singleton getInstance() {
        if (singleInstance == null) {
            singleInstance = new Singleton();
        }
        return singleInstance;
    }

    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

