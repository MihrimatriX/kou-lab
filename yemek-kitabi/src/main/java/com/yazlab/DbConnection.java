package com.yazlab;

import java.sql.*;

public class DbConnection {
    private static final String DB_URL = "jdbc:sqlite:yemek_kitabi.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void updateRecipe(Recipe recipe) {
        String query = "UPDATE Tarifler SET TarifAdi=?, Kategori=?, HazirlamaSuresi=?, Talimatlar=? WHERE TarifID=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, recipe.getName());
            stmt.setString(2, recipe.getCategory());
            stmt.setInt(3, recipe.getPreparationTime());
            stmt.setString(4, recipe.getInstructions());
            stmt.setInt(5, recipe.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initializeDatabase() {
        try (Connection connection = getConnection()) {
            createTables(connection);
            insertSampleData(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        String[] createTableQueries = {
            "CREATE TABLE IF NOT EXISTS Tarifler (" +
                "TarifID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TarifAdi TEXT NOT NULL, " +
                "Kategori TEXT NOT NULL, " +
                "HazirlamaSuresi INTEGER NOT NULL, " +
                "Talimatlar TEXT NOT NULL" +
            ")",
            
            "CREATE TABLE IF NOT EXISTS Malzemeler (" +
                "MalzemeID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "MalzemeAdi TEXT NOT NULL, " +
                "ToplamMiktar TEXT NOT NULL, " +
                "MalzemeBirim TEXT NOT NULL, " +
                "BirimFiyat REAL NOT NULL" +
            ")",
            
            "CREATE TABLE IF NOT EXISTS TarifMalzeme (" +
                "TarifID INTEGER, " +
                "MalzemeID INTEGER, " +
                "MalzemeMiktar REAL NOT NULL, " +
                "PRIMARY KEY (TarifID, MalzemeID), " +
                "FOREIGN KEY (TarifID) REFERENCES Tarifler(TarifID) ON DELETE CASCADE, " +
                "FOREIGN KEY (MalzemeID) REFERENCES Malzemeler(MalzemeID) ON DELETE CASCADE" +
            ")"
        };

        try (Statement statement = connection.createStatement()) {
            for (String query : createTableQueries) {
                statement.executeUpdate(query);
            }
        }
    }

    private static void insertSampleData(Connection connection) throws SQLException {
        if (isTableEmpty(connection, "Malzemeler")) {
            insertSampleIngredients(connection);
        }
        
        if (isTableEmpty(connection, "Tarifler")) {
            insertSampleRecipes(connection);
        }
    }

    private static boolean isTableEmpty(Connection connection, String tableName) throws SQLException {
        String query = "SELECT COUNT(*) FROM " + tableName;
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            return rs.next() && rs.getInt(1) == 0;
        }
    }

    private static void insertSampleIngredients(Connection connection) throws SQLException {
        String[] ingredients = {
            "INSERT INTO Malzemeler (MalzemeAdi, ToplamMiktar, MalzemeBirim, BirimFiyat) VALUES ('Un', '1000', 'gram', 5.0)",
            "INSERT INTO Malzemeler (MalzemeAdi, ToplamMiktar, MalzemeBirim, BirimFiyat) VALUES ('Şeker', '500', 'gram', 8.0)",
            "INSERT INTO Malzemeler (MalzemeAdi, ToplamMiktar, MalzemeBirim, BirimFiyat) VALUES ('Yumurta', '12', 'adet', 15.0)",
            "INSERT INTO Malzemeler (MalzemeAdi, ToplamMiktar, MalzemeBirim, BirimFiyat) VALUES ('Süt', '1000', 'ml', 12.0)",
            "INSERT INTO Malzemeler (MalzemeAdi, ToplamMiktar, MalzemeBirim, BirimFiyat) VALUES ('Tereyağı', '250', 'gram', 25.0)"
        };

        try (Statement stmt = connection.createStatement()) {
            for (String sql : ingredients) {
                stmt.executeUpdate(sql);
            }
        }
    }

    private static void insertSampleRecipes(Connection connection) throws SQLException {
        String[] recipes = {
            "INSERT INTO Tarifler (TarifAdi, Kategori, HazirlamaSuresi, Talimatlar) VALUES ('Basit Kek', 'Tatlı', 30, '1. Un ve şekeri karıştırın\n2. Yumurtaları ekleyin\n3. 180°C fırında 25 dakika pişirin')",
            "INSERT INTO Tarifler (TarifAdi, Kategori, HazirlamaSuresi, Talimatlar) VALUES ('Omlet', 'Kahvaltı', 10, '1. Yumurtaları çırpın\n2. Tereyağında pişirin\n3. İsteğe göre peynir ekleyin')"
        };

        try (Statement stmt = connection.createStatement()) {
            for (String sql : recipes) {
                stmt.executeUpdate(sql);
            }
        }
    }
}