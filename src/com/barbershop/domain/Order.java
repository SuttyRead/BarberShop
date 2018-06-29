package com.barbershop.domain;

public class Order {

    private Customer customer;
    private MasterHand masterHand;
    private double cost;
    private Services services;
    private String 	beginningOfAdmission;
    private String 	endOfAdmission;

    public Order() {
    }

    public Order(Customer customer, MasterHand masterHand, double cost, Services services, String beginningOfAdmission, String endOfAdmission) {
        this.customer = customer;
        this.masterHand = masterHand;
        this.cost = cost;
        this.services = services;
        this.beginningOfAdmission = beginningOfAdmission;
        this.endOfAdmission = endOfAdmission;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", masterHand=" + masterHand +
                ", cost=" + cost +
                ", services=" + services +
                ", beginningOfAdmission='" + beginningOfAdmission + '\'' +
                ", endOfAdmission='" + endOfAdmission + '\'' +
                '}';
    }

}
