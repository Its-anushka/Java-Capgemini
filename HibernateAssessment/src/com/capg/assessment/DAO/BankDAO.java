package com.capg.assessment.DAO;
import com.capg.assessment.entity.Bank;
import com.capg.assessment.entity.Transactions;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BankDAO {
	private static SessionFactory sf;
	
    static {
        try {
            AnnotationConfiguration cfg = new AnnotationConfiguration();
            cfg.configure();   // loads hibernate.cfg.xml
            sf = cfg.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //adding transaction in transactions table
	public void addTransaction(Transactions tns) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(tns);
		tx.commit();
		session.close();
	}
	
	//updating transaction
	public void updateTransaction(Transactions tns) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(tns);
		tx.commit();
		session.close();
	}
	
	//fetching a transaction by account number
	public Transactions getTransaction(int accountNum) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Transactions tns = (Transactions) session.get(Transactions.class, accountNum);
		return tns;
	}
	
	//fetching a bank account by account number
	public Bank getAccount(int accountNum) {
		Session session = sf.openSession();
		Bank bankAcc = (Bank) session.get(Bank.class, accountNum);
		return bankAcc;
	}
	
	//adding an account to the database
	public void addAccount(Bank bankAcc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(bankAcc);
		tx.commit();
		session.close();
	}
	
	//fetching account balance
	public double getBalance(int accountNumber) {
		Session session = sf.openSession();
		Bank bankAcc = null;
		try {
			bankAcc = (Bank) session.get(Bank.class, accountNumber);
		}
		catch(Exception e) {
			System.out.println("Account not found!");
		}
		
		finally {
			session.close();	
		}
		return bankAcc.getBalance();
	}
	
	//updating account details
	public void updateAccount(Bank bankAcc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			
			session.update(bankAcc);
		}
		catch(Exception e) {
			System.out.println("Account not found!");
		}
		finally {
			tx.commit();
			session.close();
		}
		
	}
	
}

