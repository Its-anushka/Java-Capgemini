package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class ProductivityLog {
    String logId;
    String employeeName;
    String taskType;
    double hoursSpent;

    public ProductivityLog(String logId,  String employeeName, String taskType, double hoursSpent) {
        this.logId = logId;
        this.taskType = taskType;
        this.employeeName = employeeName;
        this.hoursSpent = hoursSpent;
    }

    @Override
    public String toString() {
        return logId + " - " + employeeName + " - " + taskType + " - " + hoursSpent ;
    }

    public String getTaskType() {
        return taskType;
    }

    public double getHoursSpent(){
        return hoursSpent;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}

class SolutionEmp{
    public static void main(String[] args){
        ArrayList<ProductivityLog> arr = new ArrayList<>();
        arr.add(new ProductivityLog("L01", "Amit", "Coding", 6.5));
        arr.add(new ProductivityLog("L02", "Rohit", "Testing", 3.0));
        arr.add(new ProductivityLog("L03", "Neha", "Design", 7.0));
        arr.add(new ProductivityLog("L04", "Amit", "Coding", 4.0));
        arr.add(new ProductivityLog("L05", "Rohit", "Testing", 6.0));
        arr.add(new ProductivityLog("L06", "Sneha", "Design", 2.5));
        arr.add(new ProductivityLog("L07", "Neha", "Coding", 5.5));
        arr.add(new ProductivityLog("L08", "Amit", "Testing", 2.0));
        arr.add(new ProductivityLog("L09", "Sneha", "Coding", 3.0));
        arr.add(new ProductivityLog("L10", "Rohit", "Design", 8.0));

        System.out.println("--- Logs with More Than 5 Hours ---");
        arr.stream().filter(e -> e.hoursSpent > 5).forEach(System.out::println);

        System.out.println("\n--- Total Hours per Task Type ---");
        Map<String,Double> map = arr.stream().collect(
                Collectors.groupingBy(
                        ProductivityLog :: getTaskType,
                        Collectors.summingDouble(ProductivityLog :: getHoursSpent)));

        map.forEach((task, hours) -> System.out.println(task + " - " + hours + " hours"));

        System.out.println("\n--- Employee with Highest Total Hours ---");
        Map<String,Double>  maxHours = arr.stream().collect(
                Collectors.groupingBy(ProductivityLog :: getEmployeeName,
                Collectors.summingDouble(ProductivityLog :: getHoursSpent)));

        maxHours.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e ->
                        System.out.println(e.getKey() + " - " + e.getValue() + " hours"));


        System.out.println("\n--- Sorted Logs by Hours (Descending) ---");
        arr.stream().sorted(Comparator.comparing(ProductivityLog :: getHoursSpent).reversed()).forEach(System.out::println);

        System.out.println("\n--- Mapped Formatted Strings ---");
        arr.stream().forEach(p -> System.out.println(p.employeeName + " spent " +p.hoursSpent + " hours on " + p.taskType));

    }
}
