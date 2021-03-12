package com.melgaabeb.kata.bank.domain;

import java.util.ArrayList;
import java.util.List;

public class TransactionsHistory {
    private List<Transaction> transactionList;

    public TransactionsHistory() {
        this.transactionList = new ArrayList<Transaction>();
    }
    public TransactionsHistory(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public void addTransaction(float amount, float balance) {
        Transaction transaction = new Transaction(amount, balance);
        transactionList.add(transaction);
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }
}
