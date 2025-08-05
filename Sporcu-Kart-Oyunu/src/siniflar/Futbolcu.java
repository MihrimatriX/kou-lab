package siniflar;

import javafx.scene.image.Image;

public class Futbolcu extends Sporcu {
    String futbolcuAdi;
    String futbolcuTakim;
    int penalti;
    int serbestAtis;
    int kaleciKarsiKarsiya;
    boolean kartKullanildiMi;
    public Image kartResim;


    public Image getKartResim() {
        return kartResim;
    }

    public void setKartResim(Image kartResim) {
        this.kartResim = kartResim;
    }

    public String getFutbolcuAdi() {
        return futbolcuAdi;
    }

    public void setFutbolcuAdi(String futbolcuAdi) {
        this.futbolcuAdi = futbolcuAdi;
    }

    public String getFutbolcuTakim() {
        return futbolcuTakim;
    }

    public void setFutbolcuTakim(String futbolcuTakim) {
        this.futbolcuTakim = futbolcuTakim;
    }

    public int getPenalti() {
        return penalti;
    }

    public void setPenalti(int penalti) {
        this.penalti = penalti;
    }

    public int getSerbestAtis() {
        return serbestAtis;
    }

    public void setSerbestAtis(int serbestAtis) {
        this.serbestAtis = serbestAtis;
    }

    public int getKaleciKarsiKarsiya() {
        return kaleciKarsiKarsiya;
    }

    public void setKaleciKarsiKarsiya(int kaleciKarsiKarsiya) {
        this.kaleciKarsiKarsiya = kaleciKarsiKarsiya;
    }

    public boolean isKartKullanildiMi() {
        return kartKullanildiMi;
    }

    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }

    public Futbolcu(String sporcuIsim, String sporcuTakim, String futbolcuAdi, String futbolcuTakim, Image image) {
        super(sporcuIsim, sporcuTakim, image);
        this.futbolcuAdi = futbolcuAdi;
        this.futbolcuTakim = futbolcuTakim;
        this.kartResim = image;
    }

    @Override
    public void sporcuPuaniGoster() {
        super.sporcuPuaniGoster();
    }
}
