package prolab1.pkg3;


public class Seri implements ManipulatorRobotlar {

    private int motor_sayisi,yuk_miktari,kapasite,kol_uzunlugu,tasima_hizi;
    private String robot_tipi;
    
    
    public Seri(){
        
    }
    public Seri(int motor_sayisi,int yuk_miktari,String robot_tipi,int kapasite,int kol_uzunlugu,int tasima_hizi){
        this.motor_sayisi = motor_sayisi;
        this.yuk_miktari = yuk_miktari;
        this.robot_tipi = robot_tipi;
        this.kapasite = kapasite;
        this.kol_uzunlugu = kol_uzunlugu;
        this.tasima_hizi = tasima_hizi;
    }


    @Override
    public int getMotor_sayisi() {
        return motor_sayisi;
    }

    
    @Override
    public void setMotor_sayisi(int motor_sayisi) {
        this.motor_sayisi = motor_sayisi;
    }

    
    @Override
    public int getYuk_miktari() {
        return yuk_miktari;
    }

    
    @Override
    public void setYuk_miktari(int yuk_miktari) {
        this.yuk_miktari = yuk_miktari;
    }

    
    @Override
    public String getRobot_tipi() {
        return robot_tipi;
    }

    
    @Override
    public void setRobot_tipi(String robot_tipi) {
        this.robot_tipi = robot_tipi;
    }

    
    public int getKol_uzunlugu() {
        return kol_uzunlugu;
    }

    
    public void setKol_uzunlugu(int kol_uzunlugu) {
        this.kol_uzunlugu = kol_uzunlugu;
    }

    
    public int getTasima_hizi() {
        return tasima_hizi;
    }

    
    public void setTasima_hizi(int tasima_hizi) {
        this.tasima_hizi = tasima_hizi;
    }

    
    public int getKapasite() {
        return kapasite;
    }

    
    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }    
}