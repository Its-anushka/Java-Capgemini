package EmployeeManagementSystem;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static Scanner sc = new Scanner(System.in);
    private Employee[] employees;
    private int count;
    private int hr;
    private int it;

    private boolean alreadyExists(int id){
        for (int i = 0; i < employees.length; i++){
            if (employees[i] != null && employees[i].getId() == id) return true;
        }
        return false;
    }

    private void addEmployee() {
        if (count < employees.length) {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            if (count == 0 || alreadyExists(id) == false)
            {
            System.out.print("Enter Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Enter Department: ");
            String dep = sc.next();
            if(dep.equals("IT")) it++;
            else hr++;
            System.out.print("Enter Salary: ");
            double sal = sc.nextDouble();
            Employee emp = new Employee(id, name, dep, sal);
            employees[count++] = emp;
            System.out.println("Employee added successfully!");
            }
            else if (alreadyExists(id) == true) {
                System.out.println("Employee with the given ID already exists! Cannot add duplicate.");
            }
        }
    }

    private void displayEmployees(){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null)
            System.out.println(employees[i].toString());
        }
    }

    private void updateEmployee(){
        System.out.print("Enter id: ");
        int search = sc.nextInt();
        System.out.print("What do you want to update?\n" +
                "1 -> Name\n" +
                "2 -> Department\n" +
                "3 -> salary\n" +
                "Enter your choice (1/2/3): ");
        int choice = sc.nextInt();

        Employee up = null;
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getId() == search){
                up = employees[i];
                break;
            }
        }

        switch(choice){
            case 1:
                System.out.print("Enter new name: ");
                sc.nextLine();
                String newName = sc.nextLine();
                up.setName(newName);
                break;
            case 2:
                System.out.print("Enter new department: ");
                sc.nextLine();
                String newDep = sc.nextLine();
                up.setDepartment(newDep);
                break;
            case 3:
                System.out.print("Enter new salary: ");
                sc.nextLine();
                double newSal = sc.nextDouble();
                up.setSalary(newSal);
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    private void searchEmployee(){
        System.out.print("Enter id: ");
        int search = sc.nextInt();

        for (int i = 0; i < employees.length ; i++){
            Employee e = employees[i];
            if (e.getId() == search){
                System.out.println(e.toString());
                return;
            }
        }
        System.out.println("ID not found");
    }

    public void deleteEmployee(){
        System.out.print("Enter id: ");
        int search = sc.nextInt();
        int idx = 0;

        for (int i = 0; i < employees.length ; i++){
            Employee e = employees[i];
            if (e.getId() == search) {
                idx = i;
                break;
            }
        }

        for(int i = idx ;  i < employees.length - 1 ; i++){
            employees[i] = employees[i+1];
        }
    }

    public void countByDepartment(){
        System.out.print("Enter department to count: ");
        String dep = sc.next();
        if (dep.equals("IT"))
            System.out.println("Number of employees in IT: " + it);
        else{
            System.out.println("Number of employees in HR: " + hr);
        }
    }

    public static void main(String[] args){
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Employee[] em = new Employee[10];
        ems.employees = em;
        System.out.println("Welcome to Employee Management System \n1 - Add Employee\n2 - Display All Employees\n3 - Update Employee\n4 - Delete Employee\n5 - Search Employee by ID\n6 - Count Employees by Department\n7 - Exit \n");
        int choice = 0;
        do {
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ems.addEmployee();
                    break;
                case 2:
                    ems.displayEmployees();
                    break;
                case 3:
                    ems.updateEmployee();
                    break;
                case 4:
                    ems.deleteEmployee();
                    break;
                case 5:
                    ems.searchEmployee();
                    break;
                case 6:
                    ems.countByDepartment();
                    break;
            }
        }while (choice != 7);

    }


}
