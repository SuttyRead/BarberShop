package com.barbershop.service;

import com.barbershop.domain.Customer;
import com.barbershop.repository.impl.CustomerDAOH2Impl;

import java.util.List;

public class CustomerService {

    private CustomerDAOH2Impl customerDAOH2;

    public CustomerService() {
        customerDAOH2 = CustomerDAOH2Impl.instance();
    }



    public List<Customer> getAllCustomers() {
        return customerDAOH2.getAllCustomers();
    }

    public Customer findCustomerById(int id){
        return customerDAOH2.findCustomerById(id);
    }

    public void addCustomer(Customer customer){
        customerDAOH2.addCustomer(customer);
    }

}
