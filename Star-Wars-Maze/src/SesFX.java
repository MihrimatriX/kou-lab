import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;

public class SesFX
{
    public void sesCal() throws FileNotFoundException, JavaLayerException
    {
        File file = new File("src\\Sesler\\ImperialMarch.mp3"); //Kendi mp3 dosyanızın yolunu yazın.
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        Player oynatici = new Player(bufferedInputStream);
        oynatici.play();
    }
}