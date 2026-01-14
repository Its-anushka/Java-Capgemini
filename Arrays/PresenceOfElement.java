package Arrays;
import java.util.Scanner;
import java.util.Arrays;
public class PresenceOfElement {

    static boolean isPresent(int ele, int[] arr){
        for (int i = 0; i < arr.length ; i++){
            if (arr[i] == ele) return true;
        }
        return false;
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

        System.out.println("Enter element to be searched: ");
        int ele = sc.nextInt();
        System.out.println(isPresent(ele, arr));

    }
}
