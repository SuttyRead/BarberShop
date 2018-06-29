package com.barbershop.exception;

public class CleaningWomanNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "CleaningWoman not found";
    }

}
