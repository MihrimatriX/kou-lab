package com.asansor.thread;

public class AvmManager
{
    private binakatlari[] Binakatlari;

    public AvmManager()
    {
        Binakatlari = new binakatlari[5];

        for (int i = 0; i < 5; i ++)
        {
            Binakatlari[i] = new binakatlari();
        }
    }

    public synchronized void yolcu_istekleri_artirir(int kat, int hedef, int sayi)
    {
        this.Binakatlari[kat].increasePassengersRequests(hedef, sayi);
    }

    public synchronized ElevatorEvent sonraki_istegial(int kat, int asansorid)
    {
        // Herhangi bir etkinliğin olup olmadiğini kontrol et
       for (int i = 0; i < 5; i++)
       {
           binakatlari fl = Binakatlari[i];
           if (fl.getYaklasan_asansor() == -1 && fl.yolcuisteklerini_al())
           {
               fl.setYaklasan_asansor(asansorid);
               return new ElevatorEvent(i, SimClock.getTime() + Math.abs(i - kat) * 5 + 10);
           }
       }
        return null;
    }

    public synchronized int[] yolculari_yukle(int kat, int asansorid)
    {
        this.Binakatlari[kat].setYaklasan_asansor(-1);
        // ilk önce hepsini doldur yoksa boşalt
        int[] yuklenmis = new int[5];
        int[] istekler = this.Binakatlari[kat].getYolcuistekleri();
        boolean yukari_mi = false;

        //TODO Kontrol Thread

        for (int i = kat; i < istekler.length; i ++)
        {
            if (istekler[i] != 0) {
//                events.add(new ElevatorEvent(i, Math.abs(i - floor) * 5 + timeToLoad));
                yuklenmis[i] = istekler[i];
                istekler[i] = 0;
                yukari_mi = true;
            }
        }
        // yolcu yükle
        if (!yukari_mi)
        {
            this.Binakatlari[kat].setYolcuistekleri(yuklenmis);
            return istekler;
        }
        this.Binakatlari[kat].setYolcuistekleri(istekler);
        return yuklenmis;
    }

    public synchronized void yolculari_bosalt(int kat, int kat_numarasi, int nerden)
    {
        this.Binakatlari[kat].increaseArrivedPassengers(nerden, kat_numarasi);
    }

    public synchronized int[] toplamyolcu_istekleri(int floor)
    {
        return this.Binakatlari[floor].getToplamhedefistegi();
    }
    public synchronized int[] toplamvarmis_yolcular(int floor)
    {
        return this.Binakatlari[floor].getVaranyolcular();
    }
}