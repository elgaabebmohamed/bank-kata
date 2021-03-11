package com.melgaabeb.kata.bank.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionsHistoryTest {

    public static final int AMOUNT = 12;
    public static final int BALANCE = 24;
    private String expetedDate;

    @BeforeEach
    void setUp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        expetedDate = dateFormat.format(new Date());
    }

    @Test
    public void Given_Transaction_History_When_Add_Transaction_Then_Transaction_is_Stored_in_History() {

        // Given
        TransactionsHistory transactionHistory = new TransactionsHistory();

        // When
        transactionHistory.addTransaction(AMOUNT, BALANCE);

        // Then
        Transaction addedTransaction = transactionHistory.getTransactionList().get(0);
        assertEquals(transactionHistory.getTransactionList().size(), 1, 0);
        assertEquals(AMOUNT, addedTransaction.getAbsoluteAmount(), 0);
        assertTrue(addedTransaction.getAbsoluteAmount() > 0);
        assertEquals("deposit",addedTransaction.getOperation());
        assertEquals(addedTransaction.getFormattedDate(), expetedDate);
    }
}
