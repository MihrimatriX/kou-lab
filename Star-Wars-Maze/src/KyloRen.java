import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class KyloRen extends Karakter
{
    public static BufferedImage Kylo;
    public static String DosyaYoluKylo = "src\\Texture\\FinalKyloRen.png";

    public KyloRen() throws IOException
    {
        setHiz(2);//Kylo Ren 2 Hızlıdır.
        System.out.println("DartVader Geldi...");
        KyloRen kylo = new KyloRen();
        Kylo = ImageIO.read(new File(DosyaYoluKylo));
    }
}