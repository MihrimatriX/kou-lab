package okulister;

import data.Tile;
import static helpers.Artist.DrawQuadTex;
import helpers.Clock;
import static helpers.Clock.Delta;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

public class Dusman extends Karakter {

    private int width, height, health;
    private float speed, x, y;
    private Texture texture;
    private Tile startTile;

    private boolean first = true;

    public Dusman(Texture texture, Tile startTile, int width, int height, float speed) {
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = width;
        this.height = height;
        //this.health = health;
        this.speed = speed;
        this.texture = texture;
    }

    public void Update() {

        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
                System.out.println("Right");

            }
        }

        /*if (first) {
            first = false;
        } else {
            x += Delta() * speed;
        }*/
    }

    public void Draw() {
        DrawQuadTex(texture, x, y, width, height);
    }

}
