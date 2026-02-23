package entity;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
	
	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerId;
	
	@Column(name = "CUSTOMER_NAME", length = 20)
	private String name;
	private String email;
	private String phone;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<>();
	
	public Long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public String getDetails() {
		return "Id: " + customerId + " Name: " +
	name + " Email: " + email + " Phone: " + phone;
		}
}
