package Arrays;
import java.util.Scanner;
import java.util.Arrays;

public class SecondHighLowElement {

    public static int secondHighest(int[] arr){
        int max = arr[0];
        int secMax = 0;

        for(int i = 1; i < arr.length ; i++){
            if (arr[i] > max){
                secMax = max;
                max = arr[i];
            }
            else if(arr[i] < max && arr[i] > secMax){
                secMax = arr[i];
            }
        }
        return secMax;
    }

    public static int secondLowest(int[] arr){
        int min = arr[0];
        int secMin = arr[1];

        for(int i = 1; i < arr.length ; i++){
            if (arr[i] < min){
                secMin = min;
                min = arr[i];
            }

            else if (arr[i] > min && arr[i] <= secMin){
                secMin = arr[i];
            }
        }
        return secMin;
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
        System.out.print("Second highest element: ");
        System.out.println(secondHighest(arr));
        System.out.print("Second lowest element: ");
        System.out.println(secondLowest(arr));
    }
}
