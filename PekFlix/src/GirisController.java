/**
 * @class   : Giris Islemleri
 * @author1 : Gürcan Topaloğlu       - 160202040
 * @author2 : Ahmet Faruk Uzunkaya   - 160202052
 */

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;

public class GirisController
{
    @FXML
    private TextField kullaniciText;
    @FXML
    private TextField sifreText;

    private String kullaniciAd;
    private String sifre;

    private String url       = "jdbc:mysql://localhost:3308/pekflix";
    private String username  = "root";
    private String password  = "";

    public static final String dbKonum         = "jdbc:mysql://localhost:3308/pekflix";
    public static final String dbkullaniciAdi  = "afu";
    public static final String dbsifre         = "158358";

    public void girisYap() throws SQLException
    {
        if
        (
                kullaniciText.  getText().trim().isEmpty() ||
                sifreText.      getText().trim().isEmpty()
        )
        {
            Alert uyari = new Alert(Alert.AlertType.WARNING);
            uyari.setTitle          (" UYARI "                           );
            uyari.setHeaderText     ("Birşeyleri Eksik Doldurdun."       );
            uyari.setContentText    ("Lütfen Tüm Alanları Doldurun."     );
            uyari.showAndWait();
        }
        else {
            kullaniciAd = kullaniciText.getText();
            sifre       = sifreText.getText();

            try
            {
                Connection connection = DriverManager.getConnection(url, username, password);
                String sorgu = "SELECT kullaniciPosta,kullaniciSifre FROM kullanici WHERE kullaniciPosta='" + kullaniciAd + "' AND kullaniciSifre='" + sifre + "'";
                Statement pst = connection.createStatement();

                /*
                preparedStatement.setString(1, kullaniciAd  );
                preparedStatement.setString(2, sifre        );
                preparedStatement.executeUpdate();
                 */

                ResultSet rs = pst.executeQuery(sorgu);

                if (rs.next())
                {
                    System.out.println(rs.getString(1) + " " + rs.getString(2));
                    System.out.println("Giriş Başarılı. Yönlendir...");
                    Main.anaPencere.setScene(Main.anaEkranim);

                    /*
                    Main.anaPencere.setMaxWidth  (900);
                    Main.anaPencere.setMaxHeight (700);
                    Main.anaPencere.setMinWidth  (900);
                    Main.anaPencere.setMinHeight (700);
                    Main.anaPencere.centerOnScreen();
                    */

                    Main.anaPencere.setHeight(Main.anaPencere.getHeight());
                    Main.anaPencere.setWidth(Main.anaPencere.getWidth());
                    Main.anaPencere.centerOnScreen();

                    //Main.anaPencere.setFullScreen(true);
                }
                else{
                    if ( !(rs.getString(1).equals(kullaniciAd) ) )
                    {
                        //TODO => E-Posta Yok Kayıt Ol.
                        Alert yok = new Alert(Alert.AlertType.WARNING);
                        yok.setTitle          (" UYARI "                            );
                        yok.setHeaderText     ("Bu E-Posta Sistemde Kayıtlı Değil." );
                        yok.setContentText    ("Kayıt Olarak Oturum Açmayı Deneyin.");
                        yok.showAndWait();
                    }
                    System.out.println("E-Posta Veya Şifre Yanlış");
                }
                connection.close();
            }
            catch (SQLException e)
            {
                Alert yok = new Alert(Alert.AlertType.WARNING);
                yok.setTitle          (" UYARI "                            );
                yok.setHeaderText     ("Bu E-Posta Sistemde Kayıtlı Değil." );
                yok.setContentText    ("Kayıt Olarak Oturum Açmayı Deneyin.");
                yok.showAndWait();
                System.out.println("HATA Bulundu. : HATA => " + e);
            }
        }
    }

    public static void onerilen() throws SQLException
    {
        Connection connection = DriverManager.getConnection(dbKonum, dbkullaniciAdi, dbsifre);
        String sorgu = "";
        Statement pst = connection.createStatement();


    }

    public void kayitOl()
    {
        Main.anaPencere.setScene(Main.kayitEkrani);
        Main.anaPencere.centerOnScreen();
        Main.anaPencere.setResizable(false);
        System.out.println("Kayıt Sayfasına Git.");
    }
}