package com.barbershop.exception;

public class AdministratorNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Administrator not found";
    }

}
