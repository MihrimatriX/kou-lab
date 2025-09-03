# Asansör Simülasyonu (Multi-thread)

Çok iş parçacıklı (multi-thread) bir AVM-asansör simülasyonu. Katlara yolcu gelişleri, giriş/çıkış akışı ve asansör hareketi ayrı iş parçacıklarında yönetilir.

## Özellikler
- Kat bazlı yolcu kuyrukları ve rastgele yolcu/kat üretimi
- Giriş/çıkış akışını yöneten bağımsız thread'ler (`AvmGiris`, `AvmCikis`)
- Simülasyon saatini yöneten saat bileşeni (`SimClock`)
- Asansör hareket ve olay yönetimi (`Asansor`, `ElevatorEvent`)

## Gereksinimler
- Java 8+
- Bir IDE (IntelliJ IDEA/Eclipse) veya komut satırı

## Çalıştırma
### IDE ile
1. Projeyi IDE'ye açın.
2. Çalıştırma hedefi olarak `com.asansor.thread.AsansorProgrami` sınıfını seçin.
3. Run.

### Komut satırı ile
```bash
javac -d out src/com/asansor/thread/*.java
java -cp out com.asansor.thread.AsansorProgrami
```

## Yapı
```
src/com/asansor/thread/
├── Asansor.java                 # Asansör mantığı
├── AsansorProgrami.java         # Giriş noktası (main)
├── AsansorSimulasyonu.java      # Simülasyon orkestrasyonu
├── AvmCikis.java                # Çıkış thread'i
├── AvmGiris.java                # Giriş thread'i
├── binakatlari.java             # Kat temsil/yardımcı
├── ElevatorEvent.java           # Olay modeli
├── SimClock.java                # Simülasyon saati
└── YolcuGelisi.java             # Yolcu geliş davranışı
```

## Parametreler
`AsansorProgrami` içinde:
- `simulasyon_suresi`: Toplam süre (ms)
- `rateSimTime`: Zaman ölçeği
- `rastgeleKisi()`, `rastgeleKat()`: Senaryo üretimi

## Notlar
- Eşzamanlılık sorunlarını görmek için thread sleep/değerlerini değiştirip farklı yoğunlukları deneyin.
