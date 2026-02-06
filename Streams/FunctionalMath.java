package Streams;
@FunctionalInterface
interface Calculator{
    void calculate(int a, int b);
}

public class FunctionalMath {
    public static void main(String[] args) {
        int a = 60, b = 30;

        Calculator sum = (x, y) -> System.out.println("Sum of " + x + " and " + y + " is " + (x+y));
        Calculator sub = (x, y) -> System.out.println("Difference between " +x + " and " + y + " is " + (x - y));
        Calculator prod = (x, y) -> System.out.println("Product1 of "+x+" and "+y+" is " + x*y);
        Calculator div = (x, y) -> System.out.println("Quotient of "+x+" and "+y+" is " + x/y);

        sum.calculate(a,b);
        sub.calculate(a,b);
        prod.calculate(a, b);
        div.calculate(a,b);
    }
}
