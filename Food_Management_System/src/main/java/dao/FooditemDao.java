package dao;

import entities.Category;
import entities.FoodItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FooditemDao {

    @PersistenceContext
    private EntityManager em;

    public void add(FoodItem food){
        em.persist(food);
    }

    public List<FoodItem> findByCategory(long categoryId){;
        Category c = em.find(Category.class, categoryId);
        return c.getItems();
    }

    public void remove(long itemId){
        FoodItem food = em.find(FoodItem.class, itemId);
        em.remove(food);
    }

    public FoodItem findById(long itemId){
        return em.find(FoodItem.class, itemId);
    }
}
