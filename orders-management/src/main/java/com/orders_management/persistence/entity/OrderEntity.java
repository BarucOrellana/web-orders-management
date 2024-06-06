package com.orders_management.persistence.entity;

public class OrderEntity {
    private int idOrder;
    private CustomerEntity customer;
    private DestinationEntity destination;
    private double otherCharges;
    private int invoice;
    private TruckEntity truck;
    private OperatorEntity operator;
    private boolean accepted;
    private boolean finished;
    private double fuel;
    private double tollbooth;
    private double otherExpenses;
    private double operatorCost;
}
