package com.recipe;

import com.recipe.exception.GetMoreFoodException;
import com.recipe.exception.WrongIngredientException;

import java.util.List;

public interface RecipeMaker {

    CookedFood makeFood(Recipe recipe, List<Ingredient> ingredients);

    void canMakeFood(Recipe recipe, List<Ingredient> ingredients) throws GetMoreFoodException, WrongIngredientException;
}
