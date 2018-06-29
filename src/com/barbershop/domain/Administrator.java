package com.barbershop.domain;

public class Administrator extends Person {

    public static final String HIRING = "hiring";
    public static final String EXPERIENCE = "experience";

    private String hiring;
    private double experience;

    public Administrator() {
    }

    public Administrator(String firstName, String lastName, String middleName) {
        super(firstName, lastName, middleName);
    }

    public Administrator(String firstName, String lastName, String middleName, String yearOfBirthday, String hiring, double experience) {
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
        return "Administrator{" + super.toString() +
                "hiring=" + hiring +
                ", experience=" + experience +
                '}';
    }

}
