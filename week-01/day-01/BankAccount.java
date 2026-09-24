public class BankAccount {
    private String owner;
    private double balance;

    private static int accountCount = 0;

    private static final double MINIMUN_DEPOSIT = 100.0;

    public BankAccount(String owner, double balance){
        this.owner= owner;
        this.balance = balance;
        accountCount = accountCount + 1;
    }

    public void deposit(double amount){
        balance = balance + amount;
    }

    public double getBalance(){
        return balance;
    }
}
