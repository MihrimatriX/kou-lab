
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HaritaCizim
{

    ArrayList<String> veri = new ArrayList<String>();
    public static int[][] Labirent = new int[11][14];

    public void HaritaCiz() throws IOException
    {
        String oku = "";

        try
        {
            FileInputStream fStream = new FileInputStream("src\\Texture\\Harita.txt");
            DataInputStream dStream = new DataInputStream(fStream);
            BufferedReader HaritaOku = new BufferedReader(new InputStreamReader(dStream));

            for (int i = 0; i < 11; i++)
            {
                oku = HaritaOku.readLine();

                String[] SayiCevir = oku.split("\\s+");
                for (int j = 0; j < SayiCevir.length; j++)
                {
                    Labirent[i][j] = Integer.parseInt(SayiCevir[j]);
                }
                veri.add(oku);
            }
            dStream.close();

            System.out.println("Harita Okundu..");
        }
        catch (Exception e)
        {
            System.out.println("HATA : " + e.getMessage());
        }
    }
}