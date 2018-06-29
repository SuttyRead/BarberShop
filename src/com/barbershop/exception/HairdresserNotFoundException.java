package com.barbershop.exception;

public class HairdresserNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Hairdresser not found";
    }

}
