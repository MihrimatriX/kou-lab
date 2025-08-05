// prolab2.cpp : Defines the entry point for the console application.
//

//#include "stdafx.h"
#include<time.h>
#include<stdlib.h>
#include<string.h>
#include <iostream>
#include <fstream>
#include <iomanip>

using namespace std;
struct Kayit
{
	char* adSoyad;
	int numara;

};

static int sayac = 0;
int numara[9] = { 1,1,0,2,0,2,0,0,0 };
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
	int sonuc = 0;
	for (int i = 0; i < 9; i++)
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
//bölen kalan
//lineer yoklama
int bolenKalan(int numara)
{

	int bglAdres;
	bglAdres = numara % 631;
	return bglAdres;
	//631 olmasýnýn sebebi; Bütün hash fonksiyonlarý, dosya doluluða yaklaþtýkça kötü iþlemeye baþlarlar. 
	//Genel bir tavsiye olarak yükleme faktörü %70 veya %80 alýnýr. yükl.faktörü=500/625 =%80 ykleme faktörünü verir.
	//maksimum 631 olabiliyorsa 625 e en yakýn asal sayý olarak 631 seçiliyor.

}
int bayrak[631] = {0};// öncelikle içeriðin hepsini 0 yapýyoruz, kayýt edilince 1 e çeviriyoruz (bayrak mantýðý).
int lineerYoklamaBolenKalanKyt(int numara)
{


	int bglAdres;
	int evAdres;
	bglAdres = bolenKalan(numara);
	evAdres = bglAdres;
	basla:
	if (bayrak[bglAdres] == 0)
	{
		bayrak[bglAdres]++;
		return bglAdres;

	}
	else if(bayrak[bglAdres]==1)
	{
		bglAdres = bglAdres + 1;
		
		if (bglAdres> 631)
			bglAdres = 1;
		if (bglAdres == evAdres) {
			cout << "Dosya Doldu!" << endl;
			return -1;
		}
		goto basla;
	}


}/*
void lineerYoklamaBolenKalanAra(int numara)
{
	int bglAdres;
	int evAdres;
	bglAdres = bolenKalan(numara);
	evAdres = bglAdres;
	if(bayrak[bglAdres]==1)
	{ 
	if(numara==)
	}


}*/

int main()
{
	Kayit kisiler[500];
	srand(time(NULL));

	for (int i = 0; i < 500; i++)
	{
		kisiler[i].adSoyad = RasgeleIsimUret();
		kisiler[i].numara = NumaraUret();

		//kisiler[i].numara = rand() % 19 + 1;
	}
	for (int i = 0; i < 500; i++)
	{
		cout << kisiler[i].numara << " " << kisiler[i].adSoyad << endl;
	}
	ofstream kayit;
	kayit.open("Kayit.txt");
	for (int i = 0; i < 500; i++)
	{
		kayit << kisiler[i].numara << " " << kisiler[i].adSoyad << endl;
	}
	kayit.close();
	ofstream lyBolenKalan;
	lyBolenKalan.open("lineerYoklamaBolenKalan.txt");
	lyBolenKalan<<setw(5)<< "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad"<< endl;//setw iomanip kütüphanesinden gelir boþluk býrakýp yazý yazmayý saðlar.
	for (int i = 0; i < 500; i++)
	{
		
		lyBolenKalan <<setw(7)<< lineerYoklamaBolenKalanKyt(kisiler[i].numara)<<setw(20)<<kisiler[i].numara<<setw(20)<<kisiler[i].adSoyad<<endl;
	}
	system("pause");
	return 0;
}


