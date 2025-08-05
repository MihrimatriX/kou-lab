package com.asansor.thread;

public class AvmGiris implements Runnable
{
    private int rastgeleKisiSayi;
    private int rastgeleKat;

    public int getRastgeleKisiSayi() {
        return rastgeleKisiSayi;
    }

    public int getRastgeleKat() {
        return rastgeleKat;
    }

    public void setRastgeleKisiSayi(int rastgeleKisiSayi)
    {
        this.rastgeleKisiSayi = rastgeleKisiSayi;
    }

    public void setRastgeleKat(int rastgeleKat)
    {
        this.rastgeleKat = rastgeleKat;
    }

    public void avmGirisSira()
    {
        rastgeleKat = (int) (1 + Math.random() * 4);
        rastgeleKisiSayi = (int) (1 + Math.random() * 9);

        System.out.println("Rastgele Kat Sayisi => " + rastgeleKat);
        System.out.println("Rastgele Kisi Sayisi => " + rastgeleKisiSayi);

        setRastgeleKat(rastgeleKat);
        setRastgeleKisiSayi(rastgeleKisiSayi);
    }

    @Override
    public void run()
    {
        while (true)
        {
            System.out.println("[.AVM GIRIS THREAD CALISIYOR.][----- GIRIS -----]");
            avmGirisSira();
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}