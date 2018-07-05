package com.barbershop.repository.impl;

import com.barbershop.domain.MasterHand;
import com.barbershop.exception.MasterHandNotFoundException;
import com.barbershop.repository.MasterHandDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.barbershop.repository.impl.ConnectionFactory.*;


public class MasterHandDAOH2Impl implements MasterHandDAO {

    private Connection connection;
    private PreparedStatement pst = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private static MasterHandDAOH2Impl instance;

    public static MasterHandDAOH2Impl instance() {
        if (instance == null) {
            instance = new MasterHandDAOH2Impl();
        }
        return instance;
    }

    private static final String INSERT_MASTER_HAND = String.format("INSERT INTO master_hands(%s, %s, %s, %s, %s, %s)" +
            " VALUES (?, ?, ?, ?, ?, ?);", MasterHand.FIRST_NAME, MasterHand.LAST_NAME, MasterHand.MIDDLE_NAME, MasterHand.PHONE_NUMBER, MasterHand.HIRING, MasterHand.EXPERIENCE);

    private static final String GET_ALL_MASTER_HANDS = "SELECT * FROM master_hands";

    private static final String DELETE_MASTER_HAND_BY_ID = String.format("DELETE FROM master_hands WHERE %s = ?;", MasterHand.ID);

    private static final String GET_MASTER_HAND_BY_ID = "SELECT * FROM master_hands WHERE id = ?";

    private static final String GET_MASTER_HAND_BY_NAME = "SELECT * FROM master_hands WHERE first_name = ? and last_name = ? and middle_name = ?";

    private static final String UPDATE_MASTER_HAND = String.format("UPDATE master_hands SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? " +
            "WHERE id = ?", MasterHand.FIRST_NAME, MasterHand.LAST_NAME, MasterHand.MIDDLE_NAME, MasterHand.PHONE_NUMBER, MasterHand.HIRING, MasterHand.EXPERIENCE);


    @Override
    public void addMasterHand(MasterHand masterHand) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(INSERT_MASTER_HAND);

            pst.setString(1, masterHand.getFirstName());
            pst.setString(2, masterHand.getLastName());
            pst.setString(3, masterHand.getMiddleName());
            pst.setString(4, masterHand.getPhoneNumber());
            pst.setString(5, masterHand.getHiring());
            pst.setDouble(6, masterHand.getExperience());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public List<MasterHand> getAllMasterHand() {
        List<MasterHand> masterHands = new ArrayList<>();

        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_MASTER_HANDS);

            while (rs.next()) {
                MasterHand masterHand = new MasterHand();
                masterHand.setId(rs.getInt(MasterHand.ID));
                masterHand.setFirstName(rs.getString(MasterHand.FIRST_NAME));
                masterHand.setLastName(rs.getString(MasterHand.LAST_NAME));
                masterHand.setMiddleName(rs.getString(MasterHand.MIDDLE_NAME));
                masterHand.setPhoneNumber(rs.getString(MasterHand.PHONE_NUMBER));
                masterHand.setHiring(rs.getString(MasterHand.HIRING));
                masterHand.setExperience(rs.getDouble(MasterHand.EXPERIENCE));
                masterHands.add(masterHand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
        return masterHands;
    }

    @Override
    public MasterHand findMasterHand(MasterHand masterHand) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_MASTER_HAND_BY_NAME);
            pst.setString(1, masterHand.getFirstName());
            pst.setString(2, masterHand.getLastName());
            pst.setString(3, masterHand.getMiddleName());
            rs = pst.executeQuery();

            while (rs.next()) {
                masterHand.setId(rs.getInt(MasterHand.ID));
                masterHand.setFirstName(rs.getString(MasterHand.FIRST_NAME));
                masterHand.setLastName(rs.getString(MasterHand.LAST_NAME));
                masterHand.setMiddleName(rs.getString(MasterHand.MIDDLE_NAME));
                masterHand.setPhoneNumber(rs.getString(MasterHand.PHONE_NUMBER));
                masterHand.setHiring(rs.getString(MasterHand.HIRING));
                masterHand.setExperience(rs.getDouble(MasterHand.EXPERIENCE));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return masterHand;
    }

    @Override
    public MasterHand findMasterHandById(int id) {
        MasterHand masterHand = new MasterHand();

        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_MASTER_HAND_BY_ID);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                masterHand.setId(rs.getInt(MasterHand.ID));
                masterHand.setFirstName(rs.getString(MasterHand.FIRST_NAME));
                masterHand.setLastName(rs.getString(MasterHand.LAST_NAME));
                masterHand.setMiddleName(rs.getString(MasterHand.MIDDLE_NAME));
                masterHand.setPhoneNumber(rs.getString(MasterHand.PHONE_NUMBER));
                masterHand.setHiring(rs.getString(MasterHand.HIRING));
                masterHand.setExperience(rs.getDouble(MasterHand.EXPERIENCE));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return masterHand;
    }

    @Override
    public void updateMasterHand(MasterHand masterHand) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(UPDATE_MASTER_HAND);
            pst.setString(1, masterHand.getFirstName());
            pst.setString(2, masterHand.getLastName());
            pst.setString(3, masterHand.getMiddleName());
            pst.setString(4, masterHand.getPhoneNumber());
            pst.setString(5, masterHand.getHiring());
            pst.setDouble(6, masterHand.getExperience());
            pst.setInt(7, masterHand.getId());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public void deleteMasterHand(int id) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(DELETE_MASTER_HAND_BY_ID);
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            if (result == 0) {
                throw new MasterHandNotFoundException();
            }
        } catch (MasterHandNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }


}
