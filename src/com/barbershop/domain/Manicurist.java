package com.barbershop.domain;

public class Manicurist extends MasterHand{



    public Manicurist() {
    }

    public Manicurist(String firstName, String lastName, String middleName, String phoneNumber, String hiring, double experience) {
        super(firstName, lastName, middleName, phoneNumber, hiring, experience);
    }

    @Override
    public String toString() {
        return "Manicurist(First name = " + getFirstName() + ", last name = " + getLastName() + "," +
                " middle name = " + getMiddleName() + ", phone number = " + getPhoneNumber() +
                ", hiring = " + getHiring() + ", experience = " + getExperience() + ")";
    }
}
