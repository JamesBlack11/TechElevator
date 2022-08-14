package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount{


    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }


    @Override
    public int withdraw(int amountToWithdraw) {
        if (getBalance() > amountToWithdraw) {
            super.withdraw(amountToWithdraw);
        } else {
            if (getBalance() - amountToWithdraw > -100) {
                super.withdraw(amountToWithdraw + 10);
            } else {
                return getBalance();
            }
       }
        return getBalance();
    }
}

