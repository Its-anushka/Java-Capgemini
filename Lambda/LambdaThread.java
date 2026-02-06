package Lambda;

public class LambdaThread {
    public static void main(String[] args){
        Runnable task = () -> {
            for (int i = 1; i <=3 ; i++){
                System.out.println("Song " + i + " playing...");
            }
        };

        Thread t = new Thread(task);
        t.start();
    }
}


