package com.barbershop.repository.impl;

import com.barbershop.domain.Customer;
import com.barbershop.repository.CustomerDAO;

import java.sql.*;
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

    private static final String CREATE_CUSTOMER_TABLE = "CREATE TABLE IF NOT EXISTS customers (" +
            Customer.ID + " INT(11) PRIMARY KEY AUTO_INCREMENT," +
            Customer.FIRST_NAME + " VARCHAR(255)," +
            Customer.LAST_NAME + " VARCHAR(255)," +
            Customer.MIDDLE_NAME + " VARCHAR(255)," +
            ");";

    public CustomerDAOH2Impl() {
        createTableIfNotExists();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    private void createTableIfNotExists() {
        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(CREATE_CUSTOMER_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
    }

}
