package com.recipe;

import com.recipe.exception.MissingFoodException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kitchen {
    private final List<Ingredient> ingredientsInKitchen = new ArrayList<>();
    private final Map<String, Ingredient> mapOfIngredients = new HashMap<>();

    void useIngredients(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            String ingredientIdentifier = ingredient.getIngredientIdentifier();
            if (mapOfIngredients.containsKey(ingredientIdentifier)) {
                mapOfIngredients.get(ingredientIdentifier).removeAmount(ingredient.getAmount());
            } else {
                throw new MissingFoodException(ingredientIdentifier);
            }
        }
    }

    void addIngredients(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            String ingredientIdentifier = ingredient.getIngredientIdentifier();
            if (mapOfIngredients.containsKey(ingredientIdentifier)) {
                mapOfIngredients.get(ingredientIdentifier).addAmount(ingredient.getAmount());
            } else {
                Ingredient newIngredient = Ingredient.of(ingredient);
                ingredientsInKitchen.add(newIngredient);
                mapOfIngredients.put(ingredientIdentifier, newIngredient);
            }
        }
    }

    public List<Ingredient> getIngredientsInKitchen() {
        return this.ingredientsInKitchen;
    }

    public Kitchen startWithIngredients(List<Ingredient> ingredients) {
        Kitchen kitchen = new Kitchen();
        kitchen.addIngredients(ingredients);
        return kitchen;
    }

}
