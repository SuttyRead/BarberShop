package com.barbershop.repository.impl;

import com.barbershop.domain.*;
import com.barbershop.exception.OrderNotFoundException;
import com.barbershop.repository.OrderDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.barbershop.repository.impl.ConnectionFactory.getInstance;

public class OrderDAOH2Impl implements OrderDAO {

    private Connection connection;
    private PreparedStatement pst = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private static OrderDAOH2Impl instance;

    public static OrderDAOH2Impl instance() {
        if (instance == null) {
            instance = new OrderDAOH2Impl();
        }
        return instance;
    }


    private static final String INSERT_ORDER = String.format("INSERT INTO orders(%s, %s, %s, %s, %s, %s)" +
            " VALUES (?, ?, ?, ?, ?, ?);", Order.CUSTOMER, Order.MASTER_HAND, Order.COST, Order.SERVICES, Order.BEGINNING_OF_ADMISSION, Order.END_OF_ADMISSION);

    private static final String GET_ALL_ORDERS = "SELECT * FROM orders";

    private static final String DELETE_ORDER_BY_ID = String.format("DELETE FROM orders WHERE %s = ?;", Order.ID);

    private static final String GET_ORDER_BY_ID = "SELECT * FROM orders WHERE id = ?";

    private static final String UPDATE_ORDER = String.format("UPDATE orders SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? " +
            "WHERE id = ?",  Order.CUSTOMER,Order.MASTER_HAND, Order.COST, Order.SERVICES, Order.BEGINNING_OF_ADMISSION, Order.END_OF_ADMISSION);

    @Override
    public void addOrder(Order order) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(INSERT_ORDER);

            pst.setInt(1, order.getMasterHandId());
            pst.setInt(2, order.getCustomerId());
            pst.setInt(3, (int) order.getCost());
            pst.setInt(4, order.getServicesId());
            pst.setString(5, order.getBeginningOfAdmission());
            pst.setString(6, order.getEndOfAdmission());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        MasterHandDAOH2Impl masterHandDAOH2 = new MasterHandDAOH2Impl();
        CustomerDAOH2Impl customerDAOH2 = new CustomerDAOH2Impl();
        ServicesDAOH2Impl servicesDAOH2 = new ServicesDAOH2Impl();
        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_ORDERS);

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt(Order.ID));
                order.setMasterHandId(rs.getInt(Order.MASTER_HAND));
                order.setCustomerId(rs.getInt(Order.CUSTOMER));
                order.setCost(rs.getInt(Order.COST));
                order.setServicesId(rs.getInt(Order.SERVICES));
                order.setBeginningOfAdmission(rs.getString(Order.BEGINNING_OF_ADMISSION));
                order.setEndOfAdmission(rs.getString(Order.END_OF_ADMISSION));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
        return orders;
    }

    @Override
    public void deleteOrder(int id) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(DELETE_ORDER_BY_ID);
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            if (result == 0) {
                throw new OrderNotFoundException();
            }
        } catch (OrderNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }



}
