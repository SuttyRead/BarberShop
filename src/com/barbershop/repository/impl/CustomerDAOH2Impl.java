package com.barbershop.repository.impl;

import com.barbershop.domain.Customer;
import com.barbershop.domain.Hairdresser;
import com.barbershop.domain.MasterHand;
import com.barbershop.repository.CustomerDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.barbershop.repository.impl.ConnectionFactory.*;


public class CustomerDAOH2Impl implements CustomerDAO {


    private Connection connection;
    private PreparedStatement pst = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private static CustomerDAOH2Impl instance;

    public static CustomerDAOH2Impl instance() {
        if (instance == null) {
            instance = new CustomerDAOH2Impl();
        }
        return instance;
    }

    private static final String GET_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE id = ?";

    private static final String INSERT_CUSTOMER = String.format("INSERT INTO customers(%s, %s, %s, %s)" +
            " VALUES (?, ?, ?, ?);", Customer.FIRST_NAME, Customer.LAST_NAME, Customer.MIDDLE_NAME, Customer.PHONE_NUMBER);

    private static final String GET_ALL_CUSTOMERS = "SELECT * FROM customers";

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_CUSTOMERS);

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt(Hairdresser.ID));
                customer.setFirstName(rs.getString(Hairdresser.FIRST_NAME));
                customer.setLastName(rs.getString(Hairdresser.LAST_NAME));
                customer.setMiddleName(rs.getString(Hairdresser.MIDDLE_NAME));
                customer.setPhoneNumber(rs.getString(Hairdresser.PHONE_NUMBER));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
        return customers;
    }

    @Override
    public Customer findCustomerById(int id) {
        Customer customer = new Customer();

        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_CUSTOMER_BY_ID);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                customer.setId(rs.getInt(MasterHand.ID));
                customer.setFirstName(rs.getString(MasterHand.FIRST_NAME));
                customer.setLastName(rs.getString(MasterHand.LAST_NAME));
                customer.setMiddleName(rs.getString(MasterHand.MIDDLE_NAME));
                customer.setPhoneNumber(rs.getString(MasterHand.PHONE_NUMBER));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return customer;
    }

    @Override
    public void addCustomer(Customer customer) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(INSERT_CUSTOMER);

            pst.setString(1, customer.getFirstName());
            pst.setString(2, customer.getLastName());
            pst.setString(3, customer.getMiddleName());
            pst.setString(4, customer.getPhoneNumber());

            pst.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }


}
