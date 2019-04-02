package com.recipe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.recipe.Ingredient.ServingType.*;
import static com.recipe.Step.Action.*;
import static com.recipe.Step.Container.*;

public class Main {

    public static void main(String[] args) {
        RecipeMaker recipeMaker = new RecipeMaker();
        Ingredient poundOfChicken = Ingredient.of("Chicken", 1, POUND);
        Ingredient halfCupMayo = Ingredient.of("Mayonnaise", 1 / 2D, CUP);
        Recipe recipe = Recipe.builder().makesFood("Chicken Salad", 4)
            .withIngredient(poundOfChicken)
            .withIngredient(halfCupMayo)
            .step(SHRED, Arrays.asList(poundOfChicken), LARGE_BOWL)
            .step(COMBINE, Arrays.asList(poundOfChicken, halfCupMayo), LARGE_BOWL)
            .build();

        List<Ingredient> ingredientsInKitchen =
            Stream.of(
                Ingredient.of("Tomato Sauce", 1, CUP),
                Ingredient.of("Mayonnaise", 2D, CUP),
                poundOfChicken
            ).collect(Collectors.toList());
        Kitchen kitchen = new Kitchen();
        kitchen.addIngredients(ingredientsInKitchen);

        recipeMaker.canMakeFood(recipe, kitchen.getIngredientsInKitchen());
        CookedFood cookedFood = recipeMaker.makeFood(recipe, kitchen.getIngredientsInKitchen());
    }
}
