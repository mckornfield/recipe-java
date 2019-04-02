package com.recipe;

import com.recipe.exception.NotEnoughFoodException;

import java.util.Objects;

public class Ingredient {
    enum ServingType {EACH, CUP, POUND, TABLESPOON, TSP}

    private double amount;
    private final String ingredientName;
    private final ServingType servingType;


    private Ingredient(String ingredientName, double amount, ServingType servingType) {
        this.amount = amount;
        this.ingredientName = ingredientName;
        this.servingType = servingType;
    }

    public static Ingredient of(String ingredientName, double amount, ServingType servingType) {
        return new Ingredient(ingredientName, amount, servingType);
    }

    public static Ingredient of(Ingredient ingredient) {
        return new Ingredient(ingredient.getIngredientName(), ingredient.getAmount(), ingredient.getServingType());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return amount == that.amount &&
            Objects.equals(ingredientName, that.ingredientName) &&
            servingType == that.servingType;
    }

    public double getAmount() {
        return amount;
    }

    public double addAmount(double addedAmount) {
        this.amount += addedAmount;
        return this.amount;
    }

    public double removeAmount(double removedAmount) {
        double newAmount = this.amount - removedAmount;
        if (newAmount < 0) {
            throw new NotEnoughFoodException();
        }
        this.amount = newAmount;
        return this.amount;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public ServingType getServingType() {
        return servingType;
    }

    public String getIngredientIdentifier() {
        return ingredientName + "-" + servingType;
    }

    public boolean areOfSameItemAndQuantity(Ingredient other){
        return getIngredientIdentifier().equals(other.getIngredientIdentifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, ingredientName, servingType);
    }
}
