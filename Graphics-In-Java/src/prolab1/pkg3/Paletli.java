package prolab1.pkg3;


public class Paletli extends GezginRobotlar {
    
    private int palet_sayisi;
    double engel_suresi = 0.0;
    
    public Paletli(){
        gezinme_hizi = 10;
    }
    public Paletli(int motor_sayisi,int yuk_miktari,String robot_tipi){
        super(motor_sayisi,yuk_miktari,robot_tipi);
        gezinme_hizi = 10;
    }

    public double EngelGecmeSuresiBul(int motor_sayisi){
        engel_suresi += (motor_sayisi * 3.0);
        return engel_suresi;
    }
    
    
    public int getPalet_sayisi() {
        return palet_sayisi;
    }

    
    public void setPalet_sayisi(int palet_sayisi) {
        this.palet_sayisi = palet_sayisi;
    }
    
}