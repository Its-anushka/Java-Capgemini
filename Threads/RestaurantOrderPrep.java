package Threads;

public class RestaurantOrderPrep {
    public static void main(String[] args) throws InterruptedException {

        OrderSystem orderSystem = new OrderSystem();

        for (int i = 1; i <= 5; i++) {

            Thread chef = new Thread(new ChefThread(i));
            Thread plating = new Thread(new PlatingThread(i, chef));
            Thread server = new Thread(new ServerThread(i, orderSystem, plating));

            chef.start();
            plating.start();
            server.start();

            server.join();
        }

        System.out.println("\nAll orders completed: " + orderSystem.getCompletedOrders());
    }
}

class OrderSystem{
    private int completedOrders;

    public synchronized void incrementCompleted() {
        completedOrders++;
    }

    public int getCompletedOrders(){
        return this.completedOrders;
    }
}

class ChefThread implements Runnable{
    private int orderId;

    public ChefThread(int orderId) {
        this.orderId = orderId;
    }

    public void run(){
        try {
            System.out.println("Order " + orderId + ": Chef is cooking...");
            Thread.sleep(500);
            System.out.println("Order " + orderId + ": Chef finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PlatingThread implements Runnable{
    private int orderId;
    Thread chefThread;

    public PlatingThread(int orderId, Thread chefThread) {
        this.orderId = orderId;
        this.chefThread = chefThread;
    }

    public void run() {
        try {
            chefThread.join(); // wait for cooking
            System.out.println("Order " + orderId + ": Plating...");
            Thread.sleep(400);
            System.out.println("Order " + orderId + ": Plating complete.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread implements Runnable{
    private int orderId;
    Thread platingThread;
    private OrderSystem orderSystem;

    public ServerThread(int orderId, OrderSystem orderSystem, Thread platingThread) {
        this.orderId = orderId;
        this.orderSystem = orderSystem;
        this.platingThread = platingThread;
    }

    public void run(){
        try {
            platingThread.join(); // wait for plating
            System.out.println("Order " + orderId + ": Server delivering...");
            Thread.sleep(350);
            System.out.println("Order " + orderId + ": Delivered!\n");
            orderSystem.incrementCompleted();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
