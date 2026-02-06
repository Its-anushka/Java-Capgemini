package Streams;

@FunctionalInterface
interface LoanApprovalRule{
    public boolean approve(LoanApplication app);
}
public class LoanApplication {
    private double income;
    private int creditScore;
    private double amountRequested;

    public LoanApplication(double income, int creditScore, double amountRequested) {
        this.income = income;
        this.creditScore = creditScore;
        this.amountRequested = amountRequested;
    }

    public double getIncome() {
        return income;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getAmountRequested() {
        return amountRequested;
    }
}

class LSolution{
    public static boolean processLoan(LoanApplication app, LoanApprovalRule rule){
       return rule.approve(app);
    }

    public static void main(String[] args){
        LoanApplication loan = new LoanApplication(60000, 720, 36000);

        LoanApprovalRule incomeRule = a -> a.getIncome() >= 50000;
        LoanApprovalRule creditRule = a -> a.getCreditScore() >= 720;
        LoanApprovalRule amountRule = a -> a.getAmountRequested() <= a.getIncome() * 0.30;

        String inc = (processLoan(loan, incomeRule)? "Accepted" : "Rejected");
        String cred = (processLoan(loan, creditRule)? "Accepted" : "Rejected");
        String amt = (processLoan(loan, amountRule)? "Accepted" : "Rejected");

        System.out.println("Credit Score Rule: " + cred);
        System.out.println("Income Rule: " + inc);
        System.out.println("Safe Borrow Rule: " + amt);

    }
}
