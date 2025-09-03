# Android + ASP.NET Web API – Google Maps ve REST

Android tarafında Google Maps entegrasyonu, sunucu tarafında ASP.NET Web API ile REST servisleri içerir.

## Yapı

- `Android/` → Android Studio projesi (Google Maps)
- `YazLab23/` → ASP.NET Web API projesi (WebApiConfig, Controllers vb.)

## Gereksinimler

- Android Studio, Android SDK
- Visual Studio (.NET Framework, MVC/Web API 5)

## Sunucu (ASP.NET Web API)

1. `YazLab23.sln` dosyasını Visual Studio ile açın.
2. Gerekirse `packages` geri yüklensin (NuGet restore).
3. F5 ile çalıştırın (IIS Express). Yardım sayfaları `Areas/HelpPage` altındadır.

## İstemci (Android)

1. `Android/` klasörünü Android Studio ile açın.
2. `local.properties` ve SDK/yapılandırmalarınızı kontrol edin.
3. Çalıştırın. Harita anahtarınız/yetkilendirme için `google_maps_api.xml` dosyasını düzenleyin.

## Notlar

- Web API uç noktalarını Android istemci içerisinde `baseUrl` olarak ayarlayın.
- JSON parse için `Newtonsoft.Json` (sunucu) ve Android tarafında uygun kütüphaneler kullanılmaktadır.
