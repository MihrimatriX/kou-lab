import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javazoom.jl.decoder.JavaLayerException;

public class Main extends JFrame
{
    public static void main(String[] args) throws IOException, FileNotFoundException, JavaLayerException
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                GirisEkrani girisEkrani;
                try
                {
                    girisEkrani = new GirisEkrani();
                    girisEkrani.setVisible(true);
                }

                catch (IOException ex)
                {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

                catch (JavaLayerException ex)
                {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        System.out.println("Baslatildi.");
    }
}