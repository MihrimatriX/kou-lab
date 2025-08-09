## Tic-Tac-Toe (README Türkçe)

Bu proje, konsol tabanlı ve özelleştirilebilir tahtaya sahip bir Tic-Tac-Toe (X-O) oyunudur.

### Özellikler
- 3x3, 5x5 veya 7x7 tahta boyutları
- İnsan vs. Bilgisayar modu
- Oyun kaydetme/yükleme (`game-save.txt`)
- Konsola ASCII tahta çizimi
- Gelişmiş bilgisayar zekâsı: 3x3 için Minimax; daha büyük tahtalarda hızlı sezgisel strateji (kazan/blok/merkez)

### Proje Yapısı
- `TicTacToe.java`: Uygulamanın giriş noktası ve oyun akışı
- `GameBoard.java`: Tahta durumu, hamle uygulama, kazanan/beraberlik kontrolü, kaydet/yükle
- `Player.java`: İnsan/Bilgisayar oyuncu mantığı, hamle üretimi
- `game-save.txt`: Oyun kayıt dosyası (otomatik oluşturulur)

### Derleme ve Çalıştırma (Java 8+)
```bash
cd Tic-Tac-Toe
javac *.java
java TicTacToe
```

Alternatif olarak scriptler:
```bash
# Linux/macOS
./run.sh

# Windows (PowerShell/CMD)
run.bat
```

### Kullanım Akışı
1. Oyun başında kayıt yüklemek isteyip istemediğiniz sorulur (Y/N)
2. Yeni oyunda tahta boyutunu (3/5/7) ve kullanıcı işaretini (X/O) seçin
3. Sıra sizdeyken X ve Y değerlerini [0, N-1] aralığında girin
4. Bilgisayar rastgele geçerli bir hamle yapar
5. Oyun bitince devam etmek isteyip istemediğiniz sorulur

### Notlar
- Kaydetme/yükleme basit bir metin formatı kullanır: ilk karakter tahta boyutu, devamında hücreler ve son karakter sıradaki oyuncunun işareti
- Konsol çıktıları ve hata çıktıları UTF-8’e ayarlanır

