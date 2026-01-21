package Threads;

public class Order {
    private int orderId;
    private String customerName;
    private double amount;

    public Order(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }
}

class OrderProcessor implements Runnable{
    private Order order;

    public OrderProcessor(Order order) {
        this.order = order;
    }

    @Override
    public void run(){
        this.validateOrder();
        this.processPayment();
        this.shipOrder();
    }

    private void validateOrder(){
        System.out.println("Validating order "+ this.order.getOrderId());
    }

    private void processPayment(){
        System.out.println("Processing payment for order " + this.order.getOrderId());
    }

    private void shipOrder(){
        System.out.println("Shipping order " + this.order.getOrderId());
    }

    public static void main(String[] args) {
        OrderProcessor op1 = new OrderProcessor(new Order(101, "Alice", 2500));
        OrderProcessor op2 = new OrderProcessor(new Order(102, "Bob", 1500));
        OrderProcessor op3 = new OrderProcessor(new Order(103, "Charlie", 3200));
        Thread t1 = new Thread(op1);
        Thread t2 = new Thread(op2);
        Thread t3 = new Thread(op3);

        try{
            t1.start();
            Thread.sleep(1000);
            t2.start();
            Thread.sleep(1000);
            t3.start();
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}

