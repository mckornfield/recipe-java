package com.recipe;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private final List<Ingredient> ingredients;
    private final List<Step> steps;
    private final CookedFood cookedFood;

    public Recipe(List<Ingredient> ingredients, List<Step> steps, CookedFood cookedFood) {
        this.ingredients = ingredients;
        this.steps = steps;
        this.cookedFood = cookedFood;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public CookedFood getCookedFood() {
        return cookedFood;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private List<Ingredient> ingredients = new ArrayList<>();
        private List<Step> steps = new ArrayList<>();
        private CookedFood cookedFood;

        Builder withIngredient(Ingredient newIngredient) {
            Ingredient ingredient = Ingredient.of(newIngredient);
            ingredients.add(ingredient);
            return this;
        }

        Builder withIngredient(String name, int number, Ingredient.ServingType servingType) {
            Ingredient ingredient = Ingredient.of(name, number, servingType);
            ingredients.add(ingredient);
            return this;
        }

        Builder step(Step.Action action, List<Ingredient> ingredientsForStep, Step.Container container) {
            Step step = new Step(action, ingredientsForStep, container);
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
