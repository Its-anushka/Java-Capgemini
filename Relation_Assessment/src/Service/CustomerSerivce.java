package Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Address;
import entity.Customer;

public class CustomerSerivce {
	private EntityManager em;
	private EntityTransaction tx;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void registerCustomer(String name, String email, String phone) {
		
		try {
			
			tx = em.getTransaction();
			tx.begin();
			Customer customer = new Customer();
			customer.setName(name);
			customer.setEmail(email);
			customer.setPhone(phone);
			
			em.persist(customer);
			tx.commit();
		}
		catch(Exception e) {
			 if (tx.isActive()) {
		            tx.rollback();
		        }

		        e.printStackTrace();
		}
	}
	
	public void addAdddressToCustomer(Long customerId, Address address) {
		try {
			tx = em.getTransaction();
			tx.begin();
			Customer customer = em.find(Customer.class, customerId);
			
			if (customer == null) {
	            System.out.println("Customer not found!");
	            return;
	        }
			
			address.setCustomer(customer);
			customer.setAddress(address);
			em.persist(customer);
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
