package com.recipe.exception;

public class NotEnoughFoodException extends RuntimeException {
    public NotEnoughFoodException(String message) {
        super(message);
    }
}
