package com.barbershop.exception;

public class OrderNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Order not found";
    }

}
