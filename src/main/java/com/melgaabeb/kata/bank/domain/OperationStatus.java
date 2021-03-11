package com.melgaabeb.kata.bank.domain;

public enum OperationStatus {
    OK(0),
    ACCOUNT_RECEIVABLE(1);

    private final Integer statusCode;

    OperationStatus(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
