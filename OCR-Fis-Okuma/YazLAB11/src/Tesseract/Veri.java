package Tesseract;

public class Veri
{
    private int fisNo;
    private String companyName;
    private String tarih;
    private String toplamFiyat;
    private String UrunKDVFiyat;

    public Veri(int fisNo, String companyName, String tarih, String UrunKDVFiyat, String toplamFiyat) {
        this.fisNo = fisNo;
        this.companyName = companyName;
        this.tarih = tarih;
        this.toplamFiyat = toplamFiyat;
        this.UrunKDVFiyat = UrunKDVFiyat;
    }

    public String getUrunKDVFiyat() {
        return UrunKDVFiyat;
    }

    public void setUrunKDVFiyat(String UrunKDVFiyat) {
        this.UrunKDVFiyat = UrunKDVFiyat;
    }

    public String getToplamFiyat() {
        return toplamFiyat;
    }

    public void setToplamFiyat(String toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }

    public int getFisNo() {
        return fisNo;
    }

    public void setFisNo(int fisNo) {
        this.fisNo = fisNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
}