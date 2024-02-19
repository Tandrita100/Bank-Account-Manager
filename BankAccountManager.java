package com.projects;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountManager {
    public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();      //Arraylist of class Bankaccount

    while(true){       //loop will continue until i exit

        System.out.println("\n* welcome to Bank Account Manager *");
        System.out.println("1. Create an Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Balance Enquiry");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.println();
        System.out.println("Please Enter Your Choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            //account creation
            case 1:
                System.out.println("Enter Account number: ");
                String accountNum = sc.next();
                System.out.println("Enter Initial Balance: ");
                double balance = sc.nextDouble();
                BankAccount newAccount = new BankAccount(accountNum, balance);
                accounts.add(newAccount);
                System.out.println("Congratulations!! Your account has been created Successfully.");
                break;
            //Deposit amount
            case 2:
                System.out.println("Enter account number: ");
                String depositAccountNumber = sc.next();
                BankAccount depositAccount = BankAccount.findAccount(accounts, depositAccountNumber );
                if (depositAccount != null) {
                    System.out.println("Enter Deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    depositAccount.deposit(depositAmount);
                    System.out.println("Deposit Successful :)");
                } else {
                    System.out.println("Sorry, Account not found :(");
                }
                break;
            //withdraw amount
            case 3:
                System.out.println("Enter account number: ");
                String withdrawAccountNumber = sc.next();
                BankAccount withdrawAccount = BankAccount.findAccount(accounts, withdrawAccountNumber );
                if (withdrawAccount != null) {
                    System.out.println("Enter Withdrawal amount: ");
                    double withdrawalAmount = sc.nextDouble();
                    boolean success = withdrawAccount.Withdraw(withdrawalAmount);
                    if (success) {
                        System.out.println("Withdrawal successful :)");
                    }
                } else {
                    System.out.println("Sorry, Account not found :(");
                }
                break;
            //balance check
            case 4:
                System.out.println("Enter account number: ");
                String checkBalanceAccountNumber = sc.next();
                BankAccount checkBalanceAccount = BankAccount.findAccount(accounts, checkBalanceAccountNumber );
                if (checkBalanceAccount != null) {
                    System.out.println("Current Balance: " + checkBalanceAccount.getBalance());
                } else {
                    System.out.println("Sorry, Account not found :(");
                }
                break;
            //Transaction History
            case 5:
                System.out.println("Enter account number: ");
                String transactionHistoryAccountNumber = sc.next();
                BankAccount transactionHistoryAccount = BankAccount.findAccount(accounts, transactionHistoryAccountNumber );
                if (transactionHistoryAccount != null) {
                    transactionHistoryAccount.printTransactionHistory();
                } else {
                    System.out.println("Sorry, Account not found :(");
                }
                break;
            //exit
            case 6:
                System.out.println("Exiting Bank Manager. Goodbye, Have a Wonderful Day.");
                System.exit(0);
            default:
                System.out.println("Enter a valid choice");

           }
        }
    }
}


