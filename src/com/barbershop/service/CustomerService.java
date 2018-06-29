package com.barbershop.service;

import com.barbershop.domain.Customer;
import com.barbershop.repository.impl.CustomerDAOH2Impl;

import java.util.List;

public class CustomerService {

    private CustomerDAOH2Impl customerDAOH2;

    public CustomerService() {
        customerDAOH2 = CustomerDAOH2Impl.instance();
    }

    List<Customer> getAllCustomers() {
        return customerDAOH2.getAllCustomers();
    }

}
