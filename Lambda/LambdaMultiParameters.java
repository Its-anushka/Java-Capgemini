package Lambda;
import java.util.Scanner;
public class LambdaMultiParameters {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Adder sum = (a, b) -> a + b;
        int x = sc.nextInt();
        int y = sc.nextInt();
        int s = sum.add(x, y);
        System.out.println(x + " + " + y + " = "+s);
    }
}
