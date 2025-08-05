package okulister;

public class Oyuncu extends Karakter{
    private int oyuncuID;
    private String oyuncuAdi;
    private String oyuncuTur;
    private int skor;

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

    public String getOyuncuTur() {
        return oyuncuTur;
    }

    public void setOyuncuTur(String oyuncuTur) {
        this.oyuncuTur = oyuncuTur;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }
 
    public int PuaniGoster()
    {
        return this.skor;
    }
}
