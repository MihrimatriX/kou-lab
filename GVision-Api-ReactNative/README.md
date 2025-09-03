# React Native – Google Vision Nesne Bulucu

Kamera ile görüntü alıp Google Vision API üzerinden nesne tespiti yapan mobil uygulama.

## Gereksinimler
- Node.js 16+
- React Native CLI (veya Expo dev client)
- Android Studio / Xcode

## Kurulum
```bash
npm install
```

Android:
```bash
npx react-native run-android
```
iOS (macOS):
```bash
cd ios && pod install && cd ..
npx react-native run-ios
```

## Yapı
- `screens/CameraContainer.js`: Kamera akışı
- `screens/scan.js`: Tespit ekranı
- `config.json`: API yapılandırmaları
