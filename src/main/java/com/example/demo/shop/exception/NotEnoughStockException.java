package com.example.demo.shop.exception;

/**
 * @author Andrew Han
 * @since 2019-10-05
 */
public class NotEnoughStockException extends RuntimeException {

    public NotEnoughStockException(String message) {
        super(message);
    }
}
