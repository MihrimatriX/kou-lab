# Gezgin Zeplin Projesi (Java)

Dosyalardan şehir/komşuluk verilerini okuyup güzergah hesaplayan basit bir simülasyon.

## Önemli Dosyalar
- `ek/komsuluklar.txt`, `ek/koordinat.txt`: Girdi veri setleri
- `src/node/*.java`: Veri okuma ve yol hesabı
- `src/gui/MainObject.java`: Basit arayüz/başlangıç

## Çalıştırma
```bash
javac -d out src/node/*.java src/gui/MainObject.java
java -cp out gui.MainObject
```
