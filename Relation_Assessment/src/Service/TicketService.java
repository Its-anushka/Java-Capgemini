package Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Order;
import entity.SupportTicket;

public class TicketService {
	private EntityManager em;
	private EntityTransaction tx;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void raiseTicket(Long orderId, String issueDescription) {
		 	try {
		 		tx = em.getTransaction();
		 		tx.begin();
		 		Order o = em.find(Order.class, orderId);
		 		
		 		if (o == null) {
		 			System.out.println("Order not found");
		 			return;
		 		}
		 		
		 		SupportTicket s = new SupportTicket();
		 		s.setOrder(o);
		 		s.setIssueDescription(issueDescription);
		 		
		 		em.persist(s);
		 		
		 	}
		 	
		 	catch(Exception e) {
				 if (tx.isActive()) {
			            tx.rollback();
			        }

			        e.printStackTrace();
			}
	}
}
