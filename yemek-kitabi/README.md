# 🍳 Yemek Kitabı Uygulaması

JavaFX ile geliştirilmiş, SQLite veritabanı kullanan yemek tarifi yönetim uygulaması.

## ✨ Özellikler

- **Tarif Yönetimi**: Ekleme, düzenleme, silme ve arama
- **Malzeme Yönetimi**: Stok takibi ve maliyet hesaplama
- **Stok Kontrolü**: Malzeme yeterliliği (yeşil/kırmızı renk kodlaması)
- **Arama**: Tarif adı ve malzeme bazında arama
- **Kategoriler**: Tarifleri kategorilere göre organize etme

## 🚀 Hızlı Başlangıç

### Gereksinimler
- Java 17+
- Maven 3.6+

### Çalıştırma

```bash
# Windows
.\mvnw.cmd javafx:run

# Linux/Mac  
./mvnw javafx:run
```

**Veya IDE ile**: `com.yazlab.TarifUygulamasi` sınıfını çalıştırın

## 📁 Proje Yapısı

```
src/main/java/com/yazlab/
├── TarifUygulamasi.java          # Ana uygulama
├── MainController.java           # Ana ekran kontrolcüsü
├── AddIngredientController.java  # Malzeme ekleme
├── RecipeDetailController.java   # Tarif detayları
├── Recipe.java                   # Tarif modeli
├── Ingredient.java               # Malzeme modeli
├── RecipeIngredient.java         # Tarif-Malzeme ilişkisi
└── DbConnection.java             # Veritabanı bağlantısı
```

## 🗄️ Veritabanı

- **SQLite**: Otomatik oluşturulan `yemek_kitabi.db` dosyası
- **Tablolar**: Tarifler, Malzemeler, TarifMalzeme
- **Örnek Veriler**: İlk çalıştırmada otomatik eklenir

## 🎯 Kullanım

### Tarif Ekleme
1. Sol panelde tarif bilgilerini girin
2. Malzeme seçin ve miktar belirleyin
3. "Tarif Kaydet" butonuna tıklayın

### Malzeme Ekleme
1. "Malzeme Ekle" butonuna tıklayın
2. Malzeme bilgilerini girin
3. "Kaydet" butonuna tıklayın

### Tarif Arama
- Üst kısımdaki arama kutusuna yazın
- Enter tuşuna basın

### Tarif Detayları
- Tabloda bir tarife çift tıklayın

## 🔧 Teknik Detaylar

- **JavaFX 17**: UI framework
- **SQLite**: Veritabanı
- **Maven**: Proje yönetimi
- **Java 17**: Modern Java özellikleri

## 🐛 Sorun Giderme

### JAVA_HOME Hatası
```bash
# Windows
set JAVA_HOME=C:\Program Files\Java\jdk-17

# Linux/Mac
export JAVA_HOME=/path/to/java17
```

### Veritabanı Hatası
- `yemek_kitabi.db` dosyasını silin ve yeniden başlatın

### JavaFX Hatası
- Java 17+ kullandığınızdan emin olun

---

**Versiyon**: 2.0 (Optimized)  
**Geliştirici**: YAZLAB Projesi 