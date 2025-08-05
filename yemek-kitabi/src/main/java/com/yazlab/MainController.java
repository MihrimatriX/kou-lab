package com.yazlab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    private final ObservableList<RecipeIngredient> recipeIngredients = FXCollections.observableArrayList();
    private final ObservableList<Recipe> recipeList = FXCollections.observableArrayList();

    @FXML public TextField searchField;
    @FXML private TableView<Recipe> recipeTable;
    @FXML private TableColumn<Recipe, Integer> recipeIdColumn;
    @FXML private TableColumn<Recipe, String> recipeNameColumn;
    @FXML private TableColumn<Recipe, String> categoryColumn;
    @FXML private TableColumn<Recipe, Integer> preparationTimeColumn;
    @FXML private TableColumn<Recipe, String> instructionsColumn;
    @FXML private TableColumn<Recipe, String> ingredientListColumn;
    @FXML private TableColumn<Recipe, Double> totalCostColumn;

    @FXML private TextField recipeNameField;
    @FXML private TextField categoryField;
    @FXML private TextField preparationTimeField;
    @FXML private TextArea instructionsArea;

    @FXML private ComboBox<Ingredient> ingredientComboBox;
    @FXML private TextField ingredientAmountField;
    @FXML private TableView<RecipeIngredient> recipeIngredientTable;
    @FXML private TableColumn<RecipeIngredient, String> ingredientNameColumn;
    @FXML private TableColumn<RecipeIngredient, Float> ingredientAmountColumn;
    @FXML private TableColumn<RecipeIngredient, String> ingredientUnitColumn;

    @FXML
    public void initialize() {
        setupTableColumns();
        setupComboBox();
        loadData();
    }

    private void setupTableColumns() {
        recipeIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        recipeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        preparationTimeColumn.setCellValueFactory(new PropertyValueFactory<>("preparationTime"));
        instructionsColumn.setCellValueFactory(new PropertyValueFactory<>("instructions"));
        ingredientListColumn.setCellValueFactory(new PropertyValueFactory<>("ingredientList"));
        totalCostColumn.setCellValueFactory(new PropertyValueFactory<>("totalCost"));

        ingredientNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ingredientAmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        ingredientUnitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        recipeIngredientTable.setItems(recipeIngredients);
    }

    private void setupComboBox() {
        ingredientComboBox.setCellFactory(comboBox -> new ListCell<>() {
            @Override
            protected void updateItem(Ingredient item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getIngredientName());
            }
        });

        ingredientComboBox.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Ingredient item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getIngredientName());
            }
        });
    }

    private void loadData() {
        loadIngredients();
        loadRecipes();
    }

    @FXML
    private void loadRecipes() {
        recipeList.clear();
        String query = "SELECT t.TarifID, t.TarifAdi, t.Kategori, t.HazirlamaSuresi, t.Talimatlar, " +
                "COALESCE(SUM(tm.MalzemeMiktar * m.BirimFiyat), 0) AS ToplamMaliyet " +
                "FROM Tarifler t " +
                "LEFT JOIN TarifMalzeme tm ON t.TarifID = tm.TarifID " +
                "LEFT JOIN Malzemeler m ON tm.MalzemeID = m.MalzemeID " +
                "GROUP BY t.TarifID, t.TarifAdi, t.Kategori, t.HazirlamaSuresi, t.Talimatlar";

        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Recipe recipe = createRecipeFromResultSet(rs);
                recipeList.add(recipe);
            }
            recipeTable.setItems(recipeList);
            setupRowFactory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Recipe createRecipeFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("TarifID");
        String name = rs.getString("TarifAdi");
        String category = rs.getString("Kategori");
        int preparationTime = rs.getInt("HazirlamaSuresi");
        String instructions = rs.getString("Talimatlar");
        double totalCost = rs.getDouble("ToplamMaliyet");

        String ingredientList = getIngredientsForRecipe(id);
        List<RecipeIngredient> ingredients = getRecipeIngredients(id);
        
        Recipe recipe = new Recipe(id, name, category, preparationTime, instructions, ingredientList);
        recipe.setTotalCost(totalCost);
        recipe.setRecipeIngredients(ingredients);
        return recipe;
    }

    private void setupRowFactory() {
        recipeTable.setRowFactory(tv -> new TableRow<Recipe>() {
            @Override
            protected void updateItem(Recipe item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setStyle("");
                } else {
                    boolean hasSufficientIngredients = checkSufficientIngredients(item);
                    setStyle(hasSufficientIngredients ? "-fx-background-color: lightgreen;" : "-fx-background-color: lightcoral;");
                }
            }
        });
    }

    private boolean checkSufficientIngredients(Recipe recipe) {
        return recipe.getRecipeIngredients().stream()
                .allMatch(ingredient -> ingredient.getAmount() <= ingredient.getTotalAvailableAmount());
    }

    private List<RecipeIngredient> getRecipeIngredients(int recipeId) {
        List<RecipeIngredient> ingredients = new ArrayList<>();
        String query = "SELECT MalzemeAdi, MalzemeMiktar, ToplamMiktar FROM TarifMalzeme ri " +
                "JOIN Malzemeler m ON ri.MalzemeID = m.MalzemeID WHERE ri.TarifID = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, recipeId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                String ingredientName = rs.getString("MalzemeAdi");
                float amount = rs.getFloat("MalzemeMiktar");
                float totalAvailableAmount = rs.getFloat("ToplamMiktar");
                
                RecipeIngredient recipeIngredient = new RecipeIngredient(0, ingredientName, amount, "unit");
                recipeIngredient.setTotalAvailableAmount(totalAvailableAmount);
                ingredients.add(recipeIngredient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    private String getIngredientsForRecipe(int recipeId) {
        StringBuilder ingredients = new StringBuilder();
        String query = "SELECT MalzemeAdi, MalzemeMiktar FROM TarifMalzeme ri " +
                "JOIN Malzemeler m ON ri.MalzemeID = m.MalzemeID WHERE ri.TarifID = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, recipeId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                String ingredientName = rs.getString("MalzemeAdi");
                double amount = rs.getDouble("MalzemeMiktar");
                ingredients.append(ingredientName).append(" (").append(amount).append("), ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (ingredients.length() > 0) {
            ingredients.setLength(ingredients.length() - 2);
        }
        return ingredients.toString();
    }

    @FXML
    private void addIngredient() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/addIngredient.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Malzeme Ekle");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();

            loadIngredients();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadIngredients() {
        ObservableList<Ingredient> ingredients = FXCollections.observableArrayList();
        String query = "SELECT * FROM Malzemeler";

        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("MalzemeID");
                String name = rs.getString("MalzemeAdi");
                String unit = rs.getString("MalzemeBirim");
                String total = rs.getString("ToplamMiktar");
                double unitPrice = rs.getDouble("BirimFiyat");
                ingredients.add(new Ingredient(id, name, unit, total, unitPrice));
            }
            ingredientComboBox.setItems(ingredients);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addIngredientToRecipe() {
        Ingredient selectedIngredient = ingredientComboBox.getValue();
        if (selectedIngredient == null) {
            showAlert("Lütfen bir malzeme seçin.");
            return;
        }

        float amount;
        try {
            amount = Float.parseFloat(ingredientAmountField.getText());
        } catch (NumberFormatException e) {
            showAlert("Geçerli bir miktar girin.");
            return;
        }

        if (recipeIngredients.stream().anyMatch(ri -> ri.getIngredientId() == selectedIngredient.getIngredientId())) {
            showAlert("Bu malzeme zaten eklendi.");
            return;
        }

        RecipeIngredient recipeIngredient = new RecipeIngredient(
                selectedIngredient.getIngredientId(),
                selectedIngredient.getIngredientName(),
                amount,
                selectedIngredient.getUnit()
        );

        recipeIngredients.add(recipeIngredient);
        ingredientAmountField.clear();
        ingredientComboBox.getSelectionModel().clearSelection();
    }

    private void addIngredientToRecipe(int recipeId, int ingredientId, double amount) {
        String query = "INSERT INTO TarifMalzeme (TarifID, MalzemeID, MalzemeMiktar) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, recipeId);
            pstmt.setInt(2, ingredientId);
            pstmt.setDouble(3, amount);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchRecipe() {
        String searchTerm = searchField.getText().toLowerCase();
        if (searchTerm.trim().isEmpty()) {
            loadRecipes();
            return;
        }

        recipeList.clear();
        String query = "SELECT DISTINCT t.*, COALESCE(SUM(tm.MalzemeMiktar * m.BirimFiyat), 0) AS ToplamMaliyet " +
                "FROM Tarifler t " +
                "JOIN TarifMalzeme tm ON t.TarifID = tm.TarifID " +
                "JOIN Malzemeler m ON tm.MalzemeID = m.MalzemeID " +
                "WHERE LOWER(t.TarifAdi) LIKE ? OR LOWER(m.MalzemeAdi) LIKE ? " +
                "GROUP BY t.TarifID";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            String searchPattern = "%" + searchTerm + "%";
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Recipe recipe = createRecipeFromResultSet(rs);
                recipeList.add(recipe);
            }
            recipeTable.setItems(recipeList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void refreshPage() {
        searchField.setText("");
        loadRecipes();
    }

    @FXML
    private void saveRecipe() {
        if (!validateRecipeForm()) {
            return;
        }

        String name = recipeNameField.getText();
        String category = categoryField.getText();
        int preparationTime = Integer.parseInt(preparationTimeField.getText());
        String instructions = instructionsArea.getText();

        Recipe newRecipe = new Recipe(0, name, category, preparationTime, instructions, "");

        try (Connection conn = DbConnection.getConnection()) {
            int recipeId = insertRecipe(conn, newRecipe);
            insertRecipeIngredients(conn, recipeId);
            clearForm();
            loadRecipes();
            showAlert("Tarif başarıyla kaydedildi: " + name);
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Tarif kaydedilirken hata oluştu: " + e.getMessage());
        }
    }

    private boolean validateRecipeForm() {
        if (recipeNameField.getText().trim().isEmpty()) {
            showAlert("Tarif adı boş olamaz.");
            return false;
        }
        if (categoryField.getText().trim().isEmpty()) {
            showAlert("Kategori boş olamaz.");
            return false;
        }
        try {
            Integer.parseInt(preparationTimeField.getText());
        } catch (NumberFormatException e) {
            showAlert("Geçerli bir hazırlama süresi girin.");
            return false;
        }
        if (instructionsArea.getText().trim().isEmpty()) {
            showAlert("Talimatlar boş olamaz.");
            return false;
        }
        return true;
    }

    private int insertRecipe(Connection conn, Recipe recipe) throws SQLException {
        String sql = "INSERT INTO Tarifler (TarifAdi, Kategori, HazirlamaSuresi, Talimatlar) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, recipe.getName());
        stmt.setString(2, recipe.getCategory());
        stmt.setInt(3, recipe.getPreparationTime());
        stmt.setString(4, recipe.getInstructions());
        stmt.executeUpdate();

        String lastIdSql = "SELECT last_insert_rowid()";
        try (Statement idStmt = conn.createStatement();
             ResultSet rs = idStmt.executeQuery(lastIdSql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
            throw new SQLException("Tarif kaydedildi ancak ID alınamadı.");
        }
    }

    private void insertRecipeIngredients(Connection conn, int recipeId) throws SQLException {
        for (RecipeIngredient recipeIngredient : recipeIngredients) {
            addIngredientToRecipe(recipeId, recipeIngredient.getIngredientId(), recipeIngredient.getAmount());
        }
    }

    private void clearForm() {
        recipeNameField.clear();
        categoryField.clear();
        preparationTimeField.clear();
        instructionsArea.clear();
        recipeIngredients.clear();
    }

    @FXML
    private void handleTableClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            openRecipeDetailPopup();
        }
    }

    @FXML
    private void openRecipeDetailPopup() {
        Recipe selectedRecipe = recipeTable.getSelectionModel().getSelectedItem();

        if (selectedRecipe == null) {
            showAlert("Lütfen bir tarif seçin.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/recipeDetailPopup.fxml"));
            Parent root = loader.load();

            RecipeDetailController controller = loader.getController();
            controller.setRecipe(selectedRecipe);

            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Tarif Detayları");
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait();
            recipeTable.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bilgi");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
