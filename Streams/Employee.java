package Streams;
import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double rating;

    public Employee(int id, String name, String department, double rating) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getRating() {
        return rating;
    }
}

class PerformanceAnalysisService{

    Map<String, Double> calculateAverageRatingPerDepartment(List<Employee> employees){
        Map<String, Double> avgRating = employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment, Collectors.averagingDouble(Employee::getRating)));

        return avgRating;
    }

    List<String> findTopPerformers(List<Employee> employees){
        List<String> top = employees.stream().filter(e -> e.getRating() > 4).map(Employee :: getName).collect(Collectors.toList());
        return top;
    }
}

class EmpSolution{
    public static void main(String[] args){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John", "IT", 4.5));
        employees.add(new Employee(2, "Sara", "HR", 3.8));
        employees.add(new Employee(3, "Mike", "IT", 4.2));
        employees.add(new Employee(4, "Emma", "Finance", 4.9));
        employees.add(new Employee(5, "Tom", "HR", 4.1));

        PerformanceAnalysisService pas = new PerformanceAnalysisService();

        System.out.println("Average Rating per Department: " + pas.calculateAverageRatingPerDepartment(employees).toString());
        System.out.println("Top Performers: " + pas.findTopPerformers(employees).toString());


    }
}
