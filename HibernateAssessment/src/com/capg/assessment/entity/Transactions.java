package com.capg.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "TRANSACTIONS")
public class Transactions {
	@Id
	@Column(name = "ACCOUNT_NUMBER")
	private int account_number;
	@Column(name = "TRANSACTION")
	private String transaction;
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	
	
}
