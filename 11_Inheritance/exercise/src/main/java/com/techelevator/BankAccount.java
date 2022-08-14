package com.techelevator;


import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private int balance;

    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;



    }
    public int deposit(int amountToDeposit){
        this.balance = getBalance() + amountToDeposit;

        return balance;
    }
    public int withdraw(int amountToWithdraw) {
        this.balance = getBalance() - amountToWithdraw;
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
