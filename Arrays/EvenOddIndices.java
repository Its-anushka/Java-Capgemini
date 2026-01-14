package Arrays;
import java.util.Scanner;
import java.util.Arrays;

public class EvenOddIndices {

    //print even indices
    public static void evenIndex(int[] arr){
        for (int i = 0; i < arr.length ; i++){
            if (i % 2 == 0) System.out.println(arr[i]);
        }
    }

    //print odd indices

    public static void oddIndex(int[] arr){
        for (int i = 0; i < arr.length ; i++){
            if (i % 2 != 0) System.out.println(arr[i]);
        }
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("Enter the elements");
        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Even indexed elements :-");
        evenIndex(arr);
        System.out.println("Odd indexed elements :-");
        oddIndex(arr);
    }
}
