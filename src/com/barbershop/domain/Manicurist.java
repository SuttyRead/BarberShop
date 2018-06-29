package com.barbershop.domain;

public class Manicurist extends Person implements Speciality{

    public static final String HIRING = "hiring";
    public static final String EXPERIENCE = "experience";

    private String hiring;
    private double experience;

    public Manicurist() {
    }

    public Manicurist(String firstName, String lastName, String middleName) {
        super(firstName, lastName, middleName);
    }

    public Manicurist(String firstName, String lastName, String middleName, String yearOfBirthday, String hiring, double experience) {
        super(firstName, lastName, middleName, yearOfBirthday);
        this.hiring = hiring;
        this.experience = experience;
    }

    public String getHiring() {
        return hiring;
    }

    public void setHiring(String hiring) {
        this.hiring = hiring;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "ManicuristDAO{" + super.toString() +
                "hiring=" + hiring +
                ", experience=" + experience +
                '}';
    }

}
