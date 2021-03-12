package com.melgaabeb.kata.bank.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Math.abs;

public class Transaction {

    private float amount;
    private Date date;
    private float balance;

    public Transaction() {
    }

    public Transaction(float amount, float balance) {
        this.amount = amount;
        this.balance = balance;
        this.date = new Date();
    }

    public String getOperation() {
        return (amount < 0) ? "withdrawal" : "deposit";
    }

    public float getAbsoluteAmount() {
        return abs(amount);
    }

    public String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    @Override
    public String toString() {
        return getOperation() +  " || "  + getFormattedDate() + " || " + getAbsoluteAmount() + " || " + this.balance;
    }
}
