package com.capg.assessment.Service;
import com.capg.assessment.entity.*;

import com.capg.assessment.DAO.BankDAO;
public class BankService {
	
	static BankDAO dao = new BankDAO();
	
	public static void createAccount(int accountNumber, String customerName, 
			long mob, double balance) {
		//fetching the bank account to check if the account with given number already exists
		Bank bankA = dao.getAccount(accountNumber);
		
		//if the account doesn't exist, creating new account
		if (bankA == null) {
			Bank bank = new Bank();
			bank.setAccountNumber(accountNumber);
			bank.setCustomerName(customerName);
			bank.setMobileNumber(mob);
			bank.setBalance(balance);
			dao.addAccount(bank);
			System.out.println("Account added!");
		}
		
		//if it exists, give warning
		else {
			System.out.println("Account number already exists!");
		}
	}
	
	public static void getAccountDet(int accountNumber) {
		//fetching bank account 
		Bank bankAcc = dao.getAccount(accountNumber);
		System.out.println(
				bankAcc.getAccountNumber() + " " +
			    bankAcc.getCustomerName() + " " + 
				bankAcc.getMobileNumber() + " " +
			    bankAcc.getBalance());
	}
	
	
	public static void showBalance(int accNumber) {
		System.out.println("Current account balance: " + 
	dao.getBalance(accNumber));
		
	}
	
	
	public static void depositMoney(int accNumber, double amount) {
		Bank bankAcc = dao.getAccount(accNumber);
		//if the given account exists...
		if (bankAcc != null) {
			bankAcc.setBalance(bankAcc.getBalance() + amount);
			dao.updateAccount(bankAcc);
			System.out.println("Money successfully deposited");
			//updating transactions table
			checkTransactions(accNumber, "Deposited amount " + amount);
		}
		else {
			System.out.println("Account not found!");
		}
	}
	
	public static void withdrawMoney(int accNumber, double amount) {
		Bank bankAcc = dao.getAccount(accNumber);
		//if the given account exists...
		if (bankAcc != null) {
			bankAcc.setBalance(bankAcc.getBalance() - amount);
			dao.updateAccount(bankAcc);
			System.out.println("Money successfully withdrawn!");
			
			//updating transactions table
			checkTransactions(accNumber, "Withdrew amount " + amount);
		}
		else {
			System.out.println("Account not found!");
		}
	}
	
	public static void fundTransfer(int senderNum, int recipientNum, double amount) {
		Bank sender = dao.getAccount(senderNum); //checking if these accounts are there in the database
		Bank recipient = dao.getAccount(recipientNum);
		
		//if both are present
		if (sender != null && recipient != null) {
			sender.setBalance(sender.getBalance() - amount);
			recipient.setBalance(recipient.getBalance() + amount);
			dao.updateAccount(recipient);
			dao.updateAccount(sender);
			System.out.println("Money successfully transfered to the recipient's account!");
			
			//updating transactions table for sender
			checkTransactions(senderNum, "Transferred amount " + amount + 
					" to account " + recipient.getAccountNumber() + 
					" " + recipient.getCustomerName());
			
			//updating transactions table for receiver
			checkTransactions(recipientNum, "Received amount " + amount + 
					" from account " + sender.getAccountNumber() + 
					" " + sender.getCustomerName());
			
		}
		
		else if(sender == null) {
			System.out.println("Sender account not found");
		}
		
		else {
			System.out.println("Recipient account not found");
		}
	}
	
	
	public static void viewTransactions(int accountNum) {
		Transactions tns = dao.getTransaction(accountNum);
		System.out.println("Account number: " + tns.getAccount_number()
		+ "\nTransactions: \n" + tns.getTransaction());
	}
	
	
	private static void checkTransactions(int accountNum, String txn) {
		//fetching transaction to see if transactions associated with the given 
		//account number are there in the database
		Transactions tns = dao.getTransaction(accountNum);
		
		//if the account number is already in the transactions table
		if (tns != null) {
			
			//append the new transaction on the previous one
			tns.setTransaction(tns.getTransaction() + "\n" + txn);
			dao.updateTransaction(tns);
		}
		
		// if not there in database
		else {
			Transactions tnss = new Transactions();
			
			//create a new transaction
			tnss.setAccount_number(accountNum);
			tnss.setTransaction(txn);
			
			//add in the database
			dao.addTransaction(tnss);
		}
	}
	
	
}
