package Lambda;

public class LambdaOneParameter {
    public static void main(String[] args){
        Printer p = msg -> System.out.println("The message is: " + msg);

        p.print("That's a lady");
    }
}
