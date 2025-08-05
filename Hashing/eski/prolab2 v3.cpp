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
	int bagilAdr;

};

static int sayac = 0;

int numara[9] = { 1,1,0,2,0,2,0,0,0 };//Kocaeli Üniversitesi Numara Sistemi.

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

int bolenKalan(int numara)
{

	int bglAdres;
	bglAdres = numara % 631;
	return bglAdres;
	//619 olmasýnýn sebebi; Bütün hash fonksiyonlarý, dosya doluluða yaklaþtýkça kötü iþlemeye baþlarlar. 
	//Genel bir tavsiye olarak yükleme faktörü %70 veya %80 alýnýr. yükl.faktörü=500/625 =%80 ykleme faktörünü verir.
	//maksimum 619 olabiliyorsa 625 e en yakýn asal sayý olarak 631 seçiliyor.

}

int bayrak[631] = {0};// öncelikle içeriðin hepsini 0 yapýyoruz, kayýt edilince 1 e çeviriyoruz (bayrak mantýðý).

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
	cout<< setw(7) << "Numara" << setw(15) << "Ad Soyad" << endl;
	for (int i = 0; i < 500; i++)
	{
		cout <<setw(5)<< anaKayit[i].numara <<setw(15)<< anaKayit[i].adSoyad << endl;
	}
	ofstream kayit;
	kayit.open("Kayit.txt");
	kayit << setw(5) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip kütüphanesinden gelir boþluk býrakýp yazý yazmayý saðlar.
	for (int i = 0; i < 500; i++)
	{

		kayit <<setw(5)<< anaKayit[i].numara <<setw(20) << anaKayit[i].adSoyad << endl;
	}
	kayit.close();
}

void lineerYoklamaBolenKalan(struct Kayit lineer[500])
{
	
	struct Kayit gonder[631];
	int bglAdres;
	int evAdres;
	//kontrol.txt dosyasý sayesinde yapýlan sýralamanýn doðru olduðunu ispat etmiþ oluyoruz. ve lineer yoklamada kaydýmýzý baþarýyla tamamlýyoruz.(Proje tesliminde kaldýrýlacaktýr).
	ofstream kontrol;
	kontrol.open("kontrol.txt");

	kontrol << setw(5) << "Bagil Adres" << setw(14) << "Numara" << setw(20) << "Ad Soyad" << endl;//setw iomanip kütüphanesinden gelir boþluk býrakýp yazý yazmayý saðlar.
	for (int i = 0; i < 500; i++)
	{
		bglAdres = bolenKalan(lineer[i].numara);
		evAdres = bglAdres;
	basla:
		if (bayrak[bglAdres] == 0)
		{
			bayrak[bglAdres]++;
			gonder[bglAdres].adSoyad = lineer[i].adSoyad;
			gonder[bglAdres].numara = lineer[i].numara;
			gonder[bglAdres].bagilAdr = bglAdres;
	
			//kontrol
		
			
			kontrol << setw(7) << bglAdres << setw(20) << lineer[i].numara << setw(20) << lineer[i].adSoyad << endl;
			
		
			

		}
		else if (bayrak[bglAdres] == 1)
		{
			bglAdres = bglAdres + 1;

			if (bglAdres > 631)
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
		if(bayrak[i]==1)
		lyBolenKalan << setw(7) <<gonder[i].bagilAdr << setw(20) << gonder[i].numara << setw(20) << gonder[i].adSoyad << endl;
		else
			lyBolenKalan << setw(7) << i << setw(20) << "" << setw(20) << "" << endl;

	}

}

int main()
{
	Kayit kisiler[500];//500 kiþilik bir struct dizisi oluþturuluyor. Ýçerisinde adSoyad Numara ve BaðýlAdres deðiþkenlerini tutar.
	
	srand(time(NULL));//rastgele sayý üretmek için main fonksiyonda zaman çekirdeðini kullanýyoruz.
	
	anaKayitDosyasi(kisiler);//Ana Kayýt Dosyasý burada oluþturuluyor.	Numara ve AdSoyad üretiliyor.
	
	lineerYoklamaBolenKalan(kisiler);//Lineer Yoklama ve Bölen Kalan.

	system("pause");
	return 0;
}

