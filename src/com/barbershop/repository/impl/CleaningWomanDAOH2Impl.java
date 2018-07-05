package com.barbershop.repository.impl;

import com.barbershop.domain.CleaningWoman;
import com.barbershop.exception.CleaningWomanNotFoundException;
import com.barbershop.repository.CleaningWomanDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.barbershop.repository.impl.ConnectionFactory.*;

public class CleaningWomanDAOH2Impl implements CleaningWomanDAO {

    private Connection connection;
    private PreparedStatement pst = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private static CleaningWomanDAOH2Impl instance;

    public static CleaningWomanDAOH2Impl instance() {
        if (instance == null) {
            instance = new CleaningWomanDAOH2Impl();
        }
        return instance;
    }

    private static final String INSERT_CLEANING_WOMAN = String.format("INSERT INTO cleaning_women(%s, %s, %s, %s, %s, %s)" +
            " VALUES (?, ?, ?, ?, ?, ?);", CleaningWoman.FIRST_NAME, CleaningWoman.LAST_NAME, CleaningWoman.MIDDLE_NAME, CleaningWoman.PHONE_NUMBER, CleaningWoman.HIRING, CleaningWoman.EXPERIENCE);

    private static final String GET_ALL_CLEANING_WOMEN = "SELECT * FROM cleaning_women";

    private static final String DELETE_CLEANING_WOMAN_BY_ID = String.format("DELETE FROM cleaning_women WHERE %s = ?;", CleaningWoman.ID);

    private static final String GET_CLEANING_WOMAN_BY_ID = "SELECT * FROM cleaning_women WHERE id = ?";

    private static final String GET_CLEANING_WOMAN_BY_NAME = "SELECT * FROM cleaning_women WHERE first_name = ? and last_name = ? and middle_name = ?";

    private static final String UPDATE_CLEANING_WOMAN = String.format("UPDATE cleaning_women SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? " +
            "WHERE id = ?", CleaningWoman.FIRST_NAME, CleaningWoman.LAST_NAME, CleaningWoman.MIDDLE_NAME, CleaningWoman.PHONE_NUMBER, CleaningWoman.HIRING, CleaningWoman.EXPERIENCE);



    @Override
    public void addCleaningWoman(CleaningWoman cleaningWoman) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(INSERT_CLEANING_WOMAN);

            pst.setString(1, cleaningWoman.getFirstName());
            pst.setString(2, cleaningWoman.getLastName());
            pst.setString(3, cleaningWoman.getMiddleName());
            pst.setString(4, cleaningWoman.getPhoneNumber());
            pst.setString(5, cleaningWoman.getHiring());
            pst.setDouble(6, cleaningWoman.getExperience());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public List<CleaningWoman> getAllCleaningWomen() {
        List<CleaningWoman> cleaningWomen = new ArrayList<>();

        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_CLEANING_WOMEN);

            while (rs.next()) {
                CleaningWoman cleaningWoman = new CleaningWoman();
                cleaningWoman.setId(rs.getInt(CleaningWoman.ID));
                cleaningWoman.setFirstName(rs.getString(CleaningWoman.FIRST_NAME));
                cleaningWoman.setLastName(rs.getString(CleaningWoman.LAST_NAME));
                cleaningWoman.setMiddleName(rs.getString(CleaningWoman.MIDDLE_NAME));
                cleaningWoman.setPhoneNumber(rs.getString(CleaningWoman.PHONE_NUMBER));
                cleaningWoman.setHiring(rs.getString(CleaningWoman.HIRING));
                cleaningWoman.setExperience(rs.getDouble(CleaningWoman.EXPERIENCE));
                cleaningWomen.add(cleaningWoman);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
        return cleaningWomen;
    }

    @Override
    public CleaningWoman findCleaningWoman(CleaningWoman cleaningWoman) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_CLEANING_WOMAN_BY_NAME);
            pst.setString(1, cleaningWoman.getFirstName());
            pst.setString(2, cleaningWoman.getLastName());
            pst.setString(3, cleaningWoman.getMiddleName());
            rs = pst.executeQuery();

            while (rs.next()) {
                cleaningWoman.setId(rs.getInt(CleaningWoman.ID));
                cleaningWoman.setFirstName(rs.getString(CleaningWoman.FIRST_NAME));
                cleaningWoman.setLastName(rs.getString(CleaningWoman.LAST_NAME));
                cleaningWoman.setMiddleName(rs.getString(CleaningWoman.MIDDLE_NAME));
                cleaningWoman.setPhoneNumber(rs.getString(CleaningWoman.PHONE_NUMBER));
                cleaningWoman.setHiring(rs.getString(CleaningWoman.HIRING));
                cleaningWoman.setExperience(rs.getDouble(CleaningWoman.EXPERIENCE));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return cleaningWoman;
    }

    @Override
    public CleaningWoman findCleaningWomanById(int id) {
        CleaningWoman cleaningWoman = new CleaningWoman();

        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_CLEANING_WOMAN_BY_ID);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                cleaningWoman.setId(rs.getInt(CleaningWoman.ID));
                cleaningWoman.setFirstName(rs.getString(CleaningWoman.FIRST_NAME));
                cleaningWoman.setLastName(rs.getString(CleaningWoman.LAST_NAME));
                cleaningWoman.setMiddleName(rs.getString(CleaningWoman.MIDDLE_NAME));
                cleaningWoman.setPhoneNumber(rs.getString(CleaningWoman.PHONE_NUMBER));
                cleaningWoman.setHiring(rs.getString(CleaningWoman.HIRING));
                cleaningWoman.setExperience(rs.getDouble(CleaningWoman.EXPERIENCE));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return cleaningWoman;
    }

    @Override
    public void updateCleaningWoman(CleaningWoman cleaningWoman) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(UPDATE_CLEANING_WOMAN);
            pst.setString(1, cleaningWoman.getFirstName());
            pst.setString(2, cleaningWoman.getLastName());
            pst.setString(3, cleaningWoman.getMiddleName());
            pst.setString(4, cleaningWoman.getPhoneNumber());
            pst.setString(5, cleaningWoman.getHiring());
            pst.setDouble(6, cleaningWoman.getExperience());
            pst.setInt(7, cleaningWoman.getId());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public void deleteCleaningWoman(int id) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(DELETE_CLEANING_WOMAN_BY_ID);
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            if (result == 0){
                throw  new CleaningWomanNotFoundException();
            }
        } catch (CleaningWomanNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }


}
