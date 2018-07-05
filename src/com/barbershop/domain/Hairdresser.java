package com.barbershop.domain;

public class Hairdresser extends MasterHand{



    public Hairdresser() {
    }

    public Hairdresser(String firstName, String lastName, String middleName, String phoneNumber, String hiring, double experience) {
        super(firstName, lastName, middleName, phoneNumber, hiring, experience);
    }

    @Override
    public String toString() {
        return "Hairdresser(First name = " + getFirstName() + ", last name = " + getLastName() + "," +
                " middle name = " + getMiddleName() + ", phone number = " + getPhoneNumber() +
                ", hiring = " + getHiring() + ", experience = " + getExperience() + ")";
    }
}
