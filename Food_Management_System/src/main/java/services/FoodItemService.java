package services;

import dao.CategoryDao;
import dao.FooditemDao;
import entities.Category;
import entities.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FoodItemService {

    @Autowired
    private FooditemDao foodItemDao;

    @Autowired
    private CategoryDao categoryDao;

    public void addFoodItem(long categoryId, String name, double price){
        Category c = categoryDao.find(categoryId);
        FoodItem food = new FoodItem();
        food.setItemName(name);
        food.setPrice(price);
        food.setCategory(c);
        foodItemDao.add(food);
    }

    public void getItemsByCategory(long categoryId){
        List<FoodItem> foods = foodItemDao.findByCategory(categoryId);
        for(FoodItem food : foods){
            System.out.println(food.toString());
        }
    }

    public void removeFoodItems(long itemId){
        foodItemDao.remove(itemId);
        System.out.println("Item removed successfully");
    }
}
