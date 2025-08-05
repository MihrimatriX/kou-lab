package data;

import static helpers.Artist.*;
import java.io.IOException;
import org.newdawn.slick.opengl.Texture;

public class Tile {

    private float x, y, width, heigth;
    private Texture texture;
    private TileType type;

    
    public void Draw()
    {
        DrawQuadTex(texture, x, y, width, heigth);
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeigth() {
        return heigth;
    }

    public void setHeigth(float heigth) {
        this.heigth = heigth;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public Tile(float x, float y, float width, float height, TileType type) throws IOException {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = height;
        this.type = type;
        this.texture = QuickLoad(type.textureName);
    }
}
