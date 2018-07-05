package com.barbershop.exception;

public class MasterHandNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "MasterHand not found";
    }

}
