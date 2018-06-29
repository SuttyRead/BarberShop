package com.barbershop.service;

import com.barbershop.domain.Administrator;
import com.barbershop.repository.impl.AdministratorDAOH2Impl;

import java.util.List;

public class AdministratorService {

    private AdministratorDAOH2Impl administratorDAOH2;

    public AdministratorService() {
        administratorDAOH2 = AdministratorDAOH2Impl.instance();
    }

    public void addAdministrator(Administrator administrator) {
        administratorDAOH2.addAdministrator(administrator);
    }

    public List<Administrator> getAllAdministrators() {
        return administratorDAOH2.getAllAdministrators();
    }

    public Administrator findAdministrator(Administrator administrator) {
        return administratorDAOH2.findAdministrator(administrator);
    }

    public Administrator findAdministratorById(int id) {
        return administratorDAOH2.findAdministratorById(id);
    }

    public void updateAdministrator(Administrator administrator) {
        administratorDAOH2.updateAdministrator(administrator);
    }

    public void deleteAdministrator(int id) {
        administratorDAOH2.deleteAdministrator(id);
    }


}
