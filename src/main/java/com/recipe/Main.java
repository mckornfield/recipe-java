package com.recipe;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.recipe.Ingredient.ServingType.CUP;
import static com.recipe.Ingredient.ServingType.POUND;

public class Main {

    public static void main(String[] args) {
        RecipeMaker recipeMaker = new RecipeMakerImpl();
        Recipe recipe = Recipe.builder().makesFood("Chicken Salad", 4)
            .withIngredient("Mayonnaise", 1 / 2, CUP)
            .withIngredient("Chicken", 1, POUND)
            .step("Shred the chicken")
            .step("Mix in a bowl with the mayonnaise")

            .build();

        List<Ingredient> ingredientsInKitchen =
            Stream.of(
                Ingredient.of("Tomato Sauce", 1, CUP),
                Ingredient.of("Mayonnaise", 1 / 4, CUP)
            ).collect(Collectors.toList());
        Kitchen kitchen = new Kitchen();
        kitchen.addIngredients(ingredientsInKitchen);

        recipeMaker.canMakeFood(recipe, kitchen.getIngredientsInKitchen());
        CookedFood cookedFood = recipeMaker.makeFood(recipe, kitchen.getIngredientsInKitchen());
    }
}
