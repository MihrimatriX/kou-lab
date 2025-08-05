package oyun;

import javafx.scene.image.Image;
import siniflar.*;

import java.util.ArrayList;

public class Test {
    public int rastgelePuan;

    public Kullanici oyuncu = new Kullanici(1, 0, "Muhsin");
    public Bilgisayar bilgisayar = new Bilgisayar(2, 0, "Bilgisayar");

    public ArrayList<Sporcu> kartlarOyuncu = new ArrayList<>();
    public ArrayList<Sporcu> kartlarBilgisayar = new ArrayList<>();

    //TODO Uretim Kismi
    Basketbolcu drant = new Basketbolcu("Kevin Drant", "LA Laker", "Kevin Drant", "LA Laker", new Image("/texture/oyuncu_resimler/durant.jpg"));
    Basketbolcu hidayet = new Basketbolcu("Hidayet Turkoglu", "Utah Jazz", "Hidayet Turkoglu", "Utah Jazz", new Image("/texture/oyuncu_resimler/hidayet.jpg"));
    Basketbolcu kori = new Basketbolcu("Stephen Curry", "Brooklyn Nets", "Stephen Curry", "Brooklyn Nets", new Image("/texture/oyuncu_resimler/curry.jpg"));
    Basketbolcu jordan = new Basketbolcu("Michael Jordan", "Houstan Rockets", "Michael Jordan", "Houstan Rockets", new Image("/texture/oyuncu_resimler/jordan.jpg"));
    Basketbolcu cedi = new Basketbolcu("Cedi Osman", "Chicago Bulls", "Cedi Osman", "Chicago Bulls", new Image("/texture/oyuncu_resimler/cedi.jpg"));
    Basketbolcu kobe = new Basketbolcu("Kobe Byrant", "Haw Haws", "Kobe Byrant", "Haw Haws", new Image("/texture/oyuncu_resimler/kobe.jpg"));
    Basketbolcu okur = new Basketbolcu("Mehmet Okur", "Anadolu Efes", "Mehmet Okur", "Anadolu Efes", new Image("/texture/oyuncu_resimler/okur.jpg"));
    Basketbolcu datome = new Basketbolcu("GG Datome", "Caykur Rize", "GG Datome", "Caykur Rize", new Image("/texture/oyuncu_resimler/daotme.jpg"));

    Futbolcu messi = new Futbolcu("Lionel Messi", "Barcelona", "Lionel Messi", "Barcelona", new Image("/texture/oyuncu_resimler/messi.jpg"));
    Futbolcu maradona = new Futbolcu("Diego Maradona", "Napoli", "Diego Maradona", "Napoli", new Image("/texture/oyuncu_resimler/maradona.jpg"));
    Futbolcu neymar = new Futbolcu("Neymar JR", "Paris Saint-Germain", "Neymar JR", "Paris Saint-Germain", new Image("/texture/oyuncu_resimler/neymar.jpg"));
    Futbolcu ronaldo = new Futbolcu("Cristiano Ronaldo", "Real Madrid", "Cristiano Ronaldo", "Real Madrid", new Image("/texture/oyuncu_resimler/ronaldo.jpg"));
    Futbolcu pele = new Futbolcu("Pele", "Brezilya", "Pele", "Brezilya", new Image("/texture/oyuncu_resimler/peele.jpg"));
    Futbolcu alex = new Futbolcu("Alex De Souza", "Fenerbahce", "Alex De Souza", "Fenerbahce", new Image("/texture/oyuncu_resimler/alex.jpg"));
    Futbolcu sergio = new Futbolcu("Sergio Ramos", "Juventus", "Sergio Ramos", "Juventus", new Image("/texture/oyuncu_resimler/sergio.jpg"));
    Futbolcu hagi = new Futbolcu("Gheorghe Hagi", "Galatasaray", "Gheorghe Hagi", "Galatasaray", new Image("/texture/oyuncu_resimler/hagi.jpg"));

    //Toplam Futbol Ve Basket Kartlari
    ArrayList<Futbolcu> futbolKartlari = new ArrayList<>();
    ArrayList<Basketbolcu> basketKartlari = new ArrayList<>();

    int[] futbolKartIndis;
    int[] basketKartIndis;

    public void oyuncuAyarla() {
        futbolKartlari.add(messi);
        futbolKartlari.add(maradona);
        futbolKartlari.add(neymar);
        futbolKartlari.add(ronaldo);
        futbolKartlari.add(pele);
        futbolKartlari.add(alex);
        futbolKartlari.add(sergio);
        futbolKartlari.add(hagi);

        basketKartlari.add(drant);
        basketKartlari.add(hidayet);
        basketKartlari.add(kori);
        basketKartlari.add(jordan);
        basketKartlari.add(cedi);
        basketKartlari.add(kobe);
        basketKartlari.add(okur);
        basketKartlari.add(datome);

        for (int i = 0; i < futbolKartlari.size(); i++) {
            futbolKartlari.get(i).setPenalti(puanAta());
            futbolKartlari.get(i).setKaleciKarsiKarsiya(puanAta());
            futbolKartlari.get(i).setSerbestAtis(puanAta());
        }

        for (int i = 0; i < basketKartlari.size(); i++) {
            basketKartlari.get(i).setIkilik(puanAta());
            basketKartlari.get(i).setUcluk(puanAta());
            basketKartlari.get(i).setSerbestAtis(puanAta());
        }
        kartlariVer();
        indisGor();
    }

    public void kartlariVer()   //Kartlar Random Olarak 4-Basket 4-Futbol Verilecek.
    {
        //Oyuncu Kartlari Secim
        futbolKartIndis = new int[futbolKartlari.size()];
        basketKartIndis = new int[basketKartlari.size()];
        int sayi;

        //Futbol Kartlarin Indisi
        futbolKartIndis[0] = 0;
        for (int i = 1; i < 4; i++) {
            sayi = (int) (Math.random() * 8);
            for (int j = 0; j <= i; j++) {
                if (futbolKartIndis[j] == sayi) {
                    sayi = (int) (Math.random() * 8);
                    j = 0;
                }
            }
            futbolKartIndis[i] = sayi;
        }
        for (int i = 0; i < futbolKartlari.size(); i++) {
            if (i < 4) {
                kartlarOyuncu.add(futbolKartlari.get(i));
            } else {
                kartlarBilgisayar.add(futbolKartlari.get(i));
            }
        }

        //Basket Kartlarin Indisi
        basketKartIndis[0] = 0;
        for (int i = 1; i < 4; i++) {
            sayi = (int) (Math.random() * 8);
            for (int j = 0; j <= i; j++) {
                if (basketKartIndis[j] == sayi) {
                    sayi = (int) (Math.random() * 8);
                    j = 0;
                }
            }
            basketKartIndis[i] = sayi;
        }
        for (int i = 0; i < basketKartlari.size(); i++) {
            if (i < 4) {
                kartlarOyuncu.add(basketKartlari.get(i));
            } else {
                kartlarBilgisayar.add(basketKartlari.get(i));
            }
        }
        oyuncu.kartListesi(kartlarOyuncu);
        bilgisayar.kartListesi(kartlarBilgisayar);
    }

    private void indisGor() {
        for (int i = 0; i < basketKartIndis.length; i++) {
            System.out.println("Basket Kart Sira Indis : " + basketKartIndis[i]);

        }
        for (int i = 0; i < futbolKartIndis.length; i++) {
            System.out.println("Futbol Kart Sira Indis : " + futbolKartIndis[i]);

        }
    }

    protected int puanAta() {
        rastgelePuan = (int) (70 + (Math.random() * 29));
        return rastgelePuan;
    }

    public void log() {
        for (int i = 0; i < futbolKartlari.size(); i++) {
            System.out.print("İsim, Takim: " + futbolKartlari.get(i).getFutbolcuAdi() + ",\t" + futbolKartlari.get(i).getFutbolcuTakim() + "\t");
            System.out.println("\tPenaltı: " + futbolKartlari.get(i).getPenalti() + "\tSerbest Vuruş: " + futbolKartlari.get(i).getSerbestAtis() + "\tKaleci Durum: " + futbolKartlari.get(i).getKaleciKarsiKarsiya());
        }
        for (int i = 0; i < basketKartlari.size(); i++) {
            System.out.print("İsim, Takim: " + basketKartlari.get(i).getBasketbolcuAdi() + ",\t" + basketKartlari.get(i).getBasketbolcuTakim() + "\t");
            System.out.println("\tIkilik : " + basketKartlari.get(i).getIkilik() + "\tUcluk: " + basketKartlari.get(i).getUcluk() + "\tSerbest Atis: " + basketKartlari.get(i).getSerbestAtis());
        }

        System.out.println("Bilgisayarin Kartlari : ");
        System.out.println("PC Kart Sayi : " + kartlarBilgisayar.size());
        for (int i = 0; i < kartlarBilgisayar.size(); i++) {
            System.out.println("Kart Adi : " + kartlarBilgisayar.get(i).getSporcuIsim() + " " + kartlarBilgisayar.get(i).getSporcuTakim());
        }

        System.out.println("Oyuncunun Kartlari : ");
        System.out.println("Oyuncu Kart Sayi : " + kartlarOyuncu.size());
        for (int i = 0; i < kartlarOyuncu.size(); i++) {
            System.out.println("Kart Adi : " + kartlarOyuncu.get(i).getSporcuIsim() + " " + kartlarOyuncu.get(i).getSporcuTakim());
        }
    }
}