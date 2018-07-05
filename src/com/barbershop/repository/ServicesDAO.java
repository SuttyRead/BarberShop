package com.barbershop.repository;

import com.barbershop.domain.Services;

import java.util.List;

public interface ServicesDAO {

    List<Services> getAllServices();

    Services findServicesById(int id);

    void addServices(Services services);

    void deleteServices(int id);

    void updateServices(Services services);

}
