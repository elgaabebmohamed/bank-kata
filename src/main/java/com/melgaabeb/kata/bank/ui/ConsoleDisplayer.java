package com.melgaabeb.kata.bank.ui;

public class ConsoleDisplayer implements Displayer {
    @Override
    public void display(String line) {
        System.out.println(line);
    }
}
