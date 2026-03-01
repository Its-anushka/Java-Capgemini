package dao;

import entities.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryDao {

    @PersistenceContext
    private EntityManager em;

    public long addCategoryToDb(Category category){
        em.persist(category);
        return category.getId();
    }

    public List<Category> findAll() {
        return em.createQuery("from Category", Category.class).getResultList();
    }

    public Category find(long id){
        return em.find(Category.class, id);
    }

    public void delete(long id){
        Category c = em.find(Category.class, id);
        em.remove(c);
    }



}
