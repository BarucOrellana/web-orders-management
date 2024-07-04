package com.orders_management.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @Column(name = "id_order", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;
    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate date;
    @Column(name = "id_customer", nullable = false)
    private int idCustomer;
    @Column(name = "destination", length = 50, nullable = false)
    private String destinationName;
    @Column(name = "id_truck")
    private int idTruck;
    @Column(name = "id_operator")
    private int idOperator;
    @Column(name = "other_charges")
    private double otherCharges;
    @Column
    private int invoice;
    @Column(columnDefinition = "TINYINT")
    private boolean accepted;
    @Column(columnDefinition = "TINYINT")
    private boolean finished;
    @Column
    private double fuel;
    @Column
    private double tollbooth;
    @Column(name = "other_expenses")
    private double otherExpenses;
    @Column(name = "operator_cost")
    private double operatorCost;
    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
    private CustomerEntity customer;
    @ManyToOne
    @JoinColumn(name = "id_destination", referencedColumnName = "id_destination", insertable = false, updatable = false)
    private DestinationEntity destination;
    @ManyToOne
    @JoinColumn(name = "id_truck", referencedColumnName = "id_truck", insertable = false, updatable = false)
    private TruckEntity truck;
    @ManyToOne
    @JoinColumn(name = "id_operator", referencedColumnName = "id_operator", insertable = false, updatable = false)
    private OperatorEntity operator;
}
