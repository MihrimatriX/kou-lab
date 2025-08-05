import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DarthVader extends Karakter
{
    public static BufferedImage Darth;
    public static String DosyaYoluDarth = "src\\Texture\\FinalDartVader.png";

    public DarthVader() throws IOException
    {
        System.out.println("Darth Vader Geldi.");
        setHiz(1);//Hızı Normal
        DarthVader dartvader = new DarthVader();
        Darth = ImageIO.read(new File(DosyaYoluDarth));
    }

    public void duvarKir()
    {



        System.out.println("Duvar Kirdim ...:D");
    }
}