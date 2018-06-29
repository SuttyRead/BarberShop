package com.barbershop.domain;

public class CleaningWoman extends Person {

    public static final String HIRING = "hiring";
    public static final String EXPERIENCE = "experience";

    private String hiring;
    private double experience;

    public CleaningWoman() {
    }

    public CleaningWoman(String firstName, String lastName, String middleName) {
        super(firstName, lastName, middleName);
    }

    public CleaningWoman(String firstName, String lastName, String middleName, String yearOfBirthday, String hiring, double experience) {
        super(firstName, lastName, middleName, yearOfBirthday);
        this.hiring = hiring;
        this.experience = experience;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public String getHiring() {
        return hiring;
    }

    public void setHiring(String hiring) {
        this.hiring = hiring;
    }

    @Override
    public String toString() {
        return "CleaningWoman{" + super.toString() +
                "experience=" + experience +
                ", hiring=" + hiring +
                '}';
    }

}
