package com.melgaabeb.kata.bank;

import com.melgaabeb.kata.bank.domain.Account;
import com.melgaabeb.kata.bank.ui.ConsoleDisplayer;
import com.melgaabeb.kata.bank.ui.Displayer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Displayer consoleDisplayer = new ConsoleDisplayer();
        Account account = new Account(124, consoleDisplayer);
        
        account.deposit(25);
        account.deposit(9);
        account.withdrawal(29);
        account.deposit(32);
        account.withdrawal(69);

        account.checkOperations();
    }
}
