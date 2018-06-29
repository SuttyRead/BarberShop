package com.barbershop.repository;

import com.barbershop.domain.Manicurist;

import java.util.List;

public interface ManicuristDAO {

    void addManicurist(Manicurist manicurist);

    List<Manicurist> getAllManicurist();

    Manicurist findManicurist(Manicurist manicurist);

    Manicurist findManicuristById(int id);

    void updateManicurist(Manicurist manicurist);

    void deleteManicurist(int id);

}
