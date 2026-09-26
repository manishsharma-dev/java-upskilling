class Account{
    private String accountHolder;
    private double balance;

    public Account(String accountHolder,  double balance){
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String deposit(double amount){
        if(amount <=0){
            return "Invalid amount";
        }
        balance  +=amount;
        return "Amount deposited successfully";
    }

     public String withdraw(double amount){
        if(amount <=0){
            return "Invalid amount";
        }
        if(balance < amount){
            return "Insufficient balance";
        }
        balance  -=amount;
        return "Amount deposited successfully";
    }

    public String getBalance(){
        return "User " + accountHolder + "has balance of " + balance;
    }

}

public class BankAccount {
     Account acc =  new Account("Manish", 10000);
     
}
