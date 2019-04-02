package com.recipe.exception;

import com.recipe.Ingredient;

public class MissingFoodException extends RuntimeException {
    public MissingFoodException(String message) {
        super(message);
    }

    public MissingFoodException(Ingredient ingredient) {
        super("The ingredient is missing : " + ingredient.getIngredientIdentifier());
    }
}
