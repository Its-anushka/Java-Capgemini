package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Order {
	
	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long orderId;
	
	@Column(name = "ORDER_DATE")
	private LocalDate orderDate;
	
	double totalAmount;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
	
	@ManyToMany
	@JoinTable(
	    name = "order_products",
	    joinColumns = @JoinColumn(name = "order_id"),
	    inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	private List<Product> products = new ArrayList<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private SupportTicket ticket;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public SupportTicket getTicket() {
		return ticket;
	}

	public void setTicket(SupportTicket ticket) {
		this.ticket = ticket;
	}
	
	
}
