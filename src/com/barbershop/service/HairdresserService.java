package com.barbershop.service;

import com.barbershop.domain.Hairdresser;
import com.barbershop.repository.impl.HairdresserDAOH2Impl;

import java.util.List;

public class HairdresserService {


    private HairdresserDAOH2Impl hairdresserDAOH2;

    public HairdresserService() {
        hairdresserDAOH2 = HairdresserDAOH2Impl.instance();
    }

    public void addHairdresser(Hairdresser hairdresser) {
        hairdresserDAOH2.addHairdresser(hairdresser);
    }

    public List<Hairdresser> getAllHairdresser() {
        return hairdresserDAOH2.getAllHairdresser();
    }

    public Hairdresser findHairdresser(Hairdresser hairdresser) {
        return hairdresserDAOH2.findHairdresser(hairdresser);
    }

    public Hairdresser findHairdresserById(int id) {
        return hairdresserDAOH2.findHairdresserById(id);
    }

    public void updateHairdresser(Hairdresser hairdresser) {
        hairdresserDAOH2.updateHairdresser(hairdresser);
    }

    public void deleteHairdresser(int id) {
        hairdresserDAOH2.deleteHairdresser(id);
    }



}
