package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {
    private int orderId;
    private String customerName;
    private double amount;
    private String status;

    public Order(int orderId, String customerName, double amount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}

class OrderAnalyticsService{
    double calculateTotalRevenue(List<Order> orders){
       return orders.stream().filter(o -> o.getStatus().equals("COMPLETED")).map(o -> o.getAmount()).reduce(0.0, (a, b) -> a+b);
    }

    List<String> findPremiumCustomers(List<Order> orders){
        Map<String, Double> cus = orders.stream().filter(o -> o.getStatus().equals("COMPLETED")).collect(Collectors.groupingBy(Order::getCustomerName, Collectors.summingDouble(Order :: getAmount)));
        return cus.entrySet().stream().filter(o -> o.getValue() > 2000).map(o -> o.getKey()).toList();
    }
}

class OSolution{
    public static void main(String[] args){
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(101, "Alice", 1200, "COMPLETED"));
        orders.add(new Order(102, "Bob", 700, "CANCELLED"));
        orders.add(new Order(103, "Alice", 900, "COMPLETED"));
        orders.add(new Order(104, "David", 2500, "COMPLETED"));
        orders.add(new Order(105, "Bob", 1500, "COMPLETED"));

        OrderAnalyticsService oas = new OrderAnalyticsService();
        System.out.println("Total Revenue: " + oas.calculateTotalRevenue(orders));
        System.out.println("Premium Customers: " + oas.findPremiumCustomers(orders).toString());
    }
}
