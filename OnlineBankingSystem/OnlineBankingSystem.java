package OnlineBankingSystem;
import java.util.Scanner;

public class OnlineBankingSystem {
    private Account[] accounts;
    private int count;
    Scanner sc = new Scanner(System.in);

    public OnlineBankingSystem(){
        accounts = new Account[10];
        count = 0;
        accounts[count++] = new Account(101, "Alice", 5000);
        accounts[count++] = new Account(102, "Bob", 5000);
        accounts[count++] = new Account(103, "Charlie", 3000);
    }

    public static void main(String[] args) throws InsufficientFundsException, AccountNotFoundException {
        OnlineBankingSystem obs = new OnlineBankingSystem();

        obs.displayAccounts();
        obs.transferFunds();
        obs.displayAccounts();
    }

    //Method for funds transfer
    private void transferFunds() throws InsufficientFundsException, AccountNotFoundException{

        try {
            System.out.print("Enter source account number: ");
            int source = sc.nextInt();
            System.out.print("Enter target account number: ");
            int target = sc.nextInt();
            System.out.println("Enter amount to transfer: ");
            double amount = sc.nextDouble();
//fetching source and target accounts
            Account sourceAcc = findAccount(source);
            Account targetAcc = findAccount(target);

            sourceAcc.withdraw(amount);
            targetAcc.deposit(amount);
        }
        catch (InsufficientFundsException e){
            System.out.println("Transaction failed: " + e.getMessage());
        }

        catch (AccountNotFoundException e){
            System.out.println("Transaction failed: " + e.getMessage());
        }

        catch(IllegalArgumentException e){
            System.out.println("Transaction failed: " + e.getMessage());
        }

    }

    private void displayAccounts(){
        for (int i = 0; i < count ; i++){
            System.out.println(accounts[i].toString());
        }
    }

    //method to fetch the specified account from the accounts
    private Account findAccount(int a) throws AccountNotFoundException{
        for (int i = 0; i < count ; i++){
            if (a == accounts[i].getAccountNumber()){
                return accounts[i];
            }
        }
        throw new AccountNotFoundException();
    }
}
