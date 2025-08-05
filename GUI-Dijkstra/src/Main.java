import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main  {


    public static void main(String[] args) throws IOException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {  }


            JFrame j = new JFrame();
            j.setTitle("Gezgin Kargo Sirketi");

            j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            j.setSize(new Dimension(900, 600));
            j.add(new MainPencere());
            j.setVisible(true);




    }
}


