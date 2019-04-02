package com.recipe;

import com.recipe.exception.GetMoreFoodException;
import com.recipe.exception.MissingFoodException;
import com.recipe.exception.NotEnoughFoodException;
import com.recipe.exception.WrongIngredientException;

import java.util.List;
import java.util.Optional;

public class RecipeMaker {
    public CookedFood makeFood(Recipe recipe, List<Ingredient> ingredients) {
        List<Step> steps = recipe.getSteps();
        for (Step step : steps) {
            doStep(step);
        }
        CookedFood cook = recipe.getCookedFood();
        return cook;
    }

    private void doStep(Step step) {
        System.out.println("Current Step: " + step);
    }

    public void canMakeFood(Recipe recipe, List<Ingredient> availableIngredients) throws GetMoreFoodException, WrongIngredientException {
        List<Ingredient> ingredients = recipe.getIngredients();
        // Can make this more efficient for now, just brute force n^2 to start
        for (Ingredient requiredIngredient : ingredients) {
            Optional<Ingredient> opIng = availableIngredients.stream().
                filter(availIngred -> availIngred.areOfSameItemAndQuantity(requiredIngredient))
                .findFirst();

            Ingredient matchingAvailableIngredient =
                opIng.orElseThrow(() -> new MissingFoodException(requiredIngredient));
            // Only works if ingredient is only listed once in a recipe
            if (matchingAvailableIngredient.getAmount() < requiredIngredient.getAmount()) {
                throw new NotEnoughFoodException("Need more of " + requiredIngredient.getIngredientIdentifier() + ", currently we only have " +
                    matchingAvailableIngredient.getAmount() + " but we need " + requiredIngredient.getAmount());
            }

        }
    }

}
