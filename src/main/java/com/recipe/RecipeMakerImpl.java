package com.recipe;

import com.recipe.exception.GetMoreFoodException;
import com.recipe.exception.WrongIngredientException;

import java.util.List;

public class RecipeMakerImpl implements RecipeMaker {
    @Override
    public CookedFood makeFood(Recipe recipe, List<Ingredient> ingredients) {
        return null;
    }

    @Override
    public void canMakeFood(Recipe recipe, List<Ingredient> ingredients) throws GetMoreFoodException, WrongIngredientException {

    }

}
