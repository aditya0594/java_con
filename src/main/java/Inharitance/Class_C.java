package Inharitance;

public class Class_C extends Class_B{

    int age = 30;
    public void MethodClassC(){
        super.MethodClassB();
    }
    public void getdata(){
        super.getdata();
        System.out.println("I am in child class C get data ");
    }
    public static void main(String[] arg){
        Class_C obj = new Class_C();
        obj.MethodClassC();
        obj.getdata();
    }
}
