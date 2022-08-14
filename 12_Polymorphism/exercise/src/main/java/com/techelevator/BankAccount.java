package com.techelevator;

public class BankAccount implements Accountable{

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int deposit(int amountToDeposit) {
        balance = balance + amountToDeposit;
        return balance;
    }

    public int withdraw(int amountToWithdraw) {
        balance = balance - amountToWithdraw;
        return balance;
    }
    public int transferTo(BankAccount destinationAccount, int transferAmount) {
        int sourceBalance = getBalance();
        int destinationBalance = destinationAccount.getBalance();
        if (sourceBalance - transferAmount >= 0) {
            sourceBalance = withdraw(transferAmount);
            destinationAccount.deposit(transferAmount);
            return sourceBalance;
        }
      return sourceBalance;
    }

}
// create a list for Bank Customer List<BankAccount>