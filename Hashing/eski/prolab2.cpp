// prolab2.cpp : Defines the entry point for the console application.
//

//#include "stdafx.h" (visual studio' da kullanmak i�in.)
#include<time.h>
#include<stdlib.h>
#include<string.h>
#include <iostream>
#include <fstream>

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
	//alt + rand() % (ust - alt + 1).
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

int main()
{
	Kayit kisiler[500];
	srand(time(NULL));

	for (int i = 0; i < 500; i++)
	{
		kisiler[i].adSoyad = RasgeleIsimUret();
		kisiler[i].numara = NumaraUret();
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

	system("pause");
	return 0;
}


