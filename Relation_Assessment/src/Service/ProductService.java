package Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Product;

public class ProductService {
	private EntityManager em;
	private EntityTransaction tx;
	
	
	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}


	public void addProduct(String name, double price) {
		try {
			tx = em.getTransaction();
			tx.begin();
			Product p = new Product();
			p.setPrice(price);
			p.setProductName(name);
			em.persist(p);
			tx.commit();
			em.close();
		}
		
		catch(Exception e) {
			 if (tx.isActive()) {
		            tx.rollback();
		        }

		        e.printStackTrace();
		}
	}
}
