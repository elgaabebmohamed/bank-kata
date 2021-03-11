package com.melgaabeb.kata.bank.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionTest {

    private String expetedDate;

    @BeforeEach
    public void setUp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        expetedDate = dateFormat.format(new Date());
    }


        @Test
    public void Given_Deposit_Transaction_When_Get_Amount_and_Operation_Then_Amount_is_Positive_And_Operation_is_deposit_And_date_is_today() {
        // Given
        Transaction transaction = new Transaction(12, 24);

        // When
        String operation = transaction.getOperation();
        float amount = transaction.getAbsoluteAmount();
        String transactionDate = transaction.getFormattedDate();

        // Then
        assertEquals(12, amount, 0);
        assertTrue(amount > 0);
        assertEquals("deposit", operation);
        assertEquals(transactionDate, expetedDate);
    }
}
