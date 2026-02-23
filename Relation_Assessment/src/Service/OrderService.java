package Service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Customer;
import entity.Order;
import entity.Product;

public class OrderService {
	private EntityManager em;
	private EntityTransaction tx;
	
	
	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}


	public void placeOrder(Long customerId, List<Long> productIds) {
		try {
			tx = em.getTransaction();
			tx.begin();
			Customer c = em.find(Customer.class, customerId);
			
			if(c == null) {
				System.out.println("Customer not found");
			}
			
			Order o = new Order();
			o.setCustomer(c);
			o.setOrderDate(LocalDate.now());
			
			double total = 0;
			for(long pid : productIds) {
				 Product p = em.find(Product.class, pid);
		            o.getProducts().add(p);
		            total += p.getPrice();
			}
			
			o.setTotalAmount(total);
			
			em.persist(o);
			tx.commit();
		}
		
		catch(Exception e) {
			 if (tx.isActive()) {
		            tx.rollback();
		        }

		        e.printStackTrace();
		}
	}
}
