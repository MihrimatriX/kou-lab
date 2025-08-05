import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;


public class Grafpaneli extends JPanel implements MouseListener, MouseMotionListener {

    private Cizimaraclari cizimaraclari;

    private Graf graf;                 //Kenar, dugum, graf tanimlamalari

    private Dugum seciliDugum = null;
    private Dugum VurgulanmisDugum = null;
    private Kenar VurgulanmisKenar = null;

    private List<Dugum> yol = null;

    private Point ımlec;      //imlec



    public Grafpaneli(Graf graf){
        this.graf = graf;

        addMouseListener(this);       //Fare dinleyicisi
        addMouseMotionListener(this);
    }

    public void setYol(List<Dugum> yol) {
        this.yol = yol;
        VurgulanmisKenar = null;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon ic = new ImageIcon("src\\kaynak\\tr.png"); // Graf paneli resmimiz
        Graphics2D graphics2d = (Graphics2D) g;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.drawImage(ic.getImage(), 0, 0, getWidth(), getHeight(), null); //Arka Plan Resimi cizdirme fonksiyonumuz
        cizimaraclari = new Cizimaraclari(graphics2d);

        if(graf.isSolved()){
            cizimaraclari.yolciz(yol);
        }

        if(seciliDugum != null && ımlec != null){   //Kenar cizdirme kontrolu
            Kenar e = new Kenar(seciliDugum, new Dugum(ımlec));
            cizimaraclari.kenarciz(e);
        }

        for(Kenar kenar : graf.getKenars()){       //Ustune gelinen kenari daha kalin gosterip kenari cizer
            if(kenar == VurgulanmisKenar)
                cizimaraclari.kenardisiciz(kenar);
            cizimaraclari.kenarciz(kenar);
        }

        for(Dugum dugum : graf.getDugums()){
            if(dugum == seciliDugum || dugum == VurgulanmisDugum)      //Dugumu belli durumlarda hareli cizer
                cizimaraclari.dishalkaciz(dugum);
            if(graf.kaynaksa(dugum))
                cizimaraclari.kaynakdugumciz(dugum);
            else if(graf.hedefse(dugum))
                cizimaraclari.hedefdugumciz(dugum);
            else
                cizimaraclari.dugumciz(dugum);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Dugum secili = null;
        for(Dugum dugum : graf.getDugums()) {     //Secilen koordinata dugum cizer
            if(Cizimaraclari.sinirlarinicindemi(e, dugum.getKoordinat())){
                secili = dugum;
                break;
            }
        }

        if(secili!=null) {
            if(e.isControlDown() && e.isShiftDown()){         //Tus makrolarimiz
                graf.dugumsil(secili);
                graf.setSolved(false);
                repaint();
                return;
            } else if(e.isControlDown() && graf.isSolved()){
                yol = secili.getYol();
                repaint();
                return;
            } else if(e.isShiftDown()){
                if(SwingUtilities.isLeftMouseButton(e)){
                    if(!graf.hedefse(secili))
                        graf.setKaynak(secili);
                    else
                        JOptionPane.showMessageDialog(null, "Hedef kaynak olarak atanamaz");
                } else if(SwingUtilities.isRightMouseButton(e)) {
                    if(!graf.kaynaksa(secili))
                        graf.setHedef(secili);
                    else
                        JOptionPane.showMessageDialog(null, "Kaynak hedef olarak secilemez");
                }else
                    return;

                graf.setSolved(false);
                repaint();
                return;
            }
        }

        if(VurgulanmisKenar !=null){
            if(e.isControlDown() && e.isShiftDown()){
                graf.getKenars().remove(VurgulanmisKenar);
                VurgulanmisKenar = null;
                graf.setSolved(false);
                repaint();
                return;
            }

            String input = JOptionPane.showInputDialog("Agirlik girin " + VurgulanmisKenar.toString()
                                                        + " : ");
            try {
                int agirlik = Integer.parseInt(input);
                if (agirlik > 0) {
                    VurgulanmisKenar.setAgirlik(agirlik);
                    graf.setSolved(false);
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "Agirlik positif olmalidir");
                }
            } catch (NumberFormatException nfe) {}
            return;
        }

        for(Dugum dugum : graf.getDugums()) {
            if(Cizimaraclari.cakisiyormu(e, dugum.getKoordinat())){
                JOptionPane.showMessageDialog(null, "Ust uste dugum olusturulamaz");
                return;
            }
        }

        graf.dugumekle(e.getPoint());
        graf.setSolved(false);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (Dugum dugum : graf.getDugums()) {
            if(seciliDugum !=null && dugum != seciliDugum && Cizimaraclari.sinirlarinicindemi(e, dugum.getKoordinat())){
                Kenar new_kenar = new Kenar(seciliDugum, dugum);
                graf.kenarekle(new_kenar);
                graf.setSolved(false);
            }
        }
        seciliDugum = null;
        VurgulanmisDugum = null;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        VurgulanmisDugum = null;

        for (Dugum dugum : graf.getDugums()) {
            if(seciliDugum ==null && Cizimaraclari.sinirlarinicindemi(e, dugum.getKoordinat())){
                seciliDugum = dugum;
            } else if(Cizimaraclari.sinirlarinicindemi(e, dugum.getKoordinat())) {
                VurgulanmisDugum = dugum;
            }
        }

        if(seciliDugum !=null){
            if(e.isControlDown()){
                seciliDugum.setKoordinat(e.getX(), e.getY());
                ımlec = null;
                repaint();
                return;
            }

            ımlec = new Point(e.getX(), e.getY());
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        if(e.isControlDown()){
            VurgulanmisDugum = null;
            for (Dugum dugum : graf.getDugums()) {
                if(Cizimaraclari.sinirlarinicindemi(e, dugum.getKoordinat())) {
                    VurgulanmisDugum = dugum;
                }
            }
        }

        VurgulanmisKenar = null;

        for (Kenar kenar : graf.getKenars()) {
            if(Cizimaraclari.kenarda(e, kenar)) {
                VurgulanmisKenar = kenar;
            }
        }

        repaint();
    }

    public void reset(){    //Reset butonumuz
        graf.temizle();
        seciliDugum = null;
        VurgulanmisDugum = null;
        VurgulanmisKenar = null;
        repaint();
    }
}
