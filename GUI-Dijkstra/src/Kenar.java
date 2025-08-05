public class Kenar {
    private Dugum birinci;
    private Dugum ikinci;
    private int agirlik = 1;

    public Kenar(Dugum birinci, Dugum ikinci){
        this.birinci = birinci;
        this.ikinci = ikinci;
    }

    public Dugum getbirinci(){
        return birinci;
    }

    public Dugum getikinci(){
        return ikinci;
    }

    public void setAgirlik(int agirlik){
        this.agirlik = agirlik;
    }

    public int getAgirlik(){
        return agirlik;
    }

    public boolean hasNode(Dugum dugum){
        return birinci == dugum || ikinci == dugum;
    }

    public boolean equals(Kenar kenar) {
        return (birinci == kenar.birinci && ikinci == kenar.ikinci) || (birinci == kenar.ikinci && ikinci == kenar.birinci) ;
    }

    @Override
    public String toString() {    //Kenar bilgilerini bastirir
        return "Kenar ~ "
                + getbirinci().getId() + " - "
                + getikinci().getId();
    }
}
