package services;

import dao.FooditemDao;
import dao.OrderDao;
import entities.FoodItem;
import entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private FooditemDao fooditemDao;

    @Autowired
    private OrderDao orderDao;

    public long placeOrder(List<Long> foodItems, String customerName){
        Order order = new Order();
        order.setCustomerName(customerName);
        List<FoodItem> items = new ArrayList<>();
        double totalAmount = 0;
        for(long id : foodItems){
            FoodItem food = fooditemDao.findById(id);
            items.add(food);
            totalAmount += food.getPrice();
        }

        order.setTotalAmount(totalAmount);
        order.setFoodItems(items);
        order.setOrderDate(new Date());

        orderDao.save(order);
        return order.getId();
    }

    public void calculateTotal(long orderId){
        double amount = orderDao.findById(orderId).getTotalAmount();
        System.out.println("The total amount is: " + amount);
    }
}
