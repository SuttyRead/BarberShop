package com.barbershop.domain;

import static com.barbershop.repository.impl.ConnectionFactory.*;

public class Customer extends Person {




    public Customer() {
    }

    public Customer(String firstName, String lastName, String middleName) {
        super(firstName, lastName, middleName);
    }



}
