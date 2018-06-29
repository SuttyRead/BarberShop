package com.barbershop.repository;

import com.barbershop.domain.Administrator;

import java.util.List;

public interface AdministratorDAO {

    void addAdministrator(Administrator administrator);

    List<Administrator> getAllAdministrators();

    Administrator findAdministrator(Administrator administrator);

    Administrator findAdministratorById(int id);

    void updateAdministrator(Administrator administrator);

    void deleteAdministrator(int id);

}
