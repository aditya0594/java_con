package Java_Program;

public class Largest_Among_three_numbers_using {



    public static void main(String[] args) {
        int N1 = 5;
        int N2 = 3;
        int N3 = 1;
//
//        // Using the If...else
//        if(N1 >= N2 && N1 >= N3){
//            System.out.println(N1 + " is the largest number");
//        }
//        else if (N2>=N1 && N2>=N3){
//            System.out.println(N2 + "is the largest number");
//        }
//        else{
//            System.out.println(N3 + "is the largest number");
       // }


        // Using the Nested if else
        if(N1>= N2) {
            if (N1 >= N3) {
                System.out.println(N1 + "is the largest");
            } else {
                System.out.println(N3 + "is the largest");
            }
        }
            else{
                if(N2>=N3){
                    System.out.println(N2 + "is the largest");
                }
                else{
                    System.out.println(N3+ "is the largest");
            }
        }
    }


}
