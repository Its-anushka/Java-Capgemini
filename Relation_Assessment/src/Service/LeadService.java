package Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Customer;
import entity.Lead;
import entity.SalesEmployee;

public class LeadService {
	private EntityManager em;
	private EntityTransaction tx;
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void createLead(String name, String source, String contactInfo) {
		try {
			tx = em.getTransaction();
			tx.begin();
			Lead lead = new Lead();
			lead.setName(name);
			lead.setSource(source);
			lead.setContact(contactInfo);
			lead.setStatus("NEW");
			em.persist(lead);
			tx.commit();
			
		}
		
		catch(Exception e) {
			 if (tx.isActive()) {
		            tx.rollback();
		        }

		        e.printStackTrace();
		}
	}
	
	public void assignLeadToEmployee(Long leadId, Long employeeId) {
		try {
			tx = em.getTransaction();
			tx.begin();
			Lead lead = em.find(Lead.class, leadId);
			SalesEmployee employee = em.find(SalesEmployee.class, employeeId);
			if (lead == null || employee == null) {
				System.out.println("Lead or employee not found");
				return;
			}
			
			lead.setEmployee(employee);
			employee.getLeads().add(lead);
			
			tx.commit();
		}
		
		catch(Exception e) {
			 if (tx.isActive()) {
		            tx.rollback();
		        }

		        e.printStackTrace();
		}
	}
	
	public void convertLeadToCustomer(Long leadId) {
		try {
			tx = em.getTransaction();
			tx.begin();
			Lead lead = em.find(Lead.class, leadId);
			
			if (lead == null) {
				System.out.println("Lead not found");
				return;
			}
			Customer c = new Customer();
			c.setName(lead.getName());
			c.setPhone(lead.getContact());
			c.setEmail(lead.getEmail());
			em.persist(c);
			
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
