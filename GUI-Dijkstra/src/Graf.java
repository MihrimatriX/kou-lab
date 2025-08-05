import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Graf {
    private int sayac = 1;
    private List<Dugum> dugums = new ArrayList<>();
    private List<Kenar> kenars = new ArrayList<>();

    private Dugum kaynak;
    private Dugum hedef;

    private boolean solved = false;

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setDugums(List<Dugum> dugums){
        this.dugums = dugums;
    }

    public List<Dugum> getDugums(){
        return dugums;
    }

    public void setKenars(List<Kenar> kenars){
        this.kenars = kenars;
    }

    public List<Kenar> getKenars(){
        return kenars;
    }

    public boolean dugumerisilebilirmi(Dugum dugum){   //Dugum erisilebilir mi kontrol eder
        for(Kenar kenar : kenars)
            if(dugum == kenar.getbirinci() || dugum == kenar.getikinci())
                return true;

        return false;
    }

    public void setKaynak(Dugum dugum){    //Kaynagi set eder
        if(dugums.contains(dugum))
            kaynak = dugum;
    }

    public void setHedef(Dugum dugum){    //Hedefi set eder
        if(dugums.contains(dugum))
            hedef = dugum;
    }

    public Dugum getKaynak(){
        return kaynak;
    }

    public Dugum getHedef(){
        return hedef;
    }

    public boolean kaynaksa(Dugum dugum){
        return dugum == kaynak;
    }

    public boolean hedefse(Dugum dugum){
        return dugum == hedef;
    }

    public void dugumekle(Point coord){   //Dugumleri koordinatina gore ekler
        Dugum dugum = new Dugum(coord);
        dugumekle(dugum);
    }

    public void dugumekle(Dugum dugum){
        dugum.setId(sayac++);
        dugums.add(dugum);
        if(dugum.getId()==1)
            kaynak = dugum;
    }

    public void kenarekle(Kenar new_kenar){  //Kenar ekler
        boolean eklendi = false;
        for(Kenar kenar : kenars){
            if(kenar.equals(new_kenar)){
                eklendi = true;
                break;
            }
        }
        if(!eklendi)
            kenars.add(new_kenar);
    }

    public void dugumsil(Dugum dugum){   //Dugum siler
        List<Kenar> delete = new ArrayList<>();
        for (Kenar kenar : kenars){
            if(kenar.hasNode(dugum)){
                delete.add(kenar);
            }
        }
        for (Kenar kenar : delete){
            kenars.remove(kenar);
        }
        dugums.remove(dugum);
    }

    public void temizle(){   //Ekrani bos konuma getirir
        sayac = 1;
        dugums.clear();
        kenars.clear();
        solved = false;

        kaynak = null;
        hedef = null;
    }

}
