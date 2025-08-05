#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QFileDialog>
#include <QMessageBox>
#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <QFile>
#include <QTextStream>
//#include "includes/CkCompression.h"
#include <iostream>
#include "dialoghakkinda.h"

#define OFFSETBITS 5
#define LENGTHBITS (8-OFFSETBITS)

#define OFFSETMASK ((1 << (OFFSETBITS)) - 1)
#define LENGTHMASK ((1 << (LENGTHBITS)) - 1)

#define GETOFFSET(x) (x >> LENGTHBITS)
#define GETLENGTH(x) (x & LENGTHMASK)
#define OFFSETLENGTH(x, y) (x << LENGTHBITS | y)

using namespace std;

//CkCompression compress;

QString text;
char *gelen;
int num;

MainWindow::MainWindow(QWidget *parent) : QMainWindow(parent), ui(new Ui::MainWindow)
{
    ui->setupUi(this);
}

MainWindow::~MainWindow()
{
    delete ui;
}

struct token
{
    uint8_t offset_len;
    char c;
};

/*
* iki string'in ilk kaç karakteri özdeş?
* maksimum limit sayısı kadar kontrol yapar.
*/
inline int prefix_match_length(char *s1, char *s2, int limit)
{
    int len = 0;

    while (*s1++ == *s2++ && len < limit)
    {
        len++;
    }
    return len;
}

/*
* memcpy fonksiyonu ile benzer. Byte düzeyinde
* kopyalama yapma garantisi olduğu için, bu
* versiyonu kullanıyoruz.
*/
inline void lz77memcpy(char *s1, char *s2, int size)
{
    while (size--)
        *s1++ = *s2++;
}

/*
* token array'ini, karakter array'ine dönüştürür.
*/
char *decode(struct token *tokens, int numTokens, int *pcbDecoded)
{
    // hafızada ayırdığımız kapasite
    int cap = 1 << 3;

    // kullanılan byte sayısı
    *pcbDecoded = 0;

    // hafızada yer ayır
    char *decoded = static_cast<char *>(malloc(cap));

    int i;
    for (i = 0; i < numTokens; i++)
    {
        // token'in içinden offset, length ve char
        // değerlerini oku
        int offset = GETOFFSET(tokens[i].offset_len);
        int len = GETLENGTH(tokens[i].offset_len);
        char c = tokens[i].c;

        // gerekirse kapasite artır.
        if (*pcbDecoded + len + 1 > cap)
        {
            cap = cap << 1;
            decoded = static_cast<char *>(realloc(decoded, cap));
        }

        // eğer length 0 değilse, gösterilen karakteleri
        // kopyala
        if (len > 0)
        {
            lz77memcpy(&decoded[*pcbDecoded], &decoded[*pcbDecoded - offset], len);
        }

        // kopyalanan karakter kadar ileri sar
        *pcbDecoded += len;

        // tokenin içindeki karateri ekle.
        decoded[*pcbDecoded] = c;

        // 1 adım daha ileri sar.
        *pcbDecoded = *pcbDecoded + 1;
    }
    return decoded;
}

/*
* LZ77 ile sıkıştırılacak bir metin alır.
* token array'i döndürür.
* Eğer numTokens NULL değilse, token sayısını
* numTokens ile gösterilen yere kaydeder.
*/
struct token *encode(char *text, int limit, int *numTokens)
{
    // cap (kapasite) hafızada kaç tokenlik yer ayırdığımız.
    int cap = 1 << 3;

    // kaç token oluşturduğumuz.
    int _numTokens = 0;

    // oluşturulacak token
    struct token t;

    // lookahead ve search buffer'larının başlangıç pozisyonları
    char *lookahead, *search;

    // tokenler için yer ayır.
    struct token *encoded = static_cast<token *>(malloc(cap * sizeof(struct token)));

    // token oluşturma döngüsü
    for (lookahead = text; lookahead < text + limit; lookahead++)
    {
        // search buffer'ı lookahead buffer'ın 31 (OFFSETMASK) karakter
        // gerisine koyuyoruz.
        search = lookahead - OFFSETMASK;

        // search buffer'ın metnin dışına çıkmasına engel ol.
        if (search < text) search = text;

        // search bufferda bulunan en uzun eşleşmenin
        // boyutu
        int max_len = 0;

        // search bufferda bulunan en uzun eşleşmenin
        // pozisyonu
        char *max_match = lookahead;

        // search buffer içinde arama yap.
        for (; search < lookahead; search++)
        {
            int len = prefix_match_length(search, lookahead, LENGTHMASK);

            if (len > max_len)
            {
                max_len = len;
                max_match = search;
            }
        }

        /*
        * ! ÖNEMLİ !
        * Eğer eşleşmenin içine metnin son karakteri de dahil olmuşsa,
        * tokenin içine bir karakter koyabilmek için, eşleşmeyi kısaltmamız
        * gerekiyor.
        */
        if (lookahead + max_len >= text + limit)
        {
            max_len = text + limit - lookahead - 1;
        }

        // bulunan eşleşmeye göre token oluştur.
        t.offset_len = OFFSETLENGTH(lookahead - max_match, max_len);
        lookahead += max_len;
        t.c = *lookahead;

        // gerekirse, hafızada yer aç
        if (_numTokens + 1 > cap)
        {
            cap = cap << 1;
            encoded = static_cast<token *>(realloc(encoded, cap * sizeof(struct token)));
        }

        // oluşturulan tokeni, array'e kaydet.
        encoded[_numTokens++] = t;
    }

    if (numTokens)
    {
        *numTokens = _numTokens;
    }
    return encoded;
}

// bir dosyanın tamamını tek seferde
// okur. Büyük dosyaları okumak için uygun
// değildir.
char *file_read(FILE *f, int *size)
{
    char *content;
    fseek(f, 0, SEEK_END);
    *size = ftell(f);
    content = static_cast<char *>(malloc(*size));
    fseek(f, 0, SEEK_SET);
    fread(content, 1, *size, f);
    return content;
}

void MainWindow::on_lz77_clicked()
{
    FILE *f;

    int metin_boyutu = 8, token_sayisi, decode_boyutu;
    char *kaynak_metin = "aaaaaaaa"; QString decoded_metin;

    struct token *encoded_metin;

    if ((f = fopen("okunan.txt", "rb")))
    {
        kaynak_metin = file_read(f, &metin_boyutu);
        fclose(f);
    }

    encoded_metin = encode(kaynak_metin, metin_boyutu, &token_sayisi);
    if ((f = fopen("encoded_LZ77.data", "wb")))
    {
        fwrite(encoded_metin, sizeof(struct token), token_sayisi, f);
        fclose(f);
    }

    decoded_metin = decode(encoded_metin, token_sayisi, &decode_boyutu);
    QByteArray array = decoded_metin.toLocal8Bit();
    char* buffer = array.data();

    if ((f = fopen("decoded_LZ77.data", "wb")))
    {
        fwrite(buffer, 1, decode_boyutu, f);
        fclose(f);
    }


    /**
     * @brief CkCompression : DEFLATE ALGORİTHM
     */
/*
    CkCompression compress;
    compress.put_Algorithm("deflate");

     bool success = compress.CompressFile("okunan.txt", "encoded_DEFLATE.data");

     if (success != true)
     {
        cout << "başarılı";
     }

     success = compress.DecompressFile("okunan.txt", "decoded_DEFLATE.data");

     if (success != true)
     {
        cout << "başarılı";
     }
*/

    int lzboyut = (int)(token_sayisi * sizeof(struct token));
    QString mesaj;
    printf("Orjinal Boyut: %d, Encode Boyutu: %d, Decode Boyutu: %d", metin_boyutu, token_sayisi * sizeof(struct token), decode_boyutu);


    int boyutu = metin_boyutu;
    float oranLz = ((float)lzboyut / (float)boyutu) * 100;


    printf("lzboyut %d \n", lzboyut);

    printf("metin boyut %d \n", boyutu);

    printf("oran %lf \n", oranLz);


    QString a = QString::number(boyutu);
    QString b = QString::number(lzboyut);
    //QString flz = QString::number(oranLz);

    ui->boyut->setText(a);
    ui->lzboyut->setText(b);

    ui->boyutdef->setText("Yapılmadı");


    ui->barLZ77->setValue((100-(int)oranLz));
    ui->barDeflate->setValue(100);


    /**
     * @brief QMessageBox::information
     * BURADA BİLGİLER YAZDIRILACAK.
     */
    QMessageBox::information(this, "Dosya", "Sıkıştırldı. Kapatabilirsiniz.");
}

void MainWindow::on_dosyaSec_clicked()
{

    QFile oku("okunan.txt");
    if (!oku.open(QFile::WriteOnly | QFile::Text))
    {
        QMessageBox::warning(this, "Uyari", "Dosya Oluşturma Hatasi");
    }

    QString filename = QFileDialog::getOpenFileName(this, tr("Open File"), "C://", "Text File (*.txt);;");
    QFile file(filename);
    num = file.handle();

    if (!file.open(QFile::ReadOnly | QFile::Text))
    {
        QMessageBox::warning(this, "Uyari", "Dosya Acma Hatasi");
    }

    QTextStream in(&file);
    text = in.readAll();

    QTextStream out(&oku);
    out << text;
    oku.close();

    QByteArray array = text.toLocal8Bit();
    gelen = array.data();

    ui->girdiMetin->setPlainText(text);
    file.close();
}

void MainWindow::on_pushButton_clicked()
{
    DialogHakkinda dialog;
    dialog.setModal(true);
    dialog.setFixedSize(400, 250);
    dialog.exec();
}
