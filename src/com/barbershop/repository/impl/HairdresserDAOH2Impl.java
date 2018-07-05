package com.barbershop.repository.impl;

import com.barbershop.domain.Hairdresser;
import com.barbershop.exception.HairdresserNotFoundException;
import com.barbershop.repository.HairdresserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.barbershop.repository.impl.ConnectionFactory.*;

public class HairdresserDAOH2Impl implements HairdresserDAO {

    private Connection connection;
    private PreparedStatement pst = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private static HairdresserDAOH2Impl instance;

    public static HairdresserDAOH2Impl instance() {
        if (instance == null) {
            instance = new HairdresserDAOH2Impl();
        }
        return instance;
    }

    private static final String INSERT_HAIRDRESSER = String.format("INSERT INTO hairdressers(%s, %s, %s, %s, %s, %s)" +
            " VALUES (?, ?, ?, ?, ?, ?);", Hairdresser.FIRST_NAME, Hairdresser.LAST_NAME, Hairdresser.MIDDLE_NAME, Hairdresser.PHONE_NUMBER, Hairdresser.HIRING, Hairdresser.EXPERIENCE);

    private static final String GET_ALL_HAIRDRESSERS = "SELECT * FROM hairdressers";

    private static final String DELETE_HAIRDRESSER_BY_ID = String.format("DELETE FROM hairdressers WHERE %s = ?;", Hairdresser.ID);

    private static final String GET_HAIRDRESSER_BY_ID = "SELECT * FROM hairdressers WHERE id = ?";

    private static final String GET_HAIRDRESSER_BY_NAME = "SELECT * FROM hairdressers WHERE first_name = ? and last_name = ? and middle_name = ?";

    private static final String UPDATE_HAIRDRESSER = String.format("UPDATE hairdressers SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? " +
            "WHERE id = ?", Hairdresser.FIRST_NAME, Hairdresser.LAST_NAME, Hairdresser.MIDDLE_NAME, Hairdresser.PHONE_NUMBER, Hairdresser.HIRING, Hairdresser.EXPERIENCE);



    @Override
    public void addHairdresser(Hairdresser hairdresser) {
        MasterHandDAOH2Impl masterHandDAOH2 = new MasterHandDAOH2Impl();
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(INSERT_HAIRDRESSER);

            pst.setString(1, hairdresser.getFirstName());
            pst.setString(2, hairdresser.getLastName());
            pst.setString(3, hairdresser.getMiddleName());
            pst.setString(4, hairdresser.getPhoneNumber().toString());
            pst.setString(5, hairdresser.getHiring().toString());
            pst.setDouble(6, hairdresser.getExperience());

            pst.execute();

            masterHandDAOH2.addMasterHand(hairdresser);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public List<Hairdresser> getAllHairdresser() {
        List<Hairdresser> hairdressers = new ArrayList<>();

        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_HAIRDRESSERS);

            while (rs.next()) {
                Hairdresser hairdresser = new Hairdresser();
                hairdresser.setId(rs.getInt(Hairdresser.ID));
                hairdresser.setFirstName(rs.getString(Hairdresser.FIRST_NAME));
                hairdresser.setLastName(rs.getString(Hairdresser.LAST_NAME));
                hairdresser.setMiddleName(rs.getString(Hairdresser.MIDDLE_NAME));
                hairdresser.setPhoneNumber(rs.getString(Hairdresser.PHONE_NUMBER));
                hairdresser.setHiring(rs.getString(Hairdresser.HIRING));
                hairdresser.setExperience(rs.getDouble(Hairdresser.EXPERIENCE));
                hairdressers.add(hairdresser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
        return hairdressers;
    }

    @Override
    public Hairdresser findHairdresser(Hairdresser hairdresser) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_HAIRDRESSER_BY_NAME);
            pst.setString(1, hairdresser.getFirstName());
            pst.setString(2, hairdresser.getLastName());
            pst.setString(3, hairdresser.getMiddleName());
            rs = pst.executeQuery();

            while (rs.next()) {
                hairdresser.setId(rs.getInt(Hairdresser.ID));
                hairdresser.setFirstName(rs.getString(Hairdresser.FIRST_NAME));
                hairdresser.setLastName(rs.getString(Hairdresser.LAST_NAME));
                hairdresser.setMiddleName(rs.getString(Hairdresser.MIDDLE_NAME));
                hairdresser.setPhoneNumber(rs.getString(Hairdresser.PHONE_NUMBER));
                hairdresser.setHiring(rs.getString(Hairdresser.HIRING));
                hairdresser.setExperience(rs.getDouble(Hairdresser.EXPERIENCE));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return hairdresser;
    }

    @Override
    public Hairdresser findHairdresserById(int id) {
        Hairdresser hairdresser = new Hairdresser();

        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_HAIRDRESSER_BY_ID);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                hairdresser.setId(rs.getInt(Hairdresser.ID));
                hairdresser.setFirstName(rs.getString(Hairdresser.FIRST_NAME));
                hairdresser.setLastName(rs.getString(Hairdresser.LAST_NAME));
                hairdresser.setMiddleName(rs.getString(Hairdresser.MIDDLE_NAME));
                hairdresser.setPhoneNumber(rs.getString(Hairdresser.PHONE_NUMBER));
                hairdresser.setHiring(rs.getString(Hairdresser.HIRING));
                hairdresser.setExperience(rs.getDouble(Hairdresser.EXPERIENCE));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return hairdresser;
    }

    @Override
    public void updateHairdresser(Hairdresser hairdresser) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(UPDATE_HAIRDRESSER);
            pst.setString(1, hairdresser.getFirstName());
            pst.setString(2, hairdresser.getLastName());
            pst.setString(3, hairdresser.getMiddleName());
            pst.setString(4, hairdresser.getPhoneNumber());
            pst.setString(5, hairdresser.getHiring());
            pst.setDouble(6, hairdresser.getExperience());
            pst.setInt(7, hairdresser.getId());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public void deleteHairdresser(int id) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(DELETE_HAIRDRESSER_BY_ID);
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            if (result == 0) {
                throw new HairdresserNotFoundException();
            }
        } catch (HairdresserNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }



}
