#include "graphics.h"
#include <iostream>
#include <math.h>
#include <time.h>
#include <stdlib.h>                
#include <ctype.h>   
#include <cstring>
#include <stdio.h>
#include <string.h>

void ilkekran();

bool kontrol = true;
bool kontrolcikis = true;

void ekran1();
void ekran2();

void matrisHesap();
void iterasyon();
void matris(float x1, float x2, float x3, float x4);

void girisekrani();

const char *resim = "C:\\AFU\\Works\\Prolab 1\\Prolab1_1.Proje\\Yollar.JPG";
const char *yol1 = "C:\\AFU\\Works\\Prolab 1\\Prolab1_1.Proje\\Yol1.JPG";
const char *yol2 = "C:\\AFU\\Works\\Prolab 1\\Prolab1_1.Proje\\Yol2.JPG";
const char *basayolu = "C:\\AFU\\Works\\Prolab 1\\Prolab1_1.Proje\\SecT.JPG";

char *kayanbildiri = "Lütfen Haritalardan Birini Seçiniz. ( Ýki Giriþ Ýki Çýkýþ Girmeniz Rica Olunur. )";
char *birincimap = "Lüften Ýki Giriþ Ve Çýkýþ Yollarini Seciniz..";
char *ikincimap = "Lütfen Ýki Giriþ Ve Çýkýþ Yolu Seçiniz..";

using namespace std; 

int main()
{
	int haritasecim;

	char girisharitabir_bir, girisharitabir_iki, cikisharitabir_bir, cikisharitabir_iki;
	
	char girisharitaiki_bir, girisharitaiki_iki, cikisharitaiki_bir, cikisharitaiki_iki;

	int X, T, Z, Y;

	int a, b, c, d;
	

	//------------------------------------------------
	initwindow(1200, 700, "----- PROLAB -----");
	cout << " \n\t- Merhaba Hosgeldiniz - \n\n";
	cout << "Lutfen Harita Seciminizi Yapiniz :\nSeciminiz : ";
	girisekrani();
	delay(1500);
	cleardevice();
	ilkekran();
	//------------------------------------------------
	/*
	*Buraya Kadarki Bölümde Ýlk Açýlýþ Ýþlemleri Yapýldý...
	*/
	//------------------------------------------------

	cin >> haritasecim;

	if (haritasecim == 1)
	{
		cleardevice();
		settextstyle(1, HORIZ_DIR, 1);
		ekran1();
		cout << "Giris Yollarini Seciniz : \n";
		outtextxy(680, 20, "<-----::OUTPOT::----->");
		//----------------------------------------------------------GÝRÝÞLER BURDAN
		cout << "Birinci Giris : ";
		cin >> girisharitabir_bir;
		cout << endl;

		outtextxy(600, 50, " - Birinci Giriþ Girildi.");

		cout << "Ikinci Giris : ";
		cin >> girisharitabir_iki;
		cout << endl;
		outtextxy(600, 75, " - Ýkinci Giriþ Girildi.");

		while (kontrol == true)
		{
			if (girisharitabir_bir == 'T' && girisharitabir_iki != 'T' ||
				girisharitabir_bir == 'T' && girisharitabir_iki == 'X' ||
				girisharitabir_bir == 'T' && girisharitabir_iki == 'Y' ||
				girisharitabir_bir == 'T' && girisharitabir_iki == 'Z' ||

				girisharitabir_bir == 'X' && girisharitabir_iki == 'T' ||
				girisharitabir_bir == 'X' && girisharitabir_iki != 'X' ||
				girisharitabir_bir == 'X' && girisharitabir_iki == 'Y' ||
				girisharitabir_bir == 'X' && girisharitabir_iki == 'Z' ||

				girisharitabir_bir == 'Y' && girisharitabir_iki == 'T' ||
				girisharitabir_bir == 'Y' && girisharitabir_iki == 'X' ||
				girisharitabir_bir == 'Y' && girisharitabir_iki != 'Y' ||
				girisharitabir_bir == 'Y' && girisharitabir_iki == 'Z' ||

				girisharitabir_bir == 'Z' && girisharitabir_iki == 'T' ||
				girisharitabir_bir == 'Z' && girisharitabir_iki == 'X' ||
				girisharitabir_bir == 'Z' && girisharitabir_iki == 'Y' ||
				girisharitabir_bir == 'Z' && girisharitabir_iki != 'Z' 	)
			{
				if (girisharitabir_bir == 'T')
				{
					//BURADA GÝRÝÞ 1 T SEÇÝLDÝ.
					cout << "GIRIS 1 " << girisharitabir_bir << " SECILDI" << endl;
				

				}
				if (girisharitabir_bir == 'X')
				{
					//BURADA GÝRÝÞ 1 X SEÇÝLDÝ.
					cout << "GIRIS 1 " << girisharitabir_bir << " SECILDI" << endl;

				}
				if (girisharitabir_bir == 'Y')
				{
					//BURADA GÝRÝÞ 1 Y SEÇÝLDÝ.
					cout << "GIRIS 1 " << girisharitabir_bir << " SECILDI" << endl;

				}
				if (girisharitabir_bir == 'Z')
				{
					//BURADA GÝRÝÞ 1 Z SEÇÝLDÝ.
					cout << "GIRIS 1 " << girisharitabir_bir << " SECILDI" << endl;

				}
				if (girisharitabir_iki == 'T')
				{
					//BURADA GÝRÝÞ 2 T SEÇÝLDÝ.
					cout << "GIRIS 2 " << girisharitabir_iki << " SECILDI" << endl;

				}
				if (girisharitabir_iki == 'X')
				{
					//BURADA GÝRÝÞ 2 X SEÇÝLDÝ.
					cout << "GIRIS 2 " << girisharitabir_iki << " SECILDI" << endl;

				}
				if (girisharitabir_iki == 'Y')
				{
					//BURADA GÝRÝÞ 2 Y SEÇÝLDÝ.
					cout << "GIRIS 2 " << girisharitabir_iki << " SECILDI" << endl;

				}
				if (girisharitabir_iki == 'Z')
				{
					//BURADA GÝRÝÞ 2 Z SEÇÝLDÝ.
					cout << "GIRIS 2 " << girisharitabir_iki << " SECILDI" << endl;

				}
				
				kontrol = false;
				break;
			}
			else
			{
				cout << " Gecerli Bir Girdi Giriniz..." << endl;
				cout << "Birinci Giris....:";
				cin >> girisharitabir_bir;
				cout << endl;
				cout << "Ikinci Giris....:";
				cin >> girisharitabir_iki;
			}
		}
		//--------------------------------------------------------------------------
		//-----------------------------------------------------------ÇIKIÞLAR BURDAN 
		cout << "Birinci Cikis : ";
		cin >> cikisharitabir_bir;
		cout << endl;

		outtextxy(600, 100, " - Birinci Çýkýþ Girildi.");
				
		cout << "Ikinci Cikis : ";
		cin >> cikisharitabir_iki;
		cout << endl;

		outtextxy(600, 125, " - Ikinci Çýkýþ Girildi.");
				
		while (kontrolcikis == true)
		{
			if (cikisharitabir_bir == 'T' && cikisharitabir_iki != 'T' ||
				cikisharitabir_bir == 'T' && cikisharitabir_iki == 'X' ||
				cikisharitabir_bir == 'T' && cikisharitabir_iki == 'Y' ||
				cikisharitabir_bir == 'T' && cikisharitabir_iki == 'Z' ||

				cikisharitabir_bir == 'X' && cikisharitabir_iki == 'T' ||
				cikisharitabir_bir == 'X' && cikisharitabir_iki != 'X' ||
				cikisharitabir_bir == 'X' && cikisharitabir_iki == 'Y' ||
				cikisharitabir_bir == 'X' && cikisharitabir_iki == 'Z' ||

				cikisharitabir_bir == 'Y' && cikisharitabir_iki == 'T' ||
				cikisharitabir_bir == 'Y' && cikisharitabir_iki == 'X' ||
				cikisharitabir_bir == 'Y' && cikisharitabir_iki != 'Y' ||
				cikisharitabir_bir == 'Y' && cikisharitabir_iki == 'Z' ||

				cikisharitabir_bir == 'Z' && cikisharitabir_iki == 'T' ||
				cikisharitabir_bir == 'Z' && cikisharitabir_iki == 'X' ||
				cikisharitabir_bir == 'Z' && cikisharitabir_iki == 'Y' ||
				cikisharitabir_bir == 'Z' && cikisharitabir_iki != 'Z')
			{
				if (cikisharitabir_bir == 'T')
				{
					//BURADA ÇIKIÞ 1 T SEÇÝLDÝ.
					cout << "CIKIS 1 " << cikisharitabir_bir << " SECILDI" << endl;

				}
				if (cikisharitabir_bir == 'X')
				{
					//BURADA ÇIKIÞ 1 X SEÇÝLDÝ.
					cout << "CIKIS 1 " << cikisharitabir_bir << " SECILDI" << endl;

				}
				if (cikisharitabir_bir == 'Y')
				{
					//BURADA ÇIKIÞ 1 Y SEÇÝLDÝ.
					cout << "CIKIS 1 " << cikisharitabir_bir << " SECILDI" << endl;

				}
				if (cikisharitabir_bir == 'Z')
				{
					//BURADA ÇIKIÞ 1 Z SEÇÝLDÝ.
					cout << "CIKIS 1 " << cikisharitabir_bir << " SECILDI" << endl;

				}
				if (cikisharitabir_iki == 'T')
				{
					//BURADA ÇIKIÞ 2 T SEÇÝLDÝ.
					cout << "CIKIS 2 " << cikisharitabir_iki << " SECILDI" << endl;

				}
				if (cikisharitabir_iki == 'X')
				{
					//BURADA ÇIKIÞ 2 X SEÇÝLDÝ.
					cout << "CIKIS 2 " << cikisharitabir_iki << " SECILDI" << endl;

				}
				if (cikisharitabir_iki == 'Y')
				{
					//BURADA ÇIKIÞ 2 Y SEÇÝLDÝ.
					cout << "CIKIS 2 " << cikisharitabir_iki << " SECILDI" << endl;

				}
				if (cikisharitabir_iki == 'Z')
				{
					//BURADA ÇIKIÞ 2 Z SEÇÝLDÝ.
					cout << "CIKIS 2 " << cikisharitabir_iki << " SECILDI" << endl;

				}
				kontrolcikis = false;
				break;
			}
			else
			{
				cout << " Gecerli Bir Girdi Giriniz..." << endl;
				cout << "Birinci Cikis....:" << endl;
				cin >> cikisharitabir_bir;
				cout << "Ikinci cikis....:" << endl;
				cin >> cikisharitabir_iki;
			}

			
		}
		//---------------------------------------------------------------------------

		cout << "Secilen Yon A Yonu" << endl;

		for (int i = 0; i < 360; i++)
		{
			arc(288, 288, 10, 100, 150);
			delay(50);
		}
		/*
		A yönünde bir ok oynat
		*/

		cout << "Girislerdeki Arac Miktarlarini Giriniz : " << endl;

		cout << "T : ";
		cin >> T;
		cout << endl;
		//outtextxy(,,);
	
		cout << "X : ";
		cin >> X;
		cout << endl;
		//outtextxy(,,);

		cout << "Y : ";
		cin >> Y;
		cout << endl;
		//outtextxy(,,);

		cout << "Z : ";
		cin >> Z;
		cout << endl;
		//outtextxy(,,);

		cout << "Yollarin Yogunluklarini Giriniz :" << endl;

		cout << "a : ";
		cin >> a;
		cout << endl;
	
		cout << "b : ";
		cin >> b;
		cout << endl;
	
		cout << "d : ";
		cin >> d;
		cout << endl;
	
		cout << "c : ";
		cin >> c;
		cout << endl;
			












	}	

	if (haritasecim == 2)
	{
		cleardevice();
		ekran2();
		cout << "Giris Yollarini Seciniz : \n";

		cout << "Birinci Giris :";
		cin >> girisharitaiki_bir;

		cout << "Ikinci Giris :";
		cin >> girisharitaiki_iki;
	}
	
	getch();
	return 0;
}

void ekran1()
{
	readimagefile(yol1, 0, 0, 581, 610);
	settextstyle(1, HORIZ_DIR, 1);
	line(590, 0, 590, 600);
	for (int frame = 1100; frame <= 1100; frame--)
	{
		outtextxy(frame, 630, birincimap);
		delay(5);
		if (frame == 30)
		{
			break;
		}
	}
}

void ekran2()
{
	readimagefile(yol2, 0, 0, 533, 610);
	settextstyle(1, HORIZ_DIR, 1);
	line(590, 0, 590, 600);
	for (int frame = 1100; frame <= 1100; frame--)
	{
		outtextxy(frame, 630, ikincimap);
		delay(5);
		if (frame == 30)
		{
			break;
		}
	}
}

void girisekrani()
{
	settextstyle(5, HORIZ_DIR, 6);
	for (int yukseklik = 230; yukseklik < 380; yukseklik++)
	{
		outtextxy(200, yukseklik, "HOSGELDINIZ / WELCOME");
		delay(10);
	}
}

void ilkekran()
{
	readimagefile(resim, 0, 0, 1200, 700);
	settextstyle(5, HORIZ_DIR, 5);
	outtextxy(750, 50, "HARITA 2");
	outtextxy(230, 50, "HARITA 1");
	line(590, 0, 590, 600);

	settextstyle(1, HORIZ_DIR, 1);
	for (int frame = 1100; frame <= 1100; frame--)
	{
		outtextxy(frame, 630, kayanbildiri);
		delay(5);
		if (frame == 30)
		{
			break;
		}
	}
}

void matrisHesap()
{
	int birinciSayac, ikinciSayac, ucuncuSayac, matrisBoyutu;
	int matris[20][20], geciciDegisken, sonuclarDizisi[10];

	//std::cout << "\nMatrisin boyutunu giriniz: ";
	//scanf("%d", &matrisBoyutu);

	for (birinciSayac = 1; birinciSayac <= matrisBoyutu; birinciSayac++)
	{
		for (ikinciSayac = 1; ikinciSayac <= (matrisBoyutu + 1); ikinciSayac++)
		{
			std::cout << " matris[%d][%d]:", birinciSayac, ikinciSayac;
			scanf("%f", &matris[birinciSayac][ikinciSayac]);
		}
	}
	/* Now finding the elements of diagonal matrix */
	for (ikinciSayac = 1; ikinciSayac <= matrisBoyutu; ikinciSayac++)
	{
		for (birinciSayac = 1; birinciSayac <= matrisBoyutu; birinciSayac++)
		{
			if (birinciSayac != ikinciSayac)
			{
				geciciDegisken = matris[birinciSayac][ikinciSayac] / matris[ikinciSayac][ikinciSayac];
				for (ucuncuSayac = 1; ucuncuSayac <= matrisBoyutu + 1; ucuncuSayac++)
				{
					matris[birinciSayac][ucuncuSayac] = matris[birinciSayac][ucuncuSayac] - geciciDegisken * matris[ikinciSayac][ucuncuSayac];
				}
			}
		}
	}
	std::cout << "\nCozum:\n";
	for (birinciSayac = 1; birinciSayac <= matrisBoyutu; birinciSayac++)
	{
		sonuclarDizisi[birinciSayac] = matris[birinciSayac][matrisBoyutu + 1] / matris[birinciSayac][birinciSayac];
		std::cout << "\n sonuclarDizisi%d=%f\n", birinciSayac, sonuclarDizisi[birinciSayac];
	}
}

void matris(float x1, float x2, float x3, float x4)// gauss jordan için eliminisyar
{

	float yeniX1 = 0;
	float yeniX2 = 0;
	float yeniX3 = 0;
	float yeniX4 = 0;
	float b1bolen = 1;
	float b2bolen = 1;

	yeniX1 = x1 / x1;
	yeniX2 = x2 / yeniX1;
	b1bolen = b1bolen / x1;

	yeniX3 = x3 - yeniX1 * x3;
	yeniX4 = x4 - yeniX2 * x3;// bilinmeyenleri çözmek için katsayýlarý veriyor
	b2bolen = b2bolen - b1bolen * x3;

	yeniX3 = yeniX3 / yeniX4;
	b2bolen = b2bolen / yeniX4;
	yeniX4 = yeniX4 / yeniX4;
	b1bolen = b1bolen - yeniX2 * b2bolen;
	yeniX2 = yeniX2 - yeniX2 * yeniX4;
}

void iterasyon()
{
	int kontrol[4][2];
	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 2; j++)
		{
			cin >> kontrol[i][j];
		}

	} // bütün deðerler  girildi.
	int sayac = 0;
	for (int i = 0; i <4; i++)
	{
		for (int j = 0; j <2; j++)
		{

			if (i == -1 && i == j)
			{
				sayac = 1;
			}

		}
	}

}
