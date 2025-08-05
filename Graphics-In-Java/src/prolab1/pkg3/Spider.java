package prolab1.pkg3;


public class Spider extends GezginRobotlar {
    
    private int bacak_sayisi;
    
    public Spider(){
        gezinme_hizi = 30;
    }
    public Spider(int motor_sayisi,int yuk_miktari,String robot_tipi){
        super(motor_sayisi,yuk_miktari,robot_tipi);
        gezinme_hizi = 30;
    }

    
    public int getBacak_sayisi() {
        return bacak_sayisi;
    }

    
    public void setBacak_sayisi(int bacak_sayisi) {
        this.bacak_sayisi = bacak_sayisi;
    }
    
    
    
}