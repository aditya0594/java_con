package polymorphism;

public class Example_Child_animal extends Example_Parent_animal{
    @Override
    public void sound(){
        System.out.println("Cat make meow");
    }
    public void dog(){
        System.out.println("Dog make barks");
    }

    public static void main(String[] args) {
        Example_Parent_animal my_dog = new Example_Child_animal();
        my_dog.sound();
    }

}
