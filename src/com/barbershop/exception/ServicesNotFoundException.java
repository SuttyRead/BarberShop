package com.barbershop.exception;

public class ServicesNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Services not found";
    }

}
