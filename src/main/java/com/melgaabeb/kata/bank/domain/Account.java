package com.melgaabeb.kata.bank.domain;

public class Account {

    private float balance;

    public Account() {
    }

    public Account(float balance) {
        this.balance = balance;
    }

    public void deposit(float amount) {
        balance += amount;
    }

    public Integer withdrawal(float amount) {
        Integer operationStatus = 0;
        if (amount > balance) {
            operationStatus = 1;
        } else {
            balance -= amount;
        }
        return operationStatus;
    }

    public float getBalance() {
        return balance;
    }
}
