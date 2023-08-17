package Collection;

public class Sum_of_element_in_Array {
    public static void main(String[] args) {

        int a[] = {2, 2, 2};
        int sum = 0;
    /*for(int i=0; i<=a.length-1;i++){
       sum = sum+a[i];
    }
        System.out.println(sum);
    }*/
        // enhanced forloop
        for (int value : a) {
            sum = sum + value;
        }
        System.out.println(sum);
    }

}
