package com.barbershop.repository;

import com.barbershop.domain.CleaningWoman;

import java.util.List;

public interface CleaningWomanDAO {

    void addCleaningWoman(CleaningWoman cleaningWoman);

    List<CleaningWoman> getAllCleaningWomen();

    CleaningWoman findCleaningWoman(CleaningWoman cleaningWoman);

    CleaningWoman findCleaningWomanById(int id);

    void updateCleaningWoman(CleaningWoman cleaningWoman);

    void deleteCleaningWoman(int id);


}
