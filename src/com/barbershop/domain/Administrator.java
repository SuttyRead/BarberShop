package com.barbershop.domain;

public class Administrator extends MasterHand {


    public Administrator() {
    }

    public Administrator(String firstName, String lastName, String middleName, String phoneNumber, String hiring, double experience) {
        super(firstName, lastName, middleName, phoneNumber, hiring, experience);
    }

    @Override
    public String toString() {
        return "Administrator(First name = " + getFirstName() + ", last name = " + getLastName() + "," +
                " middle name = " + getMiddleName() + ", phone number = " + getPhoneNumber() +
                ", hiring = " + getHiring() + ", experience = " + getExperience() + ")";
    }
}
