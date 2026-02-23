package Service;

import javax.persistence.EntityManager;

public class ReportService {
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}



	public void setEm(EntityManager em) {
		this.em = em;
	}



	public void getEmployeePerformance(Long employeeId) {
		 Long count = em.createQuery(
		            "SELECT COUNT(l) FROM Lead l WHERE l.employee.id = :id",
		            Long.class)
		            .setParameter("id", employeeId)
		            .getSingleResult();

		        System.out.println("Total Leads Handled: " + count);
		        em.close();
	}
}
