
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <graphics.h>
#include <iostream>

int nereden=0,nereye=1,uzaklik=2,yolindex=3,X_kordinat=0,Y_kordinat=1,pixel_x,pixel_y;
void matrisgorsel(int dugumsayisi,int Matris[][4],int YedekMatris[][4])
{
    int j,i,k=0,y=60;

    for(i=0;i<=dugumsayisi;i++)
    {
line(600,i*30+40,600+dugumsayisi*30,i*30+40);
line(600+i*30,40,600+i*30,40+dugumsayisi*30);
    }
for(i=0;i<dugumsayisi;i++)  //MATRiSiN D�KEY DUGUM ADI
    {
char s1[20];
sprintf(s1,"D%d",i);
  outtextxy(570,30*i+50,s1);
  

  outtextxy(605+i*30,20,s1);
    }



int sayac=0;
    for(k=0;k<dugumsayisi;k++)
    {
char s1[20];
sprintf(s1,"%d",YedekMatris[sayac][uzaklik]);
sayac++;
    printf("sayac:%d-uzakl�k:%d\n",sayac,YedekMatris[sayac][uzaklik]);
    outtextxy(600+15,30*k+50,s1);
    for(i=1;i<dugumsayisi;i++)
    {
char s2[20];
sprintf(s2,"%d",YedekMatris[sayac][uzaklik]);
sayac++;
printf("sayac:%d-uzakl�k:%d\n",sayac,YedekMatris[sayac][uzaklik]);
        outtextxy(600+i*30+10,30*k+50,s2);
    }
    }




}


void grafikdugum(int sayac, int kruskalsehir[], int cizimyap[][2], int Matris[][4],int dugumsayisi,int YedekMatris[][4])
{
    int driver,mode,errcode=0;
    driver=DETECT;

   // initgraph(&driver,&mode,"C:\\TC\\BGI");

int ekran=initwindow(1240,680);
    //Garafik Ekran Y�kleme Hatalary
    errcode=graphresult();
    if(errcode!=0)
    {
        printf("graph error:%d",errcode);
        exit(1); //hata ile cik
    }
int j,i=1;
char s1[20];

//int baslangicsehri,bitissehri,yolindeksi;  buraya matrisig�nder ordan  i�lem yapcan
outtextxy(600,0,"DUGUMLER ARASI UZAKLIK BILGISI ASAGIDAKI TABLODA YER ALMAKTADIR");
matrisgorsel(dugumsayisi,Matris,YedekMatris);
for(j=0;j<=20;j++)
{
sprintf(s1,"%d",j);
outtextxy(25*j+20,0,s1);
outtextxy(0,20*j+20,s1);
}


rectangle(20,18,550,18);
rectangle(18,18,18,420);
setcolor(YELLOW);
line(565,0,565,800);
setcolor(WHITE);


for(i=0;i<dugumsayisi;i++)//HARFLER� YAZDIR
{
char s1[20]="D",s2[20];
sprintf(s2,"%d",i);
strcat(s1,s2);

outtextxy(cizimyap[i][0]*25+20,cizimyap[i][1]*20+20,s1);

}
int yol,sehirnereden,sehirnereye;
for(i=0;i<dugumsayisi*dugumsayisi;i++)//T�M YOLLAR
{
yol=i;
sehirnereden=Matris[yol][nereden];
sehirnereye=Matris[yol][nereye];
line(cizimyap[sehirnereden][X_kordinat]*25+20,cizimyap[sehirnereden][Y_kordinat]*20+20,cizimyap[sehirnereye][X_kordinat]*25+20,cizimyap[sehirnereye][Y_kordinat]*20+20);
Sleep(100);
}

setcolor(RED);
setlinestyle(0,10,3);
for(i=0;i<sayac;i++)//KRUSKAL SONU� ��ZG�S�
{
yol=kruskalsehir[i];
sehirnereden=Matris[yol][nereden];
sehirnereye=Matris[yol][nereye];
line(cizimyap[sehirnereden][X_kordinat]*25+20,cizimyap[sehirnereden][Y_kordinat]*20+20,cizimyap[sehirnereye][X_kordinat]*25+20,cizimyap[sehirnereye][Y_kordinat]*20+20);
Sleep(1000);
}

for(i=0;i<dugumsayisi;i++)//HARFLER� YAZDIR
{
char s1[20]="D",s2[20];
sprintf(s2,"%d",i);
strcat(s1,s2);
outtextxy(cizimyap[i][X_kordinat]*25+20,cizimyap[i][Y_kordinat]*20+20,s1);

}




getch();
closegraph(ekran);
//setcurrentwindow
int x;
scanf("%d",&x);

}



void matrisigoster(int dugumsayisi,int Matris[][4],int YedekMatris[][4])
{

    for(int i=0;i<dugumsayisi*dugumsayisi;i++)
{
    printf("D%d-D%d ARASi= %d KM\n",Matris[i][nereden],Matris[i][nereye],Matris[i][uzaklik]);

char s1[20];

sprintf(s1, "%d - %d ARASi= %d KM",Matris[i][nereden],Matris[i][nereye],Matris[i][uzaklik]);
//outtextxy(0,i*25+50,s1 );
//strcat(s1,s2);
//outtextxy(cizimyap[i][0]*20+20,cizimyap[i][1]*20+20,s1);
pixel_x=0;
pixel_y=i*25+50;
}
pixel_y+=25;
}
int sirala(int dugumsayisi, int matris[][4])
{
int g1,g2,g3,adet=dugumsayisi*dugumsayisi;

//BU DONGUDE YOL UZUNLUKLARINI SIRALAYACA�IZ AYNI ZAMANDA YOL �NDEXLER�DE YER DE���T�RECEK
for( int j=2;j<adet;j++)
{
for(int k=0;k<j;k++)
{
     if (matris[k][uzaklik]>matris[j][uzaklik])
      {
        //YOL UZUNLUKLARI YER DE���T�R�YOR
        g1=matris[k][nereden];
        g2=matris[k][nereye];
        g3=matris[k][uzaklik];
       matris[k][nereden]=matris[j][nereden];
       matris[k][nereye]=matris[j][nereye];
       matris[k][uzaklik]=matris[j][uzaklik];

         matris[j][nereden]=g1;
        matris[j][nereye]=g2;
        matris[j][uzaklik]=g3;
      }
    }
  }
}

void CihanCihatMehmetKuruskal(int dugumsayisi,int Matris[][4],int Dugum[][2],int YedekMatris[][4])//D�KKAT ALAN KODUNU ve B�lge kodunu dugumsayisi kadar DOLDUR
{
int yoltoplamuzunluk=0,alansirasi=0,alankodu[dugumsayisi],bolgekodu[dugumsayisi],kruskalsehir[dugumsayisi],sayac=0;/*B�LGE KODU HER D���M�N BA�LANGI� DE�ER�N� G�STER�R
E�ER D���M GEZ�L�RSE BA�LANGI� DE�ER�NE ALAN KODU ATANACAK bolgekodu nun her bir de�eri asl�nda bir k�y�n alan kodunu
g�stermektedir. bolgekodu[4] yani 4 tane dugumun gezilip gezilmedi�i durumununu belirtir 0 gezilmemi� anlam�ndad�r alankodu
ayn� zaman diliminde gezilip gezilmedi�ini belirtir.*/
 //alankodu[dugumsayisi]={100,200,300,400},bolgekodu[4]={0,0,0,0};/*�RNEKT�R
int i,f=0;
 for(i=1;i<=dugumsayisi;i++)
 {

     alankodu[i-1]=i*100;
     bolgekodu[i-1]=0;
}

int baslangic,bitis,index,s,kontrol=0;
for(s=0;s<dugumsayisi*dugumsayisi;s++)// T�M YOL SORGULARindex YAPILIYOR
{

    //index=yolindex[s];
    if(Matris[s][uzaklik]>0)//YOL UZUNLU�U 0 DE��LSE
    {
baslangic=Matris[s][nereden];//Hangi sehirden
bitis=Matris[s][nereye];

//hangi sehire gidiliyor?
//printf("\n\nkontrol=%d-%d",baslangic,bitis);
if(bolgekodu[baslangic]==0&&bolgekodu[bitis]==0) //gidilen �ehirlere ilk kez mi gidilmi� ilk kez se ba�lang��  0 de�ilse  alan kodu atayacaz
{
	
 
 printf("\n\nD%d-D%d ARASi=%d birim==> D%d ve D%d dugumleri ilk kez geziliyor",Matris[s][nereden],Matris[s][nereye],Matris[s][uzaklik],Matris[s][nereden],Matris[s][nereye]);
 char str[100];sprintf(str,"D%d-D%d ARASi=%d birim==> D%d ve D%d dugumleri ilk kez geziliyor",Matris[s][nereden],Matris[s][nereye],Matris[s][uzaklik],Matris[s][nereden],Matris[s][nereye]);
 outtextxy(600,300+f,str); f+=30;
 bolgekodu[baslangic]=alankodu[alansirasi];
bolgekodu[bitis]=alankodu[alansirasi];
alansirasi++;// bir sonraki sorgulamada e�er 2 �ehirde gezilmemi�se farkl� b�lge kodu atanacak
yoltoplamuzunluk=yoltoplamuzunluk+Matris[s][uzaklik];
kruskalsehir[sayac]=Matris[s][yolindex];
sayac=sayac+1;
}
else if(bolgekodu[baslangic]!=0&&bolgekodu[bitis]==0)//1. �ehir gezilmi� 2. �ehir gezilmemi�se
{
   
    printf("\n\nD%d-D%d ARASi=%d birim==>D%d dugumu gezilmis ;D%d ise ilk kez geziliyor",Matris[s][nereden],Matris[s][nereye],Matris[s][uzaklik],Matris[s][nereden],Matris[s][nereye]);
 char str[100];sprintf(str,"D%d-D%d ARASi=%d birim==>D%d dugumu gezilmis ;D%d ise ilk kez geziliyor",Matris[s][nereden],Matris[s][nereye],Matris[s][uzaklik],Matris[s][nereden],Matris[s][nereye]);
outtextxy(600,300+f,str); f+=30;
bolgekodu[bitis]=bolgekodu[baslangic];//AYNI YOL D�ZERGAHINA BA�LANMI� OLDULAR;
yoltoplamuzunluk=yoltoplamuzunluk+Matris[s][uzaklik];

kruskalsehir[sayac]=Matris[s][yolindex];
sayac=sayac+1;


}
else if(bolgekodu[baslangic]==0&&bolgekodu[bitis]!=0)//1. �ehir gezilmemi� 2. �ehir gezilmi�se
{
     printf("\n\nD%d-D%d ARASi=%d birim==>D%d dugumu gezilmis ;D%d ise ilk kez geziliyor",Matris[s][nereden],Matris[s][nereye],Matris[s][uzaklik],Matris[s][nereye],Matris[s][nereden]);
char str[100];sprintf(str,"D%d-D%d ARASi=%d birim==>D%d dugumu gezilmis ;D%d ise ilk kez geziliyor",Matris[s][nereden],Matris[s][nereye],Matris[s][uzaklik],Matris[s][nereden],Matris[s][nereye]);
outtextxy(600,300+f,str); f+=30;

bolgekodu[baslangic]=bolgekodu[bitis];//AYNI YOL D�ZERGAHINA BA�LANMI� OLDULAR;
yoltoplamuzunluk=yoltoplamuzunluk+Matris[s][uzaklik];
kruskalsehir[sayac]=Matris[s][yolindex];
sayac=sayac+1;


}
else if(bolgekodu[baslangic]!=0&&bolgekodu[bitis]!=0&&bolgekodu[baslangic]!=bolgekodu[bitis])//HER 2 �EH�RDE GEZ�LM��SE ancak bolge kodlar� farkl�ysa
{
//printf("\n\nbaslangic:%d,bitis:%d\n",baslangic,bitis);
//printf("\n\nbolbaslangic:%d,bolbitis:%d\n",bolgekodu[baslangic],bolgekodu[bitis]);
printf("%\n\nD%d-D%d ARASi=%d birim==>D%d dugumu gezilmis ;D%d dugumude gezilmis ancak her iki dugum farkli zamanlarda gezilmis",Matris[s][nereden],Matris[s][nereye],Matris[s][uzaklik],Matris[s][nereden],Matris[s][nereye]);
char str[100];sprintf(str,"D%d-D%d ARASi=%d birim==>D%d dugumu gezilmis ;D%d dugumude gezilmis ancak her iki dugum farkli zamanlarda gezilmis",Matris[s][nereden],Matris[s][nereye],Matris[s][uzaklik],Matris[s][nereden],Matris[s][nereye]);
outtextxy(600,300+f,str); f+=30;

//AYNI YOL D�ZERGAHINA BA�LANMI� OLDULAR ;
yoltoplamuzunluk=yoltoplamuzunluk+Matris[s][uzaklik];
int x,ilk,son;
ilk=bolgekodu[baslangic];
son=bolgekodu[bitis];
kruskalsehir[sayac]=Matris[s][yolindex];
sayac=sayac+1;

for(x=0;x<dugumsayisi;x++)
{
if(bolgekodu[x]==son)
{

    bolgekodu[x]=ilk;
    x=0;

}
}
}
}
}

printf("\n\nCOZUMLEME iSLEMi TAMAMLANDi;\n***********************************************\n YUKARiDA BELiRTiLEN EN KiSA YOLUN TOPLAM UZUNLUGU=%d BiRiMDiR\n\n",yoltoplamuzunluk);
char str[100];sprintf(str,"COZUMLEME iSLEMi TAMAMLANDi ----> YUKARiDA BELiRTiLEN EN KiSA YOLUN TOPLAM UZUNLUGU=%d BiRiMDiR",yoltoplamuzunluk);
outtextxy(600,300+f,str); f+=30;
grafikdugum(sayac,kruskalsehir,Dugum,Matris,dugumsayisi,YedekMatris);

}



int main()
{

    int hata=1,i,j,x,y;//matris[satir][nereden,nereye,uzakl�k,yolindex]
    int dugumsayisi;int bayrak=0;
dugumal:
    char karaktermi[8],krsay=0;
    printf("\nDugum sayisini giriniz:\n");

     fgets(karaktermi,8,stdin);


 for(i=0;i<strlen(karaktermi);i++)
{
    if ( isalpha(karaktermi[i])|| ispunct(karaktermi[i]) )
{
    printf("\nHATALI GIRIS YAPTINIZ(HARF VEYA OZEL KARAKTER) \nLUTFEN [0-400] SAYI GIRINIZ \n");
goto dugumal;
}


}

sscanf(karaktermi,"%d",&dugumsayisi);
//dugumsayisi=atoi(karaktermi);


    if(dugumsayisi>400)
    {
        system("cls");
        printf("DUGUM SAYISI 400 DEN FAZLA OLAMAZ LUTFEN TEKRAR GIRIS YAPINIZ\n(YANLIS GIRIS SAYISI %d)\n\n",hata);
        hata++;
        goto dugumal;
    }
    else if(dugumsayisi>254&&dugumsayisi<=400)
    {
     printf("\nRAM'DE YETERLI ALAN YOK\nLUTFEN FARKLI BIR DEGER GIRINIZ.[ ORNEK= 0-254]\n\n");
     goto dugumal;
    }

    printf("\nlutfen asagida belirtilen dugumlerin [x][y] kordinat bilgilerini giriniz\n**************************************************************************\n");
//DU�UM MATR�S�� DUGUME A�T X VE Y DE�ERLER�N� TUTAR.
int w,Dugum[dugumsayisi][2],Matris[dugumsayisi*dugumsayisi-1][4],YedekMatris[dugumsayisi*dugumsayisi-1][4];
for(i=0;i<dugumsayisi;i++)
{
yeniden_x:
    printf("D%d dugumune ait [x] kordinatini giriniz:  ",i);
     fgets(karaktermi,8,stdin);
  for(w=0;w<strlen(karaktermi);w++)
{
    if ( isalpha(karaktermi[w])|| ispunct(karaktermi[w]) )
{
    printf("\nHATALI GIRIS YAPTINIZ(HARF VEYA OZEL KARAKTER) \nLUTFEN [0-20] SAYI GIRINIZ \n");
goto yeniden_x;
}
}
    sscanf(karaktermi,"%d",&x);

    if(x>20||x<0)
    {
    printf("\nHATALI GIRIS YAPTINIZ LUTFEN 0-20 ARASI BIR DEGER GIRINIZ\n");
    goto yeniden_x;
    }
    Dugum[i][0]=x;
yeniden_y:
	printf("D%d dugumune ait [y] kordinatini giriniz:  ",i);
	 fgets(karaktermi,8,stdin);
  for(w=0;w<strlen(karaktermi);w++)
{
    if ( isalpha(karaktermi[w])|| ispunct(karaktermi[w]) )
{
    printf("\nHATALI GIRIS YAPTINIZ(HARF VEYA OZEL KARAKTER) \nLUTFEN [0-20] SAYI GIRINIZ \n");
goto yeniden_y;
}
}
     sscanf(karaktermi,"%d",&y);
    if(y>20||y<0)
    {
    printf("\nHATALI GIRIS YAPTINIZ LUTFEN 0-20 ARASI BIR DEGER GIRINIZ\n");
    goto yeniden_y;
    }
    Dugum[i][1]=y;
    for(j=0;j<i;j++)
    {
if(Dugum[i][0]==Dugum[j][0]&&Dugum[i][1]==Dugum[j][1])
{
    printf("\n\n%d,%d KORDINATI SISTEMDE KAYITLIDIR\n LUTFEN BASKA BIR DUGUM GIRINIZ\n\n",x,y);
goto yeniden_x;
}
    }

}
 int ekran=initwindow(1240,680);
   outtextxy(100,0,"GRAFLARDA EN KiSA YOL (KRUSKAL ALGORiTMASI)");
int a=0,b=0;
for(int i=0;i<dugumsayisi*dugumsayisi;i++)
{
Matris[i][nereden]=a;
  Matris[i][nereye]=b;
  Matris[i][uzaklik]=fabs(Dugum[a][0]-Dugum[b][0])+fabs(Dugum[a][1]-Dugum[b][1]);
  Matris[i][yolindex]=i;

  YedekMatris[i][nereden]=a;
  YedekMatris[i][nereye]=b;
  YedekMatris[i][uzaklik]=fabs(Dugum[a][0]-Dugum[b][0])+fabs(Dugum[a][1]-Dugum[b][1]);
  YedekMatris[i][yolindex]=i;

  b++;
  if(b==dugumsayisi)
  {
      b=0;
      a++;
  }
}
matrisigoster(dugumsayisi,Matris,YedekMatris);
printf("\n\nEN KISADAN EN UZUNA DOGRU YOL BiLGiSi ASAGiDA SiRALANMiSTiR\n***************************************************************\n");

sirala(dugumsayisi,Matris);
matrisigoster(dugumsayisi,Matris,YedekMatris);
printf("\n\nEN KISA YOL SORGUSU YAPILIYOR(BASLANGiC-->BiTiS=YOL UZUNLUGU)\n*****************************************\n");
//outtextxy(0,300,"EN KISA YOL SORGUSU YAPILIYOR(BASLANGiC-->BiTiS=YOL UZUNLUGU)");

//grafikgosterim(dugumsayisi,Dugum);
CihanCihatMehmetKuruskal(dugumsayisi,Matris,Dugum,YedekMatris);//D�KKAT BU KOD sirala(dugumsayisi,yoluzunluklari,yolindeks); ten sonra �al��t�r�lmal� ��nk� indeksler s�raland�ktan sonra yol sorgulamas� yap�lacak

}


