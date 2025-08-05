import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Cizimaraclari {
    private Graphics2D g;
    private static int cap = 12;


    public Cizimaraclari(Graphics2D graphics2D){
        g = graphics2D;
    }

    public static boolean sinirlarinicindemi(MouseEvent e, Point p) {   //Dugumler sinirlarin icinde mi
        int x = e.getX();
        int y = e.getY();

        int sinirX = (int) p.getX();
        int sinirY = (int) p.getY();

        return (x <= sinirX + cap && x >= sinirX - cap) && (y <= sinirY + cap && y >= sinirY - cap);
    }

    public static boolean cakisiyormu(MouseEvent e, Point p) {   //Dugumler cakisiyorlar mi
        int x = e.getX();
        int y = e.getY();

        int sinirX = (int) p.getX();
        int sinirY = (int) p.getY();

        return (x <= sinirX + 2.5* cap && x >= sinirX - 2.5* cap) && (y <= sinirY + 2.5* cap && y >= sinirY - 2.5* cap);
    }

    public static boolean kenarda(MouseEvent e, Kenar kenar) {    //Dugumler kenarlarin ustunde mi

        int msf = parcayaolanmesafe( e.getPoint(),
                                  kenar.getbirinci().getKoordinat(),
                                  kenar.getikinci().getKoordinat() );
        if (msf<6)
            return true;
        return false;
    }

    public static Color parseColor(String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
    }

    public void agirlikciz(Kenar kenar) {      //Kenar agirligini yazdirir
        Point from = kenar.getbirinci().getKoordinat();
        Point to = kenar.getikinci().getKoordinat();
        int x = (from.x + to.x)/2;
        int y = (from.y + to.y)/2;

        int rad = cap /2;
        g.fillOval(x-rad, y-rad, 2*rad, 2*rad);
        agirlikyazisi(String.valueOf(kenar.getAgirlik()), x, y);
    }

    public void yolciz(List<Dugum> path) {     //Yol cizdirir
        List<Kenar> kenars = new ArrayList<>();
        for(int i = 0; i < path.size()-1; i++) {
            kenars.add(new Kenar(path.get(i), path.get(i+1)));
        }

        for(Kenar kenar : kenars) {
            yolciz(kenar);
        }
    }

    public void yolciz(Kenar kenar) {
        g.setColor(parseColor("#00fffb"));   //Yol rengi
        kalinkenarciz(kenar);
    }

    public void kenardisiciz(Kenar kenar) {    //Kenarlarin disini renklendirir
        g.setColor(parseColor("#ff0000"));
        kalinkenarciz(kenar);
    }

    private void kalinkenarciz(Kenar kenar){    //Kenarlari kalin gosterir
        Point from = kenar.getbirinci().getKoordinat();
        Point to = kenar.getikinci().getKoordinat();
        g.setStroke(new BasicStroke(8));
        g.drawLine(from.x, from.y, to.x, to.y);
        int x = (from.x + to.x)/2;
        int y = (from.y + to.y)/2;

        int rad = 13;
        g.fillOval(x-rad, y-rad, 2*rad, 2*rad);
    }

    public void kenarciz(Kenar kenar) {   //Kenar cizdirir
        g.setColor(parseColor("#000000"));    //Kenar rengi
        kenargovdesiciz(kenar);
        agirlikciz(kenar);
    }

    private void kenargovdesiciz(Kenar kenar){
        Point from = kenar.getbirinci().getKoordinat();
        Point to = kenar.getikinci().getKoordinat();
        g.setStroke(new BasicStroke(3));
        g.drawLine(from.x, from.y, to.x, to.y);
    }

    public void dishalkaciz(Dugum dugum){    //Kenarlara hare katar
        g.setColor(parseColor("#f6ff00")); //Hare rengi
        cap +=5;
        g.fillOval(dugum.getX() - cap, dugum.getY() - cap, 2 * cap, 2 * cap);
        cap -=5;
    }

    public void kaynakdugumciz(Dugum dugum){    //Kaynak dugumu cizdirir
        g.setColor(parseColor("#0008ff"));
        g.fillOval(dugum.getX() - cap, dugum.getY() - cap, 2 * cap, 2 * cap);

        cap -=5;
        g.setColor(parseColor("#000000"));
        g.fillOval(dugum.getX() - cap, dugum.getY() - cap, 2 * cap, 2 * cap);

        cap +=5;
        g.setColor(parseColor("#dbfbff"));
        merkeziyazi(String.valueOf(dugum.getId()), dugum.getX(), dugum.getY());
    }

    public void hedefdugumciz(Dugum dugum){   //Hedef dugumu cizdirir
        g.setColor(parseColor("#ff0000"));
        g.fillOval(dugum.getX() - cap, dugum.getY() - cap, 2 * cap, 2 * cap);

        cap -=5;
        g.setColor(parseColor("#ffffff"));
        g.fillOval(dugum.getX() - cap, dugum.getY() - cap, 2 * cap, 2 * cap);

        cap +=5;
        g.setColor(parseColor("#ff0000"));
        merkeziyazi(String.valueOf(dugum.getId()), dugum.getX(), dugum.getY());
    }

    public void dugumciz(Dugum dugum){    //Dugum cizdirir
        g.setColor(parseColor("#2cb027"));
        g.fillOval(dugum.getX() - cap, dugum.getY() - cap, 2 * cap, 2 * cap);

        cap -=5;
        g.setColor(parseColor("#000000"));
        g.fillOval(dugum.getX() - cap, dugum.getY() - cap, 2 * cap, 2 * cap);

        cap +=5;
        g.setColor(parseColor("#ffffff"));
        merkeziyazi(String.valueOf(dugum.getId()), dugum.getX(), dugum.getY());
    }

    public void agirlikyazisi(String text, int x, int y) { //Agirlik girilen text kutusunu cizdirir
        g.setColor(parseColor("#cccccc"));
        FontMetrics fm = g.getFontMetrics();
        double t_width = fm.getStringBounds(text, g).getWidth();
        g.drawString(text, (int) (x - t_width / 2), (y + fm.getMaxAscent() / 2));
    }

    public void merkeziyazi(String text, int x, int y) {
        FontMetrics fm = g.getFontMetrics();
        double t_width = fm.getStringBounds(text, g).getWidth();
        g.drawString(text, (int) (x - t_width / 2), (y + fm.getMaxAscent() / 2));
    }


    // Hesaplamalar
    private static int karesinial(int x) {
        return x * x;
    }
    private static int mesafe2(Point v, Point w) {
        return karesinial(v.x - w.x) + karesinial(v.y - w.y);
    }
    private static int karesialinmismesafe(Point p, Point v, Point w) {
        double l2 = mesafe2(v, w);
        if (l2 == 0) return mesafe2(p, v);
        double t = ((p.x - v.x) * (w.x - v.x) + (p.y - v.y) * (w.y - v.y)) / l2;
        if (t < 0) return mesafe2(p, v);
        if (t > 1) return mesafe2(p, w);
        return mesafe2(p, new Point(
                (int)(v.x + t * (w.x - v.x)),
                (int)(v.y + t * (w.y - v.y))
        ));
    }
    private static int parcayaolanmesafe(Point p, Point v, Point w) {
        return (int) Math.sqrt(karesialinmismesafe(p, v, w));
    }

}
