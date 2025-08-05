#include <graphics.h>
#include <stdio.h>
#include <cstdlib>//Sistemin arkaplan rengini değiştirme
#include "bitmap_image.hpp";
#include <stdlib.h>
#include <conio.h>
void arayuz();
void kaydet_format_bmp();
void yukle();
void dikdortgen();
void kalem();
void cizgi();
void cember();
void ucgen();
void silgi();
void arkaplan();

int i,j,k,renk=BLACK,arkaplanrengi=15,cizgikalinligi=3,yazirengi=15;
unsigned char   red;
unsigned char green;
unsigned char  blue;


//*****************************************************************************************************************************
void karsilamaekrani()
{
readimagefile("karsilamaekrani.bmp",0,0,900,600);
Sleep(5000);
cleardevice();
}

//*****************************************************************************************************************************
void arkaplan()
{
readimagefile("arkaplanbeyaz.bmp",0,100,900,600);
}

//*****************************************************************************************************************************

void silgi()
{
    setcolor(yazirengi);
    outtextxy(570,5,"SECILEN ISLEM TURU=>SILGI                         ");
    baslangic:
    clearmouseclick(WM_LBUTTONDOWN);
    if(mousey()>=104)
    {
        setcolor(arkaplanrengi);
        while(mousey()>104) //starts infinite loop
        {
                if(ismouseclick(WM_LBUTTONDOWN)) //sol dü?meye basyldyysa
                {
                moveto(mousex(),mousey());
                clearmouseclick(WM_LBUTTONDOWN);
                clearmouseclick(WM_LBUTTONUP);
                        while(!ismouseclick(WM_LBUTTONUP))
                        {

                                   if(mousey()<104)
                                   {

                                       clearmouseclick(WM_LBUTTONUP);
                                       if(ismouseclick(WM_LBUTTONDOWN)) //sol dü?meye basyldyysa
                                       {
                                       // outtextxy(350,200,"ALAN DIŞINDA");

                                        }


                                   }
                                   else
                                   {
                                       for(i=-5;i<5;i++)
                                       {
                                           for(j=-5;j<5;j++)
                                           {
                                              putpixel(mousex()+i,mousey()+j,arkaplanrengi);
                                           }
                                       }






                                   }
                        }
                }
        }
 }
 else
 {
  goto baslangic;
 }
}

//*****************************************************************************************************************************


void ucgen()
{
    setcolor(yazirengi);
    outtextxy(570,5,"SECILEN ISLEM TURU=>UCGEN                          ");
    int x1,y1,x2,y2;
 baslangic:
    clearmouseclick(WM_LBUTTONDOWN);
    if(mousey()>=100)
    {
    setcolor(renk);
while(mousey()>100)
if(ismouseclick(WM_LBUTTONDOWN)&& mousey()>100) //sol dü?meye basyldyysa
{
x1=mousex();
y1=mousey();
clearmouseclick(WM_LBUTTONDOWN);
clearmouseclick(WM_LBUTTONUP);
while(!ismouseclick(WM_LBUTTONUP) && mousey()>100)
{

   if(mousey()<100)
   {

       clearmouseclick(WM_LBUTTONUP);
       if(ismouseclick(WM_LBUTTONDOWN)) //sol dü?meye basyldyysa
{
    //outtextxy(350,200,"ALAN DIŞINDA");

}


   }
   else
   {
x2=mousex();
y2=mousey();
 setcolor(renk);
              line(x1,y1,x2,y2);
              line(x1-(x2-x1),y2,x1,y1);
              line(x1-(x2-x1),y2,x2,y2);



            if(x2!=mousex()||y2!=mousey())
            {
               setcolor(arkaplanrengi);
              line(x1,y1,x2,y2);
              line(x1-(x2-x1),y2,x1,y1);
              line(x1-(x2-x1),y2,x2,y2);


            }

   }
}
}
}
 else
 {
  goto baslangic;
 }
}

//*****************************************************************************************************************************


void cember()
{
    setcolor(yazirengi);
    outtextxy(570,5,"SECILEN ISLEM TURU=>CEMBER                            ");
    int x1,y1,x2,y2;
 baslangic:
    clearmouseclick(WM_LBUTTONDOWN);
    if(mousey()>=100)
    {
    setcolor(renk);
while(mousey()>100)
if(ismouseclick(WM_LBUTTONDOWN)&& mousey()>100) //sol dü?meye basyldyysa
{
x1=mousex();
y1=mousey();
clearmouseclick(WM_LBUTTONDOWN);
clearmouseclick(WM_LBUTTONUP);
while(!ismouseclick(WM_LBUTTONUP) && mousey()>100)
{

   if(mousey()<100)
   {

       clearmouseclick(WM_LBUTTONUP);
       if(ismouseclick(WM_LBUTTONDOWN)) //sol dü?meye basyldyysa
{
   // outtextxy(350,200,"ALAN DIŞINDA");

}


   }
   else
   {
x2=mousex();
y2=mousey();

 setcolor(renk);
               if(y1-abs(y2-y1)>=100)//ÇİZİM ALANINI AŞMAMASI İÇİN KONTROL
    {
                   circle(abs(x1),abs(y1),abs(y2-y1));
    }



            if(x2!=mousex()||y2!=mousey())
            {
               setcolor(arkaplanrengi);
                  if(y1-abs(y2-y1)>=100)//ÇİZİM ALANINI AŞMAMASI İÇİN KONTROL
    {
                   circle(abs(x1),abs(y1),abs(y2-y1));

    }


            }

   }
}
}
}
 else
 {
  goto baslangic;
 }
}

//*****************************************************************************************************************************

void dikdortgen()
{
    setcolor(yazirengi);
    outtextxy(570,5,"SECILEN ISLEM TURU=>DIKDORTGEN                                             ");
    int x1,y1,x2,y2;
 baslangic:
    clearmouseclick(WM_LBUTTONDOWN);
    if(mousey()>=100)
    {
    setcolor(renk);
while(mousey()>100)
if(ismouseclick(WM_LBUTTONDOWN)&& mousey()>100) //sol dü?meye basyldyysa
{
x1=mousex();
y1=mousey();
clearmouseclick(WM_LBUTTONDOWN);
clearmouseclick(WM_LBUTTONUP);
while(!ismouseclick(WM_LBUTTONUP) && mousey()>100)
{

   if(mousey()<100)
   {

       clearmouseclick(WM_LBUTTONUP);
       if(ismouseclick(WM_LBUTTONDOWN)) //sol dü?meye basyldyysa
{
   // outtextxy(350,200,"ALAN DIŞINDA");

}


   }
   else
   {
x2=mousex();
y2=mousey();
 setcolor(renk);
                    line(x1,y1,x2,y1);
                    line(x2,y1,x2,y2);
                    line(x1,y2,x2,y2);
                    line(x1,y1,x1,y2);


            if(x2!=mousex()||y2!=mousey())
            {
               setcolor(arkaplanrengi);
                    line(x1,y1,x2,y1);
                    line(x2,y1,x2,y2);
                    line(x1,y2,x2,y2);
                    line(x1,y1,x1,y2);

            }

   }
}
}
}
 else
 {
  goto baslangic;
 }
}

//*****************************************************************************************************************************

void cizgi()
{
    setcolor(yazirengi);
    outtextxy(570,5,"SECILEN ISLEM TURU=>CIZGI                                            ");
int x1,y1,x2,y2;
 baslangic:
    clearmouseclick(WM_LBUTTONDOWN);
    clearmouseclick(WM_LBUTTONUP);
    if(mousey()>=100)
    {
    setcolor(renk);
while(mousey()>100)
if(ismouseclick(WM_LBUTTONDOWN)&& mousey()>100) //sol dü?meye basyldyysa
{
x1=mousex();
y1=mousey();
clearmouseclick(WM_LBUTTONDOWN);
clearmouseclick(WM_LBUTTONUP);
while(!ismouseclick(WM_LBUTTONUP) && mousey()>100)
{

   if(mousey()<100)
   {

       clearmouseclick(WM_LBUTTONUP);
       if(ismouseclick(WM_LBUTTONDOWN)) //sol dü?meye basyldyysa
{
  //  outtextxy(350,200,"ALAN DIŞINDA");

}


   }
   else
   {
x2=mousex();
y2=mousey();
 setcolor(renk);
                    line(x1,y1,x2,y2);



            if(x2!=mousex()||y2!=mousey())
            {
               setcolor(arkaplanrengi);
                    line(x1,y1,x2,y2);


            }

   }
}
}
}
 else
 {
  goto baslangic;
 }
}

//*****************************************************************************************************************************
void kalem()
{
    setcolor(yazirengi);
    outtextxy(570,5,"SECILEN ISLEM TURU=>KALEM                                             ");
    baslangic:
    clearmouseclick(WM_LBUTTONDOWN);
    if(mousey()>=100)
    {
        setcolor(renk);
        while(mousey()>100) //starts infinite loop
        {
                if(ismouseclick(WM_LBUTTONDOWN)) //sol dü?meye basyldyysa
                {
                moveto(mousex(),mousey());
                clearmouseclick(WM_LBUTTONDOWN);
                clearmouseclick(WM_LBUTTONUP);
                        while(!ismouseclick(WM_LBUTTONUP))
                        {

                                   if(mousey()<100)
                                   {

                                       clearmouseclick(WM_LBUTTONUP);
                                       if(ismouseclick(WM_LBUTTONDOWN)) //sol dü?meye basyldyysa
                                       {
                                   //     outtextxy(350,200,"ALAN DIŞINDA");

                                        }


                                   }
                                   else
                                   {

                                    lineto(mousex(),mousey());
                                   }
                        }
                }
        }
 }
 else
 {
  goto baslangic;
 }
}

//*****************************************************************************************************************************
void arayuz()
{
readimagefile("arayuz.bmp",0,0,900,100);
}
//*****************************************************************************************************************************
void kaydet_format_bmp()
{

setcolor(yazirengi);
outtextxy(570,5,"KAYDETME ISLEMI BASLATILIYOR.BEKLEYINIZ                         ");
bitmap_image image(900,500);
FILE *dosya=fopen("ekrangoruntusu.txt","w");
for (unsigned int x = 0; x < 900; x++)
   {
      for (unsigned int y = 100; y <600; y++)
      {
          if(y>99)//neden 99 mu? çünkü çizim alanu y>100 den başlıyor
          {
              fprintf(dosya,"%d\n",getpixel(x,y));
          }

if(getpixel(x,y)==WHITE)
{
         rgb_t col;
         col.blue=255;
         col.red=255;
         col.green=255;
         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==YELLOW)
{
         rgb_t col;
         col.red=255;
         col.green=255;
         col.blue=0;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==RED)
{
         rgb_t col;
         col.red=255;
         col.green=0;
         col.blue=0;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==BLUE)
{
         rgb_t col;
         col.red=0;
         col.green=0;
         col.blue=255;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==BROWN)
{
         rgb_t col;
         col.red=165;
         col.green=42;
         col.blue=42;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==CYAN)
{
         rgb_t col;
         col.red=0;
         col.green=255;
         col.blue=255;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==GREEN)
{
         rgb_t col;
         col.red=0;
         col.green=128;
         col.blue=0;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==LIGHTCYAN)
{
         rgb_t col;
         col.red=172;
         col.green=255;
         col.blue=252;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==LIGHTGREEN)
{
         rgb_t col;
         col.red=150;
         col.green=249;
         col.blue=123;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==LIGHTRED)
{
         rgb_t col;
         col.red=255;
         col.green=71;
         col.blue=76;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==LIGHTBLUE)
{
         rgb_t col;
         col.red=149;
         col.green=208;
         col.blue=252;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==DARKGRAY)
{
         rgb_t col;
         col.red=169;
         col.green=169;
         col.blue=169;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==LIGHTGRAY)
{
         rgb_t col;
         col.red=211;
         col.green=211;
         col.blue=211;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==MAGENTA)
{
         rgb_t col;
         col.red=255;
         col.green=0;
         col.blue=255;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==LIGHTMAGENTA)
{
         rgb_t col;
         col.red=255;
         col.green=128;
         col.blue=255;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}
else if(getpixel(x,y)==BLACK)
{
         rgb_t col;
         col.red=0;
         col.green=0;
         col.blue=0;

         image.set_pixel(x,y-100,col.red,col.green,col.blue);
}


      }
   }
   image.save_image("paintekran.bmp");
   fclose(dosya);
   outtextxy(570,5,"BASARIYLA KAYDEDILDI                                             ");
}
//*****************************************************************************************************************************
void yukle()
{
    // KISA YONTEM AMA RENK KAYBI YAŞANIYOR
/*
cleardevice();
setcolor(yazirengi);
outtextxy(570,5,"YUKLEME YAPILIYOR BEKLEYINIZ        ");
readimagefile("paintekran.bmp",0,100,900,600);
arayuz();
*/
cleardevice();

arayuz();
setcolor(yazirengi);
outtextxy(570,5,"YUKLEME YAPILIYOR BEKLEYINIZ                                          ");

 FILE *dosya=fopen("ekrangoruntusu.txt","r");



                 int renk,i=0,j=0;
                 while(!feof(dosya)){
                   fscanf(dosya,"%d",&renk);
                   putpixel(i,j+100,renk);

                j++;
                j=j%500;   //i satir sayısı j sutun sayisini belirtir
                if(j==0)
                {
                    i++;
                }

                 }
                 fclose(dosya);
setcolor(WHITE);
outtextxy(570,5,"YUKLEME ISLEMI TAMAMLANDI                                                          ");


}

//*****************************************************************************************************************************
int main()
{
initwindow(900, 600,"Mehmet Samet YILDIZ - Adem YILMAZ",20,20);
karsilamaekrani();
setcolor(yazirengi);
outtextxy(570,5,"AYARLAR YUKLENIYOR.LUTFEN BEKLEYINIZ");
arayuz();
arkaplan();
while(1)
{
    if(ismouseclick(WM_LBUTTONDBLCLK) && mousey()<100)
    {

                    if(mousey()>30 && mousex()<100)
                    {
                        kaydet_format_bmp();
                    clearmouseclick(WM_LBUTTONDBLCLK);

                    }
                    else if(mousey()>30 && mousex()>100 && mousex()<200)
                    {
 yukle();
                        clearmouseclick(WM_LBUTTONDBLCLK);

                    }
                     else if(mousey()>30 && mousex()>200 && mousex()<300)
                    {
kalem();
                         clearmouseclick(WM_LBUTTONDBLCLK);

                    }
                         else if(mousey()>30 && mousex()>300 && mousex()<400)
                    {
                        cizgi();
                         clearmouseclick(WM_LBUTTONDBLCLK);
                         clearmouseclick(WM_LBUTTONDOWN);
                         clearmouseclick(WM_LBUTTONUP);


                    }
                          else if(mousey()>30 && mousex()>400 && mousex()<500)
                    {
                        cember();
                         clearmouseclick(WM_LBUTTONDBLCLK);
                         clearmouseclick(WM_LBUTTONDOWN);
                         clearmouseclick(WM_LBUTTONUP);



                    }
                          else if(mousey()>30 && mousex()>500 && mousex()<600)
                    {
                        dikdortgen();
                         clearmouseclick(WM_LBUTTONDBLCLK);
                         clearmouseclick(WM_LBUTTONDOWN);
                         clearmouseclick(WM_LBUTTONUP);

                    }
                          else if(mousey()>30 && mousex()>600 && mousex()<700)
                    {
                        ucgen();
                         clearmouseclick(WM_LBUTTONDBLCLK);
                         clearmouseclick(WM_LBUTTONDOWN);
                         clearmouseclick(WM_LBUTTONUP);

                    }
                    else if(mousey()>30 && mousex()>700 && mousex()<800 && mousey()<65)
                    {
                        silgi();
                         clearmouseclick(WM_LBUTTONDBLCLK);
                         clearmouseclick(WM_LBUTTONDOWN);
                         clearmouseclick(WM_LBUTTONUP);

                    }
                      else if(mousey()>65 && mousex()>700 && mousex()<800 && mousey()<100)
                    {

                        arayuz();
                        arkaplan();
                        setcolor(yazirengi);
                        outtextxy(570,5,"CIZIM EKRANI TEMIZLENDI                                                                                   ");
                         clearmouseclick(WM_LBUTTONDBLCLK);
                         clearmouseclick(WM_LBUTTONDOWN);
                         clearmouseclick(WM_LBUTTONUP);

                    }
                       else if(mousey()>30 && mousex()>800 && mousex()<900 && mousey()<65)
                    {
                        setcolor(yazirengi);
                        cizgikalinligi++;
                        char str[3];
                        sprintf(str,"CIZGI KALINLIGI=%d                                                                            ",cizgikalinligi);
                        setlinestyle(0,0,cizgikalinligi);
                        outtextxy(570,5,str);
                        setcolor(renk);
                         clearmouseclick(WM_LBUTTONDBLCLK);
                         clearmouseclick(WM_LBUTTONDOWN);
                         clearmouseclick(WM_LBUTTONUP);

                    }
                       else if(mousey()>65 && mousex()>800 && mousex()<900 && mousey()<100)
                    {

                        setcolor(yazirengi);
                        cizgikalinligi--;
                        char str[3];
                        sprintf(str,"CIZGI KALINLIGI=%d                                                                        ",cizgikalinligi);
                        setlinestyle(0,0,cizgikalinligi);
                        outtextxy(570,5,str);
                        setcolor(renk);
                         clearmouseclick(WM_LBUTTONDBLCLK);
                         clearmouseclick(WM_LBUTTONDOWN);
                         clearmouseclick(WM_LBUTTONUP);

                    }
          //
    }
    if(ismouseclick(WM_LBUTTONDBLCLK) && mousey()>100 )//ÇİZİM ALANI KISMI
    {
         clearmouseclick(WM_LBUTTONDBLCLK);
    }
    if(ismouseclick(WM_LBUTTONDBLCLK) && mousey()<30  )//RENK TABLOSUNUN OLDUĞU KISIM
    {
        if(mousex()>130 && mousex()<432 && mousey()<30)
        {
            renk=getpixel(mousex(),mousey());
            setcolor(yazirengi);
            outtextxy(570,5,"CIZIM RENGI DEGISTI...ISLEM SECINIZ");

                       clearmouseclick(WM_LBUTTONDOWN);
                         clearmouseclick(WM_LBUTTONUP);

        }

 clearmouseclick(WM_LBUTTONDBLCLK);
    }




}


getch();


}
