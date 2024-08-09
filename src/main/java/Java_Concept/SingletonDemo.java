package Java_Concept;

public class SingletonDemo {
        public static void main(String[] args) {
            // Get the only instance of the Singleton class
            Singleton singleton = Singleton.getInstance();

            // Show a message
            singleton.showMessage();
        }
}
