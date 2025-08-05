import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KarakterSec
{
    public static Karakter SecilenKarakter;

    public KarakterSec() throws IOException
    {
        BufferedReader karakterGiris = new BufferedReader(new FileReader("src\\Texture\\Karakterler.txt"));
        String okunan = "";

        int i=0;
        for(String oku; (oku = karakterGiris.readLine())!=null; )
        {
/*
            if (oku.startsWith("K"))
            {
                String[] cevir = okunan.split(":");

                if (cevir[1].startsWith("MasterYoda"))
                {
                    System.out.println("Karakter Yoda");
                    SecilenKarakter = new MasterYoda();
                }
                if (cevir[1].startsWith("LukeSkywlaker"))
                {
                    System.out.println("Karakter Luke");
                    SecilenKarakter = new LukeSkywalker();
                }
            }
            i++;
            System.out.println("Karakter Secim Gerceklestirildi...");*/
        }
    }
}