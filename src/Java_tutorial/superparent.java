public class superparent {

        int a = 5; // This is globle variable // instance variable

        public void getData(){
            int a = 3; // the scope of this local variable inside , this method only.
            System.out.println(a);
            // "This" refers to the current object -- object scope lies in class level.
            System.out.println(this.a);

            int b =a+this.a;
            System.out.println(b);
        }
        public static void main(String[] args){
            superparent obj = new superparent();
            obj.getData();

        }

    }
