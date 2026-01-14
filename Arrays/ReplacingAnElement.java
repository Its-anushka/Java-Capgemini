package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReplacingAnElement {

    public static void replace(int ele, int newEle, int[] arr){

        for(int i = 0 ; i < arr.length ; i++){
            if (arr[i] == ele) {
                arr[i] = newEle;
            }
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

        System.out.println("Enter element to be replaced: ");
        int ele = sc.nextInt();
        System.out.println("Enter new element: ");
        int newEle = sc.nextInt();replace(ele, newEle, arr);

        System.out.println(Arrays.toString(arr));
    }
}
