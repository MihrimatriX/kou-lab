# Yemek Kitabi Uygulamasi PowerShell Script
Write-Host "Yemek Kitabi Uygulamasi Baslatiliyor..." -ForegroundColor Green
Write-Host ""

# Java versiyonunu kontrol et
try {
    $javaVersion = java -version 2>&1 | Select-String "version"
    Write-Host "Java Versiyonu: $javaVersion" -ForegroundColor Yellow
} catch {
    Write-Host "HATA: Java bulunamadi! Java 17 veya uzeri yukleyin." -ForegroundColor Red
    Read-Host "Devam etmek icin bir tusa basin"
    exit 1
}

# JAVA_HOME ayarla (eğer tanımlı değilse)
if (-not $env:JAVA_HOME) {
    $possibleJavaPaths = @(
        "C:\Program Files\Java\jdk-17",
        "C:\Program Files\Java\jdk-17.0.5",
        "C:\Program Files\Eclipse Adoptium\jdk-17.0.5-hotspot",
        "C:\Program Files\OpenJDK\jdk-17"
    )
    
    foreach ($path in $possibleJavaPaths) {
        if (Test-Path $path) {
            $env:JAVA_HOME = $path
            Write-Host "JAVA_HOME ayarlandi: $path" -ForegroundColor Yellow
            break
        }
    }
    
    if (-not $env:JAVA_HOME) {
        Write-Host "UYARI: JAVA_HOME otomatik olarak bulunamadi." -ForegroundColor Yellow
        Write-Host "Lutfen JAVA_HOME environment variable'ini manuel olarak ayarlayin." -ForegroundColor Yellow
    }
}

# Maven wrapper ile projeyi calistir
Write-Host "Maven ile proje derleniyor ve calistiriliyor..." -ForegroundColor Cyan

try {
    if (Test-Path "mvnw.cmd") {
        & .\mvnw.cmd clean javafx:run
    } else {
        Write-Host "HATA: Maven wrapper bulunamadi!" -ForegroundColor Red
        Write-Host "Lutfen projeyi IDE ile acin (IntelliJ IDEA veya Eclipse)" -ForegroundColor Yellow
    }
} catch {
    Write-Host "HATA: Proje calistirilirken hata olustu!" -ForegroundColor Red
    Write-Host "Lutfen README.md dosyasini kontrol edin." -ForegroundColor Yellow
}

Write-Host ""
Write-Host "Script tamamlandi." -ForegroundColor Green
Read-Host "Devam etmek icin bir tusa basin" 