public class Main {
     public static void main(String[] args) {
        BankAccount account  = new BankAccount("Manish", 2000);
        BankAccount account1 =  new BankAccount("Jaya",5000);

        account.deposit(3000);
        account1.deposit(5000);
        double accountBalance = account.getBalance();
        double account1Balance = account1.getBalance();

        System.out.println("Account Balance account 1: " + accountBalance);
        System.out.println("Account Balance account 2: " + account1Balance);

      Employee e1 = new Employee("Jaya", 50000);
      Employee e2  = new Employee("Manish", 40000);

      e1.giveRaise(10);
     }
}
