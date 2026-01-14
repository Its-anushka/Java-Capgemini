package OnlineBankingSystem;

public class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    //Contructor
    public Account(int accountNumber, String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    //getter for account number
    public int getAccountNumber(){
        return this.accountNumber;
    }

    //getter for balance
    public double getBalance(){
        return this.balance;
    }


    public void deposit(double amount){
        if (amount < 0) throw new IllegalArgumentException("Amount can't be less than 0.");
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        if (amount < 0) throw new IllegalArgumentException("Amount can't be less than 0.");

        if (this.balance < amount) {
            throw new InsufficientFundsException();
        }
        else{
            balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }

}
