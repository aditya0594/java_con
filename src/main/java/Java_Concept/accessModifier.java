package Java_Concept;

public class accessModifier {

    public int i = 1;
    private int j =2;

     void abc(){  // default modifier : Access modifier anywhere only in the package
    }
    public void abc1(){  // public : variable/method as a public : You will have access across package that is anywhere
    }

    private void abc2(){  // Private : if marked variable/method as a private, you can not access outside the class

    }

    protected  void abc3(){  // protected variable/method is having access which is belonged to the same class and
                             //for the outside call we need to extends the class.

    }

    public static void main(String[] args) {

    }
}
