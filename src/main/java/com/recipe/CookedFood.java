package com.recipe;

public class CookedFood {
    private final String name;
    private final int servingSize;

    public String getName() {
        return name;
    }

    public int getServingSize() {
        return servingSize;
    }

    public CookedFood(String name, int servingSize) {
        this.name = name;
        this.servingSize = servingSize;
    }
}
