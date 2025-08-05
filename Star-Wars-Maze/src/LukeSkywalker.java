import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LukeSkywalker extends Karakter
{
    public static BufferedImage Luke;
    public static String DosyaYoluLuke = "src\\Texture\\FinalStormTrooper.png";

    public LukeSkywalker() throws IOException
    {
        setCan(3);
        System.out.println("Luke Skywalker Geldi.");
        setHiz(1);//Hızı Normal
        LukeSkywalker luke = new LukeSkywalker();
        Luke = ImageIO.read(new File(DosyaYoluLuke));

    }
    public LukeSkywalker(int x, int y) throws IOException
    {
        setCan(3);
        System.out.println("Luke Skywalker Geldi.");
        setHiz(1);//Hızı Normal
        LukeSkywalker luke = new LukeSkywalker();
        Luke = ImageIO.read(new File(DosyaYoluLuke));

    }
}