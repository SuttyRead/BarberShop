package com.barbershop.exception;

public class ManicuristNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Manicurist not found";
    }

}
