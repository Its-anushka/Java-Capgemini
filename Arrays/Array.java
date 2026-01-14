package Arrays;
import java.util.Scanner;
import java.util.Arrays;
public class Array {

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

    //sum of all given elements in an array

    public static int sumArray(int arr[]){
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) sum += arr[i];

        return sum;
    }

    //average of elements in an array

    public static int averageArray(int arr[]){
        return sumArray(arr) / arr.length;
    }

    //sum of even indices

    public static int evenIndexSum(int arr[]){
        int sum = 0;
        for (int i = 0; i < arr.length ; i++){
            if (i % 2 == 0) sum += arr[i];
        }
        return sum;
    }

    //sum of odd indices

    public static int oddIndexSum(int arr[]){
        int sum = 0;
        for (int i = 0; i < arr.length ; i++){
            if (i % 2 != 0) sum += arr[i];
        }
        return sum;
    }

    //print first half of the array

    public static void firstHalfArray(int arr[]){
        for (int i = 0 ; i <= arr.length/2 ; i++) System.out.println(arr[i]);
    }

    //print first half of the array

    public static void SecondHalfArray(int arr[]){
        for (int i = arr.length/2 ; i <= arr.length ; i++) System.out.println(arr[i]);
    }
    //average of even indices

    public static int avgEvenIndexSum(int arr[]){
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length ; i++){
            if (i % 2 == 0) {
                sum += arr[i];
                count ++;
            }
        }
        return sum / count;
    }

    //average of odd indices

    public static int avgOddIndexSum(int arr[]){
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length ; i++){
            if (i % 2 != 0) {
                sum += arr[i];
                count ++;
            }
        }
        return sum / count;
    }

    //Average of first half of the array
    public static int avgFirstHalfArray(int arr[]){
        int sum = 0;
        for (int i = 0 ; i < arr.length/2 ; i++) {
            sum += i;
        }
        return sum / (arr.length/2);
    }

    //Average of second half of the array
    public static int avgSecondHalfArray(int arr[]){
        int sum = 0;
        for (int i = arr.length/2 ; i <= arr.length ; i++) {
            sum += i;
        }
        return sum / (arr.length - (arr.length/2));
    }




    static void main() {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i = 0; i < 5 ; i++){
            System.out.println("Enter element " + (i+1) + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
    }
}
