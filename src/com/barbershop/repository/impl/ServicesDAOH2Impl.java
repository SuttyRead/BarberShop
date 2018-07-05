package com.barbershop.repository.impl;

import com.barbershop.domain.*;
import com.barbershop.exception.ManicuristNotFoundException;
import com.barbershop.exception.ServicesNotFoundException;
import com.barbershop.repository.ServicesDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.barbershop.repository.impl.ConnectionFactory.getInstance;

public class ServicesDAOH2Impl implements ServicesDAO {

    private Connection connection;
    private PreparedStatement pst = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private static ServicesDAOH2Impl instance;

    public static ServicesDAOH2Impl instance() {
        if (instance == null) {
            instance = new ServicesDAOH2Impl();
        }
        return instance;
    }

    private static final String GET_SERVICES_BY_ID = "SELECT * FROM services WHERE id = ?";

    private static final String UPDATE_SERVICE = String.format("UPDATE services SET %s = ?, %s = ?, %s = ? " +
            "WHERE id = ?", Services.SERVICE, Services.COST, Services.ID);

    private static final String DELETE_SERVICE_BY_ID = String.format("DELETE FROM services WHERE %s = ?;", Services.ID);


    private static final String INSERT_SERVICE = String.format("INSERT INTO services(%s, %s)" +
            " VALUES (?, ?);", Services.SERVICE, Services.COST);

    private static final String GET_ALL_SERVICES = "SELECT * FROM services";


    @Override
    public void addServices(Services services) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(INSERT_SERVICE);

            pst.setString(1, services.getServiceList().toString());
            pst.setInt(2, (int) services.getCost());
//            pst.setInt(3, services.getDuration());


            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public List<Services> getAllServices() {
        List<Services> servicesList = new ArrayList<>();

        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_SERVICES);

            while (rs.next()) {
                Services services = new Services();
                services.setId(rs.getInt(Services.ID));
                services.setServiceList(rs.getString(Services.SERVICE));
                services.setCost(rs.getInt(Services.COST));
                servicesList.add(services);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
        return servicesList;
    }

    @Override
    public Services findServicesById(int id) {
        Services services = new Services();

        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_SERVICES_BY_ID);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                services.setId(rs.getInt(Services.ID));
                services.setServiceList(rs.getString(Services.SERVICE));
                services.setCost(rs.getInt(Services.COST));
                services.setDuration(rs.getInt(Services.DURATION));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return services;
    }

    @Override
    public void deleteServices(int id) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(DELETE_SERVICE_BY_ID);
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            if (result == 0) {
                throw new ServicesNotFoundException();
            }
        } catch (ServicesNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public void updateServices(Services services) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(UPDATE_SERVICE);
            pst.setString(1, services.getServiceList().toString());
            pst.setDouble(2, services.getCost());
            pst.setInt(3, services.getId());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }


}
