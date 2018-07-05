package com.barbershop.domain;

public class Order {

    public static final String ID = "id";
    public static final String CUSTOMER = "customer_id";
    public static final String MASTER_HAND = "master_hand_id";
    public static final String COST = "cost";
    public static final String SERVICES = "service_id";
    public static final String BEGINNING_OF_ADMISSION = "beginning_of_admission";
    public static final String END_OF_ADMISSION = "end_of_admission";

    private int id;
    private int customerId;
    private int masterHandId;
    private int cost;
    private int servicesId;
    private String 	beginningOfAdmission;
    private String 	endOfAdmission;

    public Order() {
    }

    public Order(int customerId, int masterHandId, int cost, int servicesId, String beginningOfAdmission, String endOfAdmission) {
        this.customerId = customerId;
        this.masterHandId = masterHandId;
        this.cost = cost;
        this.servicesId = servicesId;
        this.beginningOfAdmission = beginningOfAdmission;
        this.endOfAdmission = endOfAdmission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMasterHandId() {
        return masterHandId;
    }

    public void setMasterHandId(int masterHandId) {
        this.masterHandId = masterHandId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getServicesId() {
        return servicesId;
    }

    public void setServicesId(int servicesId) {
        this.servicesId = servicesId;
    }

    public String getBeginningOfAdmission() {
        return beginningOfAdmission;
    }

    public void setBeginningOfAdmission(String beginningOfAdmission) {
        this.beginningOfAdmission = beginningOfAdmission;
    }

    public String getEndOfAdmission() {
        return endOfAdmission;
    }

    public void setEndOfAdmission(String endOfAdmission) {
        this.endOfAdmission = endOfAdmission;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", masterHandId=" + masterHandId +
                ", cost=" + cost +
                ", servicesId=" + servicesId +
                ", beginningOfAdmission='" + beginningOfAdmission + '\'' +
                ", endOfAdmission='" + endOfAdmission + '\'' +
                '}';
    }
}
