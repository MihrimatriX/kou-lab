package com.yazlab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TarifUygulamasi extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setTitle("Yemek Kitabı");
            primaryStage.setScene(scene);
            primaryStage.setWidth(1000);
            primaryStage.setHeight(700);
            primaryStage.show();

            DbConnection.initializeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Uygulama başlatılırken hata oluştu: " + e.getMessage());
        }
    }
}