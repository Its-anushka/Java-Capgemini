package com.capg.assessment.Controller;
import java.util.Scanner;
import com.capg.assessment.Service.*;

public class BankController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char choice;
		do{
			
            System.out.println("1. Create a new account");
            System.out.println("2. Show Account Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Fund Transfer");
            System.out.println("6. View Transactions");
            System.out.print("Enter your choice: ");
			int opt = sc.nextInt();

            switch (opt) {
            // creating a new account
                case 1:
                    System.out.print("Enter account number: ");
                    int acc = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Enter account holder's name: ");
                    String name = sc.nextLine();
                    
                    System.out.print("Enter mobile number: ");
                    long mob = sc.nextLong();
                    
                    System.out.print("Enter initial amount: ");
                    double amt = sc.nextDouble();
                    
                    BankService.createAccount(acc, name, mob, amt);
                    break;
                  
                 //Fetching balance
                case 2:
                		System.out.print("Enter account number: ");
                    int accoun = sc.nextInt();
                    BankService.showBalance(accoun);
                    
                    break;
                	
                    //Money deposit
                case 3:
                		System.out.print("Enter account number: ");
                    int accn = sc.nextInt();
         
                    System.out.print("Enter amount to be deposited: ");
                    double amnt = sc.nextDouble();
                    
                    BankService.depositMoney(accn, amnt);
                    
                    break;
                    
                    // Money withdrawal
                case 4:
                		System.out.print("Enter account number: ");
                    int accNum = sc.nextInt();
         
                    System.out.print("Enter amount to be withdrawn: ");
                    double amount = sc.nextDouble();
                    
                    BankService.withdrawMoney(accNum, amount);
                    
                    break;
                    
                    //Funds transfer
                case 5:
                		System.out.print("Enter senders's account number: ");
                    int sender = sc.nextInt();
                    
                    System.out.print("Enter recipient's account number: ");
                    int recipient = sc.nextInt();
                    
                    System.out.println("Enter amount: ");
                    double money = sc.nextDouble();
                    
                    BankService.fundTransfer(sender, recipient, money);
                    
                    break;
                    
                    //view transactions
                case 6: 
                		System.out.print("Enter account number: ");
                    int acoun = sc.nextInt();
                    BankService.viewTransactions(acoun);
                
                    break;
                   
                default:
                    System.out.println("Invalid input");
                    break;
            }

            System.out.print("Do you want to continue? (Y/N): ");
            choice = sc.next().charAt(0);
        }while (choice == 'Y' || choice == 'y');
		
		System.out.println("EXITED!!");

    }
	}

