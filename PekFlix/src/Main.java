/**
 * @class   : Java Main CLASS
 * @author1 : Gürcan Topaloğlu       - 160202040
 * @author2 : Ahmet Faruk Uzunkaya   - 160202052
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
    public static Stage anaPencere;

    public static Scene girisEkrani;
    public static Scene kayitEkrani;
    public static Scene anaEkranim;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        anaPencere = primaryStage;

        Parent giris    = FXMLLoader.load(getClass().getResource("Giris.fxml")   );
        Parent kayit    = FXMLLoader.load(getClass().getResource("Kayit.fxml")   );
        Parent anaEkran = FXMLLoader.load(getClass().getResource("AnaEkran.fxml"));

        girisEkrani   = new Scene(giris,    760, 600);
        kayitEkrani   = new Scene(kayit,    760, 600);
        anaEkranim    = new Scene(anaEkran);

        anaPencere.setTitle("...::: PEK FLIX :::...");
        anaPencere.setScene(girisEkrani);
        anaPencere.centerOnScreen();
        anaPencere.show();
    }

    @Override
    public void init() throws Exception
    {
        super.init();
    }

    @Override
    public void stop() throws Exception
    {
        super.stop();
    }

    public static void main(String[] args) throws IOException
    {
        launch(args);
    }
}