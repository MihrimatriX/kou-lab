package com.yazlab;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddIngredientController {
    @FXML private TextField ingredientNameField;
    @FXML private TextField totalAmountField;
    @FXML private TextField unitField;
    @FXML private TextField unitPriceField;

    @FXML
    private void saveIngredient() {
        if (!validateForm()) {
            return;
        }

        String name = ingredientNameField.getText().trim();
        String totalAmount = totalAmountField.getText().trim();
        String unit = unitField.getText().trim();
        double unitPrice = Double.parseDouble(unitPriceField.getText().trim());

        String sql = "INSERT INTO Malzemeler (MalzemeAdi, ToplamMiktar, MalzemeBirim, BirimFiyat) VALUES (?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, name);
            stmt.setString(2, totalAmount);
            stmt.setString(3, unit);
            stmt.setDouble(4, unitPrice);
            stmt.executeUpdate();

            showAlert("Malzeme başarıyla eklendi: " + name);
            closeWindow();
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Malzeme eklenirken hata oluştu: " + e.getMessage());
        }
    }

    private boolean validateForm() {
        if (ingredientNameField.getText().trim().isEmpty()) {
            showAlert("Malzeme adı boş olamaz.");
            return false;
        }
        if (totalAmountField.getText().trim().isEmpty()) {
            showAlert("Toplam miktar boş olamaz.");
            return false;
        }
        if (unitField.getText().trim().isEmpty()) {
            showAlert("Birim boş olamaz.");
            return false;
        }
        try {
            Double.parseDouble(unitPriceField.getText().trim());
        } catch (NumberFormatException e) {
            showAlert("Geçerli bir birim fiyat girin.");
            return false;
        }
        return true;
    }

    @FXML
    private void cancel() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) ingredientNameField.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bilgi");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
