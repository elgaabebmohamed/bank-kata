package com.melgaabeb.kata.bank.domain;

import com.melgaabeb.kata.bank.ui.Displayer;

public class Account {

    private float balance;
    private Displayer displayer;
    private TransactionsHistory transactionsHistory;

    public Account() {
        this.transactionsHistory = new TransactionsHistory();
    }

    public Account(float initialBalance, Displayer displayer) {
        this.balance = initialBalance;
        this.displayer = displayer;
        this.transactionsHistory = new TransactionsHistory();
        this.transactionsHistory.addTransaction(initialBalance, initialBalance);
    }

    public void deposit(float amount) {
        balance += amount;
        transactionsHistory.addTransaction(amount, balance);
    }

    public Integer withdrawal(float amount) {
        OperationStatus operationStatus = OperationStatus.OK;

        if (isReceivable(amount)) {
            operationStatus = OperationStatus.ACCOUNT_RECEIVABLE;
        } else {
            balance -= amount;
            transactionsHistory.addTransaction(-amount, balance);
        }

        return operationStatus.getStatusCode();
    }

    public float getBalance() {
        return balance;
    }

    public boolean isReceivable(float amount) {
        return (amount > balance);
    }

    public void checkOperations() {
        displayer.display("operation || date || amount || balance");
        for (Transaction transaction: transactionsHistory.getTransactionList()) {
            displayer.display(transaction.toString());
        }

    }
}
