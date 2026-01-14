package Arrays;
import java.util.Scanner;
import java.util.Arrays;
public class MinMaxElement {

    //Find the max element of the array
    public static int maxElement(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length ; i++){
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    //Find the max element of the array
    public static int minElement(int[] arr){
        int min = arr[0];
        for(int i = 1; i < arr.length ; i++){
            if (arr[i] < min) min = arr[i];
        }
        return min;
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
        System.out.println("Minimum element: " + minElement(arr));
        System.out.println("Maximum element: " + maxElement(arr));

    }

}
