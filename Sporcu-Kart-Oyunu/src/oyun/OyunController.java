package oyun;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import siniflar.*;

import java.util.ArrayList;
import java.util.Random;

public class OyunController {
    public static boolean oyunStartDurumu = false; //Kart Sayısı 0 Olunca false;
    public static boolean karsilastirmaAyni = false;
    public boolean karsilastirmaAcik = false;

    //Temp Olarak Tutulan Hangi Kart Nedir Listeleri
    //Boyutları ( 4 ) Birim.
    public ArrayList<Futbolcu> pcTempF = new ArrayList<>();
    public ArrayList<Futbolcu> oTempF = new ArrayList<>();
    public ArrayList<Basketbolcu> oTempB = new ArrayList<>();
    public ArrayList<Basketbolcu> pcTempB = new ArrayList<>();

    //Ilk Atanacak Resimler
    public Image oyuncuResim = new Image("/texture/oyuncuRes.jpg");
    public Image pcResim = new Image("/texture/pcRes.jpg");
    public Image bosKart = new Image("/texture/bosKart.png");
    public Image desteSembol = new Image("/texture/kartDeste.jpg");

    //Ilk Olarak Ayarlanacak Resimlerin Icerigi
    public ImageView oR = new ImageView(oyuncuResim);
    public ImageView pR = new ImageView(pcResim);
    public ImageView bKR = new ImageView(bosKart);
    public ImageView deste = new ImageView(desteSembol);

    //Resimlerin Sirali Listesi
    public ImageView[] pcResimleri = new ImageView[8];
    public ImageView[] oyuncuResimleri = new ImageView[8];

    //Oyuncu Puan -> //Bilgisayar Puan
    public int oyuncuPuani = 0;
    public int bilgisayarPuani = 0;

    //Arayüzdeki Genel Elemanlar
    @FXML
    Button kartDagitma;
    @FXML
    Button karsilastirButon;
    @FXML
    Label oyuncuKartSayi;
    @FXML
    Label pcKartSayi;
    @FXML
    Label oyuncuPuan;
    @FXML
    Label bilgisayarPuan;
    @FXML
    Label oyuncuRes;
    @FXML
    Label pcRes;
    @FXML
    Label kartPc;
    @FXML
    Label kartOyuncu;
    @FXML
    Label kartDesteSembol;

    //---------------------------------PC KARTLARI
    @FXML
    Label pcKart1;
    @FXML
    Label pcKart2;
    @FXML
    Label pcKart3;
    @FXML
    Label pcKart4;
    @FXML
    Label pcKart5;
    @FXML
    Label pcKart6;
    @FXML
    Label pcKart7;
    @FXML
    Label pcKart8;

    //---------------------------------OYUNCU KARTLARI
    @FXML
    Label oKart1;
    @FXML
    Label oKart2;
    @FXML
    Label oKart3;
    @FXML
    Label oKart4;
    @FXML
    Label oKart5;
    @FXML
    Label oKart6;
    @FXML
    Label oKart7;
    @FXML
    Label oKart8;

    //-----------------------------------KART OZELLIK GORUNUMU
    @FXML
    TextField oOBir;
    @FXML
    TextField oOIki;
    @FXML
    TextField oOUc;
    @FXML
    TextField oSporcuIsim;
    @FXML
    TextField oSporcuTakim;
    @FXML
    TextField bOBir;
    @FXML
    TextField bOIki;
    @FXML
    TextField bOUc;
    @FXML
    TextField bSporcuIsim;
    @FXML
    TextField bSporcuTakim;
    @FXML
    Label bo1;
    @FXML
    Label bo2;
    @FXML
    Label bo3;
    @FXML
    Label oo1;
    @FXML
    Label oo2;
    @FXML
    Label oo3;

    int[] pcKartRastgele = new int[8];
    int kartSayi = 8;

    //Oyuncu Ve Bilgisayar kart Resimler (ImageView Tipinde)
    ArrayList<Label> pencerelerO = new ArrayList<>();
    ArrayList<Label> pencerelerB = new ArrayList<>();

    //Oyuncu Kart Listesi
    ArrayList<Sporcu> oyuncuKartlari = new ArrayList<>();

    //Bilgisayar Kart Listesi
    ArrayList<Sporcu> bilgisayarKartlari = new ArrayList<>();

    //Test Sinifindaki Tum Icerik
    //Oyundaki Tum Ayarlari Burada Yapiyoruz
    Test oyunstart = new Test();

    //Kullanicilar
    Kullanici ben = new Kullanici(1, 0, "Muhsin Soba");
    Bilgisayar pc = new Bilgisayar(1, 0, "Computer");


    public void kartDagit() //Oyun Basinda Kart Dagitmasindan Sorumlu
    {
        //Kartlarin Gerekli Duruma Getirilmesi
        oyunstart.oyuncuAyarla();

        //Birden Fazla Kart Dagitmayi Engellemek
        kartDagitma.setDisable(true);

        //Pc Ve Oyuncu Kartlarina Kart Destesini Atiyoruz
        oyuncuKartlari.addAll(oyunstart.kartlarOyuncu);
        bilgisayarKartlari.addAll(oyunstart.kartlarBilgisayar);

        //Oyuncudaki Kart Adetlerine Bakalim
        System.out.println("Oyuncudaki Kart Adeti : " + oyuncuKartlari.size());
        System.out.println("Bilgisayardaki Kart Adeti : " + bilgisayarKartlari.size());
        ilkAyarlar();
    }

    public void karsilastir() {
        /** Yapilan Islemler
         *  (1) - Rastgele Ozellik Secilecek
         *  (2) - Karsilastirma Yap
         *  (3) - Kazanana Puan Ekle
         *  (4) - Puan Ayni Ise Karti Geri Ver (???)
         */

        //Rastgele Uc Ozellikten Biri Secilecek.
        Random r = new Random();
        int gelenSayi = r.nextInt(3) + 1;
        String kazanan = "Kazanan";
        String sonuc = "";

        String durum = "Karsilastirma Durumu : " + gelenSayi;

        if (gelenSayi == 1) {
            sonuc = " Penalti / Ikilik : ";
            durum += sonuc;
            System.out.println(" : " + durum);
        }
        if (gelenSayi == 2) {
            sonuc = " Kaleci / Ucluk : ";
            durum += sonuc;
            System.out.println(" : " + durum);
        }
        if (gelenSayi == 3) {
            sonuc = " Serbest Vurus / Serbest Atis : ";
            durum += sonuc;
            System.out.println(" : " + durum);
        }

        if (gelenSayi == 1) // Penalti - Ikilik
        {
            //Kartlardaki Puanlar Aliniyor
            int pcPuan = Integer.parseInt(bOBir.getText());
            int oPuan = Integer.parseInt(oOBir.getText());
            kartSayi--;

            if (pcPuan - oPuan < 0) //Oyuncu Kazanmistir
            {
                System.out.println("Oyuncu Kazandi + 5 Puan Oyuncu ");

                ben.skor += 5;
                oyuncuPuan.setText("" + ben.skor);

                pcKartSayi.setText("" + kartSayi);
                oyuncuKartSayi.setText("" + kartSayi);

                if (kartSayi == 0) //Oyun Bitmistir
                {
                    System.out.println("Oyun Bitti.");
                    karsilastirButon.setDisable(true);

                    if (ben.skor > pc.skor) {
                        kazanan = ben.getSkor() + "-> Skor ile " + ben.getOyuncuAdi() + " Oyuncu ID : " + ben.getOyuncuID();
                    }
                    if (ben.skor < pc.skor) {
                        kazanan = pc.getSkor() + "-> Skor ile " + pc.getOyuncuAdi() + " Oyuncu ID : " + pc.getOyuncuID();
                    }
                    if (ben.skor == pc.skor) {
                        kazanan = "Durum Berabere ";
                        Alert berabere = new Alert(Alert.AlertType.WARNING);
                        berabere.setTitle("DIKKAT");
                        berabere.setHeaderText("UYARI");
                        berabere.setContentText(kazanan);
                        berabere.showAndWait();
                    }

                    Alert yok = new Alert(Alert.AlertType.CONFIRMATION);
                    yok.setTitle("DIKKAT");
                    yok.setHeaderText("SONUC");
                    yok.setContentText("Oyun Bitmiştir Kazanan : " + kazanan);
                    yok.showAndWait();
                }
            }

            if (pcPuan - oPuan > 0) //PC Kazanmistir
            {
                System.out.println("Pc Kazandi + 5 Puan PC ");

                pc.skor += 5;
                bilgisayarPuan.setText("" + pc.skor);

                pcKartSayi.setText("" + kartSayi);
                oyuncuKartSayi.setText("" + kartSayi);

                if (kartSayi == 0) //Kartlar Sifir Olunca Oyun Bitmistir
                {
                    System.out.println("Oyun Bitti.");
                    karsilastirButon.setDisable(true);

                    if (ben.skor > pc.skor) {
                        kazanan = ben.getSkor() + "-> Skor Ile : " + ben.getOyuncuAdi() + " Oyuncu ID : " + ben.getOyuncuID();
                    }
                    if (ben.skor < pc.skor) {
                        kazanan = pc.getSkor() + "-> Skor Ile : " + pc.getOyuncuAdi() + " Oyuncu ID : " + pc.getOyuncuID();
                    }
                    if (ben.skor == pc.skor) {
                        kazanan = "Durum Berabere.";
                        Alert yok = new Alert(Alert.AlertType.WARNING);
                        yok.setTitle("DIKKAT");
                        yok.setHeaderText("UYARI");
                        yok.setContentText(kazanan);
                        yok.showAndWait();
                    }

                    Alert yok = new Alert(Alert.AlertType.CONFIRMATION);
                    yok.setTitle("DIKKAT");
                    yok.setHeaderText("SONUC");
                    yok.setContentText("Oyun Bitmiştir Kazanan : " + kazanan);
                    yok.showAndWait();
                }
            }
            if ((oPuan - pcPuan) == 0) //Kartlari Geri Ver
            {
                System.out.println("Skorlar Eşit Yeniden Sec");
                Alert yok = new Alert(Alert.AlertType.WARNING);
                yok.setTitle("DIKKAT");
                yok.setHeaderText("UYARI");
                yok.setContentText("Kartların Durmuu Aynı Farklı farklı Kart Ver");
                yok.showAndWait();
                kartSayi++;
                oyuncuKartSayi.setText("" + kartSayi);
                pcKartSayi.setText("" + kartSayi);

                karsilastirmaAyni = true;
            }
        }
        if (gelenSayi == 2) // Kaleci - Ucluk
        {
            //Kartlardaki Puanlar Aliniyor
            int pcPuan = Integer.parseInt(bOIki.getText());
            int oPuan = Integer.parseInt(oOIki.getText());
            kartSayi--;

            if (pcPuan - oPuan < 0) //Oyuncu Kazanmistir
            {
                System.out.println("Oyuncu Kazandi + 5 Puan Oyuncu ");

                ben.skor += 5;
                oyuncuPuan.setText("" + ben.skor);

                pcKartSayi.setText("" + kartSayi);
                oyuncuKartSayi.setText("" + kartSayi);

                if (kartSayi == 0) //Oyun Bitmistir
                {
                    System.out.println("Oyun Bitti.");
                    karsilastirButon.setDisable(true);

                    if (ben.skor > pc.skor) {
                        kazanan = ben.getSkor() + "-> Skor ile " + ben.getOyuncuAdi() + " Oyuncu ID : " + ben.getOyuncuID();
                    }
                    if (ben.skor < pc.skor) {
                        kazanan = pc.getSkor() + "-> Skor ile " + pc.getOyuncuAdi() + " Oyuncu ID : " + pc.getOyuncuID();
                    }
                    if (ben.skor == pc.skor) {
                        kazanan = "Durum Berabere " + "Yeniden Kart Dagit";
                        Alert berabere = new Alert(Alert.AlertType.WARNING);
                        berabere.setTitle("DIKKAT");
                        berabere.setHeaderText("UYARI");
                        berabere.setContentText(kazanan);
                        berabere.showAndWait();
                    }

                    Alert yok = new Alert(Alert.AlertType.CONFIRMATION);
                    yok.setTitle("DIKKAT");
                    yok.setHeaderText("SONUC");
                    yok.setContentText("Oyun Bitmiştir Kazanan : " + kazanan);
                    yok.showAndWait();
                }
            }

            if (pcPuan - oPuan > 0) //PC Kazanmistir
            {
                System.out.println("Pc Kazandi + 5 Puan PC ");

                pc.skor += 5;
                bilgisayarPuan.setText("" + pc.skor);

                pcKartSayi.setText("" + kartSayi);
                oyuncuKartSayi.setText("" + kartSayi);

                if (kartSayi == 0) //Kartlar Sifir Olunca Oyun Bitmistir
                {
                    System.out.println("Oyun Bitti.");
                    karsilastirButon.setDisable(true);

                    if (ben.skor > pc.skor) {
                        kazanan = ben.getSkor() + "-> Skor Ile : " + ben.getOyuncuAdi() + " Oyuncu ID : " + ben.getOyuncuID();
                    }
                    if (ben.skor < pc.skor) {
                        kazanan = pc.getSkor() + "-> Skor Ile : " + pc.getOyuncuAdi() + " Oyuncu ID : " + pc.getOyuncuID();
                    }
                    if (ben.skor == pc.skor) {
                        kazanan = "Durum Berabere. " + " Yeniden Kart Dagit";
                        Alert yok = new Alert(Alert.AlertType.WARNING);
                        yok.setTitle("DIKKAT");
                        yok.setHeaderText("UYARI");
                        yok.setContentText(kazanan);
                        yok.showAndWait();
                    }

                    Alert yok = new Alert(Alert.AlertType.CONFIRMATION);
                    yok.setTitle("DIKKAT");
                    yok.setHeaderText("SONUC");
                    yok.setContentText("Oyun Bitmiştir Kazanan : " + kazanan);
                    yok.showAndWait();
                }
            }
            if ((oPuan - pcPuan) == 0) //Kartlari Geri Ver
            {
                System.out.println("Skorlar Eşit Yeniden Sec");
                Alert yok = new Alert(Alert.AlertType.WARNING);
                yok.setTitle("DIKKAT");
                yok.setHeaderText("UYARI");
                yok.setContentText("Kartların Durmu Aynı Farklı farklı Kart Ver");
                yok.showAndWait();
                kartSayi++;
                oyuncuKartSayi.setText("" + kartSayi);
                pcKartSayi.setText("" + kartSayi);

                karsilastirmaAyni = true;
            }
        }
        if (gelenSayi == 3) // Serbest - Serbest
        {
            //Kartlardaki Puanlar Aliniyor
            int pcPuan = Integer.parseInt(bOUc.getText());
            int oPuan = Integer.parseInt(oOUc.getText());
            kartSayi--;

            if (pcPuan - oPuan < 0) //Oyuncu Kazanmistir
            {
                System.out.println("Oyuncu Kazandi + 5 Puan Oyuncu ");

                ben.skor += 5;
                oyuncuPuan.setText("" + ben.skor);

                pcKartSayi.setText("" + kartSayi);
                oyuncuKartSayi.setText("" + kartSayi);

                if (kartSayi == 0) //Oyun Bitmistir
                {
                    System.out.println("Oyun Bitti.");
                    karsilastirButon.setDisable(true);

                    if (ben.skor > pc.skor) {
                        kazanan = ben.getSkor() + "-> Skor ile " + ben.getOyuncuAdi() + " Oyuncu ID : " + ben.getOyuncuID();
                    }
                    if (ben.skor < pc.skor) {
                        kazanan = pc.getSkor() + "-> Skor ile " + pc.getOyuncuAdi() + " Oyuncu ID : " + pc.getOyuncuID();
                    }
                    if (ben.skor == pc.skor) {
                        kazanan = "Durum Berabere " + "Yeniden Kart Dagit";
                        Alert berabere = new Alert(Alert.AlertType.WARNING);
                        berabere.setTitle("DIKKAT");
                        berabere.setHeaderText("UYARI");
                        berabere.setContentText(kazanan);
                        berabere.showAndWait();
                    }

                    Alert yok = new Alert(Alert.AlertType.CONFIRMATION);
                    yok.setTitle("DIKKAT");
                    yok.setHeaderText("SONUC");
                    yok.setContentText("Oyun Bitmiştir Kazanan : " + kazanan);
                    yok.showAndWait();
                }
            }

            if (pcPuan - oPuan > 0) //PC Kazanmistir
            {
                System.out.println("Pc Kazandi + 5 Puan PC ");

                pc.skor += 5;
                bilgisayarPuan.setText("" + pc.skor);

                pcKartSayi.setText("" + kartSayi);
                oyuncuKartSayi.setText("" + kartSayi);

                if (kartSayi == 0) //Kartlar Sifir Olunca Oyun Bitmistir
                {
                    System.out.println("Oyun Bitti.");
                    karsilastirButon.setDisable(true);

                    if (ben.skor > pc.skor) {
                        kazanan = ben.getSkor() + "-> Skor Ile : " + ben.getOyuncuAdi() + " Oyuncu ID : " + ben.getOyuncuID();
                    }
                    if (ben.skor < pc.skor) {
                        kazanan = pc.getSkor() + "-> Skor Ile : " + pc.getOyuncuAdi() + " Oyuncu ID : " + pc.getOyuncuID();
                    }
                    if (ben.skor == pc.skor) {
                        kazanan = "Durum Berabere. " + " Yeniden Kart Dagit";
                        Alert yok = new Alert(Alert.AlertType.WARNING);
                        yok.setTitle("DIKKAT");
                        yok.setHeaderText("UYARI");
                        yok.setContentText(kazanan);
                        yok.showAndWait();
                    }

                    Alert yok = new Alert(Alert.AlertType.CONFIRMATION);
                    yok.setTitle("DIKKAT");
                    yok.setHeaderText("SONUC");
                    yok.setContentText("Oyun Bitmiştir Kazanan : " + kazanan);
                    yok.showAndWait();
                }
            }
            if ((oPuan - pcPuan) == 0) //Kartlari Geri Ver
            {
                System.out.println("Skorlar Eşit Yeniden Sec");
                Alert yok = new Alert(Alert.AlertType.WARNING);
                yok.setTitle("DIKKAT");
                yok.setHeaderText("UYARI");
                yok.setContentText("Kartların Durmu Aynı Farklı farklı Kart Ver");
                yok.showAndWait();
                kartSayi++;
                oyuncuKartSayi.setText("" + kartSayi);
                pcKartSayi.setText("" + kartSayi);

                karsilastirmaAyni = true;



            }
        }

        //Her Seferinde Bir Kart Karsilastirilmali
        karsilastirButon.setDisable(true);
    }

    public void ilkAyarlar() {
        //Uretilen Kart Bilgileri Ve Daha Fazlası
        oyunstart.log();

        oyuncuPuan.setText(String.valueOf(0));
        bilgisayarPuan.setText(String.valueOf(0));

        oyuncuKartSayi.setText(String.valueOf(8));
        pcKartSayi.setText(String.valueOf(8));

        oR.setFitHeight(220);
        oR.setFitWidth(130);
        pR.setFitHeight(220);
        pR.setFitWidth(130);
        deste.setFitHeight(340);
        deste.setFitWidth(220);
        bKR.setFitHeight(270);
        bKR.setFitWidth(180);

        oyuncuRes.setGraphic(oR);
        pcRes.setGraphic(pR);
        kartDesteSembol.setGraphic(deste);

        //
        pencerelerO.add(oKart1);
        pencerelerO.add(oKart2);
        pencerelerO.add(oKart3);
        pencerelerO.add(oKart4);
        pencerelerO.add(oKart5);
        pencerelerO.add(oKart6);
        pencerelerO.add(oKart7);
        pencerelerO.add(oKart8);

        //
        pencerelerB.add(pcKart1);
        pencerelerB.add(pcKart2);
        pencerelerB.add(pcKart3);
        pencerelerB.add(pcKart4);
        pencerelerB.add(pcKart5);
        pencerelerB.add(pcKart6);
        pencerelerB.add(pcKart7);
        pencerelerB.add(pcKart8);

        if (oyunStartDurumu) {
            kartPc.setGraphic(bKR);
            kartOyuncu.setGraphic(bKR);
        }

        tempSira();
        resimClip();
        kartDurum();
        click();
    }

    public void kartDurum() {
        System.out.println("pc kart\n");
        for (int i = 0; i < bilgisayarKartlari.size(); i++) {
            System.out.println(bilgisayarKartlari.get(i).getSporcuIsim());
        }
        space();
        System.out.println("oyuncu kart\n");
        for (int i = 0; i < oyuncuKartlari.size(); i++) {
            System.out.println(oyuncuKartlari.get(i).getSporcuIsim());
        }
        space();
        System.out.println("futbol kartlar : \n");
        for (int i = 0; i < oyunstart.futbolKartlari.size(); i++) {
            System.out.println(oyunstart.futbolKartlari.get(i).getFutbolcuAdi());
        }
        space();
        System.out.println("basket kartlar : \n");
        for (int i = 0; i < oyunstart.basketKartlari.size(); i++) {
            System.out.println(oyunstart.basketKartlari.get(i).getBasketbolcuAdi());
        }
    }

    public void space() {
        System.out.println("\n\n\n");
    }

    public void tempSira() {
        pcRastgeleKart();
        //System.out.println("Pc Deste Boyut = " + bilgisayarKartlari.size());
        for (int i = 0; i < bilgisayarKartlari.size(); i++) {
            if (i >= 4) {
                //System.out.println(">>>>> Temp Basket Kart PC: " + oyunstart.basketKartlari.get(i).getBasketbolcuAdi());
                pcTempB.add(oyunstart.basketKartlari.get(i));
            }
            if (i < 4) {
                //System.out.println("----- Temp Futbol Kart PC: " + oyunstart.futbolKartlari.get(i+4).getFutbolcuAdi());
                pcTempF.add(oyunstart.futbolKartlari.get(i + 4));
            }
        }
        for (int i = 0; i < oyuncuKartlari.size(); i++) {
            if (i >= 4) {
                //System.out.println(">>>>> Temp Basket Kart Oyuncu: " + oyunstart.basketKartlari.get(i - 4).getBasketbolcuAdi());
                oTempB.add(oyunstart.basketKartlari.get(i - 4));
            }
            if (i < 4) {
                //System.out.println("----- Temp Futbol Kart Oyuncu: " + oyunstart.futbolKartlari.get(i).getFutbolcuAdi());
                oTempF.add(oyunstart.futbolKartlari.get(i));
            }
        }

    }

    public void resimClip() {
        for (int i = 0; i < 8; i++) {
            pcResimleri[i] = new ImageView(bilgisayarKartlari.get(i).getResim());
            oyuncuResimleri[i] = new ImageView(oyuncuKartlari.get(i).getResim());
        }

        for (int i = 0; i < 8; i++) {
            pcResimleri[i].setFitHeight(180);
            pcResimleri[i].setFitWidth(120);
            oyuncuResimleri[i].setFitHeight(180);
            oyuncuResimleri[i].setFitWidth(120);
        }

        for (int i = 0; i < 8; i++) {
            if (pencerelerO.get(i).getId().equals("oKart" + (i + 1))) {
                //System.out.println("Burdaki Resim Oyuncu");
                pencerelerO.get(i).setGraphic(oyuncuResimleri[i]);
            }
            if (pencerelerB.get(i).getId().equals("pcKart" + (i + 1))) {
                //System.out.println("Burdaki Resim PC");
                pencerelerB.get(i).setGraphic(pcResimleri[i]);
            }
        }
    }

    public void pcRastgeleKart() {
        int sayi;
        pcKartRastgele[0] = 0;
        for (int i = 1; i < 4; i++) {
            sayi = (int) (Math.random() * 4);
            for (int j = 0; j <= i; j++) {
                if (pcKartRastgele[j] == sayi) {
                    sayi = (int) (Math.random() * 4);
                    j = 0;
                }
            }
            pcKartRastgele[i] = sayi;
        }
    }

    public void click() {
        for (int i = 0; i < 8; i++) {
            pencerelerO.get(i).setOnMouseClicked(event ->
            {
                //System.out.println("Tiklandi Label : " + event.getSource().toString());
                Label o = (Label) event.getSource();
                Label pc = (Label) event.getSource();
                karsilastirmaAcik = true;

                if (karsilastirmaAcik) {
                    karsilastirButon.setDisable(false);
                }

                for (int j = 0; j < 8; j++) {
                    if (o.getId().equals("oKart" + (j + 1))) {
                        kartPc.setGraphic(pcResimleri[pcKartRastgele[j]]);
                        kartOyuncu.setGraphic(oyuncuResimleri[j]);

                        if (j < 4) {
                            System.out.println("Secilen Kart Futbol");

                            oSporcuIsim.setText(oTempF.get(j).getSporcuIsim());
                            oSporcuTakim.setText(oTempF.get(j).getSporcuTakim());

                            bSporcuIsim.setText(pcTempF.get(pcKartRastgele[j]).getSporcuIsim());
                            bSporcuTakim.setText(pcTempF.get(pcKartRastgele[j]).getSporcuTakim());

                            bo1.setText("Penalti");
                            bo2.setText("Kaleci");
                            bo3.setText("Serbest");

                            oo1.setText("Penalti");
                            oo2.setText("Kaleci");
                            oo3.setText("Serbest");

                            kartPc.setGraphic(pcResimleri[pcKartRastgele[j]]);
                            kartOyuncu.setGraphic(oyuncuResimleri[j]);

                            bOBir.setText("" + pcTempF.get(j).getPenalti());
                            bOIki.setText("" + pcTempF.get(j).getKaleciKarsiKarsiya());
                            bOUc.setText("" + pcTempF.get(j).getSerbestAtis());

                            oOBir.setText("" + oTempF.get(j).getPenalti());
                            oOIki.setText("" + oTempF.get(j).getKaleciKarsiKarsiya());
                            oOUc.setText("" + oTempF.get(j).getSerbestAtis());

                            if (karsilastirmaAyni && pc.getId().equals("pcKart" + (j + 1)))
                            {
                                kartOyuncu.setGraphic(o.getGraphic());
                                kartPc.setGraphic(pc.getGraphic());
                            }
                        }

                        if (j >= 4) {
                            System.out.println("Secilen Kart Basketbol");

                            oSporcuIsim.setText(oTempB.get(j - 4).getSporcuIsim());
                            oSporcuTakim.setText(oTempB.get(j - 4).getSporcuTakim());

                            bSporcuIsim.setText(pcTempB.get(pcKartRastgele[7 - j]).getSporcuIsim());
                            pcTempB.get(7 - j).setKartKullanildimi(true);
                            bSporcuTakim.setText(pcTempB.get(pcKartRastgele[7 - j]).getSporcuTakim());

                            bo1.setText("İkilik");
                            bo2.setText("Üçlük");
                            bo3.setText("Serbest");

                            oo1.setText("İkilik");
                            oo2.setText("Üçlük");
                            oo3.setText("Serbest");

                            ////////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\/////////
                            System.out.println("pcKartRastgele Sayisi : " + pcKartRastgele[j - 4] + 4);

                            System.out.println("Kart Sayi : " + (pcKartRastgele[j - 4] + 4));
                            kartPc.setGraphic(pcResimleri[pcKartRastgele[j - 4] + 4]);
                            ////////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\//////////
                            kartOyuncu.setGraphic(oyuncuResimleri[j]);

                            bOBir.setText("" + pcTempB.get(j - 4).getIkilik());
                            bOIki.setText("" + pcTempB.get(j - 4).getUcluk());
                            bOUc.setText("" + pcTempB.get(j - 4).getSerbestAtis());

                            oOBir.setText("" + oTempB.get(j - 4).getIkilik());
                            oOIki.setText("" + oTempB.get(j - 4).getUcluk());
                            oOUc.setText("" + oTempB.get(j - 4).getSerbestAtis());

                            if (karsilastirmaAyni && pc.getId().equals("pcKart" + (j + 1)))
                            {
                                kartOyuncu.setGraphic(null);
                                kartPc.setGraphic(null);
                            }
                        }
                    }
                }
            });
        }
    }
}