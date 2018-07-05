package com.barbershop.service;

import com.barbershop.domain.MasterHand;
import com.barbershop.repository.impl.MasterHandDAOH2Impl;

import java.util.List;

public class MasterHandService {

    private MasterHandDAOH2Impl masterHandDAOH2;

    public MasterHandService() {
        masterHandDAOH2 = MasterHandDAOH2Impl.instance();
    }

    public void addMasterHand(MasterHand masterHand) {
        masterHandDAOH2.addMasterHand(masterHand);
    }

    public List<MasterHand> getAllMasterHand() {
        return masterHandDAOH2.getAllMasterHand();
    }

    public MasterHand findMasterHand(MasterHand masterHand) {
        return masterHandDAOH2.findMasterHand(masterHand);
    }

    public MasterHand findMasterHandById(int id) {
        return masterHandDAOH2.findMasterHandById(id);
    }

    public void updateMasterHand(MasterHand masterHand) {
        masterHandDAOH2.updateMasterHand(masterHand);
    }

    public void deleteMasterHand(int id) {
        masterHandDAOH2.deleteMasterHand(id);
    }

}
