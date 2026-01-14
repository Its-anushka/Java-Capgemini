package OnlineBankingSystem;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(){
        super("Source account does not have enough balance");
    }
}
