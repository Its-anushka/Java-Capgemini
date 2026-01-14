package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxFirstHalf {
    public static int maxfirstHalf(int arr[]){
        int max = arr[0];
        for (int i = 0; i < arr.length/2 ; i += 1){
            if (arr[i] > max) max = arr[i];
        }
        return max;

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("Enter the elements");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Max element on an even index: " + maxfirstHalf(arr));
    }
}
