package com.barbershop.repository;

import com.barbershop.domain.CleaningWoman;
import com.barbershop.domain.Hairdresser;

import java.util.List;

public interface HairdresserDAO {

    void addHairdresser(Hairdresser hairdresser);

    List<Hairdresser> getAllHairdresser();

    Hairdresser findHairdresser(Hairdresser hairdresser);

    Hairdresser findHairdresserById(int id);

    void updateHairdresser(Hairdresser hairdresser);

    void deleteHairdresser(int id);


}
