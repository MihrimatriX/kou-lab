@echo off
echo Yemek Kitabi Uygulamasi Baslatiliyor...
echo.

REM Java versiyonunu kontrol et
java -version >nul 2>&1
if errorlevel 1 (
    echo HATA: Java bulunamadi! Java 17 veya uzeri yukleyin.
    pause
    exit /b 1
)

REM Maven wrapper ile projeyi calistir
echo Maven ile proje derleniyor ve calistiriliyor...
call mvnw.cmd clean javafx:run

if errorlevel 1 (
    echo.
    echo HATA: Proje calistirilirken hata olustu!
    echo Lütfen README.md dosyasini kontrol edin.
    pause
    exit /b 1
)

pause 