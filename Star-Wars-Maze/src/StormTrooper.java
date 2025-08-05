import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StormTrooper extends Karakter
{
    public static BufferedImage Storm;
    public static String DosyaYoluStorm = "src\\Texture\\FinalStormTrooper.png";

    public StormTrooper() throws IOException
    {
        System.out.println("Storm Trooper Geldi.");
        setHiz(1);//Hızı Normal
        StormTrooper stormTrooper = new StormTrooper();
        Storm = ImageIO.read(new File(DosyaYoluStorm));
    }
}
