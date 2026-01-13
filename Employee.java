package EmployeeManagementSystem;

import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId(){
        return this.id;
    }

    public String getDepartment(){
        return this.department;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Details {Id: " + id +
                ", Name: " + name +
                ", Department: " + department +
                ", salary: " + salary + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;      // same reference
        if (obj == null) return false;     // null check
        if (!(obj instanceof Employee)) return false;

        Employee e = (Employee) obj;
        return this.id == e.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
