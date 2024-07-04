package com.orders_management.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "destination")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DestinationEntity {
    @Id
    @Column(name = "id_destination", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDestination;
    @Column(length = 50, nullable = false)
    private String destination;
    @Column(name = "1 TON", columnDefinition = "TINYINT")
    private boolean kg1000;
    @Column(name = "3 TON", columnDefinition = "TINYINT")
    private boolean kg3000;
    @Column(name = "5 TON", columnDefinition = "TINYINT")
    private boolean kg5000;
    @Column(name = "10 TON", columnDefinition = "TINYINT")
    private boolean kg10000;
    @Column(name = "15 TON", columnDefinition = "TINYINT")
    private boolean kg15000;
    @Column(nullable = false)
    private double price;
    @OneToMany(mappedBy = "destination", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderEntity> order;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "customer_destination",
            joinColumns = @JoinColumn(name = "destination_id", referencedColumnName = "id_destination"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id_customer"))
    private List<CustomerEntity> customers;
}
