package oyun;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Oyun extends Application
{
    public static Stage anaPencere;
    public static Scene oyunSahne;

    public Oyun() {
        super();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        anaPencere = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("OyunPencere.fxml"));

        anaPencere.getIcons().add(new Image("/texture/ea.jpg"));
        anaPencere.setTitle("Sporcu Kart Oyunu");

        oyunSahne = new Scene(root, 1600, 900);
        anaPencere.setScene(oyunSahne);
        anaPencere.setResizable(false);
        //anaPencere.setFullScreen(true);
        anaPencere.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}