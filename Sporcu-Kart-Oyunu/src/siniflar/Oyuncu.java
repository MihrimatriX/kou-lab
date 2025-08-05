package siniflar;

import java.util.ArrayList;

public class Oyuncu
{
    int oyuncuID;
    String oyuncuAdi;
    public int skor;

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public Oyuncu(int oyuncuID, int skor, String oyuncuAdi) {
        this.oyuncuID = oyuncuID;
        this.skor = skor;
        this.oyuncuAdi = oyuncuAdi;
    }

    public void kartListesi(ArrayList kartlistesi) {

    }

    public void skorGoster() {

    }

    public void kartSec() {

    }
}