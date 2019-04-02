package com.recipe;

import java.util.List;

public class Step {

    public Step(Action action, List<Ingredient> ingredientList, Container container) {
        this.action = action;
        this.ingredientList = ingredientList;
        this.container = container;
    }

    enum Action {SHRED, CUT, CHOP, MIX, COMBINE}

    enum Container {LARGE_BOWL, MEDIUM_BOWL, OVEN_PAN, STOVE_PAN, SOUP_POT}

    private final Action action;
    private final List<Ingredient> ingredientList;
    private final Container container;

    @Override
    public String toString() {
        return action + " " + ingredientList.toString() + " and put into " + container;
    }
}
