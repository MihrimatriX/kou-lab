package com.asansor.thread;

import java.util.ArrayList;
import java.util.List;

public class AsansorProgrami
{
    public static int[] katNo = {0, 1, 2, 3, 4};
    public static int[] katKuyruk = {0,0,0,0,0};

    public static void main(String[] args) throws InterruptedException
    {
        int simulasyon_suresi = 10000;
        int rateSimTime = 1;
        List<List<YolcuGelisi>> behaviorsOfFloors = new ArrayList();

        List<YolcuGelisi> davranis = new ArrayList();


        for (int i = 0; i < katNo.length; i++) {//Sorgu Sayisi
//TODO Giris Cikis Sorgu
            YolcuGelisi pa = new YolcuGelisi(rastgeleKisi(), rastgeleKat(), 200, 200);
            YolcuGelisi pa2 = new YolcuGelisi(rastgeleKisi(),0);
            davranis.add(pa);
            davranis.add(pa2);

            behaviorsOfFloors.add(davranis);
        }




        AsansorSimulasyonu simulasyon = new AsansorSimulasyonu(simulasyon_suresi, rateSimTime, behaviorsOfFloors);

        Thread AvmGiris = new Thread(new AvmGiris());
        AvmGiris.start();

        Thread AvmCikis = new Thread(new AvmCikis());
        AvmCikis.start();

        simulasyon.start();
    }


    public static int rastgeleKat()
    {
        int rastgeleKat = (int) (1 + Math.random() * 4);
        return rastgeleKat;
    }

    public static int rastgeleKisi()
    {
        int rastgeleKisiSayi = (int) (1 + Math.random() * 9);
        return rastgeleKisiSayi;
    }

}