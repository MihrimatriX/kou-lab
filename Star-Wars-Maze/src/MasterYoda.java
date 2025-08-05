import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MasterYoda extends Karakter
{
    public static BufferedImage Yoda;
    public static String DosyaYoluYoda = "src\\Texture\\FinalMasterYoda.png";

    public MasterYoda() throws IOException
    {
        setCan(6);
        System.out.println("Yoda Usta Geldi.");
        setHiz(1);//Hızı Normal
        MasterYoda ustaYoda = new MasterYoda();
        Yoda = ImageIO.read(new File(DosyaYoluYoda));

    }

    public MasterYoda(int x, int y) throws IOException
    {
        setCan(6);
        System.out.println("Yoda Usta Geldi.");
        setHiz(1);//Hızı Normal
        MasterYoda ustaYoda = new MasterYoda();
        Yoda = ImageIO.read(new File(DosyaYoluYoda));

    }

    public void setLocation()
    {

    }
}
