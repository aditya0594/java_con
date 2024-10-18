package encapsulation;

public class EncapsulationClassOne {
    // Variables declared as private
    // These private variables can only be accessed by public methods of class
        private int age;
        private String Name;

    // getter method to access private variable
    public int getAge(){
       return age;
    }

    public String getName(){

        return Name;
    }
    public void setAge(int inputage){

        int age = inputage;
    }
    public void setName(String inputName){
        String Name = inputName;
    }
}
