# A* Labirent Çözücü (Java/Swing)

Java Swing ile A* algoritmasını kullanarak labirent üzerinde en kısa yolu görselleştirir. `PathFinding.java` tek dosyalık örnek akış içerir.

## Özellikler
- Dinamik başlangıç/bitiş noktası seçimi
- Duvar çizme/silme, rastgele harita üretimi
- Boyut, yoğunluk ve animasyon hızı ayarları
- Adım adım arama görselleştirmesi

## Gereksinimler

- Java 8+

## Çalıştırma

```bash
javac PathFinding.java
java PathFinding
```

## A* Kısa Özet

f(n) = g(n) + h(n) (g: birikimli maliyet, h: sezgisel/heuristic). Bu örnekte ızgara üzerinde komşuluk ve öncelik kuyruğu ile keşif yapılır.