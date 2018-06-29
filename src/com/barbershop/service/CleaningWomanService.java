package com.barbershop.service;

import com.barbershop.domain.CleaningWoman;
import com.barbershop.repository.impl.CleaningWomanDAOH2Impl;

import java.util.List;

public class CleaningWomanService {



    private CleaningWomanDAOH2Impl cleaningWomanDAOH2;

    public CleaningWomanService() {
        cleaningWomanDAOH2 = CleaningWomanDAOH2Impl.instance();
    }

    public void addCleaningWoman(CleaningWoman cleaningWoman) {
        cleaningWomanDAOH2.addCleaningWoman(cleaningWoman);
    }

    public List<CleaningWoman> getAllCleaningWomen() {
        return cleaningWomanDAOH2.getAllCleaningWomen();
    }

    public CleaningWoman findCleaningWoman(CleaningWoman cleaningWoman) {
        return cleaningWomanDAOH2.findCleaningWoman(cleaningWoman);
    }

    public CleaningWoman findCleaningWomanById(int id) {
        return cleaningWomanDAOH2.findCleaningWomanById(id);
    }

    public void updateCleaningWoman(CleaningWoman cleaningWoman) {
        cleaningWomanDAOH2.updateCleaningWoman(cleaningWoman);
    }

    public void deleteCleaningWoman(int id) {
        cleaningWomanDAOH2.deleteCleaningWoman(id);
    }


}
