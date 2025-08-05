package okulister;

public class Karakter {

    private int ID;
    private String Ad;
    private String tur;

    private int[][] lokasyon;

    public void enKisaYol() {
        
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public int[][] getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(int[][] lokasyon) {
        this.lokasyon = lokasyon;
    }
}
