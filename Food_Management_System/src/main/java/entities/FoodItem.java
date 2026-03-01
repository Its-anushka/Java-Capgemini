package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class FoodItem {

    @Id
    @Column(name = "FOOD_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String itemName;
    private double price;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToMany(mappedBy = "foodItems")
    private List<Order> orders;

    public FoodItem(){

    }

    public FoodItem(long id, String itemName, double price, Category category) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", price=" + price
                ;
    }
}
