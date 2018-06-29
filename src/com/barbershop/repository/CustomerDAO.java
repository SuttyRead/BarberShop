package com.barbershop.repository;

import com.barbershop.domain.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getAllCustomers();

}
