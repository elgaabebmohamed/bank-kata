package com.melgaabeb.kata.bank.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.melgaabeb.kata.bank.ui.ConsolerDisplayer;
import com.melgaabeb.kata.bank.ui.Displayer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doAnswer;

public class AccountTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private String expetedDate;
    Displayer consoleDisplayerMock;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        expetedDate = dateFormat.format(new Date());

        consoleDisplayerMock = mock(ConsolerDisplayer.class);

        doAnswer(invocation -> {
            Object arg0 = invocation.getArgument(0);
            System.out.println(arg0);
            return null;
        }).when(consoleDisplayerMock).display(any(String.class));
    }

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

    @Test
    public void Given_An_Account_When_Check_Operations_Then_Operation_History_is_displayed() {

        // Given
        Account account = new Account(12, consoleDisplayerMock);
        account.deposit(26);
        account.deposit(37);
        account.withdrawal(15);

       // When
        account.checkOperations();

        // Then
        assertEquals("operation || date || amount || balance\n" +
                "deposit || "+ expetedDate +" || 12.0 || 12.0\n" +
                "deposit || "+ expetedDate +" || 26.0 || 38.0\n" +
                "deposit || "+ expetedDate +" || 37.0 || 75.0\n" +
                "withdrawal || "+ expetedDate +" || 15.0 || 60.0\n", outputStreamCaptor.toString());
        verify(consoleDisplayerMock, times(5)).display(any(String.class));
    }
}
