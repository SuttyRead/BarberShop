package com.barbershop.repository.impl;

import com.barbershop.domain.Manicurist;
import com.barbershop.exception.ManicuristNotFoundException;
import com.barbershop.repository.ManicuristDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.barbershop.repository.impl.ConnectionFactory.*;

public class ManicuristDAOH2Impl implements ManicuristDAO {

    private Connection connection;
    private PreparedStatement pst = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private static ManicuristDAOH2Impl instance;

    public static ManicuristDAOH2Impl instance() {
        if (instance == null) {
            instance = new ManicuristDAOH2Impl();
        }
        return instance;
    }

    private static final String CREATE_MANICURIST_TABLE = "CREATE TABLE IF NOT EXISTS manicurists (" +
            Manicurist.ID + " INT(11) PRIMARY KEY AUTO_INCREMENT," +
            Manicurist.FIRST_NAME + " VARCHAR(255)," +
            Manicurist.LAST_NAME + " VARCHAR(255)," +
            Manicurist.MIDDLE_NAME + " VARCHAR(255)," +
            Manicurist.YEAR_OF_BIRTHDAY + " VARCHAR(255)," +
            Manicurist.HIRING + " VARCHAR(255)," +
            Manicurist.EXPERIENCE + " DOUBLE(4)," +
            ");";

    private static final String INSERT_MANICURIST = String.format("INSERT INTO manicurists(%s, %s, %s, %s, %s, %s)" +
            " VALUES (?, ?, ?, ?, ?, ?);", Manicurist.FIRST_NAME, Manicurist.LAST_NAME, Manicurist.MIDDLE_NAME, Manicurist.YEAR_OF_BIRTHDAY, Manicurist.HIRING, Manicurist.EXPERIENCE);

    private static final String GET_ALL_MANICURISTS = "SELECT * FROM manicurists";

    private static final String DELETE_MANICURIST_BY_ID = String.format("DELETE FROM manicurists WHERE %s = ?;", Manicurist.ID);

    private static final String GET_MANICURIST_BY_ID = "SELECT * FROM manicurists WHERE id = ?";

    private static final String GET_MANICURIST_BY_NAME = "SELECT * FROM manicurists WHERE first_name = ? and last_name = ? and middle_name = ?";

    private static final String UPDATE_MANICURIST = String.format("UPDATE manicurists SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? " +
            "WHERE id = ?", Manicurist.FIRST_NAME, Manicurist.LAST_NAME, Manicurist.MIDDLE_NAME, Manicurist.YEAR_OF_BIRTHDAY, Manicurist.HIRING, Manicurist.EXPERIENCE);

    public ManicuristDAOH2Impl() {
        createTableIfNotExists();
    }

    @Override
    public void addManicurist(Manicurist manicurist) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(INSERT_MANICURIST);

            pst.setString(1, manicurist.getFirstName());
            pst.setString(2, manicurist.getLastName());
            pst.setString(3, manicurist.getMiddleName());
            pst.setString(4, manicurist.getYearOfBirthday().toString());
            pst.setString(5, manicurist.getHiring().toString());
            pst.setDouble(6, manicurist.getExperience());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public List<Manicurist> getAllManicurist() {
        List<Manicurist> manicurists = new ArrayList<>();

        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_MANICURISTS);

            while (rs.next()) {
                Manicurist manicurist = new Manicurist();
                manicurist.setId(rs.getInt(Manicurist.ID));
                manicurist.setFirstName(rs.getString(Manicurist.FIRST_NAME));
                manicurist.setLastName(rs.getString(Manicurist.LAST_NAME));
                manicurist.setMiddleName(rs.getString(Manicurist.MIDDLE_NAME));
                manicurist.setYearOfBirthday(rs.getString(Manicurist.YEAR_OF_BIRTHDAY));
                manicurist.setHiring(rs.getString(Manicurist.HIRING));
                manicurist.setExperience(rs.getDouble(Manicurist.EXPERIENCE));
                manicurists.add(manicurist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
        return manicurists;
    }

    @Override
    public Manicurist findManicurist(Manicurist manicurist) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_MANICURIST_BY_NAME);
            pst.setString(1, manicurist.getFirstName());
            pst.setString(2, manicurist.getLastName());
            pst.setString(3, manicurist.getMiddleName());
            rs = pst.executeQuery();

            while (rs.next()) {
                manicurist.setId(rs.getInt(Manicurist.ID));
                manicurist.setFirstName(rs.getString(Manicurist.FIRST_NAME));
                manicurist.setLastName(rs.getString(Manicurist.LAST_NAME));
                manicurist.setMiddleName(rs.getString(Manicurist.MIDDLE_NAME));
                manicurist.setYearOfBirthday(rs.getString(Manicurist.YEAR_OF_BIRTHDAY));
                manicurist.setHiring(rs.getString(Manicurist.HIRING));
                manicurist.setExperience(rs.getDouble(Manicurist.EXPERIENCE));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return manicurist;
    }

    @Override
    public Manicurist findManicuristById(int id) {
        Manicurist manicurist = new Manicurist();

        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_MANICURIST_BY_ID);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                manicurist.setId(rs.getInt(Manicurist.ID));
                manicurist.setFirstName(rs.getString(Manicurist.FIRST_NAME));
                manicurist.setLastName(rs.getString(Manicurist.LAST_NAME));
                manicurist.setMiddleName(rs.getString(Manicurist.MIDDLE_NAME));
                manicurist.setYearOfBirthday(rs.getString(Manicurist.YEAR_OF_BIRTHDAY));
                manicurist.setHiring(rs.getString(Manicurist.HIRING));
                manicurist.setExperience(rs.getDouble(Manicurist.EXPERIENCE));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return manicurist;
    }

    @Override
    public void updateManicurist(Manicurist manicurist) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(UPDATE_MANICURIST);
            pst.setString(1, manicurist.getFirstName());
            pst.setString(2, manicurist.getLastName());
            pst.setString(3, manicurist.getMiddleName());
            pst.setString(4, manicurist.getYearOfBirthday());
            pst.setString(5, manicurist.getHiring());
            pst.setDouble(6, manicurist.getExperience());
            pst.setInt(7, manicurist.getId());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public void deleteManicurist(int id) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(DELETE_MANICURIST_BY_ID);
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            if (result == 0) {
                throw new ManicuristNotFoundException();
            }
        } catch (ManicuristNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    private void createTableIfNotExists() {
        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(CREATE_MANICURIST_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
    }

}
