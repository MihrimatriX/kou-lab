package com.asansor.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AsansorSimulasyonu
{
    int simulasyon_suresi;
    int rateSimTime;
    List<List<YolcuGelisi>> behaviorsOfFloors;

    public AsansorSimulasyonu(int simulasyon_suresi, int rateSimTime, List<List<YolcuGelisi>> behaviorsOfFloors)
    {
        this.simulasyon_suresi = simulasyon_suresi;
        this.rateSimTime = rateSimTime;
        this.behaviorsOfFloors = behaviorsOfFloors;
    }

    public void start() throws InterruptedException
    {
        new SimClock(); // Süreyi başlat

        AvmManager bm = new AvmManager();
        Thread[] threads = new Thread[5];
        Asansor[] asansors = new Asansor[5];

        for (int i = 0; i < 5; i++)
        {
            Asansor asansor = new Asansor(i, bm);
            threads[i] = new Thread(asansor);
            threads[i].start();
            asansors[i] = asansor;
        }

        int suanki_zaman = SimClock.getTime();

        while (suanki_zaman < simulasyon_suresi)
        {
            // İstekte bulunan yolculari say
            for (int i = 0; i < behaviorsOfFloors.size(); i++)
            {
                List<YolcuGelisi> behaviors = behaviorsOfFloors.get(i);
                for (YolcuGelisi pa : behaviors)
                {
                    if (pa.getTahminiVarisSuresi() == suanki_zaman)
                    {
                        bm.yolcu_istekleri_artirir(i, pa.getHedefKat(), pa.getYolcuSayilari());
                        System.out.println(String.format("[%d] Kisi Giris Yapti\tSu Kata:[%d]\tBu Kata Gidecek:[%d]",
                                pa.getYolcuSayilari(),
                                i,
                                pa.getHedefKat()
                        ));
                        pa.setTahminiVarisSuresi(suanki_zaman + pa.getZamanPeriyodu());
                    }
                }
            }

            TimeUnit.MILLISECONDS.sleep(rateSimTime);
            SimClock.tick();
            suanki_zaman = SimClock.getTime();
        }
        //Threadleri Durdurur ve Print Yapar
        for (int i = 0; i < 5; i++)
        {
            threads[i].interrupt();
        }
        //Tüm Threadler Olene Kadar Bilgileri Printle
        TimeUnit.SECONDS.sleep(1);
        for (int i = 0; i < 5; i++)
        {
            /**
             * @Kontrol : Konrol Thread
             */
            System.out.println(String.format("Suanki Kat:[%d]\tFarkli Katlar Icin Talepleri: %s", i, Arrays.toString(bm.toplamyolcu_istekleri(i))));
            System.out.println(String.format("Suanki Kat:[%d]\tFarkli Katlardan Varan Yolcular: %s", i, Arrays.toString(bm.toplamvarmis_yolcular(i))));
        }
        for (int i = 0; i < 5; i++)
        {
            System.out.println(String.format("Su Asansor:[%d]\tToplam Yuklenmis Yolcu:[%d]\tToplam Inmis Yolcu:[%d]", i, asansors[i].getToplamyuklenmis_yolcular(), asansors[i].getToplamindirilmis_yolcular()
            ));
        }
    }
}