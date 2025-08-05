package prolab1.pkg3;


public abstract class GezginRobotlar implements Robot{
    private int motor_sayisi,yuk_miktari;
    private String robot_tipi;
    int gezinme_hizi;
    
    
    public GezginRobotlar(){
        
    }
    
    public GezginRobotlar(int motor_sayisi,int yuk_miktari,String robot_tipi){
        this.motor_sayisi = motor_sayisi;
        this.yuk_miktari = yuk_miktari;
        this.robot_tipi = robot_tipi;
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

    
    public int getGezinme_hizi() {
        return gezinme_hizi;
    }

    
    public void setGezinme_hizi(int gezinme_hizi) {
        if(getRobot_tipi().equalsIgnoreCase("spider")){
        this.gezinme_hizi = gezinme_hizi;
        }
        else if(getRobot_tipi().equalsIgnoreCase("tekerlekli") && gezinme_hizi<=30){
        this.gezinme_hizi = gezinme_hizi;
        }
        else if(getRobot_tipi().equalsIgnoreCase("paletli") && gezinme_hizi<=20){
        this.gezinme_hizi = gezinme_hizi;   
        }
        else if(getRobot_tipi().equalsIgnoreCase("hibrit")){
        this.gezinme_hizi = gezinme_hizi;
        }
        else{
        this.gezinme_hizi = 0;
        }
    }
}