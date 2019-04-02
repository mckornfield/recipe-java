package com.recipe;

import com.recipe.exception.GetMoreFoodException;
import com.recipe.exception.MissingFoodException;
import com.recipe.exception.NotEnoughFoodException;
import com.recipe.exception.WrongIngredientException;

import java.util.List;
import java.util.Optional;

public class RecipeMaker {
    public CookedFood makeFood(Recipe recipe, List<Ingredient> ingredients) {
        List<String> steps = recipe.getSteps();
        for (String step : steps) {
            doStep(step); // TODO: Consider how to use ingredients? Maybe doStep() consumes the ingredients? Step needs new data structure
        }
        CookedFood cook = recipe.cook();
        return cook;
    }

    private void doStep(String step) {
        System.out.println("Current Step: " + step);
    }

    public void canMakeFood(Recipe recipe, List<Ingredient> availableIngredients) throws GetMoreFoodException, WrongIngredientException {
        List<Ingredient> ingredients = recipe.getIngredients();
        // Can make this more efficient for now, just brute force n^2 to start
        for (Ingredient requiredIngredient : ingredients) {
            Optional<Ingredient> opIng = availableIngredients.stream().
                filter(availIngred -> availIngred.areOfSameItemAndQuantity(requiredIngredient))
                .findFirst();

            Ingredient matchingAvailableIngredient = opIng.orElseThrow(MissingFoodException::new);
            if (matchingAvailableIngredient.getAmount() < requiredIngredient.getAmount()) {
                throw new NotEnoughFoodException("Need more of " + requiredIngredient.getIngredientName());
            }

        }
    }

}
