package com.example.demo.shop.domain;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
@Data
public class Album extends Item {

    private String artist;
    private String etc;

}
