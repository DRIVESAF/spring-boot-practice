package io.drivesaf.springboot.quickstart.entity;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/04 15:28
 * @description:
 **/
public sealed class Account permits SavingsAccount, CreditAccount {
    private final String accountNumber;
    private final double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

