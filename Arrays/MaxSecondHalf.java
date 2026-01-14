package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSecondHalf {

    public static int maxSecondHalf(int arr[]){
        int max = arr[arr.length/2];
        for (int i = arr.length/2 + 1; i < arr.length ; i += 1){
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
        System.out.println("Max element on an even index: " + maxSecondHalf(arr));
    }
}
