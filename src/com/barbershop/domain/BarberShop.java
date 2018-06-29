package com.barbershop.domain;

public class BarberShop {

    private Owner owner;
    private Administrator administrator;
    private CleaningWoman cleaningWoman;
    private Hairdresser hairdresser;
    private Manicurist manicurist;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public CleaningWoman getCleaningWoman() {
        return cleaningWoman;
    }

    public void setCleaningWoman(CleaningWoman cleaningWoman) {
        this.cleaningWoman = cleaningWoman;
    }

    public Hairdresser getHairdresser() {
        return hairdresser;
    }

    public void setHairdresser(Hairdresser hairdresser) {
        this.hairdresser = hairdresser;
    }

    public Manicurist getManicurist() {
        return manicurist;
    }

    public void setManicurist(Manicurist manicurist) {
        this.manicurist = manicurist;
    }

    @Override
    public String toString() {
        return "BarberShop{" +
                "owner=" + owner +
                ", administrator=" + administrator +
                ", cleaningWoman=" + cleaningWoman +
                ", hairdresser=" + hairdresser +
                ", manicurist=" + manicurist +
                '}';
    }

}
