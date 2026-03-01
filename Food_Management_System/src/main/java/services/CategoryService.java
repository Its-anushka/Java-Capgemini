package services;

import dao.CategoryDao;
import entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public void addCategory(String name, String description){
        Category category = new Category();
        category.setCategoryName(name);
        category.setDescription(description);
        System.out.println("Category added with id: " + categoryDao.addCategoryToDb(category));
    }

    public void viewCategories(){
        System.out.println(categoryDao.findAll().toString());
    }

    public void deleteCategories(long id){
        categoryDao.delete(id);
        System.out.println("Category removed successfully");
    }
    public void findCategoryById(long id){
        System.out.println(categoryDao.find(id).toString());
    }
}
