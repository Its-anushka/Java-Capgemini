package com.capg.assessment.entity;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name = "BANK_DATABASE")
public class Bank {

    @Id
    @Column(name = "ACCOUNT_NUMBER")
    private int accountNumber;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "MOBILE_NUMBER")
    private long mobileNumber;

    @Column(name = "BALANCE")
    private double balance;
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public long getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }


}
