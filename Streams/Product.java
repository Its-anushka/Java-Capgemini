package Streams;

import java.util.ArrayList;

class Product{
    private String name;
    private int price;
    private String category;

    public Product(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + price + " " + category;
    }
}

class Solution{

    public static void main(String[] args){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Milk", "Dairy", 800));
        products.add(new Product("Butter", "Dairy", 1200));
        products.add(new Product("Tomato", "Groceries", 1600));
        products.add(new Product("Onion", "Groceries", 800));
        products.add(new Product("Paneer", "Dairy", 2000));

        products.forEach(p -> {
            p.setName(p.getName().toUpperCase());
            System.out.println(p.getName() + " " + p.getPrice() + " " + p.getCategory());
        });
        System.out.println("--------------------");
        products.stream().filter(p -> p.getPrice()>1000).forEach(System.out::println);

    }
}

