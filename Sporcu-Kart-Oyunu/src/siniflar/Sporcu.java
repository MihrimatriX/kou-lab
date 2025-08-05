package siniflar;

import javafx.scene.image.Image;

public class Sporcu {
    String sporcuIsim;
    String sporcuTakim;
    Image resim;

    public Sporcu(String sporcuIsim, String sporcuTakim, Image image) {
        this.sporcuIsim = sporcuIsim;
        this.sporcuTakim = sporcuTakim;
        this.resim = image;
    }

    public Sporcu() {

    }

    public String getSporcuIsim() {
        return sporcuIsim;
    }

    public Image getResim() {
        return resim;
    }

    public String getSporcuTakim() {
        return sporcuTakim;
    }

    public void setResim(Image resim) {
        this.resim = resim;
    }

    public void setSporcuIsim(String sporcuIsim) {
        this.sporcuIsim = sporcuIsim;
    }

    public void setSporcuTakim(String sporcuTakim) {
        this.sporcuTakim = sporcuTakim;
    }

    public void sporcuPuaniGoster() {
    }
}