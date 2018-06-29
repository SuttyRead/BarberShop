package com;

import com.barbershop.domain.Administrator;
import com.barbershop.service.AdministratorService;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        AdministratorService administratorService = new AdministratorService();
//        Administrator administrator = new Administrator("Ivan", "Ivanov", "Petrovich", LocalDateTime.now().toString(),
//                LocalDateTime.now().toString(),5);
//        administratorService.addAdministrator(administrator);
        System.out.println(administratorService.getAllAdministrators());
        System.out.println();

//        System.out.println(administratorService.findAdministrator(new Administrator("Ivan", "Ivanov", "Petrovich")));
//        System.out.println(administratorService.findAdministratorById(1));
//        administratorService.deleteAdministrator(3);
    }
}
