package com.yazlab;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class RecipeDetailController {
    @FXML private Label recipeNameLabel;
    @FXML private Label categoryLabel;
    @FXML private Label preparationTimeLabel;
    @FXML private Label totalCostLabel;
    @FXML private TextArea instructionsArea;
    @FXML private TextArea ingredientsArea;

    private Recipe recipe;

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
        displayRecipeDetails();
    }

    private void displayRecipeDetails() {
        if (recipe == null) {
            return;
        }

        recipeNameLabel.setText(recipe.getName());
        categoryLabel.setText(recipe.getCategory());
        preparationTimeLabel.setText(recipe.getPreparationTime() + " dakika");
        totalCostLabel.setText(String.format("%.2f TL", recipe.getTotalCost()));
        instructionsArea.setText(recipe.getInstructions());
        ingredientsArea.setText(recipe.getIngredientList());
    }

    @FXML
    private void close() {
        Stage stage = (Stage) recipeNameLabel.getScene().getWindow();
        stage.close();
    }
}