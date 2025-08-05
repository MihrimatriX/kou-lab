package com.yazlab;

public class RecipeIngredient {
    private int ingredientId;
    private String name;
    private float amount;
    private String unit;
    private float totalAvailableAmount;

    public RecipeIngredient(int ingredientId, String name, float amount, String unit) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public int getIngredientId() { return ingredientId; }
    public void setIngredientId(int ingredientId) { this.ingredientId = ingredientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public float getTotalAvailableAmount() { return totalAvailableAmount; }
    public void setTotalAvailableAmount(float totalAvailableAmount) { this.totalAvailableAmount = totalAvailableAmount; }

    @Override
    public String toString() {
        return name + " (" + amount + " " + unit + ")";
    }
}
