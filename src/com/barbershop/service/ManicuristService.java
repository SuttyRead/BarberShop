package com.barbershop.service;

import com.barbershop.domain.Manicurist;
import com.barbershop.repository.impl.ManicuristDAOH2Impl;

import java.util.List;

public class ManicuristService {

    private ManicuristDAOH2Impl manicuristDAOH2;

    public ManicuristService() {
        manicuristDAOH2 = ManicuristDAOH2Impl.instance();
    }

    public void addManicurist(Manicurist manicurist) {
        manicuristDAOH2.addManicurist(manicurist);
    }

    public List<Manicurist> getAllManicurists() {
        return manicuristDAOH2.getAllManicurist();
    }

    public Manicurist findManicurist(Manicurist manicurist) {
        return manicuristDAOH2.findManicurist(manicurist);
    }

    public Manicurist findManicuristById(int id) {
        return manicuristDAOH2.findManicuristById(id);
    }

    public void updateManicurist(Manicurist manicurist) {
        manicuristDAOH2.updateManicurist(manicurist);
    }

    public void deleteManicurist(int id) {
        manicuristDAOH2.deleteManicurist(id);
    }


}
