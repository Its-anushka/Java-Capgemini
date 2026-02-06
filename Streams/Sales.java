package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Sales {
    String saleId;
    String employeeName;
    String productCategory;
    int amount;

    public Sales(String saleId, String employeeName, String productCategory, int amount) {
        this.saleId = saleId;
        this.employeeName = employeeName;
        this.productCategory = productCategory;
        this.amount = amount;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return saleId + " - " + employeeName + " - " + productCategory + " - Rs." + amount;
    }
}

class SalesSolution{
    public static void main(String[] args){
        ArrayList<Sales> arr = new ArrayList<>();
        arr.add(new Sales("S01", "Amit", "Electronics", 12000));
        arr.add(new Sales("S02", "Neha", "Groceries", 4500));
        arr.add(new Sales("S03", "Rohit", "Furniture", 8200));
        arr.add(new Sales("S04", "Sneha", "Electronics", 5600));
        arr.add(new Sales("S05", "Amit", "Furniture", 3000));
        arr.add(new Sales("S06", "Neha", "Electronics", 9800));
        arr.add(new Sales("S07", "Rohit", "Groceries", 2300));
        arr.add(new Sales("S08", "Sneha", "Groceries", 12000));
        arr.add(new Sales("S09", "Amit", "Electronics", 4000));
        arr.add(new Sales("S10", "Rohit", "Furniture", 15000));

        System.out.println("--- Sales Greater Than Rs.5000 ---");
        arr.stream().filter(e -> e.amount > 5000).forEach(System.out::println);

        System.out.println("\n--- Total Sales Amount by Category ---");
        Map<String,Integer> map = arr.stream().collect(
                Collectors.groupingBy(
                        Sales :: getProductCategory,
                        Collectors.summingInt(Sales :: getAmount)));
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> System.out.println(
                e.getKey() + " - Rs." + e.getValue()
        ));

        System.out.println("\n--- Employee With Highest Total Sales ---");
        Map<String, Integer> empMap = arr.stream().
                collect(
                        Collectors.groupingBy(
                                Sales :: getEmployeeName, Collectors.summingInt(Sales :: getAmount)));

        empMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e ->
                        System.out.println(e.getKey() + " - Rs." + e.getValue()));

        System.out.println("\n--- Sales Sorted by Amount (Descending) ---");
        arr.stream().sorted(Comparator.comparing(Sales :: getAmount).reversed()).forEach(System.out::println);

        System.out.println("\n--- Mapped Strings ---");
        arr.stream().forEach(s -> System.out.println(s.getEmployeeName() + " sold items worth Rs." +s.getAmount() + " in " + s.getProductCategory()));







    }
}
