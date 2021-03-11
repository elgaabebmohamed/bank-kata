package com.melgaabeb.kata.bank.domain;

public class Account {

    private float balance;

    public void deposit(float amount) {
        balance += amount;
    }

    public float getBalance() {
        return balance;
    }
}
