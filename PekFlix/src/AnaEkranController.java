/**
 * @class   : Temel Islemleri Yapar.
 * @author1 : Gürcan Topaloğlu       - 160202040
 * @author2 : Ahmet Faruk Uzunkaya   - 160202052
 */

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AnaEkranController implements Initializable
{
    private String url       = "jdbc:mysql://localhost:3308/pekflix";
    private String username  = "root";
    private String password  = "";

    @FXML
    private TableView<Films> tablom;
    @FXML
    private TableColumn<Films, String> adCol;
    @FXML
    private TableColumn<Films, String> tipCol;
    @FXML
    private TableColumn<Films, String> turCol;
    @FXML
    private TableColumn<Films, Integer> uzCol;
    @FXML
    private TableColumn<Films, Integer> bolCol;
    @FXML
    private TableColumn<Films, String> evetCol;
    @FXML
    private TableColumn<Films, Integer> nerdeCol;
    @FXML
    private TableColumn<Films, Integer> puani;
    @FXML
    private JFXTextField turTex;
    @FXML
    private JFXTextField isimGir;

    private int izleSure;
    private ObservableList<Films>filmlerim;
    private DbConnection db;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        db = new DbConnection();
    }

    private void loadDataFromDatabase() throws SQLException
    {
        Connection conn = db.Connect();
        filmlerim = FXCollections.observableArrayList();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM program");

        while (rs.next())
        {
            filmlerim.add(new Films(
                    rs.getString(2), // Program Adı
                    rs.getString(3), // Program Tipi
                    rs.getString(4), // Program Turu
                    rs.getInt(5),    // Program Uzunluk
                    rs.getInt(6),    // Program Bölüm Sayısı
                    rs.getInt(7),    // Program Puanı
                    1,//rs.getInt(8),    // Program Kalan Yer
                    "Evet" //rs.getString(9)  // Programı İzleme Durumu
            ));
        }
        conn.close();

        adCol.setCellValueFactory(new PropertyValueFactory<>("adi"));
        tipCol.setCellValueFactory(new PropertyValueFactory<>("tipi"));
        turCol.setCellValueFactory(new PropertyValueFactory<>("tur"));
        uzCol.setCellValueFactory(new PropertyValueFactory<>("sure"));
        bolCol.setCellValueFactory(new PropertyValueFactory<>("bSayi"));
        puani.setCellValueFactory(new PropertyValueFactory<>("puani"));
        nerdeCol.setCellValueFactory(new PropertyValueFactory<>("kalan"));
        evetCol.setCellValueFactory(new PropertyValueFactory<>("izledim"));

        tablom.setItems(null);
        tablom.setItems(filmlerim);
    }

    public void anaEkraniGetir() throws SQLException
    {
        loadDataFromDatabase();
    }

    public void cikisYap()
    {
        Alert yok = new Alert(Alert.AlertType.CONFIRMATION);
        yok.setTitle          ("HOSCAKAL"                           );
        yok.setHeaderText     ("Tekrar Gel."                        );
        yok.setContentText    ("Kaldığın Yerden Devam Edebilirsin." );
        yok.showAndWait();
        System.exit(0);
    }

    public void izle() throws SQLException
    {
        izleSure = 0;

        int random = ( 30 + (int) (Math.random()* 100) );
        izleSure = random;

        Alert yok = new Alert(Alert.AlertType.WARNING);
        yok.setTitle          ("KEYİFLİ SEYİRLER" );
        yok.setHeaderText     ("Program İzleme" );
        yok.setContentText    ("Programı İzlemiş Bulunuyorsunuz." );


        String izleSorgu = "UPDATE kullaniciprogram SET izlenmeSure = "+ izleSure +" WHERE kullaniciprogram.kullaniciProgramId = 1";

        Connection conn = db.Connect();
        ResultSet resultSet = conn.createStatement().executeQuery(izleSorgu);


        conn.close();
        yok.showAndWait();
        System.out.println("Seçilen Film Izlendi.");
    }

    public void isimArama() throws SQLException
    {
        Connection conn = db.Connect();
        String aramaTuru = isimGir.getText();
        filmlerim = FXCollections.observableArrayList();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM `program` WHERE programAdi='"+ aramaTuru +"'");

        while (rs.next())
        {
            filmlerim.add(new Films(
                    rs.getString(2), // Program Adı
                    rs.getString(3), // Program Tipi
                    rs.getString(4), // Program Turu
                    rs.getInt(5),    // Program Uzunluk
                    rs.getInt(6),    // Program Bölüm Sayısı
                    rs.getInt(7),    // Program Puanı
                    1,//rs.getInt(8),    // Program Kalan Yer
                    "Evet" //rs.getString(9)  // Programı İzleme Durumu
            ));
        }

        adCol.setCellValueFactory(new PropertyValueFactory<>("adi"));
        tipCol.setCellValueFactory(new PropertyValueFactory<>("tipi"));
        turCol.setCellValueFactory(new PropertyValueFactory<>("tur"));
        uzCol.setCellValueFactory(new PropertyValueFactory<>("sure"));
        bolCol.setCellValueFactory(new PropertyValueFactory<>("bSayi"));
        puani.setCellValueFactory(new PropertyValueFactory<>("puani"));
        nerdeCol.setCellValueFactory(new PropertyValueFactory<>("kalan"));
        evetCol.setCellValueFactory(new PropertyValueFactory<>("izledim"));

        tablom.setItems(null);
        tablom.setItems(filmlerim);
    }

    public void turArama() throws SQLException
    {
        Connection conn = db.Connect();
        String aramaTuru = turTex.getText();
        filmlerim = FXCollections.observableArrayList();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM `program` WHERE programTuru='"+ aramaTuru +"'");

        while (rs.next())
        {
            filmlerim.add(new Films(
                    rs.getString(2), // Program Adı
                    rs.getString(3), // Program Tipi
                    rs.getString(4), // Program Turu
                    rs.getInt(5),    // Program Uzunluk
                    rs.getInt(6),    // Program Bölüm Sayısı
                    rs.getInt(7),    // Program Puanı
                    1,//rs.getInt(8),     // Program Kalan Yer
                    "Evet" //rs.getString(9)  // Programı İzleme Durumu
            ));
        }

        adCol.setCellValueFactory(new PropertyValueFactory<>("adi"));
        tipCol.setCellValueFactory(new PropertyValueFactory<>("tipi"));
        turCol.setCellValueFactory(new PropertyValueFactory<>("tur"));
        uzCol.setCellValueFactory(new PropertyValueFactory<>("sure"));
        bolCol.setCellValueFactory(new PropertyValueFactory<>("bSayi"));
        puani.setCellValueFactory(new PropertyValueFactory<>("puani"));
        nerdeCol.setCellValueFactory(new PropertyValueFactory<>("kalan"));
        evetCol.setCellValueFactory(new PropertyValueFactory<>("izledim"));

        tablom.setItems(null);
        tablom.setItems(filmlerim);
    }
}