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
        OperationStatus operationStatus = OperationStatus.OK;

        if (isReceivable(amount)) {
            operationStatus = OperationStatus.ACCOUNT_RECEIVABLE;
        } else {
            balance -= amount;
        }

        return operationStatus.getStatusCode();
    }

    public float getBalance() {
        return balance;
    }

    public boolean isReceivable(float amount) {
        return (amount > balance);
    }
}
