package Lambda;

public class LambdaZeroParameter {

    public static void main(String[] args){
        //Traditional anonymous class (long)
        Greeting f = new Greeting() {public void sayHello() {
           System.out.println("Hello!");}};

        Greeting g = () -> System.out.println("Hello, it's Anushka");
        g.sayHello();
    }
}
