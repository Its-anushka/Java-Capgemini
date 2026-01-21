package Threads;

public class Threading{
    public static void main(String[] args){
        TaskWorker tw = new TaskWorker();
        Thread t1 = new Thread(tw);
        Thread t2 = new Thread(tw);

        t1.start();
        t2.start();
    }
}
class TaskWorker implements Runnable {
    public void run(){
        try{
            for(int i = 1; i <= 5 ; i++){
                System.out.println(i);
                Thread.sleep(500);
            }
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}