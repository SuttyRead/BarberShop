package com;

import com.barbershop.controller.MainController;
import com.barbershop.domain.*;
import com.barbershop.repository.CreateTable;
import com.barbershop.repository.impl.CreateTableDAOH2Impl;
import com.barbershop.repository.impl.ManicuristDAOH2Impl;
import com.barbershop.repository.impl.OrderDAOH2Impl;
import com.barbershop.service.*;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        MainController mainController = new MainController();
        mainController.doWork();




//        AdministratorService administratorService = new AdministratorService();
//        Administrator administrator = new Administrator("Ivan", "Ivanov", "Petrovich", LocalDateTime.now().toString(),
//                LocalDateTime.now().toString(),5);
//        administratorService.addAdministrator(administrator);
//        System.out.println(administratorService.getAllAdministrators());
//        System.out.println();
//        System.out.println();

//        System.out.println(administratorService.findAdministrator(new Administrator("Ivan", "Ivanov", "Petrovich")));
//        System.out.println(administratorService.findAdministratorById(1));
//        administratorService.deleteAdministrator(3);

//        ServicesService servicesService = new ServicesService();
//        System.out.println(servicesService.getAllServices());

//
//        OrderDAOH2Impl orderDAOH2 = new OrderDAOH2Impl();
//        MasterHand masterHand1 = new MasterHand();
//        OrderService orderService = new OrderService();
//
//        Customer customer = new Customer();
//        customer.setFirstName("Ivan");
//        customer.setLastName("Ivanov");
//        customer.setMiddleName("Petrovich");
//        customer.setPhoneNumber("123467876");
//

//        MasterHandService masterHandService = new MasterHandService();
//        HairdresserService hairdresserService = new HairdresserService();
//
//        MasterHand masterHand = new Hairdresser();
//        masterHand.setFirstName("Ann");
//        masterHand.setLastName("Mill");
//        masterHand.setMiddleName("Ivanovna");
//        masterHand.setPhoneNumber("97644567");
//        masterHand.setExperience(4);
//        masterHand.setHiring(LocalDateTime.now().toString());
//
//        hairdresserService.addHairdresser((Hairdresser) masterHand);
//
//        System.out.println(masterHandService.getAllMasterHand());
//        System.out.println();
//        System.out.println(hairdresserService.getAllHairdresser());

//
//        ServicesService servicesService = new ServicesService();
//        Services services = new Services();
//        services.setServiceList(ServiceList.HAIRCUT.toString());
//        services.setDuration(1);
//        services.setCost(200);
//        servicesService.addServices(services);
//
//        System.out.println(servicesService.getAllServices());

//
//        Order order = new Order();
//        order.setCustomerId(customer);
//        order.setMasterHandId(masterHand);
//        order.setServicesId(services);
//
//        LocalDateTime localDateTime = LocalDateTime.now();
//        order.setBeginningOfAdmission(localDateTime.toString());
//        order.setEndOfAdmission(localDateTime.plusHours(services.getDuration()).toString());
//
//        orderService.addOrder(order);
//
//        System.out.println(orderService.getAllOrders());

    }
}
