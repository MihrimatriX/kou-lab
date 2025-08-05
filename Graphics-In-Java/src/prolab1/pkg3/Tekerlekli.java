package prolab1.pkg3;


public class Tekerlekli extends GezginRobotlar {
    private int tekerlek_sayisi;
    double engel_suresi = 0.0;
    
    public Tekerlekli(){
        gezinme_hizi = 20;
    }
    public Tekerlekli(int motor_sayisi,int yuk_miktari,String robot_tipi){
        super(motor_sayisi,yuk_miktari,robot_tipi);
        gezinme_hizi = 20;
    }    

    public double EngelGecmeSuresiBul(int motor_sayisi){
        engel_suresi += (motor_sayisi * 0.5);
        return engel_suresi;
    }
    
    
    public int getTekerlek_sayisi() {
        return tekerlek_sayisi;
    }

    
    public void setTekerlek_sayisi(int tekerlek_sayisi) {
        this.tekerlek_sayisi = tekerlek_sayisi;
    }
    
}