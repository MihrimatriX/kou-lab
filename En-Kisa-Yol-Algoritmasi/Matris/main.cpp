//140202098 İsmet Karaduman
#include <graphics.h>
#include <stdlib.h>
#include <stdio.h>

//NOTLAR: Matriste hane sayısı parametriktir. Arttırılabilinir Ancak 16 lık matriste
//yüksek haneli sayılar için goruntu bozuldugundan sayılar 3 haneli seçilmiştir. Program
//içerinden hanesayisi değişkeni değiştirilerek arttırılabilir.

using namespace std;
int mboyut=16;

void Altmatris(int matris[16][16],int boyut,int secim);
void Hadamard(int matris[][16],int boyut,int secim)
{
    int satir,sutun,sonuc;
    sonuc=1;

    for (satir=0; satir<boyut; satir++)
    {
        for (sutun=0; sutun<boyut; sutun++)
        {
            if (matris[satir][sutun]!=matris[sutun][satir])
                sonuc=0;
        }
    }
    for (satir=0; satir<boyut; satir++)
    {
        for (sutun=0; sutun<boyut; sutun++)
        {
            if (matris[satir][sutun]!=matris[(boyut-satir-1)][boyut-sutun-1])
                sonuc=0;
        }
    }

    if (secim==1)
    {
        FILE *dosya= fopen("hadamard.txt", "w");
        if( dosya == NULL )
        {
            printf("%s","Hadamard Matris Dosyasi Acilamadi.");
            exit(1);
        }
        if (sonuc==1)
        {
            fprintf(dosya,"%s","Girilen Matris Hadamardir." );
            fprintf(dosya,"\n");
        }
        else
        {
            fprintf(dosya,"%s","Girilen Matris Hadamard Degildir." );
            fprintf(dosya,"\n");
        }
        fclose(dosya);
    }
    if (secim==2)
    {
        FILE *dosya= fopen("hadamard.txt", "a");
        if( dosya == NULL )
        {
            printf("%s","Hadamard Matris Dosyasi Acilamadi.");
            exit(1);
        }
        if (sonuc==1)
        {
            for (satir=0; satir<boyut; satir++)
            {
                for (sutun=0; sutun<boyut; sutun++)
                {
                    fprintf(dosya,"%d\t",matris[satir][sutun]);
                }
                fprintf(dosya,"\n");
            }
            fprintf(dosya,"\n");
        }
        fclose(dosya);
    }

}
int Determinant(int matris[][16],int boyut)
{
    int satir,sutun,sutun1,sutun2 ;
    int determinant = 0 ;
    int yedekmatris[16][16];
    if (boyut == 2)
    {
        determinant = (matris[0][0] * matris[1][1]) - (matris[1][0] * matris[0][1]);
    }
    else
    {
        determinant = 0 ;
        for (sutun1 = 0 ; sutun1 < boyut ; sutun1++)
        {
            for (satir = 1 ; satir < boyut ; satir++)
            {
                sutun2 = 0 ;
                for (sutun = 0 ; sutun < boyut ; sutun++)
                {
                    if (sutun == sutun1)
                        continue ;
                    yedekmatris[satir-1][sutun2] = matris[satir][sutun] ;
                    sutun2++;
                }
            }
            int carp;
            if ((sutun1%2)==0) carp=1;
            else carp=-1;
            determinant +=  carp* matris[0][sutun1] * Determinant(yedekmatris,boyut-1);
        }
    }
    return(determinant) ;
}

void Mds(int matris[][16],int boyut,int secim)
{
    int satir,sutun,determinant,sonuc=1;
    while (1)
    {
        if ((Determinant(matris,boyut)==0)||(boyut<2))
        {
            sonuc=0;
            break ;
        }
        else
        {
            Altmatris(matris,boyut,2);
        }
    }

    if (secim==1)
    {
        FILE *dosya= fopen("Mds.txt", "w");
        if( dosya == NULL )
        {
            printf("%s","Mds Matris Dosyasi Acilamadi.");
            exit(1);
        }
        if (sonuc==1)
        {
            fprintf(dosya,"%s","Girilen Matris Mds dir." );
            fprintf(dosya,"\n");
        }
        else
        {
            fprintf(dosya,"%s","Girilen Matris Mds Degildir." );
            fprintf(dosya,"\n");
        }
        fclose(dosya);
    }
    if (secim==2)
    {
        FILE *dosya= fopen("Mds.txt", "a");
        if( dosya == NULL )
        {
            printf("%s","Mds Matris Dosyasi Acilamadi.");
            exit(1);
        }
        if (sonuc==1)
        {
            for (satir=0; satir<boyut; satir++)
            {
                for (sutun=0; sutun<boyut; sutun++)
                {
                    fprintf(dosya,"%d\t",matris[satir][sutun]);
                }
                fprintf(dosya,"\n");
            }
            fprintf(dosya,"\n");
        }
        fclose(dosya);
    }
}
void Simetrik(int matris[][16],int boyut,int secim)
{
    int satir,sutun,sonuc=1;
    for (satir=0; satir<boyut; satir++)
    {
        for(sutun=0; sutun<boyut; sutun++)
        {
            if (matris[satir][sutun]!=matris[sutun][satir])
            {
                sonuc=0;
            }
        }
    }
    if (secim==1)
    {
        FILE *dosya2= fopen("simetrik.txt", "w");
        if( dosya2 == NULL )
        {
            printf("%s","Simetrik Matris Dosyasi Acilamadi.");
            exit(1);
        }
        if (sonuc==1)
        {
            fprintf(dosya2,"%s","Girilen Matris Simetriktir." );
            fprintf(dosya2,"\n");
        }
        else
        {
            fprintf(dosya2,"%s","Girilen Matris Simetriktir Degildir." );
            fprintf(dosya2,"\n");
        }
        fclose(dosya2);
    }
    if (secim==2)
    {
        FILE *dosya2= fopen("simetrik.txt", "a");
        if( dosya2 == NULL )
        {
            printf("%s","Simetrik Matris Dosyasi Acilamadi.");
            exit(1);
        }
        if (sonuc==1)
        {
            for (satir=0; satir<boyut; satir++)
            {
                for (sutun=0; sutun<boyut; sutun++)
                {
                    fprintf(dosya2,"%d\t",matris[satir][sutun]);
                }
                fprintf(dosya2,"\n");
            }
            fprintf(dosya2,"\n");
        }
        fclose(dosya2);
    }

}
void Dairesel (int matris[][16],int boyut, int secim)
{
    int satir,sutun,sonuc;
    sonuc=1;
    for (satir=0; satir<boyut; satir++)
    {
        for (sutun=0; sutun<boyut; sutun++)
        {
            if (matris[satir][sutun]!=matris[(satir+1)%boyut][(sutun+1)%boyut])
                sonuc=0;
        }
    }
    if (secim==1)
    {
        FILE *dosya= fopen("dairesel.txt", "w");
        if( dosya == NULL )
        {
            printf("%s","Dairesel Matris Dosyasi Acilamadi.");
            exit(1);
        }
        if (sonuc==1)
        {
            fprintf(dosya,"%s","Girilen Matris Daireseldir" );
            fprintf(dosya,"\n");
        }
        else
        {
            fprintf(dosya,"%s","Girilen Matris Dairesel Degildir." );
            fprintf(dosya,"\n");
        }
        fclose(dosya);
    }
    if (secim==2)
    {
        FILE *dosya= fopen("dairesel.txt", "a");
        if( dosya == NULL )
        {
            printf("%s","Dairesel Matris Dosyasi Acilamadi.");
            exit(1);
        }
        if (sonuc==1)
        {
            for (satir=0; satir<boyut; satir++)
            {
                for (sutun=0; sutun<boyut; sutun++)
                {
                    fprintf(dosya,"%d\t",matris[satir][sutun]);
                }
                fprintf(dosya,"\n");
            }
            fprintf(dosya,"\n");
        }
        fclose(dosya);
    }
}
void Altmatris(int matris[16][16],int boyut,int secim)
{
    int satir,sutun,xsatir,xsutun,sayac,yenimatris[16][16],x,y,x1,y1;
    for (sayac=2; sayac<boyut; sayac++)
    {
        for (satir=0; satir<boyut; satir++)
        {
            for (sutun=0; sutun<boyut; sutun++)
            {
                if(satir+sayac>boyut||sutun+sayac>boyut)
                {
                    break;
                }
                x=0;
                y=0;
                for (xsatir=satir; xsatir<satir+sayac; xsatir++)
                {
                    for (xsutun=sutun; xsutun<sutun+sayac; xsutun++)
                    {
                        yenimatris[x][y]=matris[xsatir][xsutun];
                        y++;
                    }
                    x++;
                    y=0;
                }
                switch (secim)
                {
                case 1:
                {
                    if ((sayac==2)||(sayac==4)||(sayac==8)||(sayac==16))
                        Hadamard(yenimatris,sayac,2);
                    break;
                }
                case 2:
                {
                    Mds(yenimatris,sayac,2);
                    break;
                }
                case 3:
                {
                    Simetrik(yenimatris,sayac,2);
                    break;
                }
                case 4:
                {
                    Dairesel(yenimatris,sayac,2);
                    break;
                }
                default:
                    break;
                }
            }
        }
    }
}
// bar kısmı
int DegerAl(int x,int y,int hanesayisi,int index)
{
    char karakter, girilen[hanesayisi-1];
    int sayi=0,sayac=0,sayac1=0;
    bar(x-5,y-3,x+(hanesayisi*10),y+18);
    while (1)
    {
        karakter=getch();
        outtextxy(450,410,"                                         ");
        outtextxy(450,435,"                                         ");
        outtextxy(450,460,"                                         ");

        if ((karakter>='0')&&(karakter<='9'))
        {
            girilen[sayac]=karakter;
            girilen[sayac+1]='\0';
            if (sayac<hanesayisi-1)
            {
                sayac++;
            }
            outtextxy(x,y,girilen);
        }
        else
        {
            if ((karakter==13))
            {
                if (karakter==13)
                {
                    sayi=0;
                    for (sayac1=0; sayac1<strlen(girilen); sayac1++)
                        sayi=sayi*10+girilen[sayac1]-48;
                    //printf("%d",sayi);
                    if (index==1)
                    {
                        if ((sayi<4)||(sayi>16))
                        {
                            outtextxy(450,410,"           HATA         ");
                            outtextxy(450,435,"Lutfen 4 ile 16 Arasinda");
                            outtextxy(450,460,"    Bir Sayi Giriniz    ");
                            bar(x-5,y-3,x+(hanesayisi*10),y+18);
                            girilen[0]='\0';
                            sayac=0;
                        }
                        else
                        {
                            if (sayac!=0) break;
                        }
                    }
                    else
                    {
                        if (sayac!=0) break;
                    }
                }

            }
            else
            {
                outtextxy(450,410,"          HATA          ");
                outtextxy(450,435," Lutfen Sayisal Degerler");
                outtextxy(450,460,"         Giriniz        ");
            }
        }
    }
    return sayi;
}
void MenuGiris()
{
    int satir=0,sutun=0,matris[16][16],menusec;
    while(1)
    {
        outtextxy(440,50,"          MENU        ");
        outtextxy(440,80,"1 - HADAMARD MATRIS   ");
        outtextxy(440,110,"2 - MDS MATRIS        ");
        outtextxy(440,140,"3 - SIMETRIK MATRIS   ");
        outtextxy(440,170,"4 - DAIRESEL MATRIS   ");
        outtextxy(440,200,"5 - CIKIS             ");
        outtextxy(440,230,"Seciminiz : ");
        menusec=DegerAl(550,230,2,0);
        if ((menusec>=1)&&(menusec<=5))
        {
            if (menusec==1)
            {
                if ((mboyut==4)||(mboyut==8)||(mboyut==16))
                {
                    break;
                }
                else
                {
                    outtextxy(450,410,"           HATA         ");
                    outtextxy(450,435,"Hadamard Icin Matris");
                    outtextxy(450,460,"Boyutu 4,8,16 olmalidir.");
                }
            }
            else
            {
                break;
            }
        }
        else
        {
            outtextxy(450,410,"           HATA         ");
            outtextxy(450,435,"Lutfen 1 ile 5 Arasinda");
            outtextxy(450,460,"    Bir Secim Yapiniz    ");
        }
    }
    switch (menusec)
    {
    case 1:
    {
        FILE *dosya= fopen("matris.txt", "r");
        if( dosya == NULL )
        {
            printf("%s","Dosya Acilamadi");
            exit(1);
        }
        while( !feof(dosya) )
        {
            fscanf(dosya,"%d",&matris[satir][sutun]);
            sutun++;
            if ((sutun%mboyut)==0)
            {
                satir++;
                sutun=0;
            }
        }
        fclose(dosya);
        Hadamard(matris,mboyut,1);
        Altmatris(matris,mboyut,1);
        break;
    }
    case 2:
    {
        FILE *dosya= fopen("matris.txt", "r");
        if( dosya == NULL )
        {
            printf("%s","Dosya Acilamadi");
            exit(1);
        }
        while( !feof(dosya) )
        {
            fscanf(dosya,"%d",&matris[satir][sutun]);
            sutun++;
            if ((sutun%mboyut)==0)
            {
                satir++;
                sutun=0;
            }
        }
        fclose(dosya);
        Mds(matris,mboyut,1);
        Altmatris(matris,mboyut,2);
        break;
    }
    case 3:
    {
        FILE *dosya= fopen("matris.txt", "r");
        if( dosya == NULL )
        {
            printf("%s","Dosya Acilamadi");
            exit(1);
        }
        while( !feof(dosya) )
        {
            fscanf(dosya,"%d",&matris[satir][sutun]);
            sutun++;
            if ((sutun%mboyut)==0)
            {
                satir++;
                sutun=0;
            }
        }
        fclose(dosya);
        Simetrik(matris,mboyut,1);
        Altmatris(matris,mboyut,3);
        break;
    }
    case 4:
    {
        FILE *dosya= fopen("matris.txt", "r");
        if( dosya == NULL )
        {
            printf("%s","Dosya Acilamadi");
            exit(1);
        }
        while( !feof(dosya) )
        {
            fscanf(dosya,"%d",&matris[satir][sutun]);
            sutun++;
            if ((sutun%mboyut)==0)
            {
                satir++;
                sutun=0;
            }
        }
        fclose(dosya);
        Dairesel(matris,mboyut,1);
        Altmatris(matris,mboyut,4);
        break;
    }
    case 5:
    {
        printf("%s","cikis 4,8,");
        exit(5);
    }

    default:
        break;
    }
}
void MatrisGiris()
{
    int satir,sutun,secim;
    char meleman[5];
    outtextxy(60,20,"Matrisin Boyutunu Giriniz....:");
    mboyut=DegerAl(260,20,2,1);
    outtextxy(60,45,"Matrisin Elemanlarini Giriniz:");

    int matris[mboyut][mboyut];
    bar(10,65,15,475);
    bar(15,65,25,70);
    bar(15,470,25,475);
    bar(425,65,430,475);
    bar(415,65,430,70);
    bar(415,470,430,475);
    int x1=15+(400/(mboyut+1)),y1=70+(400/(mboyut+1));
    for (satir=0; satir<mboyut; satir++)
    {
        for (sutun=0; sutun<mboyut; sutun++)
        {
            matris[satir][sutun]=DegerAl(260,45,3,0);
            sprintf(meleman,"%d",matris[satir][sutun]);
            outtextxy(x1,y1,meleman);
            x1=x1+(400/(mboyut+1));
        }
        y1=y1+(400/(mboyut+1));
        x1=15+(400/(mboyut+1));
    }

    FILE *dosya= fopen("matris.txt", "r");
    if( dosya == NULL )
    {
       // printf("%s"," Matrix.txt dosyasi yok ");
        outtextxy(450,410,"           HATA         ");
        outtextxy(450,435," Matrix.txt dosyasi yok ");
        outtextxy(450,460,"    Bir Tusa Basiniz    ");
        char sec;
        sec=getch();
        exit(1);
    }
    else
    {
        fclose(dosya);
        //FILE *dosya1= fopen("matris.txt", "w");
        //    fclose(dosya1);
        FILE *dosya= fopen("matris.txt", "a");
    }


    for (satir=0; satir<mboyut; satir++)
    {
        for (sutun=0; sutun<mboyut; sutun++)
        {
            fprintf(dosya,"%d\t",matris[satir][sutun]);
        }
        fprintf(dosya,"\n");
    }
    fclose(dosya);
}

int main()
{
    //Garafik Sürücülerini Yukle
    int satir,sutun;


    // grafik için lazım
    // buradan
    int driver,mode,errcode=0;
    driver=DETECT;
    initgraph(&driver,&mode,"C:\\TC\\BGI");

    //Garafik Ekran Yükleme Hatalarý
    errcode=graphresult();
    if(errcode!=0)
    {
        printf("graph error:%d",errcode);
        exit(1); //hata ile cik
    }

  //buraya
    MatrisGiris();
    MenuGiris();
    closegraph();

    return 0;
}
