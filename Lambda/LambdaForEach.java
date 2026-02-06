package Lambda;

public class LambdaForEach {

        public static void main(String[] args){
            String[] string = {"Lavender", "Indigo", "Lilac"};
            Runnable task = () -> {
                for(String s : string){
                    System.out.println("The colour...." + s);
                }
            };

            Thread t = new Thread(task);
            t.start();
        }

}
