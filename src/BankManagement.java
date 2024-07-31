import java.util.Scanner;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void transfer(Account targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
            System.out.println("transferred: " + amount + " to account " + targetAccount.getAccountNumber());
        } else {
            System.out.println("transaction failed. Check amount and balance.");
        }
    }
}

// SavingsAccount class
class SavingsAccount extends Account {


    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);

    }


}


class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);

    }


    public void withdraw(double amount) {
        if (amount > 0 && amount <= (getBalance())) {
            super.withdraw(amount);
        } else {
            System.out.println(" doesn't have enough money to Withdrawal ");
        }
    }
}


public class BankManagement {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter savings account details : ");
        System.out.println("Enter savings account account number :");
        String accNum1 =sc.nextLine();
        System.out.println("Enter savings account balance");
        double balance1=sc.nextDouble();
        System.out.println("Enter checking account details : ");
        System.out.println("Enter checking account number :");

        String accNum2=sc.nextLine();
        sc.nextLine();
        System.out.println("Enter checking account balance :");
        double balance2=sc.nextDouble();
        SavingsAccount savings = new SavingsAccount(accNum1, balance1);
        CheckingAccount checking = new CheckingAccount(accNum2, balance2);
        //inputs for savings account
        System.out.println("Enter deposit amount for Savings Account : ");
        double savDep= sc.nextDouble();
        System.out.println("Enter withdraw amount for Savings Account : ");
        double savWith=sc.nextDouble();
        System.out.println("Enter deposit amount for checking Account : ");
        double checkdep=sc.nextDouble();
        System.out.println("Enter withdraw amount for Checking Account : ");
        double checkwith=sc.nextDouble();
        System.out.println("Enter transfer amount");
        double transferamount=sc.nextDouble();
        savings.deposit(savDep);
        savings.withdraw(savWith);


        checking.deposit(checkdep);
        checking.withdraw(checkwith);


        savings.transfer(checking, transferamount);
        System.out.println("Savings Account Balance: " + savings.getBalance());
        System.out.println("Checking Account Balance: " + checking.getBalance());
    }
}

