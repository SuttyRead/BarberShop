package com.barbershop.repository;

import com.barbershop.domain.Customer;
import com.barbershop.domain.Hairdresser;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getAllCustomers();

    Customer findCustomerById(int id);

    void addCustomer(Customer customer);

}
