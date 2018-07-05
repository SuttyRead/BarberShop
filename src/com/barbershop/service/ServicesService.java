package com.barbershop.service;

import com.barbershop.domain.Services;
import com.barbershop.repository.impl.ServicesDAOH2Impl;

import java.util.List;

public class ServicesService {

    private ServicesDAOH2Impl servicesDAO;

    public ServicesService() {
        servicesDAO = ServicesDAOH2Impl.instance();
    }

    public List<Services> getAllServices() {
        return servicesDAO.getAllServices();
    }

    public void addServices(Services services) {
        servicesDAO.addServices(services);
    }

    public void deleteServices(int id) {
        servicesDAO.deleteServices(id);
    }

    public void updateServices(Services services) {
        servicesDAO.updateServices(services);
    }

    public Services findServicesById(int id) {
        return servicesDAO.findServicesById(id);
    }

}
