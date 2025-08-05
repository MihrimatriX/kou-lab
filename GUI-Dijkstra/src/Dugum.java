import java.awt.*;
import java.util.List;

public class Dugum {
    private Point koordinat = new Point();
    private int id;
    private List<Dugum> yol;

    public Dugum(){}

    public Dugum(int id){
        this.id = id;
    }

    public Dugum(Point p){
        this.koordinat = p;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setKoordinat(int x, int y){
        koordinat.setLocation(x, y);
    }

    public Point getKoordinat(){
        return koordinat;
    }

    public void setYol(List<Dugum> yol) {
        this.yol = yol;
    }

    public List<Dugum> getYol() {
        return yol;
    }

    public int getX(){
        return (int) koordinat.getX();
    }

    public int getY(){
        return (int) koordinat.getY();
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Dugum " + id;
    }  // Dugum bilgisini doner
}
