import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class MainPencere extends JPanel {

    private Graf graf;
    private Grafpaneli grafpaneli;

    public MainPencere() throws IOException {
        super.setLayout(new BorderLayout());
        setGraphPanel();
    }


    private void setGraphPanel(){
        graf = new Graf();
        grafpaneli = new Grafpaneli(graf);
        grafpaneli.setPreferredSize(new Dimension(750, 500));

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(grafpaneli);
        scroll.setPreferredSize(new Dimension(750, 500));
        scroll.getViewport().setViewPosition(new Point(4100, 0));
        add(scroll, BorderLayout.CENTER);

        setButtons();

    }



    private void setButtons(){
        JButton run = new JButton();
        Iconal(run, "run");
        JButton reset = new JButton();
        Iconal(reset, "reset");
        final JButton info = new JButton();
        Iconal(info, "info");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Cizimaraclari.parseColor("#DDDDDD"));
        buttonPanel.add(reset);
        buttonPanel.add(run);
        buttonPanel.add(info);


        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grafpaneli.reset();
            }
        });

        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Yeni dugum olusturmak icin bos bir alana tiklayin\n" +
                        "Kenar olusturmak icin dugumlerden dugume tiklayin\n" +
                        "Kenarlara agirlik koymak icin ustune tiklayin\n\n" +
                        "Tus kombinasyonlari:\n" +
                        "Shift + Left Click       :    Kaynagi secer\n" +
                        "Shift + Right Click     :    Hedefi secer\n" +
                        "Ctrl  + Drag               :   Secili nesnenin  Yerini degistirir\n" +
                        "Ctrl  + Click                :    Dugume giden  yolu gösterir\n" +
                        "Ctrl  + Shift + Click   :    Dugum yada kenar siler\n");
            }
        });

        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dijkstra dijkstra = new Dijkstra(graf);
                try{
                    dijkstra.run();
                    grafpaneli.setYol(dijkstra.gethedefyolu());
                } catch (IllegalStateException ise){
                    JOptionPane.showMessageDialog(null, ise.getMessage());
                }
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void Iconal(JButton buton, String img){
        try {
            Image icon = ImageIO.read(getClass().getResource(
                    "/kaynak/" + img + ".png"));
            ImageIcon imageIcon = new ImageIcon(icon);
            buton.setIcon(imageIcon);
            buton.setBorderPainted(false);
            buton.setFocusPainted(false);
            buton.setContentAreaFilled(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}




