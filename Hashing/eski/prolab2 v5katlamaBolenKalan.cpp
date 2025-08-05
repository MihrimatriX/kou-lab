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

int numara[9] = { 1,1,0,2,0,2,0,0,0 };//Kocaeli �niversitesi Numara Sistemi.

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
	Struct dizisi sayesinde s�ras�yla bu fonksiyon �al��acakt�r.
	Numara sistemi ��yledir:
	ilk �� basamak 110,120,130... giri� y�l�n� temsil eder. 110=2011 gibi...
	sonraki �� basamak bilg. m�hendisli�inin kodudur. 202.
	son �� basamak ise giri� s�ralamas�d�r. (hi� bir ��rencinin numaras� 0 ile bitemez.)
	her sene i�in 100 ki�i ay�rarak 5 senelik kay�t tutulmaktad�r. 110-202-099 den sonra 110-202-101 gelir.
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
	//dizideki sonucu integer bir de�i�kene at�yoruz
	return diziToIntNumara(9,numara);
	
}

char *RasgeleIsimUret()
{
	//alt + rand() % (ust - alt + 1) 
	int AdUzunluk = 2 + rand() % 6;//en az 2 harfli en�ok 7 harfli isim
	int SoyadUzunluk = 5 + rand() % 6;//en az 5 harfli en�ok 10 harfli soyisim
	char *isim = new char[9 + 2];// isim soyisim aras�ndaki bo�luk ve c�mle sonu \0 � da ekleriz +2 olur.
								 //Toplam 10 karakterlik isim soyisim istendi�i i�in 9+2 =11 char alan� ay�r�yoruz... (bo�lu�u dahil etmedim)
	char *KuckHarf = "abcdefghijklmnopqrstuvwxyz";
	char *BykHarf = "ABCDEFGHIJKLMOPRSTUVWXYZ";
	for (int i = 0; i < AdUzunluk; i++) {
		if (i == 0)
		{
			isim[0] = BykHarf[rand() % strlen(BykHarf)];
			continue;//ilk harfi atad�ktan sonra di�er harfe ge�mesi i�in d�ng�y� 1 atlat�r�z.
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
	int numaraHavuzu[800];//800 kapasiteli numara havuzu olu�turup i�inden rasgele 500 tane numaray� kullan�yoruz.Numara �retimi...
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
		anaKayit[i].adSoyad = RasgeleIsimUret();//�sim �retimi...

	}
	/*cout << setw(7) << "Numara" << setw(15) << "Ad Soyad" << endl;
	for (int i = 0; i < 500; i++) kontorol ama�l� yazd�rma
	{
		cout << setw(5) << anaKayit[i].numara << setw(15) << anaKayit[i].adSoyad << endl;
	}*/
	ofstream kayit;
	kayit.open("Kayit.txt");
	kayit << setw(5) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip k�t�phanesinden gelir bo�luk b�rak�p yaz� yazmay� sa�lar.
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
	//619 olmas�n�n sebebi; B�t�n hash fonksiyonlar�, dosya dolulu�a yakla�t�k�a k�t� i�lemeye ba�larlar. 
	//Genel bir tavsiye olarak y�kleme fakt�r� %70 veya %80 al�n�r. y�kl.fakt�r�=500/625 =%80 ykleme fakt�r�n� verir.
	//maksimum 619 olabiliyorsa 625 e en yak�n asal say� olarak 631 se�iliyor.

}
int katlama(int numara)
{
	int bglAdres;
	int dizi[9];
	//numaray� diziye cevirelim...
	for (int i = 8; numara != 0; i--)
	{
		dizi[i] = numara % 10;
		numara /= 10;
	}
	//diziyi 4 er 4 er Katl�yoruz..
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
	if (bglAdres > 9999)//4 basamakl� say�lar elde ediyoruz e�er 5 basamak olursa on binler basama�� silinir
		bglAdres %= 10000;

	return bglAdres%631;
}


int bayrakLyBk[631] = {0};// �ncelikle i�eri�in hepsini 0 yap�yoruz, kay�t edilince 1 e �eviriyoruz (bayrak mant���).
struct Kayit lyBolenKalanKayit[631];//yazd�rd���m�z verileri tutmak i�in kullan�yoruz.

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
	//Dosyaya yazd�rma ger�ekle�iyor...
	ofstream lyBolenKalan;
	lyBolenKalan.open("lineerYoklamaBolenKalan.txt");
	lyBolenKalan << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip k�t�phanesinden gelir bo�luk b�rak�p yaz� yazmay� sa�lar.
	for (int i = 0; i < 631; i++)
	{
		if(bayrakLyBk[i]==1)
		lyBolenKalan << setw(7) <<lyBolenKalanKayit[i].bagilAdr << setw(20) << lyBolenKalanKayit[i].numara << setw(20) << lyBolenKalanKayit[i].adSoyad << endl;
		else {
			lyBolenKalanKayit[i].bagilAdr = i;
			lyBolenKalanKayit[i].adSoyad = "";
			lyBolenKalanKayit[i].numara = NULL;
			//bo� kay�tlar�da g�stermek i�in kullan�yoruz. Yazd�r�rken Numaray� yazd�rm�yoruz ��nk� null de�er 0 olarak okunuyor.
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
struct Kayit lyKatlamaKayit[631];//yazd�rd���m�z verileri tutmak i�in kullan�yoruz.
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
	//Dosyaya yazd�rma ger�ekle�iyor...
	ofstream lyBolenKatlama;
	lyBolenKatlama.open("lineerYoklamaKatlama.txt");
	lyBolenKatlama << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip k�t�phanesinden gelir bo�luk b�rak�p yaz� yazmay� sa�lar.
	for (int i =0; i < 631; i++)
	{
		if (bayrakLyKatlama[i] == 1)
			lyBolenKatlama << setw(7) << lyKatlamaKayit[i].bagilAdr << setw(20) << lyKatlamaKayit[i].numara << setw(20) << lyKatlamaKayit[i].adSoyad << endl;
		else {
			lyKatlamaKayit[i].bagilAdr = i;
			lyKatlamaKayit[i].adSoyad = "";
			lyKatlamaKayit[i].numara = NULL;
			//bo� kay�tlar�da g�stermek i�in kullan�yoruz. Yazd�r�rken Numaray� yazd�rm�yoruz ��nk� null de�er 0 olarak okunuyor.
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
	Kayit kisiler[500];//500 ki�ilik bir struct dizisi olu�turuluyor. ��erisinde adSoyad Numara ve Ba��lAdres de�i�kenlerini tutar.
	
	srand(time(NULL));//rastgele say� �retmek i�in main fonksiyonda zaman �ekirde�ini kullan�yoruz.
	
	anaKayitDosyasi(kisiler);//Ana Kay�t Dosyas� burada olu�turuluyor.	Numara ve AdSoyad �retiliyor.

	LineerYoklamaBolenKalan(kisiler); //Lineer Yoklama ve Bolen Kalan Kay�t Dosyas� olu�turuluyor.
	
	cout<<lineerYoklamaBolenKalanAra(kisiler)<<" Adimda Lineer Yoklama Bolen Kalan ile Tum Kisiler Tarandi!"<<endl;//Lineer Yoklama ve Bolen Kalan Kay�t edilen dosyadan t�m ki�iler aran�yor ve ekrana numara isim yazd�r�l�yor.

	LineerYoklamaKatlama(kisiler);

	cout << lineerYoklamaKatlamaAra(kisiler)<< " Adimda Lineer Yoklama Katlama ile Tum Kisiler Tarandi!" << endl;
	//sonu�lar� incelemek ad�na ara fonksiyonlar� i�indeki ki�ileri g�r�nt�leme komutu yorum sat�r� haline getirilmi�tir.


	system("pause");
	return 0;
}
