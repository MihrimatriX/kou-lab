import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javazoom.jl.decoder.JavaLayerException;

public class GirisEkrani extends JFrame
{
    public BufferedImage Yer;
    public BufferedImage Duvar;
    public BufferedImage CanBar;

    private final List<Integer> yol = new ArrayList<Integer>();

    public GirisEkrani() throws IOException, FileNotFoundException, JavaLayerException
    {
        KarakterSec secim = new KarakterSec();

        Duvar = ImageIO.read(new File("src\\Texture\\Duvar.png"));
        Yer = ImageIO.read(new File("src\\Texture\\Yol.png"));
        CanBar = ImageIO.read(new File("src\\Texture\\Can.png"));

        setTitle("        <<<<<<<<<<<<<<   Star Wars Maze    >>>>>>>>>>>>>>>>");
        setSize(710, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        setResizable(false);
        HaritaCizim harita = new HaritaCizim();

        SesFX ses = new SesFX();
       //ses.sesCal();//TODO SES ÇALMAK İÇİN BUNU AÇMAN YETERLİ.....

        harita.HaritaCiz();
        System.out.println("Harita Okundu Ve Uretildi ....");

        //KısaYolBul.araYol(HaritaCizim.Labirent, 1, 1,yol);
        //System.out.println(yol);
    }

    public String karsilayanYazi = "GURCAN - AFU PRESENTS"; //Karşilama Ekrani Olsun....

    public void paint(Graphics g)
    {
        int KalanCan = 3;
        super.paint(g);
        g.translate(5, 25);
        g.setColor(Color.BLACK);

        g.drawString(": KALAN HAKKINIZ :", 30,590);

        for (int i=0; i < KalanCan; i++)
        {
            g.drawImage(CanBar,30+(50*i),600,null);
        }

        for (int i = 0; i < HaritaCizim.Labirent.length; i++)
        {
            for (int j = 0; j < HaritaCizim.Labirent[0].length; j++)
            {
                /**
                 *      0 = Duvar
                 *      1 = Yol
                 */
                if (HaritaCizim.Labirent[i][j] == 0)
                {
                    g.drawImage(Duvar, (50 * j),(50 * i),null);
                }
                else
                    {
                    g.drawImage(Yer, (50 * j),(50 * i),null);
                }
            }
        }
    }

    protected void processKeyEvent(KeyEvent tus)//TUŞ KOMBİNASYONLARI
    {
        if (tus.getID() != KeyEvent.KEY_PRESSED)
        {
            return;
        }
        if ( tus.getKeyCode() == KeyEvent.VK_RIGHT && tus.getID() == KeyEvent.KEY_PRESSED )
        {/*
            if (HaritaCizim.Labirent[KarakterSec.SecilenKarakter.getY()][KarakterSec.SecilenKarakter.getX() + 1] == 1)
            {
                KarakterSec.SecilenKarakter.setLocation(KarakterSec.SecilenKarakter.getX() + 1,KarakterSec.SecilenKarakter.getY() + 1);
            }*/
            repaint();
        }
        if( tus.getKeyCode() == KeyEvent.VK_LEFT && tus.getID() == KeyEvent.KEY_PRESSED )
        {/*
            if (HaritaCizim.Labirent[KarakterSec.SecilenKarakter.getY()][KarakterSec.SecilenKarakter.getX() + 1] == 1)
            {
                KarakterSec.SecilenKarakter.setLocation(KarakterSec.SecilenKarakter.getX() - 1,KarakterSec.SecilenKarakter.getY() + 1);
            }*/
            repaint();
        }
        if( tus.getKeyCode() == KeyEvent.VK_UP && tus.getID() == KeyEvent.KEY_PRESSED )
        {/*
            if (HaritaCizim.Labirent[KarakterSec.SecilenKarakter.getY() - 1][KarakterSec.SecilenKarakter.getX()] == 1)
            {
                KarakterSec.SecilenKarakter.setLocation(KarakterSec.SecilenKarakter.getX(),KarakterSec.SecilenKarakter.getY() - 1);
            }*/
            repaint();
        }
        if( tus.getKeyCode() == KeyEvent.VK_DOWN && tus.getID() == KeyEvent.KEY_PRESSED )
        {/*
            if (HaritaCizim.Labirent[KarakterSec.SecilenKarakter.getY() + 1][KarakterSec.SecilenKarakter.getX()] == 1)
            {
                KarakterSec.SecilenKarakter.setLocation(KarakterSec.SecilenKarakter.getX(),KarakterSec.SecilenKarakter.getY() + 1);
            }*/
            repaint();
        }
    }
}