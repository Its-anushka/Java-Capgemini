package Lambda;

public class LambdaAnotherOne {
    public static void main(String[] args){
        Calculator multiply = (a, b) -> {
            System.out.println("Multiplying "+ a +" and "+ b + "......");
            return a*b;
        };

        System.out.println("....and the result is: " + multiply.calculate(19,19));
    }
}
