package com.example.demo.shop.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Delivery extends Item {

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;


    public Delivery() {
    }

    public Delivery(Address address) {
        this.address = address;
    }
}
