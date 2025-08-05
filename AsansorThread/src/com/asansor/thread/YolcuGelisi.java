package com.asansor.thread;

public class YolcuGelisi
{
    private int yolcuSayilari;
    private int hedefKat;
    private int zamanPeriyodu;
    private int tahminiVarisSuresi;

    public YolcuGelisi(int yolcuSayilari, int hedefKat)
    {
        this.yolcuSayilari = yolcuSayilari;
        this.hedefKat = hedefKat;
        this.zamanPeriyodu = 200;
        this.tahminiVarisSuresi = 200;
    }

    public YolcuGelisi(int yolcuSayilari, int hedefKat, int zamanPeriyodu, int tahminiVarisSuresi) {
        this.yolcuSayilari = yolcuSayilari;
        this.hedefKat = hedefKat;
        this.zamanPeriyodu = zamanPeriyodu;
        this.tahminiVarisSuresi = tahminiVarisSuresi;
    }

    public int getYolcuSayilari() {
        return yolcuSayilari;
    }

    public void setYolcuSayilari(int yolcuSayilari) {
        this.yolcuSayilari = yolcuSayilari;
    }

    public int getHedefKat() {
        return hedefKat;
    }

    public void setHedefKat(int hedefKat) {
        this.hedefKat = hedefKat;
    }

    public int getZamanPeriyodu() {
        return zamanPeriyodu;
    }

    public void setZamanPeriyodu(int zamanPeriyodu) {
        this.zamanPeriyodu = zamanPeriyodu;
    }

    public int getTahminiVarisSuresi() {
        return tahminiVarisSuresi;
    }

    public void setTahminiVarisSuresi(int tahminiVarisSuresi) {
        this.tahminiVarisSuresi = tahminiVarisSuresi;
    }
}