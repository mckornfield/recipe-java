package com.recipe;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private final List<Ingredient> ingredients;
    private final List<String> steps;
    private final CookedFood cookedFood;

    public Recipe(List<Ingredient> ingredients, List<String> steps, CookedFood cookedFood) {
        this.ingredients = ingredients;
        this.steps = steps;
        this.cookedFood = cookedFood;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public CookedFood cook() {
        return cookedFood;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private List<Ingredient> ingredients = new ArrayList<>();
        private List<String> steps = new ArrayList<>();
        private CookedFood cookedFood;

        Builder withIngredient(String name, int number, Ingredient.ServingType servingType) {
            Ingredient ingredient = Ingredient.of(name, number, servingType);
            ingredients.add(ingredient);
            return this;
        }

        Builder step(String step) {
            steps.add(step);
            return this;
        }

        Builder makesFood(String foodName, int servingSize) {
            cookedFood = new CookedFood(foodName, servingSize);
            return this;
        }

        public Recipe build() throws RuntimeException {
            if (ingredients.isEmpty()) {
                throw new RuntimeException("All recipes require at least one ingredient");
            } else if (steps.isEmpty()) {
                throw new RuntimeException("All recipes require at least one step");
            } else if (null == cookedFood) {
                throw new RuntimeException("All recipes make at least one food");
            }
            return new Recipe(ingredients, steps, cookedFood);
        }
    }
}
