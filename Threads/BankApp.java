package Threads;

public class BankApp{
    public static void main(String[] args) {
        BankAccount a = new BankAccount(5000);
        ATM atm = new ATM(a, 3000);
        ATM atm1 = new ATM(a, 2500);

        Thread t1 = new Thread(atm);
        Thread t2 = new Thread(atm1);

        t1.start();
        t2.start();
    }
}

class ATM implements Runnable{
    private BankAccount account;
    private int amount;

    public ATM(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run(){
        this.account.withdraw(this.amount);
    }
}

class BankAccount{
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int amount){
        if (amount <= balance) {
            System.out.println(Thread.currentThread().getName() +
                    " withdrawing " + amount);
            balance -= amount;
            System.out.println("Remaining Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " insufficient balance");
        }
    }
}


