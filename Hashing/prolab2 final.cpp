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

static int sayac = 0;//numara üretiminde kullanýlýyor.
int lyBkSay = 0, lyKatSay = 0, lyKortSay = 0, atBkSay = 0, atKatSay = 0, atKortSay = 0,lineerSay = 0;;//7 dosyanýn adým sayýsý için global deðiþkenler tanýmlandý 
//hem kayýt için hemde arama için sayaç her adýmda arttýrýlýr.
enum {
	MAX = 7
};//6 tane adým sayýcý için dizinin boyutunu global olarak tanýmlýyoruz.
void buble(int*);//sýralarken kullanýlacak fonksiyonun prototipi.

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
	{
		lineerSay++; lineerSay++; lineerSay++;
		numaraHavuzu[i] = NumaraUret();
	}
	lineerSay++;
	int numaraBayrak[800] = {};
	lineerSay++;
	int k = 0, rast;
	do
	{
		lineerSay++;
	basla:
		lineerSay++;
		rast = rand() % 800;
		lineerSay++;
		if (numaraBayrak[rast] == 0) {
			lineerSay++; lineerSay++;

			anaKayit[k].numara = numaraHavuzu[rast];
			lineerSay++;
			numaraBayrak[rast]++;
		}
		else
		{
			lineerSay++;
			goto basla;
		}
			lineerSay++;
		k++;
	} while (k<500);


	for (int i = 0; i < 500; i++)
	{
		lineerSay++; lineerSay++; lineerSay++;
		anaKayit[i].adSoyad = RasgeleIsimUret();//Ýsim Üretimi...

	}
	/*cout << setw(7) << "Numara" << setw(15) << "Ad Soyad" << endl;
	for (int i = 0; i < 500; i++) kontorol amaçlý yazdýrma
	{
		cout << setw(5) << anaKayit[i].numara << setw(15) << anaKayit[i].adSoyad << endl;
	}*/
	ofstream kayit;
	kayit.open("Kayit.txt");
	lineerSay++; lineerSay++;
	kayit << setw(5) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip kütüphanesinden gelir boþluk býrakýp yazý yazmayý saðlar.
	for (int i = 0; i < 500; i++)
	{
		lineerSay++; lineerSay++; lineerSay++;

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
	//619 olmasýnýn sebebi; Bütün hash fonksiyonlarý, dosya doluluða yaklaþtýkça kötü iþlemeye baþlarlar. 
	//Genel bir tavsiye olarak yükleme faktörü %70 veya %80 alýnýr. yükl.faktörü=500/625 =%80 ykleme faktörünü verir.
	//maksimum 619 olabiliyorsa 625 e en yakýn asal sayý olarak 631 seçiliyor.

}
int katlama(int numara,string cakismaTipi)
{

	int bglAdres;
	int dizi[9];
	//numarayý diziye cevirelim...
	for (int i = 8; numara != 0; i--)
	{
		dizi[i] = numara % 10;
		numara /= 10;
	}
	//diziyi 3 er 3 er Katlýyoruz..
	int son[3], orta = 202, bas[3];

	/*
	for (int i = 6; i <= 8; i++)
	{
		son[i - 6] = dizi[i];
	}

	for (int i = 0; i <= 2; i++)
	{
		bas[i - 0] = dizi[i];

	}*/
	for (int i = 8; i > 5; i--)
	{
		son[8 - i] = dizi[i];
	}

	for (int i = 2; i >= 0; i--)
	{
		bas[2 - i] = dizi[i];

	}

	bglAdres = diziToIntNumara(3, son) + diziToIntNumara(3, bas) + orta;
	if (bglAdres > 999)//4 basamaklý sayýlar elde ediyoruz eðer 5 basamak olursa on binler basamaðý silinir
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


	//max kayit sayisina göre mod alýnýr öyle gönderilir.
	if (cakismaTipi == "ayrikTasma")
		bglAdres %= 501;
	else if (cakismaTipi == "lineerYoklama")
		bglAdres %= 631;
	
	return bglAdres;
}


int bayrakLyBk[631] = {0};// öncelikle içeriðin hepsini 0 yapýyoruz, kayýt edilince 1 e çeviriyoruz (bayrak mantýðý).
struct Kayit lyBolenKalanKayit[631];//yazdýrdýðýmýz verileri tutmak için kullanýyoruz.

void LineerYoklamaBolenKalan(struct Kayit lineer[500])
{
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		lyBkSay++;
		bglAdres = bolenKalan(lineer[i].numara,"lineerYoklama");
		lyBkSay++;
		evAdres = bglAdres;
		lyBkSay++;
	basla:
		lyBkSay++;
		if (bayrakLyBk[bglAdres] == 0)
		{
			lyBkSay++;
			bayrakLyBk[bglAdres]++;
			lyBkSay++;
			lyBolenKalanKayit[bglAdres].adSoyad = lineer[i].adSoyad;
			lyBkSay++;
			lyBolenKalanKayit[bglAdres].numara = lineer[i].numara;
			lyBkSay++;
			lyBolenKalanKayit[bglAdres].bagilAdr = bglAdres;
			lyBkSay++;

		}
		
		else if (bayrakLyBk[bglAdres] == 1)
		{
			lyBkSay++;
			lyBkSay++;
			bglAdres = bglAdres + 1;
			lyBkSay++;

			if (bglAdres > 630)
			{
				lyBkSay++;
				bglAdres = 0;
				lyBkSay++;
			}
				
			if (bglAdres == evAdres) {
				lyBkSay++;
				cout << "Dosya Doldu!" << endl;
				lyBkSay++;

			}
			lyBkSay++;
			goto basla;
		}
		
		lyBkSay++;
	}
	//Dosyaya yazdýrma gerçekleþiyor...
	ofstream lyBolenKalan;
	lyBolenKalan.open("lineerYoklamaBolenKalan.txt");
	lyBkSay++;
	lyBolenKalan << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip kütüphanesinden gelir boþluk býrakýp yazý yazmayý saðlar.
	lyBkSay++;
	for (int i = 0; i < 631; i++)
	{
		lyBkSay++;	lyBkSay++;
		if (bayrakLyBk[i] == 1) {
			lyBkSay++;
			lyBolenKalan << setw(7) << lyBolenKalanKayit[i].bagilAdr << setw(20) << lyBolenKalanKayit[i].numara << setw(20) << lyBolenKalanKayit[i].adSoyad << endl;
			lyBkSay++;
		}
		else {
			lyBkSay++;
			lyBolenKalanKayit[i].bagilAdr = i;
			lyBkSay++;
			lyBolenKalanKayit[i].adSoyad = "";
			lyBkSay++;
			lyBolenKalanKayit[i].numara = NULL;
			lyBkSay++;
			//boþ kayýtlarýda göstermek için kullanýyoruz. Yazdýrýrken Numarayý yazdýrmýyoruz çünkü null deðer 0 olarak okunuyor.
			lyBolenKalan << setw(7) << lyBolenKalanKayit[i].bagilAdr << setw(20) << " "<< setw(20) << lyBolenKalanKayit[i].adSoyad << endl;
			lyBkSay++;
		}
	}
	

}


int lineerYoklamaBolenKalanAra(struct Kayit lineer[500])
{
	
	int ogrSay=0;

	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		lyBkSay++;	lyBkSay++;
		bglAdres = bolenKalan(lineer[i].numara,"lineerYoklama"); 
		lyBkSay++;
		evAdres = bglAdres;
		lyBkSay++;
		
	basla:	lyBkSay++;
		if (bayrakLyBk[bglAdres] == 0) { lyBkSay++; cout << "Kayit Dosyada Degil!" << endl; lyBkSay++;
		}
		else
		{
			lyBkSay++;
			if (lyBolenKalanKayit[bglAdres].numara == lineer[i].numara)
			{
				lyBkSay++;
				ogrSay++;
				lyBkSay++;
				cout << ogrSay << ". " << lyBolenKalanKayit[bglAdres].numara << " " << lyBolenKalanKayit[bglAdres].adSoyad << endl;
				lyBkSay++;
			}
			else
			{
				lyBkSay++;
				bglAdres++;
				lyBkSay++;
				if (bglAdres > 630) 
				{
					lyBkSay++;
					bglAdres = 0;	lyBkSay++;
				}
				if (bglAdres == evAdres) { lyBkSay++; cout << "Kayit Dosyada Degil! " << endl;	lyBkSay++;
				}

				else { lyBkSay++; goto basla; }
			}
		}
	}
	
	return lyBkSay++;

}
int bayrakLyKatlama[631] = { 0 };
struct Kayit lyKatlamaKayit[631];//yazdýrdýðýmýz verileri tutmak için kullanýyoruz.
void LineerYoklamaKatlama(struct Kayit lineer[500])
{
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		lyKatSay++;
		bglAdres = katlama(lineer[i].numara,"lineerYoklama");
		lyKatSay++;
		evAdres = bglAdres;
		lyKatSay++;
	basla:
		lyKatSay++;
		if (bayrakLyKatlama[bglAdres] == 0)
		{
			lyKatSay++;
			bayrakLyKatlama[bglAdres]++;
			lyKatSay++;
			lyKatlamaKayit[bglAdres].adSoyad = lineer[i].adSoyad;
			lyKatSay++;
			lyKatlamaKayit[bglAdres].numara = lineer[i].numara;
			lyKatSay++;
			lyKatlamaKayit[bglAdres].bagilAdr = bglAdres;
			lyKatSay++;
		}
		else if (bayrakLyKatlama[bglAdres] == 1)
		{
			lyKatSay++;	lyKatSay++;
			bglAdres = bglAdres + 1;
			lyKatSay++;
	
			if (bglAdres > 630) {
				lyKatSay++;
				bglAdres = 0;
				lyKatSay++;
			}
				
			if (bglAdres == evAdres) {
				lyKatSay++;
				cout << "Dosya Doldu!" << endl;
				lyKatSay++;
			}
			lyKatSay++;
			goto basla;
		}

		lyKatSay++;
	}
	//Dosyaya yazdýrma gerçekleþiyor...
	ofstream lyBolenKatlama;
	lyBolenKatlama.open("lineerYoklamaKatlama.txt");
	lyKatSay++;
	lyBolenKatlama << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip kütüphanesinden gelir boþluk býrakýp yazý yazmayý saðlar.
	lyKatSay++;
	for (int i =0; i < 631; i++)
	{
		lyKatSay++; lyKatSay++;
		if (bayrakLyKatlama[i] == 1) {
			lyKatSay++; lyKatSay++;
			lyBolenKatlama << setw(7) << lyKatlamaKayit[i].bagilAdr << setw(20) << lyKatlamaKayit[i].numara << setw(20) << lyKatlamaKayit[i].adSoyad << endl;
		}
		else {
			lyKatSay++;
			lyKatlamaKayit[i].bagilAdr = i;
			lyKatSay++;
			lyKatlamaKayit[i].adSoyad = "";
			lyKatSay++;
			lyKatlamaKayit[i].numara = NULL;
			lyKatSay++;
			//boþ kayýtlarýda göstermek için kullanýyoruz. Yazdýrýrken Numarayý yazdýrmýyoruz çünkü null deðer 0 olarak okunuyor.
			lyBolenKatlama << setw(7) << lyKatlamaKayit[i].bagilAdr << setw(20) << " " << setw(20) << lyKatlamaKayit[i].adSoyad << endl;
			lyKatSay++;
		}
	}


}
int lineerYoklamaKatlamaAra(struct Kayit lineer[500])
{
	int ogrSay=0;
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		lyKatSay++; lyKatSay++;
		bglAdres = katlama(lineer[i].numara,"lineerYoklama"); 
		lyKatSay++;
		evAdres = bglAdres; lyKatSay++;
	basla:lyKatSay++;
		if (bayrakLyKatlama[bglAdres] == 0) { lyKatSay++; cout << "Kayit Dosyada Degil!" << endl; lyKatSay++;
		}
		else
		{
			lyKatSay++;
			if (lyKatlamaKayit[bglAdres].numara == lineer[i].numara)
			{
				lyKatSay++;
				ogrSay++;
				lyKatSay++;
				cout << ogrSay << ". " << lyKatlamaKayit[bglAdres].numara << " " << lyKatlamaKayit[bglAdres].adSoyad << endl;
				lyKatSay++;
			}
			else
			{
				lyKatSay++;
				bglAdres++;
				lyKatSay++;
				if (bglAdres > 630) {
					lyKatSay++;
					bglAdres = 0; lyKatSay++;
				}
				if (bglAdres == evAdres) { lyKatSay++; cout << "Kayit Dosyada Degil! " << endl; lyKatSay++;
				}

				else { lyKatSay++; goto basla; }
			}
		}
	}
	
	return lyKatSay++;

}

int bayrakLyKareOrt[631] = { 0 };
struct Kayit lyKareOrtKayit[631];//yazdýrdýðýmýz verileri tutmak için kullanýyoruz.
void LineerYoklamaKareOrt(struct Kayit lineer[500])
{
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		lyKortSay++;
		bglAdres = kareOrtasi(lineer[i].numara,"lineerYoklama");
		lyKortSay++;
		evAdres = bglAdres;
		lyKortSay++;
	basla:
		lyKortSay++;
		if (bayrakLyKareOrt[bglAdres] == 0)
		{
			lyKortSay++;
			bayrakLyKareOrt[bglAdres]++; lyKortSay++;
			lyKareOrtKayit[bglAdres].adSoyad = lineer[i].adSoyad; lyKortSay++;
			lyKareOrtKayit[bglAdres].numara = lineer[i].numara; lyKortSay++;
			lyKareOrtKayit[bglAdres].bagilAdr = bglAdres; lyKortSay++;

		}
		else if (bayrakLyKareOrt[bglAdres] == 1)
		{
			lyKortSay++; lyKortSay++;
			bglAdres = bglAdres + 1;
			lyKortSay++;

			if (bglAdres > 630){
				lyKortSay++; bglAdres = 0; lyKortSay++;
			}
				
			if (bglAdres == evAdres) {
				lyKortSay++;
				cout << "Dosya Doldu!" << endl;
				lyKortSay++;

			}
			lyKortSay++;
			goto basla;
		}
		lyKortSay++;


	}
	//Dosyaya yazdýrma gerçekleþiyor...
	ofstream lyKareOrt;
	lyKareOrt.open("lineerYoklamaKareOrtasi.txt"); lyKortSay++;
	lyKareOrt << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip kütüphanesinden gelir boþluk býrakýp yazý yazmayý saðlar.
	lyKortSay++;
	for (int i = 0; i < 631; i++)
	{
		lyKortSay++; lyKortSay++;
		if (bayrakLyKareOrt[i] == 1) {
			lyKortSay++; lyKortSay++;
			lyKareOrt << setw(7) << lyKareOrtKayit[i].bagilAdr << setw(20) << lyKareOrtKayit[i].numara << setw(20) << lyKareOrtKayit[i].adSoyad << endl;
		}
		else {
			lyKortSay++;
			lyKareOrtKayit[i].bagilAdr = i; lyKortSay++;
			lyKareOrtKayit[i].adSoyad = ""; lyKortSay++;
			lyKareOrtKayit[i].numara = NULL; lyKortSay++;
			//boþ kayýtlarýda göstermek için kullanýyoruz. Yazdýrýrken Numarayý yazdýrmýyoruz çünkü null deðer 0 olarak okunuyor.
			lyKareOrt << setw(7) << lyKareOrtKayit[i].bagilAdr << setw(20) << " " << setw(20) << lyKareOrtKayit[i].adSoyad << endl; lyKortSay++;
		}
	}


}
int lineerYoklamaKareOrtAra(struct Kayit lineer[500])
{
	
	int ogrSay = 0;
	int bglAdres;
	int evAdres;
	for (int i = 0; i < 500; i++)
	{
		lyKortSay++; lyKortSay++;
		bglAdres = kareOrtasi(lineer[i].numara,"lineerYoklama"); lyKortSay++;
		evAdres = bglAdres; lyKortSay++;
	basla:lyKortSay++;
		if (bayrakLyKareOrt[bglAdres] == 0) { lyKortSay++; cout << "Kayit Dosyada Degil!" << endl; lyKortSay++;
		}
		else
		{
			lyKortSay++;
			if (lyKareOrtKayit[bglAdres].numara == lineer[i].numara)
			{
				lyKortSay++;
				ogrSay++;
				lyKortSay++;
				cout << ogrSay << ". " << lyKareOrtKayit[bglAdres].numara << " " <<lyKareOrtKayit[bglAdres].adSoyad << endl;
				lyKortSay++;
			}
			else
			{
				lyKortSay++;
				bglAdres++;
				lyKortSay++;
				if (bglAdres > 630) {
					lyKortSay++;
					bglAdres = 0; lyKortSay++;
				}
				if (bglAdres == evAdres) { lyKortSay++; cout << "Kayit Dosyada Degil! " << endl; lyKortSay++;
				}

				else { lyKortSay++; goto basla; }
			}
		}
	}
	
	return lyKortSay++;

}

int bayrakAtBk[900] = { 0 };// öncelikle içeriðin hepsini 0 yapýyoruz, kayýt edilince 1 e çeviriyoruz (bayrak mantýðý).
struct Kayit atBolenKalanKayit[900];//yazdýrdýðýmýz verileri tutmak için kullanýyoruz.
static int atBkAdimSay = 0;//Kayýt ve Aramanýn toplam adým sayilarýný bu þekilde tutacaðýz.

void AyrikTasmaBolenKalan(struct Kayit lineer[500])
{
	int bglAdres;
	
	int ayriTasma = 501;

	for (int i = 0; i < 500; i++)
	{
		atBkSay++; atBkSay++;
		bglAdres = bolenKalan(lineer[i].numara,"ayrikTasma");
		atBkSay++;
	
	basla:
		atBkSay++;
		if (bayrakAtBk[bglAdres] == 0)
		{
			atBkSay++;
			bayrakAtBk[bglAdres]++;
			atBkSay++;
			atBolenKalanKayit[bglAdres].adSoyad = lineer[i].adSoyad;
			atBkSay++;
			atBolenKalanKayit[bglAdres].numara = lineer[i].numara;
			atBkSay++;
			atBolenKalanKayit[bglAdres].bagilAdr = bglAdres;
			atBkSay++;

		}
		else
		{
			atBkSay++;
			while (bayrakAtBk[ayriTasma] == 1)
			{
				atBkSay++;
				ayriTasma++;
				atBkSay++;
			}
			bglAdres = ayriTasma;
			atBkSay++; 
			goto basla;

		}
		


	}
	//Dosyaya yazdýrma gerçekleþiyor...

	ofstream atBolenKalan;
	atBolenKalan.open("ayrikTasmaBolenKalan.txt"); atBkSay++;
	atBolenKalan << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip kütüphanesinden gelir boþluk býrakýp yazý yazmayý saðlar.
	atBkSay++;
	for (int i = 0; i < 900; i++)
	{
		atBkSay++; atBkSay++;
		if (i == 501) {
			atBkSay++;
			atBolenKalan << setw(35) << "AYRIK TASMA ALANI" << endl;
			atBkSay++;
		}
		if (bayrakAtBk[i] == 1) {
			atBkSay++;
			atBolenKalan << setw(7) << atBolenKalanKayit[i].bagilAdr << setw(20) << atBolenKalanKayit[i].numara << setw(20) << atBolenKalanKayit[i].adSoyad << endl;
			atBkSay++;
			
		}
		else {
			atBkSay++;
			atBolenKalanKayit[i].bagilAdr = i; atBkSay++;
			atBolenKalanKayit[i].adSoyad = ""; atBkSay++;
			atBolenKalanKayit[i].numara = NULL; atBkSay++;
			//boþ kayýtlarýda göstermek için kullanýyoruz. Yazdýrýrken Numarayý yazdýrmýyoruz çünkü null deðer 0 olarak okunuyor.
			atBolenKalan << setw(7) << atBolenKalanKayit[i].bagilAdr << setw(20) << " " << setw(20) << atBolenKalanKayit[i].adSoyad << endl; atBkSay++;
		
		}
	}
	

}
int ayrikTasmaBolenKalanAra(struct Kayit lineer[500])
{
	
	
	int tasma = 501;
	
	int ogrSay = 0;

	
	for (int i = 0; i < 500; i++)
	{
		atBkSay++; atBkSay++;
		int aranan = lineer[i].numara;
		atBkSay++;
		int bglAdr = bolenKalan(aranan, "ayrikTasma");
		atBkSay++;
		if (bayrakAtBk[bglAdr] == 0)
		{
			atBkSay++; cout << "Ogrenci Bulunamadi" << endl; atBkSay++;
	
		}
			
		else
		{
			atBkSay++;
		basla:
			atBkSay++;
			if (atBolenKalanKayit[bglAdr].numara == aranan)
			{
				atBkSay++;
				ogrSay++;
				atBkSay++;
				
		cout <<ogrSay<<". "<< atBolenKalanKayit[bglAdr].numara <<" "<< atBolenKalanKayit[bglAdr].adSoyad << endl;
		atBkSay++;
				
			}
			else
			{
				atBkSay++;
				bglAdr = tasma;
				atBkSay++;
				tasma++;
				atBkSay++;
			
				goto basla;

			}
		}
	
	}
	return atBkSay++;
}
int bayrakAtKat[900] = { 0 };// öncelikle içeriðin hepsini 0 yapýyoruz, kayýt edilince 1 e çeviriyoruz (bayrak mantýðý).
struct Kayit atKatKayit[900];//yazdýrdýðýmýz verileri tutmak için kullanýyoruz.
//static int atBkAdimSay = 0;//Kayýt ve Aramanýn toplam adým sayilarýný bu þekilde tutacaðýz.
void AyrikTasmaKatlama(struct Kayit lineer[500])
{
	int bglAdres;
	int evAdres;
	int ayriTasma = 501;

	for (int i = 0; i < 500; i++)
	{
		atKatSay++; atKatSay++;
		bglAdres = katlama(lineer[i].numara, "ayrikTasma");
		atKatSay++;
		
	basla:
		atKatSay++;
		if (bayrakAtKat[bglAdres] == 0)
		{
			atKatSay++;
			bayrakAtKat[bglAdres]++; atKatSay++;
			atKatKayit[bglAdres].adSoyad = lineer[i].adSoyad; atKatSay++;
			atKatKayit[bglAdres].numara = lineer[i].numara; atKatSay++;
			atKatKayit[bglAdres].bagilAdr = bglAdres; atKatSay++;

		}
		else
		{
			atKatSay++;
			while (bayrakAtKat[ayriTasma] == 1) {
				atKatSay++;
				ayriTasma++;
				atKatSay++;
			}
			atKatSay++;
			bglAdres = ayriTasma;
			
			goto basla;

		}



	}
	//Dosyaya yazdýrma gerçekleþiyor...

	ofstream atKatlama;
	atKatlama.open("ayrikTasmaKatlama.txt");
	atKatSay++;
	atKatlama << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip kütüphanesinden gelir boþluk býrakýp yazý yazmayý saðlar.
	atKatSay++;
	for (int i = 0; i < 900; i++)
	{
		atKatSay++; atKatSay++;
		if (i == 501) {
			atKatlama << setw(35) << "AYRIK TASMA ALANI" << endl;
			atKatSay++; atKatSay++;
		}
		if (bayrakAtKat[i] == 1) {
			atKatSay++;
			atKatlama << setw(7) << atKatKayit[i].bagilAdr << setw(20) << atKatKayit[i].numara << setw(20) << atKatKayit[i].adSoyad << endl;
			atKatSay++;

		}
		else {
			atKatSay++;
			atKatKayit[i].bagilAdr = i; atKatSay++;
			atKatKayit[i].adSoyad = ""; atKatSay++;
			atKatKayit[i].numara = NULL; atKatSay++;
			//boþ kayýtlarýda göstermek için kullanýyoruz. Yazdýrýrken Numarayý yazdýrmýyoruz çünkü null deðer 0 olarak okunuyor.
			atKatlama << setw(7) << atKatKayit[i].bagilAdr << setw(20) << " " << setw(20) << atKatKayit[i].adSoyad << endl;
			atKatSay++;

		}
	}


}



int ayrikTasmaKatlamaAra(struct Kayit lineer[500])
{

	
	int tasma = 501;

	int ogrSay = 0;
	int aranan, bglAdr;


	for (int i = 0; i < 500; i++)
	{
		atKatSay++; atKatSay++;
		 aranan = lineer[i].numara;
		 atKatSay++;

		 bglAdr = katlama(aranan, "ayrikTasma");
		 atKatSay++;

		if (bayrakAtKat[bglAdr] == 0)
		{
			atKatSay++; atKatSay++;
			cout << "Ogrenci Bulunamadi" << endl;

		}

		else
		{
			atKatSay++;
		basla:
			atKatSay++;
			if (atKatKayit[bglAdr].numara == aranan)
			{
				atKatSay++; atKatSay++; atKatSay++;
				ogrSay++;

				cout <<ogrSay<<". "<< atKatKayit[bglAdr].numara <<" "<< atKatKayit[bglAdr].adSoyad << endl;

			}
			else
			{
				atKatSay++; atKatSay++; atKatSay++;
				bglAdr = tasma;
				tasma++;

				goto basla;

			}
		}

	}
	return  atKatSay++;
}

int bayrakAtKareOrt[900] = { 0 };// öncelikle içeriðin hepsini 0 yapýyoruz, kayýt edilince 1 e çeviriyoruz (bayrak mantýðý).
struct Kayit atKareOrtKayit[900];//yazdýrdýðýmýz verileri tutmak için kullanýyoruz.
							 //static int atBkAdimSay = 0;//Kayýt ve Aramanýn toplam adým sayilarýný bu þekilde tutacaðýz.
void AyrikTasmaKareOrt(struct Kayit lineer[500])
{
	int bglAdres;
	int ayriTasma = 501;

	for (int i = 0; i < 500; i++)
	{
		atKortSay++; atKortSay++; atKortSay++;
		bglAdres = kareOrtasi(lineer[i].numara, "ayrikTasma");

	basla:
		atKortSay++;
		if (bayrakAtKareOrt[bglAdres] == 0)
		{
			atKortSay++; atKortSay++; atKortSay++; atKortSay++; atKortSay++;
			bayrakAtKareOrt[bglAdres]++;
			atKareOrtKayit[bglAdres].adSoyad = lineer[i].adSoyad;
			atKareOrtKayit[bglAdres].numara = lineer[i].numara;
			atKareOrtKayit[bglAdres].bagilAdr = bglAdres;

		}
		else
		{
			atKortSay++;
			while (bayrakAtKareOrt[ayriTasma] == 1) {
				atKortSay++; atKortSay++;
				ayriTasma++;
			}
			bglAdres = ayriTasma;
			atKortSay++;
			goto basla;

		}



	}
	//Dosyaya yazdýrma gerçekleþiyor...

	ofstream atKareOrtasi;
	atKareOrtasi.open("ayrikTasmaKareOrtasi.txt");
	atKortSay++;
	atKareOrtasi << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip kütüphanesinden gelir boþluk býrakýp yazý yazmayý saðlar.
	atKortSay++;
	for (int i = 0; i < 900; i++)
	{
		atKortSay++; atKortSay++;
		if (i == 501) {
			atKortSay++; atKortSay++;
			atKareOrtasi << setw(35) << "AYRIK TASMA ALANI" << endl;
		}
		if (bayrakAtKareOrt[i] == 1) {
			atKortSay++; atKortSay++;
			atKareOrtasi << setw(7) << atKareOrtKayit[i].bagilAdr << setw(20) << atKareOrtKayit[i].numara << setw(20) << atKareOrtKayit[i].adSoyad << endl;

		}
		else {
			atKortSay++; atKortSay++; atKortSay++; atKortSay++; atKortSay++;
			atKareOrtKayit[i].bagilAdr = i;
			atKareOrtKayit[i].adSoyad = "";
			atKareOrtKayit[i].numara = NULL;
			//boþ kayýtlarýda göstermek için kullanýyoruz. Yazdýrýrken Numarayý yazdýrmýyoruz çünkü null deðer 0 olarak okunuyor.
			atKareOrtasi << setw(7) << atKareOrtKayit[i].bagilAdr << setw(20) << " " << setw(20) << atKareOrtKayit[i].adSoyad << endl;

		}
	}


}



int ayrikTasmaKareOrtAra(struct Kayit lineer[500])
{

	
	int tasma = 501;

	int ogrSay = 0;
	int aranan, bglAdr;


	for (int i = 0; i < 500; i++)
	{
		atKortSay++; atKortSay++; atKortSay++; atKortSay++;
		aranan = lineer[i].numara;

		bglAdr = kareOrtasi(aranan, "ayrikTasma");

		if (bayrakAtKareOrt[bglAdr] == 0)
		{
			atKortSay++; atKortSay++;
			cout << "Ogrenci Bulunamadi" << endl;

		}

		else
		{
			atKortSay++;
		basla:
			atKortSay++;
			if (atKareOrtKayit[bglAdr].numara == aranan)
			{
				atKortSay++; atKortSay++; atKortSay++;
				ogrSay++;

				cout << ogrSay << ". " << atKareOrtKayit[bglAdr].numara << " " << atKareOrtKayit[bglAdr].adSoyad << endl;

			}
			else
			{
				atKortSay++; atKortSay++; atKortSay++;
				bglAdr = tasma;
				tasma++;

				goto basla;

			}
		}

	}
	return atKortSay++; ;
}

int lineerAra(struct Kayit lineer[500])
{
	int aranan,ogrSay=0;

	for (int i = 0; i < 500; i++)
	{
		lineerSay++;
		aranan = lineer[i].numara;
		lineerSay++;
		for (int j = 499; j >= 0; j--)
		{
			lineerSay++; lineerSay++;
			if (aranan == lineer[j].numara)
			{
				lineerSay++; lineerSay++; lineerSay++;
				ogrSay++;
				cout << ogrSay << ". " << lineer[j].numara << " " << lineer[j].adSoyad << endl;
			}
	
		}
	}
	return lineerSay++;
}


int main()
{
	Kayit kisiler[500];//500 kiþilik bir struct dizisi oluþturuluyor. Ýçerisinde adSoyad Numara ve BaðýlAdres deðiþkenlerini tutar.
	
	srand(time(NULL));//rastgele sayý üretmek için main fonksiyonda zaman çekirdeðini kullanýyoruz.
	
	anaKayitDosyasi(kisiler);//Ana Kayýt Dosyasý burada oluþturuluyor.	Numara ve AdSoyad üretiliyor.

	LineerYoklamaBolenKalan(kisiler); //Lineer Yoklama ve Bolen Kalan Kayýt Dosyasý oluþturuluyor.
	
	cout<< setw(5) << lineerYoklamaBolenKalanAra(kisiler)<< " Adimda Lineer Yoklama BolenKalan Yontemiyle Bulunmustur.\nDevam etmek icin bi tusa basiniz..." << endl;//Lineer Yoklama ve Bolen Kalan Kayýt edilen dosyadan tüm kiþiler aranýyor ve ekrana numara isim yazdýrýlýyor.
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
	system("cls");

	cout << lineerAra(kisiler) << " Adimda Lineer Arama Yontemiyle Bulunmustur.\nDevam etmek icin bi tusa basiniz..." << endl;

	system("pause");
	system("cls");
//SIRALAMA...
	//eþit olursa...

	//atBkSay = 14753;
	//atKortSay =14753;

	int dizi[MAX] = { lyBkSay,lyKortSay,lyKatSay,atBkSay,atKortSay,atKatSay ,lineerSay};
	
	buble(dizi);//Sýralamak için dizi bubble sort'a gönderiliyor. 
	cout << setw(19) << "ARAMA TIPI" << setw(18) << "ADIM SAYISI" << endl;
	cout <<"---------------------------------------" << endl;
	for (int i = 0; i<MAX; i++)
	{
		
		if (dizi[i] == atBkSay&&dizi[i] == atKortSay)
		{
			if (i == 0) {
				cout << setw(27) << "Ayrik Tasma BolenKalan: " << dizi[i] << "\t" << "<-- EN IYI PERFORMANS" << endl;
				cout << setw(27) << "Ayrik Tasma KareOrtasi: " << dizi[i] << "\t" << "<-- EN IYI PERFORMANS" << endl; i++; continue;
			}
			else
			{
				cout << setw(27) << "Ayrik Tasma BolenKalan: " << dizi[i] <<  endl;
				cout << setw(27) << "Ayrik Tasma KareOrtasi: " << dizi[i] << endl; i++; continue;
			}
		}
	else if (dizi[i] == lyBkSay)
			cout << setw(27) << "Lineer Yoklama BolenKalan: ";
		else if (dizi[i] == lyKortSay)
			cout << setw(27) << "Lineer Yoklama KareOrtasi: ";
		else if (dizi[i] == lyKatSay)
			cout << setw(27) << "Lineer Yoklama Katlama: ";
		else if (dizi[i] == atBkSay)
			cout << setw(27) << "Ayrik Tasma BolenKalan: ";
		else if (dizi[i] == atKortSay)
			cout << setw(27) << "Ayrik Tasma KareOrtasi: ";
		else if (dizi[i] == atKatSay)
			cout << setw(27) << "Ayrik Tasma Katlama: ";
		else if (dizi[i] == lineerSay)
			cout << setw(27) << "Lineer(hash yok) Arama: ";
		
		cout << dizi[i] << " ";
		if (i == 0)cout <<"\t" <<"<-- EN IYI PERFORMANS";
		if (i == 6)cout << "\t" << "<-- EN KOTU PERFORMANS";
		if (i<MAX - 1)
			cout <<endl;


	}//Sýralanan dizi yazdýrýlýyor.
	cout << endl;




	system("pause");
	return 0;
}
void buble(int *ptr)
{
	void sirala(int*, int*);//Birer birer küçük büyük karþýlaþtýrmasý yaýlacak, fonksiyonun prototipi burada tanýmlanýyor.
	for (int i = 0; i<MAX - 1; i++)
		for (int j = i + 1; j<MAX; j++)
			sirala(ptr + i, ptr + j);
}
void sirala(int*d1, int*d2)
{
	int gecici;
	if (*d2<*d1)
	{
		gecici = *d1;
		*d1 = *d2;
		*d2 = gecici;
	}
}
