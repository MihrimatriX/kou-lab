package data;

import static data.TileGrid.matrisOku;
import static helpers.Artist.BeginSession;
import static helpers.Artist.QuickLoad;
import helpers.Clock;
import java.io.IOException;
import java.util.Scanner;
import okulister.Dusman;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Boot {

    public Boot() throws LWJGLException, IOException {
        BeginSession();

        int[][] map = matrisOku();

        TileGrid grid = new TileGrid(map);
        Dusman dusman = new Dusman(QuickLoad("sirin"), grid.getTile(5, 6), 64, 64, 5);

        while (!Display.isCloseRequested()) {

           
            Clock.update();
            dusman.Update();

            grid.Draw();
            dusman.Draw();

            Display.update();
            Display.sync(60);
        }
    }

    public static void main(String[] args) throws LWJGLException, IOException {
        System.out.println("Oyuncu Sec: ");
        //String oyuncuAd = new Scanner(System.in).nextLine();
        // System.out.println("Secilen : " + oyuncuAd);

        new Boot();
    }
}
