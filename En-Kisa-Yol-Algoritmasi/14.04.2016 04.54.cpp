
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <graphics.h>
#include <iostream>

int nereden=0,nereye=1,uzaklik=2,yolindex=3,X_kordinat=0,Y_kordinat=1,pixel_x,pixel_y;
void matrisgorsel(int dugumsayisi,int Matris[][4])
{
    int j,i,k=0,y=60;

    for(i=0;i<=dugumsayisi;i++)
    {
line(600,i*30+40,600+dugumsayisi*30,i*30+40);
line(600+i*30,40,600+i*30,40+dugumsayisi*30);
    }
for(i=0;i<dugumsayisi;i++)
    {
char s1[20];
sprintf(s1,"D%d",i);
  outtextxy(570,30*i+50,s1);
    }



int sayac=0;
    for(k=0;k<dugumsayisi;k++)
    {
char s1[20];
sprintf(s1,"%d",Matris[sayac][uzaklik]);
sayac++;
    printf("sayac:%d-uzaklık:%d\n",sayac,Matris[sayac][uzaklik]);
    outtextxy(600+15,30*k+50,s1);
    for(i=1;i<dugumsayisi;i++)
    {
char s2[20];
sprintf(s2,"%d",Matris[sayac][uzaklik]);
sayac++;
printf("sayac:%d-uzaklık:%d\n",sayac,Matris[sayac][uzaklik]);
        outtextxy(600+i*30+10,30*k+50,s2);
    }
    }




}


void grafikdugum(int sayac, int kruskalsehir[], int cizimyap[][2], int Matris[][4],int dugumsayisi)
{
    int driver,mode,errcode=0;
    driver=DETECT;

   // initgraph(&driver,&mode,"C:\\TC\\BGI");

int ekran=initwindow(1240,680);
    //Garafik Ekran Yükleme Hatalarý
    errcode=graphresult();
    if(errcode!=0)
    {
        printf("graph error:%d",errcode);
        exit(1); //hata ile cik
    }
int i=1;
//int baslangicsehri,bitissehri,yolindeksi;  buraya matrisigönder ordan  işlem yapcan
outtextxy(600,0,"DUGUMLER ARASI UZAKLIK BILGISI ASAGIDAKI TABLODA YER ALMAKTADIR");
matrisgorsel(dugumsayisi,Matris);

outtextxy(20,0,"0");
outtextxy(40,0,"1");
outtextxy(60,0,"2");
outtextxy(80,0,"3");
outtextxy(100,0,"4");
outtextxy(120,0,"5");
outtextxy(140,0,"6");
outtextxy(160,0,"7");
outtextxy(180,0,"8");
outtextxy(200,0,"9");
outtextxy(220,0,"10");
outtextxy(240,0,"11");
outtextxy(260,0,"12");
outtextxy(280,0,"13");
outtextxy(300,0,"14");
outtextxy(320,0,"15");
outtextxy(340,0,"16");
outtextxy(360,0,"17");
outtextxy(380,0,"18");
outtextxy(400,0,"19");
outtextxy(420,0,"20");
//****************
outtextxy(0,20,"0");
outtextxy(0,40,"1");
outtextxy(0,60,"2");
outtextxy(0,80,"3");
outtextxy(0,100,"4");
outtextxy(0,120,"5");
outtextxy(0,140,"6");
outtextxy(0,160,"7");
outtextxy(0,180,"8");
outtextxy(0,200,"9");
outtextxy(0,220,"10");
outtextxy(0,240,"11");
outtextxy(0,260,"12");
outtextxy(0,280,"13");
outtextxy(0,300,"14");
outtextxy(0,320,"15");
outtextxy(0,340,"16");
outtextxy(0,360,"17");
outtextxy(0,380,"18");
outtextxy(0,400,"19");
outtextxy(0,420,"20");

rectangle(20,18,420,18);
rectangle(18,18,18,420);

for(i=0;i<dugumsayisi;i++)//HARFLERİ YAZDIR
{
char s1[20]="D",s2[20];
sprintf(s2,"%d",i);
strcat(s1,s2);

outtextxy(cizimyap[i][0]*20+20,cizimyap[i][1]*20+20,s1);

}
int yol,sehirnereden,sehirnereye;
for(i=0;i<dugumsayisi*dugumsayisi;i++)//TÜM YOLLAR
{
yol=i;
sehirnereden=Matris[yol][nereden];
sehirnereye=Matris[yol][nereye];
line(cizimyap[sehirnereden][X_kordinat]*20+20,cizimyap[sehirnereden][Y_kordinat]*20+20,cizimyap[sehirnereye][X_kordinat]*20+20,cizimyap[sehirnereye][Y_kordinat]*20+20);
Sleep(100);
}

setcolor(RED);
setlinestyle(0,10,3);
for(i=0;i<sayac;i++)//KRUSKAL SONUÇ ÇİZGİSİ
{
yol=kruskalsehir[i];
sehirnereden=Matris[yol][nereden];
sehirnereye=Matris[yol][nereye];
line(cizimyap[sehirnereden][X_kordinat]*20+20,cizimyap[sehirnereden][Y_kordinat]*20+20,cizimyap[sehirnereye][X_kordinat]*20+20,cizimyap[sehirnereye][Y_kordinat]*20+20);
Sleep(1000);
}

for(i=0;i<dugumsayisi;i++)//HARFLERİ YAZDIR
{
char s1[20]="D",s2[20];
sprintf(s2,"%d",i);
strcat(s1,s2);
outtextxy(cizimyap[i][0]*20+20,cizimyap[i][1]*20+20,s1);

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

//BU DONGUDE YOL UZUNLUKLARINI SIRALAYACAĞIZ AYNI ZAMANDA YOL İNDEXLERİDE YER DEĞİŞTİRECEK
for( int j=2;j<adet;j++)
{
for(int k=0;k<j;k++)
{
     if (matris[k][uzaklik]>matris[j][uzaklik])
      {
        //YOL UZUNLUKLARI YER DEĞİŞTİRİYOR
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

void CihanCihatMehmetKuruskal(int dugumsayisi,int Matris[][4],int Dugum[][2])//DİKKAT ALAN KODUNU ve Bölge kodunu dugumsayisi kadar DOLDUR
{
int yoltoplamuzunluk=0,alansirasi=0,alankodu[dugumsayisi],bolgekodu[dugumsayisi],kruskalsehir[dugumsayisi],sayac=0;/*BÖLGE KODU HER DÜĞÜMÜN BAŞLANGIÇ DEĞERİNİ GÖSTERİR
EĞER DÜĞÜM GEZİLİRSE BAŞLANGIÇ DEĞERİNE ALAN KODU ATANACAK bolgekodu nun her bir değeri aslında bir köyün alan kodunu
göstermektedir. bolgekodu[4] yani 4 tane dugumun gezilip gezilmediği durumununu belirtir 0 gezilmemiş anlamındadır alankodu
aynı zaman diliminde gezilip gezilmediğini belirtir.*/
 //alankodu[dugumsayisi]={100,200,300,400},bolgekodu[4]={0,0,0,0};/*ÖRNEKTİR
int i;
 for(i=1;i<=dugumsayisi;i++)
 {

     alankodu[i-1]=i*100;
     bolgekodu[i-1]=0;
}

int baslangic,bitis,index,s,kontrol=0;
for(s=0;s<dugumsayisi*dugumsayisi;s++)// TÜM YOL SORGULARindex YAPILIYOR
{

    //index=yolindex[s];
    if(Matris[s][uzaklik]>0)//YOL UZUNLUĞU 0 DEĞİLSE
    {
baslangic=Matris[s][nereden];//Hangi sehirden
bitis=Matris[s][nereye];

//hangi sehire gidiliyor?
//printf("\n\nkontrol=%d-%d",baslangic,bitis);
if(bolgekodu[baslangic]==0&&bolgekodu[bitis]==0) //gidilen şehirlere ilk kez mi gidilmiş ilk kez se başlangıç  0 değilse  alan kodu atayacaz
{
 printf("\n\nD%d-D%d ARASi=%d birim==> D%d ve D%d dugumleri ilk kez geziliyor",Matris[s][nereden],Matris[s][nereye],Matris[s][uzaklik],Matris[s][nereden],Matris[s][nereye]);
 bolgekodu[baslangic]=alankodu[alansirasi];
bolgekodu[bitis]=alankodu[alansirasi];
alansirasi++;// bir sonraki sorgulamada eğer 2 şehirde gezilmemişse farklı bölge kodu atanacak
yoltoplamuzunluk=yoltoplamuzunluk+Matris[s][uzaklik];
kruskalsehir[sayac]=Matris[s][yolindex];
sayac=sayac+1;
}
else if(bolgekodu[baslangic]!=0&&bolgekodu[bitis]==0)//1. şehir gezilmiş 2. şehir gezilmemişse
{
    printf("\n\nD%d-D%d ARASi=%d birim==>D%d dugumu gezilmis ;D%d ise ilk kez geziliyor",Matris[s][nereden],Matris[s][nereye],Matris[s][uzaklik],Matris[s][nereden],Matris[s][nereye]);
bolgekodu[bitis]=bolgekodu[baslangic];//AYNI YOL DÜZERGAHINA BAĞLANMIŞ OLDULAR;
yoltoplamuzunluk=yoltoplamuzunluk+Matris[s][uzaklik];

kruskalsehir[sayac]=Matris[s][yolindex];
sayac=sayac+1;


}
else if(bolgekodu[baslangic]==0&&bolgekodu[bitis]!=0)//1. şehir gezilmemiş 2. şehir gezilmişse
{
     printf("\n\nD%d-D%d ARASi=%d birim==>D%d dugumu gezilmis ;D%d ise ilk kez geziliyor",Matris[s][nereden],Matris[s][nereye],Matris[s][uzaklik],Matris[s][nereye],Matris[s][nereden]);

bolgekodu[baslangic]=bolgekodu[bitis];//AYNI YOL DÜZERGAHINA BAĞLANMIŞ OLDULAR;
yoltoplamuzunluk=yoltoplamuzunluk+Matris[s][uzaklik];
kruskalsehir[sayac]=Matris[s][yolindex];
sayac=sayac+1;


}
else if(bolgekodu[baslangic]!=0&&bolgekodu[bitis]!=0&&bolgekodu[baslangic]!=bolgekodu[bitis])//HER 2 ŞEHİRDE GEZİLMİŞSE ancak bolge kodları farklıysa
{
//printf("\n\nbaslangic:%d,bitis:%d\n",baslangic,bitis);
//printf("\n\nbolbaslangic:%d,bolbitis:%d\n",bolgekodu[baslangic],bolgekodu[bitis]);
printf("%\n\nD%d-D%d ARASi=%d birim==>D%d dugumu gezilmis ;D%d dugumude gezilmis ancak her iki dugum farkli zamanlarda gezilmis",Matris[s][nereden],Matris[s][nereye],Matris[s][uzaklik],Matris[s][nereden],Matris[s][nereye]);
//AYNI YOL DÜZERGAHINA BAĞLANMIŞ OLDULAR ;
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

grafikdugum(sayac,kruskalsehir,Dugum,Matris,dugumsayisi);

}


int main()
{
    printf("\t\tGRAFLARDA EN KiSA YOL (KRUSKAL ALGORiTMASI)\n**********************************************************************\n\n");

    int i,j,x,y;//matris[satir][nereden,nereye,uzaklık,yolindex]
    int dugumsayisi;
    printf("Dugum sayisini giriniz:");
    scanf("%d",&dugumsayisi);
    printf("lutfen asagida belirtilen dugumlerin [x][y] kordinat bilgilerini giriniz\n**************************************************************************\n");

int Dugum[dugumsayisi][2],Matris[dugumsayisi*dugumsayisi-1][4],YedekMatris[dugumsayisi*dugumsayisi-1][4];
for(i=0;i<dugumsayisi;i++)
{
    printf("D%d dugumune ait [x] kordinatini giriniz:  ",i);
    scanf("%d",&x);
    Dugum[i][0]=x;

	printf("D%d dugumune ait [y] kordinatini giriniz:  ",i);
    scanf("%d",&y);
    Dugum[i][1]=y;;
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
matrisigoster(dugumsayisi,Matri//NU KODU TAMAMLA
printf("\n\nEN KISADAN EN UZUNA DOGRU YOL BiLGiSi ASAGiDA SiRALANMiSTiR\n***************************************************************\n");

sirala(dugumsayisi,Matris);
matrisigoster(dugumsayisi,Matris);
printf("\n\nEN KISA YOL SORGUSU YAPILIYOR(BASLANGiC-->BiTiS=YOL UZUNLUGU)\n*****************************************\n");
//outtextxy(0,300,"EN KISA YOL SORGUSU YAPILIYOR(BASLANGiC-->BiTiS=YOL UZUNLUGU)");

//grafikgosterim(dugumsayisi,Dugum);
CihanCihatMehmetKuruskal(dugumsayisi,Matris,Dugum,YedekMatris);//DİKKAT BU KOD sirala(dugumsayisi,yoluzunluklari,yolindeks); ten sonra çalıştırılmalı çünkü indeksler sıralandıktan sonra yol sorgulaması yapılacak

}

