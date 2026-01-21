package Threads;

public class TransactionTask implements Runnable{
    private Account account;
    private int amount;
    private String transactionId;

    public TransactionTask(Account account, int amount, String transactionId) {
        this.account = account;
        this.amount = amount;
        this.transactionId = transactionId;
    }

    @Override
    public void run(){
        System.out.println("Processing transaction: " + this.transactionId);
        this.account.debit(this.amount);
    }

    public static void main(String[] args) {
        Account a = new Account(10000);
        TransactionTask tt1 = new TransactionTask(a, 3000,"TXN001");
        TransactionTask tt2 = new TransactionTask(a, 4000, "TXN002");
        TransactionTask tt3 = new TransactionTask(a, 3500, "TXN003");

        Thread t1 = new Thread(tt1);
        Thread t2 = new Thread(tt2);
        Thread t3 = new Thread(tt3);

        t1.start();
        t2.start();
        t3.start();

    }

}

class Account{
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized void debit(int amount) {

        if (amount <= balance) {
            System.out.println(Thread.currentThread().getName() +
                    " debiting amount: " + amount);
            balance -= amount;
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " transaction failed due to insufficient balance");
        }
    }

    public int getBalance(){
        return this.balance;
    }
}
