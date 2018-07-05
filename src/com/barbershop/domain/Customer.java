package com.barbershop.domain;


public class Customer extends Person {

    public Customer() {
    }

    public Customer(String firstName, String lastName, String middleName) {
        super(firstName, lastName, middleName);
    }

    @Override
    public String toString() {
        return "Customer(First name = " + getFirstName() + ", last name = " + getLastName() + "," +
                " middle name = " + getMiddleName() + ", phone number = " + getPhoneNumber() + ")";
    }

}
