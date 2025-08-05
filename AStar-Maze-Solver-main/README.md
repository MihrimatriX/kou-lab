# A* Labirent Çözücü

Bu proje, A* algoritması kullanarak labirent çözme işlemini görselleştiren bir Java uygulamasıdır.

## Özellikler

- Görsel labirent oluşturma ve düzenleme
- A* algoritması ile en kısa yol bulma
- Özelleştirilebilir labirent boyutu
- Duvar yoğunluğu ayarı
- Animasyon hızı kontrolü
- Gerçek zamanlı yol bulma görselleştirmesi

## Kullanım

1. Başlangıç noktası belirleme:
   - "Start" aracını seçin
   - Labirentte istediğiniz noktaya tıklayın

2. Bitiş noktası belirleme:
   - "Finish" aracını seçin
   - Labirentte istediğiniz noktaya tıklayın

3. Duvar oluşturma:
   - "Wall" aracını seçin
   - Labirentte duvar oluşturmak istediğiniz noktalara tıklayın veya sürükleyin

4. Duvar silme:
   - "Eraser" aracını seçin
   - Silmek istediğiniz duvarlara tıklayın veya sürükleyin

5. Yol bulma:
   - "Start Search" butonuna tıklayın
   - Algoritma başlangıç noktasından bitiş noktasına en kısa yolu bulacaktır

## Kontroller

- **Size**: Labirent boyutunu ayarlar (10x10 ile 50x50 arası)
- **Delay**: Animasyon hızını ayarlar (0-500ms)
- **Density**: Duvar yoğunluğunu ayarlar (%1-%100)
- **Generate Map**: Rastgele bir labirent oluşturur
- **Clear Map**: Labirenti temizler
- **Reset**: Mevcut aramayı sıfırlar

## Teknik Detaylar

### A* Algoritması

A* algoritması, başlangıç noktasından bitiş noktasına en kısa yolu bulmak için kullanılır. Algoritma şu özelliklere sahiptir:

- f(n) = g(n) + h(n) formülünü kullanır
  - g(n): Başlangıç noktasından mevcut noktaya olan maliyet
  - h(n): Mevcut noktadan bitiş noktasına olan tahmini maliyet (Öklid mesafesi)
- Öncelik kuyruğu kullanarak en umut verici yolları önce keşfeder
- Her düğüm için en iyi yol bilgisini saklar

### Renk Kodları

- 🟢 Yeşil: Başlangıç noktası
- 🔴 Kırmızı: Bitiş noktası
- ⬛ Siyah: Duvar
- ⬜ Beyaz: Boş alan
- 🔵 Mavi: Kontrol edilmiş alan
- 🟡 Sarı: Bulunan yol

## Geliştirme

Proje Java ile geliştirilmiştir ve şu bileşenleri içerir:

- Swing GUI framework'ü
- A* algoritması implementasyonu
- Özel Node sınıfı
- Görsel harita yönetimi

## Gereksinimler

- Java 8 veya üzeri
- Swing kütüphanesi (Java ile birlikte gelir)

## Kurulum

1. Projeyi klonlayın:
```bash
git clone https://github.com/yourusername/AStar-Maze-Solver.git
```

2. Projeyi derleyin:
```bash
javac src/com/alumation/maze/PathFinding.java
```

3. Uygulamayı çalıştırın:
```bash
java -cp src com.alumation.maze.PathFinding
```

## Lisans

Bu proje MIT lisansı altında lisanslanmıştır. Detaylar için `LICENSE` dosyasına bakın.

## Katkıda Bulunma

1. Bu depoyu fork edin
2. Yeni bir özellik dalı oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'Add some amazing feature'`)
4. Dalınıza push edin (`git push origin feature/amazing-feature`)
5. Bir Pull Request oluşturun