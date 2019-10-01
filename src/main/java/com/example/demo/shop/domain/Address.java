package com.example.demo.shop.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {

    private String city;
    private String street;
    private String zipcode;

}
