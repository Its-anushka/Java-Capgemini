package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Service.CustomerSerivce;
import Service.LeadService;
import Service.ProductService;
import Service.OrderService;
import Service.TicketService;
import Service.ReportService;

import entity.Address;

public class CRMApplication {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("crmPU");

        EntityManager em = emf.createEntityManager();

        CustomerSerivce customerService = new CustomerSerivce();
        LeadService leadService = new LeadService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        TicketService ticketService = new TicketService();
        ReportService reportService = new ReportService();

        customerService.setEm(em);
        leadService.setEm(em);
        productService.setEm(em);
        orderService.setEm(em);
        ticketService.setEm(em);
        reportService.setEm(em);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== CRM SALES MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address to Customer");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead to Employee");
            System.out.println("5. Convert Lead to Customer");
            System.out.println("6. Add Product");
            System.out.println("7. Place Order");
            System.out.println("8. Raise Support Ticket");
            System.out.println("9. View Employee Performance");
            System.out.println("10. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String cname = sc.next();

                    System.out.print("Enter email: ");
                    String email = sc.next();

                    System.out.print("Enter phone: ");
                    String phone = sc.next();

                    customerService.registerCustomer(cname, email, phone);
                    System.out.println("Customer registered successfully");
                
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    Long custId = sc.nextLong();

                    Address address = new Address();
                    System.out.print("Enter city: ");
                    address.setCity(sc.next());

                    System.out.print("Enter state: ");
                    address.setState(sc.next());

                    System.out.print("Enter pincode: ");
                    address.setPincode(sc.next());

                    customerService.addAdddressToCustomer(custId, address);
                    System.out.println("Address added successfully");
                    break;

                case 3:
                    System.out.print("Enter lead name: ");
                    String lname = sc.next();

                    System.out.print("Enter source: ");
                    String source = sc.next();
                    
                    System.out.print("Enter email: ");
                    String e_mail = sc.next();

                    leadService.createLead(lname, source, e_mail);
                    System.out.println("Lead created successfully");
                    break;

                case 4:
                    System.out.print("Enter Lead ID: ");
                    Long leadId = sc.nextLong();

                    System.out.print("Enter Employee ID: ");
                    Long empId = sc.nextLong();

                    leadService.assignLeadToEmployee(leadId, empId);
                    System.out.println("Lead assigned to employee");
                    break;

                case 5:
                    System.out.print("Enter Lead ID: ");
                    Long convertLeadId = sc.nextLong();

                    leadService.convertLeadToCustomer(convertLeadId);
                    System.out.println("Lead converted to customer");
                    break;

                case 6:
                    System.out.print("Enter product name: ");
                    String pname = sc.next();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    productService.addProduct(pname, price);
                    System.out.println("Product added successfully");
                    break;

                case 7:
                    System.out.print("Enter Customer ID: ");
                    Long orderCustId = sc.nextLong();

                    System.out.print("Enter number of products: ");
                    int count = sc.nextInt();

                    List<Long> productIds = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter Product ID: ");
                        productIds.add(sc.nextLong());
                    }

                    orderService.placeOrder(orderCustId, productIds);
                    System.out.println("Order placed successfully");
                    break;

                case 8:
                    System.out.print("Enter Order ID: ");
                    Long orderId = sc.nextLong();

                    System.out.print("Enter issue description: ");
                    String issue = sc.next();

                    ticketService.raiseTicket(orderId, issue);
                    System.out.println("Support ticket raised");
                    break;

                case 9:
                    System.out.print("Enter Employee ID: ");
                    Long reportEmpId = sc.nextLong();

                    reportService.getEmployeePerformance(reportEmpId);
                    break;

                case 10:
                    System.out.println("Exiting application...");
                    sc.close();
                    em.close();
                    emf.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}