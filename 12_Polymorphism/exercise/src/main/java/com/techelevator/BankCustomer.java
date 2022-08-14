package com.techelevator;
import java.util.ArrayList;
import java.util.List;
public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts;

    public BankCustomer() {
        accounts = new ArrayList<>();
    }



    public String getName() {
        return name;
    }
    public boolean isVip() {
        int total = 0;

        for (Accountable getAccounts : accounts) {
            total += getAccounts.getBalance();
        }
        return total >= 25000;
    }


    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[accounts.size()]);
    }

        public void setName(String name){
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress (String address){
            this.address = address;
        }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }
    }

