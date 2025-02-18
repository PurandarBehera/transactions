package com.puru.springboot.transactions.exception;

public class PaymentException extends RuntimeException {

    public PaymentException(String msg){
        super(msg);
    }
}
