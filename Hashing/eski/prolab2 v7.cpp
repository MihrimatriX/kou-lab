// prolab2.cpp : Defines the entry point for the console application.
//


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

int bolenKalan(int numara,string cakismaTipi)
{

	int bglAdres;
	if (cakismaTipi == "lineerYoklama")
		bglAdres = numara %= 631;
	else if (cakismaTipi == "ayrikTasma")
		bglAdres = numara %= 501;
	return bglAdres;
	//619 olmas�n�n sebebi; B�t�n hash fonksiyonlar�, dosya dolulu�a yakla�t�k�a k�t� i�lemeye ba�larlar. 
	//Genel bir tavsiye olarak y�kleme fakt�r� %70 veya %80 al�n�r. y�kl.fakt�r�=500/625 =%80 ykleme fakt�r�n� verir.
	//maksimum 619 olabiliyorsa 625 e en yak�n asal say� olarak 631 se�iliyor.

}
int katlama(int numara,string cakismaTipi)
{

	int bglAdres;
	int dizi[9];
	//numaray� diziye cevirelim...
	for (int i = 8; numara != 0; i--)
	{
		dizi[i] = numara % 10;
		numara /= 10;
	}
	//diziyi 3 er 3 er Katl�yoruz..
	int son[3], orta = 202, bas[3];


	for (int i = 8; i > 5; i--)
	{
		son[8 - i] = dizi[i];
	}

	for (int i = 2; i >= 0; i--)
	{
		bas[2 - i] = dizi[i];

	}

	bglAdres = diziToIntNumara(3, son) + diziToIntNumara(3, bas) + orta;
	if (bglAdres > 999)//4 basamakl� say�lar elde ediyoruz e�er 5 basamak olursa on binler basama�� silinir
	{
		bglAdres %= 1000;
	}
	if(cakismaTipi=="lineerYoklama")
	return bglAdres%631;
	else
	return bglAdres % 501;

}
int kareOrtasi(int numara,string cakismaTipi)
{
	unsigned long long kare=numara;
	kare *= kare;
	
	int kareOrt[3];
	int bglAdres;
	
	
	int dizi[17];
	for (int i = 16; kare != 0; i--)
	{
		dizi[i] = kare%10;
		kare /= 10;
	}

	for(int i=7;i<10;i++)
	{
		kareOrt[i-7]=dizi[i];
	}
	bglAdres=diziToIntNumara(3,kareOrt);


	//max kayit sayisina g�re mod al�n�r �yle g�nderilir.
	if (cakismaTipi == "ayrikTasma")
		bglAdres %= 501;
	else if (cakismaTipi == "lineerYoklama")
		bglAdres %= 631;
	
	return bglAdres;
}


int bayrakLyBk[631] = {0};// �ncelikle i�eri�in hepsini 0 yap�yoruz, kay�t edilince 1 e �eviriyoruz (bayrak mant���).
struct Kayit lyBolenKalanKayit[631];//yazd�rd���m�z verileri tutmak i�in kullan�yoruz.

void LineerYoklamaBolenKalan(struct Kayit lineer[500])
{
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		bglAdres = bolenKalan(lineer[i].numara,"lineerYoklama");
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
	int adimSayici=0,ogrSay=0;
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		bglAdres = bolenKalan(lineer[i].numara,"lineerYoklama"); adimSayici++;
		evAdres = bglAdres; adimSayici++;
	basla:adimSayici++;
		if (bayrakLyBk[bglAdres] == 0) { adimSayici++; cout << "Kayit Dosyada Degil!" << endl; }
		else
		{
			adimSayici++;
			if (lyBolenKalanKayit[bglAdres].numara == lineer[i].numara)
			{
				adimSayici++;
				ogrSay++;
				cout << ogrSay << ". " << lyBolenKalanKayit[bglAdres].numara << " " << lyBolenKalanKayit[bglAdres].adSoyad << endl;

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
		bglAdres = katlama(lineer[i].numara,"lineerYoklama");
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
	int adimSayici = 0,ogrSay=0;
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		bglAdres = katlama(lineer[i].numara,"lineerYoklama"); adimSayici++;
		evAdres = bglAdres; adimSayici++;
	basla:adimSayici++;
		if (bayrakLyKatlama[bglAdres] == 0) { adimSayici++; cout << "Kayit Dosyada Degil!" << endl; }
		else
		{
			adimSayici++;
			if (lyKatlamaKayit[bglAdres].numara == lineer[i].numara)
			{
				adimSayici++;
				ogrSay++;
				cout << ogrSay << ". " << lyKatlamaKayit[bglAdres].numara << " " << lyKatlamaKayit[bglAdres].adSoyad << endl;
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

int bayrakLyKareOrt[631] = { 0 };
struct Kayit lyKareOrtKayit[631];//yazd�rd���m�z verileri tutmak i�in kullan�yoruz.
void LineerYoklamaKareOrt(struct Kayit lineer[500])
{
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		bglAdres = kareOrtasi(lineer[i].numara,"lineerYoklama");
		evAdres = bglAdres;
	basla:
		if (bayrakLyKareOrt[bglAdres] == 0)
		{
			bayrakLyKareOrt[bglAdres]++;
			lyKareOrtKayit[bglAdres].adSoyad = lineer[i].adSoyad;
			lyKareOrtKayit[bglAdres].numara = lineer[i].numara;
			lyKareOrtKayit[bglAdres].bagilAdr = bglAdres;

		}
		else if (bayrakLyKareOrt[bglAdres] == 1)
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
	ofstream lyKareOrt;
	lyKareOrt.open("lineerYoklamaKareOrtasi.txt");
	lyKareOrt << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip k�t�phanesinden gelir bo�luk b�rak�p yaz� yazmay� sa�lar.
	for (int i = 0; i < 631; i++)
	{
		if (bayrakLyKareOrt[i] == 1)
			lyKareOrt << setw(7) << lyKareOrtKayit[i].bagilAdr << setw(20) << lyKareOrtKayit[i].numara << setw(20) << lyKareOrtKayit[i].adSoyad << endl;
		else {
			lyKareOrtKayit[i].bagilAdr = i;
			lyKareOrtKayit[i].adSoyad = "";
			lyKareOrtKayit[i].numara = NULL;
			//bo� kay�tlar�da g�stermek i�in kullan�yoruz. Yazd�r�rken Numaray� yazd�rm�yoruz ��nk� null de�er 0 olarak okunuyor.
			lyKareOrt << setw(7) << lyKareOrtKayit[i].bagilAdr << setw(20) << " " << setw(20) << lyKareOrtKayit[i].adSoyad << endl;
		}
	}


}
int lineerYoklamaKareOrtAra(struct Kayit lineer[500])
{
	int adimSayici = 0;
	int ogrSay = 0;
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		bglAdres = kareOrtasi(lineer[i].numara,"lineerYoklama"); adimSayici++;
		evAdres = bglAdres; adimSayici++;
	basla:adimSayici++;
		if (bayrakLyKareOrt[bglAdres] == 0) { adimSayici++; cout << "Kayit Dosyada Degil!" << endl; }
		else
		{
			adimSayici++;
			if (lyKareOrtKayit[bglAdres].numara == lineer[i].numara)
			{
				adimSayici++;
				ogrSay++;
				cout << ogrSay << ". " << lyKareOrtKayit[bglAdres].numara << " " <<lyKareOrtKayit[bglAdres].adSoyad << endl;
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

int bayrakAtBk[900] = { 0 };// �ncelikle i�eri�in hepsini 0 yap�yoruz, kay�t edilince 1 e �eviriyoruz (bayrak mant���).
struct Kayit atBolenKalanKayit[900];//yazd�rd���m�z verileri tutmak i�in kullan�yoruz.
static int atBkAdimSay = 0;//Kay�t ve Araman�n toplam ad�m sayilar�n� bu �ekilde tutaca��z.

void AyrikTasmaBolenKalan(struct Kayit lineer[500])
{
	int bglAdres;
	int evAdres;
	int ayriTasma = 501;

	for (int i = 0; i < 500; i++)
	{
		bglAdres = bolenKalan(lineer[i].numara,"ayrikTasma");
		evAdres = bglAdres;
		basla:
		if (bayrakAtBk[bglAdres] == 0)
		{
			bayrakAtBk[bglAdres]++;
			atBolenKalanKayit[bglAdres].adSoyad = lineer[i].adSoyad;
			atBolenKalanKayit[bglAdres].numara = lineer[i].numara;
			atBolenKalanKayit[bglAdres].bagilAdr = bglAdres;

		}
		else
		{
			while (bayrakAtBk[ayriTasma] == 1)
				ayriTasma++;
			bglAdres = ayriTasma;
			goto basla;

		}
		


	}
	//Dosyaya yazd�rma ger�ekle�iyor...

	ofstream atBolenKalan;
	atBolenKalan.open("ayrikTasmaBolenKalan.txt");
	atBolenKalan << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip k�t�phanesinden gelir bo�luk b�rak�p yaz� yazmay� sa�lar.
	for (int i = 0; i < 900; i++)
	{
		if(i==501)
			atBolenKalan << setw(35) << "AYRIK TASMA ALANI"<< endl;
		if (bayrakAtBk[i] == 1) {
			atBolenKalan << setw(7) << atBolenKalanKayit[i].bagilAdr << setw(20) << atBolenKalanKayit[i].numara << setw(20) << atBolenKalanKayit[i].adSoyad << endl;
			
		}
		else {
			atBolenKalanKayit[i].bagilAdr = i;
			atBolenKalanKayit[i].adSoyad = "";
			atBolenKalanKayit[i].numara = NULL;
			//bo� kay�tlar�da g�stermek i�in kullan�yoruz. Yazd�r�rken Numaray� yazd�rm�yoruz ��nk� null de�er 0 olarak okunuyor.
			atBolenKalan << setw(7) << atBolenKalanKayit[i].bagilAdr << setw(20) << " " << setw(20) << atBolenKalanKayit[i].adSoyad << endl;
		
		}
	}
	

}
int ayrikTasmaBolenKalanAra(struct Kayit lineer[500])
{
	
	int adimSay = 0;
	int tasma = 501;
	
	int ogrSay = 0;

	
	for (int i = 0; i < 500; i++)
	{
		
		int aranan = lineer[i].numara;
		
		int bglAdr = bolenKalan(aranan, "ayrikTasma");
		
		if (bayrakAtBk[bglAdr] == 0)
		{cout << "Ogrenci Bulunamadi" << endl;
	
		}
			
		else
		{
		
		basla:
		
			if (atBolenKalanKayit[bglAdr].numara == aranan)
			{
				
				ogrSay++;
				
		cout <<ogrSay<<". "<< atBolenKalanKayit[bglAdr].numara <<" "<< atBolenKalanKayit[bglAdr].adSoyad << endl;
				
			}
			else
			{
				
				bglAdr = tasma;
				tasma++;
			
				goto basla;

			}
		}
	
	}
	return 0;
}
int bayrakAtKat[900] = { 0 };// �ncelikle i�eri�in hepsini 0 yap�yoruz, kay�t edilince 1 e �eviriyoruz (bayrak mant���).
struct Kayit atKatKayit[900];//yazd�rd���m�z verileri tutmak i�in kullan�yoruz.
//static int atBkAdimSay = 0;//Kay�t ve Araman�n toplam ad�m sayilar�n� bu �ekilde tutaca��z.
void AyrikTasmaKatlama(struct Kayit lineer[500])
{
	int bglAdres;
	int evAdres;
	int ayriTasma = 501;

	for (int i = 0; i < 500; i++)
	{
		bglAdres = katlama(lineer[i].numara, "ayrikTasma");
		
	basla:
		if (bayrakAtKat[bglAdres] == 0)
		{
			bayrakAtKat[bglAdres]++;
			atKatKayit[bglAdres].adSoyad = lineer[i].adSoyad;
			atKatKayit[bglAdres].numara = lineer[i].numara;
			atKatKayit[bglAdres].bagilAdr = bglAdres;

		}
		else
		{
			while (bayrakAtKat[ayriTasma] == 1)
				ayriTasma++;
			bglAdres = ayriTasma;
			goto basla;

		}



	}
	//Dosyaya yazd�rma ger�ekle�iyor...

	ofstream atKatlama;
	atKatlama.open("ayrikTasmaKatlama.txt");
	atKatlama << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip k�t�phanesinden gelir bo�luk b�rak�p yaz� yazmay� sa�lar.
	for (int i = 0; i < 900; i++)
	{
		if (i == 501)
			atKatlama << setw(35) << "AYRIK TASMA ALANI" << endl;
		if (bayrakAtKat[i] == 1) {
			atKatlama << setw(7) << atKatKayit[i].bagilAdr << setw(20) << atKatKayit[i].numara << setw(20) << atKatKayit[i].adSoyad << endl;

		}
		else {
			atKatKayit[i].bagilAdr = i;
			atKatKayit[i].adSoyad = "";
			atKatKayit[i].numara = NULL;
			//bo� kay�tlar�da g�stermek i�in kullan�yoruz. Yazd�r�rken Numaray� yazd�rm�yoruz ��nk� null de�er 0 olarak okunuyor.
			atKatlama << setw(7) << atKatKayit[i].bagilAdr << setw(20) << " " << setw(20) << atKatKayit[i].adSoyad << endl;

		}
	}


}



int ayrikTasmaKatlamaAra(struct Kayit lineer[500])
{

	int adimSay = 0;
	int tasma = 501;

	int ogrSay = 0;
	int aranan, bglAdr;


	for (int i = 0; i < 500; i++)
	{

		 aranan = lineer[i].numara;

		 bglAdr = katlama(aranan, "ayrikTasma");

		if (bayrakAtKat[bglAdr] == 0)
		{
			cout << "Ogrenci Bulunamadi" << endl;

		}

		else
		{

		basla:

			if (atKatKayit[bglAdr].numara == aranan)
			{

				ogrSay++;

				cout <<ogrSay<<". "<< atKatKayit[bglAdr].numara <<" "<< atKatKayit[bglAdr].adSoyad << endl;

			}
			else
			{

				bglAdr = tasma;
				tasma++;

				goto basla;

			}
		}

	}
	return 0;
}

int bayrakAtKareOrt[900] = { 0 };// �ncelikle i�eri�in hepsini 0 yap�yoruz, kay�t edilince 1 e �eviriyoruz (bayrak mant���).
struct Kayit atKareOrtKayit[900];//yazd�rd���m�z verileri tutmak i�in kullan�yoruz.
							 //static int atBkAdimSay = 0;//Kay�t ve Araman�n toplam ad�m sayilar�n� bu �ekilde tutaca��z.
void AyrikTasmaKareOrt(struct Kayit lineer[500])
{
	int bglAdres;
	int evAdres;
	int ayriTasma = 501;

	for (int i = 0; i < 500; i++)
	{
		bglAdres = kareOrtasi(lineer[i].numara, "ayrikTasma");

	basla:
		if (bayrakAtKareOrt[bglAdres] == 0)
		{
			bayrakAtKareOrt[bglAdres]++;
			atKareOrtKayit[bglAdres].adSoyad = lineer[i].adSoyad;
			atKareOrtKayit[bglAdres].numara = lineer[i].numara;
			atKareOrtKayit[bglAdres].bagilAdr = bglAdres;

		}
		else
		{
			while (bayrakAtKareOrt[ayriTasma] == 1)
				ayriTasma++;
			bglAdres = ayriTasma;
			goto basla;

		}



	}
	//Dosyaya yazd�rma ger�ekle�iyor...

	ofstream atKareOrtasi;
	atKareOrtasi.open("ayrikTasmaKareOrtasi.txt");
	atKareOrtasi << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip k�t�phanesinden gelir bo�luk b�rak�p yaz� yazmay� sa�lar.
	for (int i = 0; i < 900; i++)
	{
		if (i == 501)
			atKareOrtasi << setw(35) << "AYRIK TASMA ALANI" << endl;
		if (bayrakAtKareOrt[i] == 1) {
			atKareOrtasi << setw(7) << atKareOrtKayit[i].bagilAdr << setw(20) << atKareOrtKayit[i].numara << setw(20) << atKareOrtKayit[i].adSoyad << endl;

		}
		else {
			atKareOrtKayit[i].bagilAdr = i;
			atKareOrtKayit[i].adSoyad = "";
			atKareOrtKayit[i].numara = NULL;
			//bo� kay�tlar�da g�stermek i�in kullan�yoruz. Yazd�r�rken Numaray� yazd�rm�yoruz ��nk� null de�er 0 olarak okunuyor.
			atKareOrtasi << setw(7) << atKareOrtKayit[i].bagilAdr << setw(20) << " " << setw(20) << atKareOrtKayit[i].adSoyad << endl;

		}
	}


}



int ayrikTasmaKareOrtAra(struct Kayit lineer[500])
{

	int adimSay = 0;
	int tasma = 501;

	int ogrSay = 0;
	int aranan, bglAdr;


	for (int i = 0; i < 500; i++)
	{

		aranan = lineer[i].numara;

		bglAdr = kareOrtasi(aranan, "ayrikTasma");

		if (bayrakAtKareOrt[bglAdr] == 0)
		{
			cout << "Ogrenci Bulunamadi" << endl;

		}

		else
		{

		basla:

			if (atKareOrtKayit[bglAdr].numara == aranan)
			{

				ogrSay++;

				cout << ogrSay << ". " << atKareOrtKayit[bglAdr].numara << " " << atKareOrtKayit[bglAdr].adSoyad << endl;

			}
			else
			{

				bglAdr = tasma;
				tasma++;

				goto basla;

			}
		}

	}
	return 0;
}




int main()
{
	Kayit kisiler[500];//500 ki�ilik bir struct dizisi olu�turuluyor. ��erisinde adSoyad Numara ve Ba��lAdres de�i�kenlerini tutar.
	
	srand(time(NULL));//rastgele say� �retmek i�in main fonksiyonda zaman �ekirde�ini kullan�yoruz.
	
	anaKayitDosyasi(kisiler);//Ana Kay�t Dosyas� burada olu�turuluyor.	Numara ve AdSoyad �retiliyor.

	LineerYoklamaBolenKalan(kisiler); //Lineer Yoklama ve Bolen Kalan Kay�t Dosyas� olu�turuluyor.
	
	cout<< setw(5) << lineerYoklamaBolenKalanAra(kisiler)<< " Adimda Lineer Yoklama BolenKalan Yontemiyle Bulunmustur.\nDevam etmek icin bi tusa basiniz..." << endl;//Lineer Yoklama ve Bolen Kalan Kay�t edilen dosyadan t�m ki�iler aran�yor ve ekrana numara isim yazd�r�l�yor.
	system("pause");
	system("cls");


	LineerYoklamaKatlama(kisiler);

	cout <<setw(5)<< lineerYoklamaKatlamaAra(kisiler)<< " Adimda Lineer Yoklama Katlama Yontemiyle Bulunmustur.\nDevam etmek icin bi tusa basiniz..." << endl;

	system("pause");
	system("cls");


	LineerYoklamaKareOrt(kisiler);
	cout << setw(5) << lineerYoklamaKareOrtAra(kisiler) << " Adimda Lineer Yoklama KareOrtasi Yontemiyle Bulunmustur.\nDevam etmek icin bi tusa basiniz..." << endl;


	system("pause");
	system("cls");

	AyrikTasmaBolenKalan(kisiler);
	cout << ayrikTasmaBolenKalanAra(kisiler)<<" Adimda AyrikTasma BolenKalan Yontemiyle Bulunmustur.\nDevam etmek icin bi tusa basiniz..."<<endl;

	system("pause");
	system("cls");

	AyrikTasmaKatlama(kisiler);
	cout << ayrikTasmaKatlamaAra(kisiler) << " Adimda AyrikTasma Katlama Yontemiyle Bulunmustur.\nDevam etmek icin bi tusa basiniz..." << endl;

	system("pause");
	system("cls");

	AyrikTasmaKareOrt(kisiler);
	cout << ayrikTasmaKareOrtAra(kisiler) << " Adimda AyrikTasma KareOrtasi Yontemiyle Bulunmustur.\nDevam etmek icin bi tusa basiniz..." << endl;
	system("pause");
	return 0;
}

