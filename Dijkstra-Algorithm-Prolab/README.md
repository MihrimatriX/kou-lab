# Dijkstra (C) – Şehirler Arası En Kısa Yol

Şehirler ve aralarındaki mesafe/bağlantı bilgileri üzerinden Dijkstra algoritması ile en kısa yolun bulunması.

## Veri Dosyaları
- `sehir kod.txt`: Şehir adları ve kodları
- `sehir mesafe.txt`: Kenarlar ve mesafeler

## Gereksinimler
- GCC/Clang (C derleyici)

## Derleme ve Çalıştırma
```bash
gcc -O2 -o dijkstra main.c
./dijkstra
```

Program çalıştığında dosyalardan grafı okuyup kaynak-hedef için en kısa yolu hesaplar.
