package BankAccount;

public class BankMain {
    private static int accountsCount = 0;
    private static double interestRate = 0.02;
        private double balance;
    private int id;
    public BankMain(){
        this.id = accountsCount;
        accountsCount++;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        BankMain.interestRate = interestRate;
    }
    public double getInterest(int years){
        return this.balance * interestRate * years;
    }
    public void deposit(double amount){
        this.balance += amount;
    }
}
