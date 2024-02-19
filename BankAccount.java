package com.projects;

import java.util.ArrayList;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount){
        balance += amount;
        transactionHistory.add("Deposit: +" + amount);
    }

    public boolean Withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            transactionHistory.add("Withdraw: -" + amount);
            return true;
        }else{
            System.out.println("Insufficient funds :(");
            return false;
        }
    }

    //get Account Number method
    public String getAccountNumber(){
        return accountNumber;
    }
    //to get balance
    public double getBalance(){
        return balance;
    }

    //to print transaction history
    public void printTransactionHistory(){
        System.out.println("Transaction History: ");
        for (String transaction: transactionHistory) {
            System.out.println(transaction);
        }
    }

    public static BankAccount findAccount(ArrayList<BankAccount> accounts, String accountNumber){
        for (BankAccount account: accounts) {
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

}
