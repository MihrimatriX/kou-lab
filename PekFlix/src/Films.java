import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Films
{
    private SimpleIntegerProperty   puani;//+
    private SimpleStringProperty    adi;//+
    private SimpleStringProperty    tipi;//+
    private SimpleStringProperty    tur;//+
    private SimpleIntegerProperty   bSayi;//+
    private SimpleIntegerProperty   sure;//+
    private SimpleIntegerProperty   kalan;//+
    private SimpleStringProperty   izledim;//+

    public IntegerProperty  puaniProperty(){return puani;    }
    public StringProperty     adiProperty(){return adi;      }
    public StringProperty    tipiProperty(){return tipi;     }
    public StringProperty     turProperty(){return tur;      }
    public IntegerProperty  bSayiProperty(){return bSayi;    }
    public IntegerProperty   sureProperty(){return sure;     }
    public IntegerProperty  kalanProperty(){return kalan;    }
    public StringProperty izledimProperty(){return izledim;  }

    public Films(String adi, String tipi, String tur, int sure, int bSayi, int puani, int kalan, String izledim) {
        this.puani  = new SimpleIntegerProperty(puani);
        this.adi    = new SimpleStringProperty(adi);
        this.tipi   = new SimpleStringProperty(tipi);
        this.tur    = new SimpleStringProperty(tur);
        this.bSayi  = new SimpleIntegerProperty(bSayi);
        this.sure   = new SimpleIntegerProperty(sure);
        this.kalan  = new SimpleIntegerProperty(kalan);
        this.izledim= new SimpleStringProperty(izledim);
    }

    public int getPuani() {
        return puani.get();
    }
    public int getKalan() {
        return kalan.get();
    }

    public void setPuani(int puani) {
        this.puani = new SimpleIntegerProperty(puani);
    }
    public void setKalan(int kalan) {
        this.kalan = new SimpleIntegerProperty(kalan);
    }

    public String getAdi() {
        return adi.get();
    }
    public String getIzledim() {
        return izledim.get();
    }

    public void setAdi(String adi) {
        this.adi = new SimpleStringProperty(adi);
    }
    public void setIzledim(String izledim) {
        this.izledim = new SimpleStringProperty(izledim);
    }

    public String getTipi() {
        return tipi.get();
    }
    public void setTipi(String tipi) {
        this.tipi = new SimpleStringProperty(tipi);
    }

    public String getTur() {
        return tur.get();
    }
    public void setTur(String tur) {
        this.tur = new SimpleStringProperty(tur);
    }

    public int getbSayi() {
        return bSayi.get();
    }
    public void setbSayi(int bSayi) {
        this.bSayi = new SimpleIntegerProperty(bSayi);
    }

    public int getSure() {
        return sure.get();
    }
    public void setSure(int sure) {
        this.sure = new SimpleIntegerProperty(sure);
    }
}