package com.example.demo.shop.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrew Han
 * @since 2019-10-05
 */
@Getter
@Setter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;
}
