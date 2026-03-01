package app;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CategoryService;
import services.FoodItemService;
import services.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodManagementApplication {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CategoryService categoryService = context.getBean(CategoryService.class);
        OrderService orderService = context.getBean(OrderService.class);
        FoodItemService foodService = context.getBean(FoodItemService.class);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Category");
            System.out.println("2. Add Food Item");
            System.out.println("3. View Food by Category");
            System.out.println("4. Place Order");
            System.out.println("5. Calculate Bill");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter category name: ");
                    String cName = sc.nextLine();
                    System.out.println("Enter description: ");
                    String des = sc.nextLine();
                    categoryService.addCategory(cName, des);
                    break;

                case 2:
                    System.out.println("Enter category id: ");
                    long cId = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Enter item price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter item name: ");
                    String iName = sc.nextLine();

                    foodService.addFoodItem(cId, iName, price);
                    break;

                case 3:
                    System.out.println("Enter category id: ");
                    long cid = sc.nextLong();
                    sc.nextLine();
                    foodService.getItemsByCategory(cid);
                    break;

                case 4:
                    List<Long> items = new ArrayList<>();
                    while (true) {
                        System.out.print("Enter item id (0 to stop): ");
                        long id = sc.nextLong();
                        if (id == 0) {
                            sc.nextLine();
                            break;
                        }
                        items.add(id);

                    }
                    System.out.println("Enter customer name: ");
                    String name = sc.nextLine();

                    System.out.println("Order placed with id: " + orderService.placeOrder(items, name));
                    break;

                case 5:
                    System.out.println("Enter order id: ");
                    long oid = sc.nextLong();
                    sc.nextLine();
                    orderService.calculateTotal(oid);
                    break;

                case 6:
                    context.close();
                    System.exit(0);
            }
        }
    }
}
