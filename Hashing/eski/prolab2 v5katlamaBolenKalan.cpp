// prolab2.cpp : Defines the entry point for the console application.
//

//#include "stdafx.h"
#include<time.h>
#include<stdlib.h>
#include<string.h>
#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>



using namespace std;
struct Kayit
{
	char* adSoyad;
	int numara;
	int bagilAdr;

};

static int sayac = 0;

int numara[9] = { 1,1,0,2,0,2,0,0,0 };//Kocaeli Üniversitesi Numara Sistemi.

int diziToIntNumara(int byt,int numara[])
{
	int sonuc = 0;
	for (int i = 0; i < byt; i++)
	{
		int num = numara[i];
		if (num != 0)
		{
			while (num > 0)
			{
				sonuc *= 10;
				num /= 10;
			}
			sonuc += numara[i];
		}
		else
		{
			sonuc *= 10;
		}

	}
	return sonuc;

}

int NumaraUret()
{
	/*
	Struct dizisi sayesinde sýrasýyla bu fonksiyon çalýþacaktýr.
	Numara sistemi þöyledir:
	ilk üç basamak 110,120,130... giriþ yýlýný temsil eder. 110=2011 gibi...
	sonraki üç basamak bilg. mühendisliðinin kodudur. 202.
	son üç basamak ise giriþ sýralamasýdýr. (hiç bir öðrencinin numarasý 0 ile bitemez.)
	her sene için 100 kiþi ayýrarak 5 senelik kayýt tutulmaktadýr. 110-202-099 den sonra 110-202-101 gelir.
	*/
	sayac++;
	if (sayac<100)
	{
		numara[8] = sayac % 10;
		numara[7] = sayac / 10;
	}
	else if (sayac>99 && sayac<101)
	{
		numara[6] = 1;
		numara[7] = 0;
		numara[8] = sayac % 10 + 1;
	}
	else
	{
		numara[1] ++;
		sayac = 1;
		numara[6] = 0;
		numara[7] = 0;
		numara[8] = 1;
	}
	//dizideki sonucu integer bir deðiþkene atýyoruz
	return diziToIntNumara(9,numara);
	
}

char *RasgeleIsimUret()
{
	//alt + rand() % (ust - alt + 1) 
	int AdUzunluk = 2 + rand() % 6;//en az 2 harfli ençok 7 harfli isim
	int SoyadUzunluk = 5 + rand() % 6;//en az 5 harfli ençok 10 harfli soyisim
	char *isim = new char[9 + 2];// isim soyisim arasýndaki boþluk ve cümle sonu \0 ý da ekleriz +2 olur.
								 //Toplam 10 karakterlik isim soyisim istendiði için 9+2 =11 char alaný ayýrýyoruz... (boþluðu dahil etmedim)
	char *KuckHarf = "abcdefghijklmnopqrstuvwxyz";
	char *BykHarf = "ABCDEFGHIJKLMOPRSTUVWXYZ";
	for (int i = 0; i < AdUzunluk; i++) {
		if (i == 0)
		{
			isim[0] = BykHarf[rand() % strlen(BykHarf)];
			continue;//ilk harfi atadýktan sonra diðer harfe geçmesi için döngüyü 1 atlatýrýz.
		}
		isim[i] = KuckHarf[rand() % strlen(KuckHarf)];
	}
	isim[AdUzunluk] = ' ';
	for (int i = AdUzunluk + 1; i < 11; i++) {
		if (i == AdUzunluk + 1)
		{
			isim[i] = BykHarf[rand() % strlen(BykHarf)];
			continue;
		}
		isim[i] = KuckHarf[rand() % strlen(KuckHarf)];
	}

	isim[11] = '\0';
	return isim;
}

void anaKayitDosyasi(struct Kayit anaKayit[500])
{
	int numaraHavuzu[800];//800 kapasiteli numara havuzu oluþturup içinden rasgele 500 tane numarayý kullanýyoruz.Numara Üretimi...
	for (int i = 0; i < 800; i++)
		numaraHavuzu[i] = NumaraUret();
	int numaraBayrak[800] = {};
	int k = 0, rast;
	do
	{
	basla:
		rast = rand() % 800;
		if (numaraBayrak[rast] == 0) {

			anaKayit[k].numara = numaraHavuzu[rast];

			numaraBayrak[rast]++;
		}
		else
			goto basla;
		k++;
	} while (k<500);


	for (int i = 0; i < 500; i++)
	{
		anaKayit[i].adSoyad = RasgeleIsimUret();//Ýsim Üretimi...

	}
	/*cout << setw(7) << "Numara" << setw(15) << "Ad Soyad" << endl;
	for (int i = 0; i < 500; i++) kontorol amaçlý yazdýrma
	{
		cout << setw(5) << anaKayit[i].numara << setw(15) << anaKayit[i].adSoyad << endl;
	}*/
	ofstream kayit;
	kayit.open("Kayit.txt");
	kayit << setw(5) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip kütüphanesinden gelir boþluk býrakýp yazý yazmayý saðlar.
	for (int i = 0; i < 500; i++)
	{

		kayit << setw(5) << anaKayit[i].numara << setw(20) << anaKayit[i].adSoyad << endl;
	}
	kayit.close();
}

int bolenKalan(int numara)
{

	int bglAdres;
	bglAdres = numara % 631;
	return bglAdres;
	//619 olmasýnýn sebebi; Bütün hash fonksiyonlarý, dosya doluluða yaklaþtýkça kötü iþlemeye baþlarlar. 
	//Genel bir tavsiye olarak yükleme faktörü %70 veya %80 alýnýr. yükl.faktörü=500/625 =%80 ykleme faktörünü verir.
	//maksimum 619 olabiliyorsa 625 e en yakýn asal sayý olarak 631 seçiliyor.

}
int katlama(int numara)
{
	int bglAdres;
	int dizi[9];
	//numarayý diziye cevirelim...
	for (int i = 8; numara != 0; i--)
	{
		dizi[i] = numara % 10;
		numara /= 10;
	}
	//diziyi 4 er 4 er Katlýyoruz..
	int son[4], orta[4], bas;
	for (int i = 8; i >= 5; i--)
	{
		son[8 - i] = dizi[i];
	}

	for (int i = 1; i<5; i++)
	{
		orta[i - 1] = dizi[i];
	}
	bas = dizi[0];
	bglAdres = diziToIntNumara(4, son) + diziToIntNumara(4, orta) + bas;
	if (bglAdres > 9999)//4 basamaklý sayýlar elde ediyoruz eðer 5 basamak olursa on binler basamaðý silinir
		bglAdres %= 10000;

	return bglAdres%631;
}


int bayrakLyBk[631] = {0};// öncelikle içeriðin hepsini 0 yapýyoruz, kayýt edilince 1 e çeviriyoruz (bayrak mantýðý).
struct Kayit lyBolenKalanKayit[631];//yazdýrdýðýmýz verileri tutmak için kullanýyoruz.

void LineerYoklamaBolenKalan(struct Kayit lineer[500])
{
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		bglAdres = bolenKalan(lineer[i].numara);
		evAdres = bglAdres;
	basla:
		if (bayrakLyBk[bglAdres] == 0)
		{
			bayrakLyBk[bglAdres]++;
			lyBolenKalanKayit[bglAdres].adSoyad = lineer[i].adSoyad;
			lyBolenKalanKayit[bglAdres].numara = lineer[i].numara;
			lyBolenKalanKayit[bglAdres].bagilAdr = bglAdres;

		}
		else if (bayrakLyBk[bglAdres] == 1)
		{
			bglAdres = bglAdres + 1;

			if (bglAdres > 630)
				bglAdres = 0;
			if (bglAdres == evAdres) {
				cout << "Dosya Doldu!" << endl;

			}
			goto basla;
		}
		
		
	}
	//Dosyaya yazdýrma gerçekleþiyor...
	ofstream lyBolenKalan;
	lyBolenKalan.open("lineerYoklamaBolenKalan.txt");
	lyBolenKalan << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip kütüphanesinden gelir boþluk býrakýp yazý yazmayý saðlar.
	for (int i = 0; i < 631; i++)
	{
		if(bayrakLyBk[i]==1)
		lyBolenKalan << setw(7) <<lyBolenKalanKayit[i].bagilAdr << setw(20) << lyBolenKalanKayit[i].numara << setw(20) << lyBolenKalanKayit[i].adSoyad << endl;
		else {
			lyBolenKalanKayit[i].bagilAdr = i;
			lyBolenKalanKayit[i].adSoyad = "";
			lyBolenKalanKayit[i].numara = NULL;
			//boþ kayýtlarýda göstermek için kullanýyoruz. Yazdýrýrken Numarayý yazdýrmýyoruz çünkü null deðer 0 olarak okunuyor.
			lyBolenKalan << setw(7) << lyBolenKalanKayit[i].bagilAdr << setw(20) << " "<< setw(20) << lyBolenKalanKayit[i].adSoyad << endl;
		}
	}
	

}


int lineerYoklamaBolenKalanAra(struct Kayit lineer[500])
{
	int adimSayici=0;
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		bglAdres = bolenKalan(lineer[i].numara); adimSayici++;
		evAdres = bglAdres; adimSayici++;
	basla:adimSayici++;
		if (bayrakLyBk[bglAdres] == 0) { adimSayici++; cout << "Kayit Dosyada Degil!" << endl; }
		else
		{
			adimSayici++;
			if (lyBolenKalanKayit[bglAdres].numara == lineer[i].numara)
			{
				adimSayici++;
				//cout << "Aranan Kayit Lineer Yoklama ve Bolen Kalan Teknigiyle "<<adimSayici<<" Adimda Bulundu." << endl; 
				//cout <<  << anaKayit[i].numara << setw(15) << anaKayit[i].adSoyad << endl;
				//cout <<setw(5)<< lyBolenKalanKayit[bglAdres].numara << setw(15)<<  lyBolenKalanKayit[bglAdres].adSoyad << endl;
			}
			else
			{
				adimSayici++;
				bglAdres++;
				if (bglAdres > 630) {
					bglAdres = 0; adimSayici++;
				}
				if (bglAdres == evAdres) { adimSayici++; cout << "Kayit Dosyada Degil! " << endl; }

				else { adimSayici++; goto basla; }
			}
		}
	}
	return adimSayici;

}
int bayrakLyKatlama[631] = { 0 };
struct Kayit lyKatlamaKayit[631];//yazdýrdýðýmýz verileri tutmak için kullanýyoruz.
void LineerYoklamaKatlama(struct Kayit lineer[500])
{
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		bglAdres = katlama(lineer[i].numara);
		evAdres = bglAdres;
	basla:
		if (bayrakLyKatlama[bglAdres] == 0)
		{
			bayrakLyKatlama[bglAdres]++;
			lyKatlamaKayit[bglAdres].adSoyad = lineer[i].adSoyad;
			lyKatlamaKayit[bglAdres].numara = lineer[i].numara;
			lyKatlamaKayit[bglAdres].bagilAdr = bglAdres;

		}
		else if (bayrakLyKatlama[bglAdres] == 1)
		{
			bglAdres = bglAdres + 1;

			if (bglAdres > 630)
				bglAdres = 0;
			if (bglAdres == evAdres) {
				cout << "Dosya Doldu!" << endl;

			}
			goto basla;
		}


	}
	//Dosyaya yazdýrma gerçekleþiyor...
	ofstream lyBolenKatlama;
	lyBolenKatlama.open("lineerYoklamaKatlama.txt");
	lyBolenKatlama << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip kütüphanesinden gelir boþluk býrakýp yazý yazmayý saðlar.
	for (int i =0; i < 631; i++)
	{
		if (bayrakLyKatlama[i] == 1)
			lyBolenKatlama << setw(7) << lyKatlamaKayit[i].bagilAdr << setw(20) << lyKatlamaKayit[i].numara << setw(20) << lyKatlamaKayit[i].adSoyad << endl;
		else {
			lyKatlamaKayit[i].bagilAdr = i;
			lyKatlamaKayit[i].adSoyad = "";
			lyKatlamaKayit[i].numara = NULL;
			//boþ kayýtlarýda göstermek için kullanýyoruz. Yazdýrýrken Numarayý yazdýrmýyoruz çünkü null deðer 0 olarak okunuyor.
			lyBolenKatlama << setw(7) << lyKatlamaKayit[i].bagilAdr << setw(20) << " " << setw(20) << lyKatlamaKayit[i].adSoyad << endl;
		}
	}


}
int lineerYoklamaKatlamaAra(struct Kayit lineer[500])
{
	int adimSayici = 0;
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		bglAdres = katlama(lineer[i].numara); adimSayici++;
		evAdres = bglAdres; adimSayici++;
	basla:adimSayici++;
		if (bayrakLyKatlama[bglAdres] == 0) { adimSayici++; cout << "Kayit Dosyada Degil!" << endl; }
		else
		{
			adimSayici++;
			if (lyKatlamaKayit[bglAdres].numara == lineer[i].numara)
			{
				adimSayici++;
				//cout << "Aranan Kayit Lineer Yoklama ve Bolen Kalan Teknigiyle "<<adimSayici<<" Adimda Bulundu." << endl; 
				//cout <<  << anaKayit[i].numara << setw(15) << anaKayit[i].adSoyad << endl;
				//cout << setw(5) << lyKatlamaKayit[bglAdres].numara << setw(15) << lyKatlamaKayit[bglAdres].adSoyad << endl;
			}
			else
			{
				adimSayici++;
				bglAdres++;
				if (bglAdres > 630) {
					bglAdres = 0; adimSayici++;
				}
				if (bglAdres == evAdres) { adimSayici++; cout << "Kayit Dosyada Degil! " << endl; }

				else { adimSayici++; goto basla; }
			}
		}
	}
	return adimSayici;

}



int main()
{
	Kayit kisiler[500];//500 kiþilik bir struct dizisi oluþturuluyor. Ýçerisinde adSoyad Numara ve BaðýlAdres deðiþkenlerini tutar.
	
	srand(time(NULL));//rastgele sayý üretmek için main fonksiyonda zaman çekirdeðini kullanýyoruz.
	
	anaKayitDosyasi(kisiler);//Ana Kayýt Dosyasý burada oluþturuluyor.	Numara ve AdSoyad üretiliyor.

	LineerYoklamaBolenKalan(kisiler); //Lineer Yoklama ve Bolen Kalan Kayýt Dosyasý oluþturuluyor.
	
	cout<<lineerYoklamaBolenKalanAra(kisiler)<<" Adimda Lineer Yoklama Bolen Kalan ile Tum Kisiler Tarandi!"<<endl;//Lineer Yoklama ve Bolen Kalan Kayýt edilen dosyadan tüm kiþiler aranýyor ve ekrana numara isim yazdýrýlýyor.

	LineerYoklamaKatlama(kisiler);

	cout << lineerYoklamaKatlamaAra(kisiler)<< " Adimda Lineer Yoklama Katlama ile Tum Kisiler Tarandi!" << endl;
	//sonuçlarý incelemek adýna ara fonksiyonlarý içindeki kiþileri görüntüleme komutu yorum satýrý haline getirilmiþtir.


	system("pause");
	return 0;
}
