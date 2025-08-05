package com.yazlab;

public class Ingredient {
    private int ingredientId;
    private String ingredientName;
    private String unit;
    private String totalAmount;
    private double unitPrice;

    public Ingredient(int ingredientId, String ingredientName, String unit, String totalAmount, double unitPrice) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.unit = unit;
        this.totalAmount = totalAmount;
        this.unitPrice = unitPrice;
    }

    public int getIngredientId() { return ingredientId; }
    public void setIngredientId(int ingredientId) { this.ingredientId = ingredientId; }

    public String getIngredientName() { return ingredientName; }
    public void setIngredientName(String ingredientName) { this.ingredientName = ingredientName; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public String getTotalAmount() { return totalAmount; }
    public void setTotalAmount(String totalAmount) { this.totalAmount = totalAmount; }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }

    @Override
    public String toString() {
        return ingredientName;
    }
}
