package com.melgaabeb.kata.bank.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void Given_An_Account_When_Deposit_Then_Amount_is_added() {
        // Given
        Account account = new Account();
        // When
        account.deposit(12);
        // Then
        assertEquals(12, account.getBalance(), 0);
    }

    @Test
    public void Given_An_Account_When_Withdrawal_Amount_available_in_account_Then_Amount_is_removed() {
        // Given
        Account account = new Account(12);
        // When
        int operationStatus = account.withdrawal(5);
        // Then
        assertEquals(7, account.getBalance(), 0);
        assertEquals(0, operationStatus, 0);
    }
}
