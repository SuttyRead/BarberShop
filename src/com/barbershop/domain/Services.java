package com.barbershop.domain;

public class Services {

    public static final String ID = "id";
    public static final String SERVICE = "service";
    public static final String COST = "cost";
    public static final String DURATION = "duration";


    private int id;
    private ServiceList serviceList;
    private int cost;
    private int duration;

    public Services() {
    }

    public Services(int id, ServiceList serviceList, int cost, int duration) {
        this.id = id;
        this.serviceList = serviceList;
        this.cost = cost;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServiceList getServiceList() {
        return serviceList;
    }

    public void setServiceList(String serviceList) {
        this.serviceList = ServiceList.valueOf(serviceList);
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", serviceList=" + serviceList +
                ", cost=" + cost +
                ", duration=" + duration +
                '}';
    }
}
