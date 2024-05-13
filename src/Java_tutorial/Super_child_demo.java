public class Super_child_demo extends Super_parent_demo {


    // Super keyword refer to the instantence variable of the parent class when the child and parent class having same name varible.
    // So to refer the variable from the parent class we use the "Super" variable.
    // To differentiation between the parent class and child class varible you could use the "Super" Keyword
     String  name = "Pawar";
    public void getString(){

        System.out.println(name);
        System.out.println(super.name);

    }

    public static void main(String[] args) {
        Super_child_demo obj = new Super_child_demo();
        obj.getString();
    }

}
