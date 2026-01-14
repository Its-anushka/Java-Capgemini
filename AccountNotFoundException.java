package OnlineBankingSystem;

public class AccountNotFoundException extends Exception{
    public AccountNotFoundException(){
        super("Target account does not exist");
    }
}
