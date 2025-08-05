package com.asansor.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Asansor implements Runnable
{
    //Asansör ve yapması gereken davranışı gösteren sınıf

    private int asansorid;
    private int suankikat;
    private int yolcu_sayisi;
    private int toplamyuklenmis_yolcular;
    private int toplamindirilmis_yolcular;
    private ArrayList<ElevatorEvent> moveQueue;
    private int[] yolcu_hedefleri; // integer dizisi
    private AvmManager yonetici;

    public Asansor(int asansorid, AvmManager yonetici)
    {
        this.asansorid = asansorid;
        this.yonetici = yonetici;
        this.suankikat = 0;
        this.yolcu_sayisi = 0;
        this.toplamyuklenmis_yolcular = 0;
        this.toplamindirilmis_yolcular = 0;
        this.moveQueue = new ArrayList<>();
    }

    public int getSuankikat()
    {
        return suankikat;
    }

    public int getYolcu_sayisi()
    {
        return yolcu_sayisi;
    }

    public int getToplamyuklenmis_yolcular()
    {
        return toplamyuklenmis_yolcular;
    }

    public ArrayList<ElevatorEvent> kuyruguhareket_ettir()
    {
        return this.moveQueue;
    }

    public int getToplamindirilmis_yolcular()
    {
        return toplamindirilmis_yolcular;
    }

    public void yuklenmisyolcusayisi_artir(int newLoaded)
    {
        this.toplamyuklenmis_yolcular += newLoaded;
    }

    public void indirilmemisyolcusayisi_artir(int newUnloadedPassengers)
    {
        this.toplamindirilmis_yolcular += newUnloadedPassengers;
    }

    public void kuyruguhareketicin_ekle(ElevatorEvent event)
    {
        if (event != null)
        {
            this.moveQueue.add(event);
        }
    }

    public void kuyruguhareketicin_ekle(List<ElevatorEvent> events)
    {
        this.moveQueue.addAll(events);
    }

    public ElevatorEvent yuklenmis_yolcular(int[] istekler)
    {
        List<ElevatorEvent> newEvents = new ArrayList<>();
        int yuklemekicin_zaman = 0;
        int toplamyeni_yolcu = 0;
        for (int i = this.suankikat; i < 5; i++)
        {
            if (istekler[i] != 0)
            {
                newEvents.add(new ElevatorEvent(i, SimClock.getTime() + Math.abs(i - this.suankikat) * 5 + yuklemekicin_zaman));
                yuklemekicin_zaman += 10;
                toplamyeni_yolcu += istekler[i];
                System.out.println(String.format("[%d] Saniye \tToplam %s Yolcu Su Asansorde:[%s]\tSu Katta:[%s]", SimClock.getTime(), toplamyeni_yolcu, this.asansorid, i));
                System.out.println(String.format("Indirme Talebi ->\t[%d] Saniye Su Asansorde:[%s]\tSu Katta:[%s]", SimClock.getTime(), this.asansorid, this.suankikat));
            }
        }

        if (newEvents.isEmpty())
        {
            for (int i = suankikat - 1; i >= 0; i--)
            {
                if (istekler[i] != 0)
                {
                    newEvents.add(new ElevatorEvent(i, SimClock.getTime() + Math.abs((i - suankikat)) * 5 + yuklemekicin_zaman));
                    yuklemekicin_zaman += 10;
                    toplamyeni_yolcu += istekler[i];
                    System.out.println(String.format("[%d] Saniye \tToplam %s Yolcu Su Asansorde:[%s]\tSu Katta:[%s]", SimClock.getTime(), toplamyeni_yolcu, this.asansorid, i));
                    System.out.println(String.format("Indirme Talebi ->\t[%d] Saniye Su Asansorde:[%s]\tSu Katta:[%s]", SimClock.getTime(), this.asansorid, this.suankikat));
                }
            }
        }
        this.kuyruguhareketicin_ekle(newEvents);

        this.yolcu_hedefleri = istekler;
        this.yolcu_sayisi = toplamyeni_yolcu;
        this.yuklenmisyolcusayisi_artir(toplamyeni_yolcu);
        return newEvents.get(0);
    }

    public void inmemis_yolcu(int floor)
    {
        System.out.println(String.format("[%d] Saniye\tSu Kadar Yoldu Indiriliyor:[%s]\tSu Asansorde:[%s]\tSu Katta:[%s]", SimClock.getTime(), this.yolcu_hedefleri[floor], this.asansorid, floor));
        this.moveQueue.remove(0);
        this.indirilmemisyolcusayisi_artir(yolcu_hedefleri[floor]);
        this.yolcu_sayisi -= yolcu_hedefleri[floor];
        this.yolcu_hedefleri[floor] = 0;
    }

    public AvmManager bina_yoneticisi()
    {
        return this.yonetici;
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (this.getYolcu_sayisi() == 0 && this.kuyruguhareket_ettir().isEmpty())
            {
                // bossa sıradaki işe geç
                ElevatorEvent event = this.bina_yoneticisi().sonraki_istegial(this.getSuankikat(), this.asansorid);
                if (event != null)
                {
                    this.kuyruguhareketicin_ekle(event);
                    System.out.println(String.format("[%d] Saniye\tSu Asansor:[%d]\tSu Kata Almak Icin Gidiyor:[%d]", SimClock.getTime(), this.asansorid, event.hedefi_al()
                    ));
                }
            }
            else if (!this.kuyruguhareket_ettir().isEmpty())
            {
                ElevatorEvent event = this.kuyruguhareket_ettir().get(0);

                if (event.tahminivarisi_al() <= SimClock.getTime())
                {
                    System.out.println(String.format("[%d] Saniye\tSu Asansor:[%d]\tSu Kata Ulasti:[%d]", SimClock.getTime(), this.asansorid, event.hedefi_al()));
                    if (this.getYolcu_sayisi() == 0)
                    {
                        this.suankikat = event.hedefi_al();
                        this.kuyruguhareket_ettir().remove(0);
                        int[] requests = this.bina_yoneticisi().yolculari_yukle(this.suankikat, this.asansorid);

                        //TODO Asansor Boyut

                        System.out.println(String.format("[%d] Saniye\tSu Asansor:[%d]\tSu Kata Ulasti:[%d]\tSu Hedeflerden Yolcu Almaya Gidecek:[%s]", SimClock.getTime(), this.asansorid, event.hedefi_al(), Arrays.toString(requests)));
                        ElevatorEvent firstEvent = this.yuklenmis_yolcular(requests);
                        System.out.println(String.format("[%d] Saniye\tSu Asansor:[%d]\tSu Kata Indirmek Icin Ulasti:[%d]", SimClock.getTime(), this.asansorid, firstEvent.hedefi_al()));
                    }
                    else
                    {
                        System.out.println(String.format("[%d] Saniye\tSu Asansor:[%d]\tSu Kata Ulasti:[%d]\tSu Kadar Yolcu Indirdi:[%d]", SimClock.getTime(), this.asansorid, event.hedefi_al(), this.yolcu_hedefleri[event.hedefi_al()]));
                        this.bina_yoneticisi().yolculari_bosalt(event.hedefi_al(), this.yolcu_hedefleri[event.hedefi_al()], this.suankikat);
                        this.inmemis_yolcu(event.hedefi_al());
                        if (!this.kuyruguhareket_ettir().isEmpty())
                        {
                            ElevatorEvent nextEvent = this.kuyruguhareket_ettir().get(0);
                            System.out.println(String.format("[%d] Saniye\tSu Asansor:[%d]\tSu Kata Indirmek Icin Ulasti:[%d]", SimClock.getTime(), this.asansorid, nextEvent.hedefi_al()));
                        }
                    }
                }
            }
        }
    }
}
