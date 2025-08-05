/**
 * @class   : Kayit Ekrani Olusturur ve Yonetir.
 * @author1 : Gürcan Topaloğlu       - 160202040
 * @author2 : Ahmet Faruk Uzunkaya   - 160202052
 */

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.format.DateTimeFormatter;

public class KayitController
{
    @FXML
    private TextField    kullaniciText;
    @FXML
    private TextField    epostaText;
    @FXML
    private TextField    sifreText;
    @FXML
    private DatePicker   dogumTarihText;
    //@FXML



    private String ad;
    private String eposta;
    private String sifre;
    private String dogum;

    static Connection connect;

    private String url       = "jdbc:mysql://localhost:3308/pekflix";
    private String username  = "root";
    private String password  = "";

    public void kayitOl() throws SQLException, ClassNotFoundException
    {
        if
        (       kullaniciText.  getText().trim().isEmpty() ||
                epostaText.     getText().trim().isEmpty() ||
                sifreText.      getText().trim().isEmpty() ||
                dogumTarihText. getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).trim().isEmpty()
        )
        {
            Alert uyari = new Alert(Alert.AlertType.WARNING);
            uyari.setTitle          (" UYARI "                           );
            uyari.setHeaderText     ("Birşeyleri Eksik Doldurdun."       );
            uyari.setContentText    ("Lütfen Tüm Alanları Doldurun."     );
            uyari.showAndWait();
        }
        else {

            ad      = kullaniciText .getText();
            eposta  = epostaText    .getText();
            sifre   = sifreText     .getText();
            dogum   = dogumTarihText.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            String durum = ad + " " + eposta + " " + sifre + " " + dogum;
            System.out.println("Kayit Islemi Başarılı.\n" + durum);

            Alert uyari = new Alert(Alert.AlertType.INFORMATION);
            uyari.setTitle          (" BILGI "                           );
            uyari.setHeaderText     ("Bu bir bilgilendirme penceresidir.");
            uyari.setContentText    ("Yeni kayıt başarıyla oluşturuldu." );

            DBKontrol();

            try
            {
                Statement stmt = connect.createStatement();
                String sorgu = String.format("INSERT INTO `kullanici` (`kullaniciId`, `kullaniciAdi`, `kullaniciPosta`, `kullaniciSifre`, `dogumTarih`) VALUES (NULL, '%s', '%s', '%s', '%s')", ad, eposta, sifre, dogum);
                int ekleme = stmt.executeUpdate(sorgu);
                connect.close();
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
            uyari.showAndWait();
        }
    }

    public void DBKontrol() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection(url,username,password);

        /*
        System.out.println("Veritabanına Bağlanılıyor...");

        try
        {
            java.sql.Connection ignored = DriverManager.getConnection(url, username, password);
            System.out.println("OK! Veritabanına Bağlanıldı!");
        }
        catch (SQLException e)
        {
            throw new IllegalStateException("HATA! Veritabanına Bağlanılamıyor!", e);
        }
        */
    }

    public void giriseGit()
    {
        Main.anaPencere.setScene(Main.girisEkrani);
        Main.anaPencere.centerOnScreen();
        Main.anaPencere.setResizable(false);
        System.out.println("Giriş Sayfası Geçildi.");
    }
}