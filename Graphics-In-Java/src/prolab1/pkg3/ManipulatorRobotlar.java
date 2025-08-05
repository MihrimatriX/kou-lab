package prolab1.pkg3;


public interface ManipulatorRobotlar extends Robot {
    public int getMotor_sayisi();
    public void setMotor_sayisi(int motor_sayisi);
    public int getYuk_miktari();
    public void setYuk_miktari(int yuk_miktari);
    public String getRobot_tipi();
    public void setRobot_tipi(String robot_tipi);
    public int getKapasite();
    public void setKapasite(int kapasite);
    public int getKol_uzunlugu();
    public void setKol_uzunlugu(int kol_uzunlugu);
    public int getTasima_hizi();
    public void setTasima_hizi(int tasima_hizi);
}