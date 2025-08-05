package siniflar;

import javafx.scene.image.Image;

public class Basketbolcu extends Sporcu
{
    private String basketbolcuAdi;
    private String basketbolcuTakim;
    private int ikilik;
    private int ucluk;
    private int serbestAtis;
    private boolean kartKullanildimi;
    public Image kartResim;

    public Image getKartResim() {
        return kartResim;
    }

    public void setKartResim(Image kartResim) {
        this.kartResim = kartResim;
    }

    public boolean isKartKullanildimi() {
        return kartKullanildimi;
    }

    public void setKartKullanildimi(boolean kartKullanildimi) {
        this.kartKullanildimi = kartKullanildimi;
    }

    public Basketbolcu(String sporcuIsim, String sporcuTakim, String basketbolcuAdi, String basketbolcuTakim, Image image) {
        super(sporcuIsim, sporcuTakim, image);
        this.basketbolcuAdi = basketbolcuAdi;
        this.basketbolcuTakim = basketbolcuTakim;
        this.kartResim = image;
    }

    public Basketbolcu() {
    }

    public String getBasketbolcuAdi() {
        return basketbolcuAdi;
    }

    public void setBasketbolcuAdi(String basketbolcuAdi) {
        this.basketbolcuAdi = basketbolcuAdi;
    }

    public String getBasketbolcuTakim() {
        return basketbolcuTakim;
    }

    public void setBasketbolcuTakim(String basketbolcuTakim) {
        this.basketbolcuTakim = basketbolcuTakim;
    }

    public int getIkilik() {
        return ikilik;
    }

    public void setIkilik(int ikilik) {
        this.ikilik = ikilik;
    }

    public int getUcluk() {
        return ucluk;
    }

    public void setUcluk(int ucluk) {
        this.ucluk = ucluk;
    }

    public int getSerbestAtis() {
        return serbestAtis;
    }

    public void setSerbestAtis(int serbestAtis) {
        this.serbestAtis = serbestAtis;
    }

    @Override
    public void sporcuPuaniGoster() {
        super.sporcuPuaniGoster();
    }
}
