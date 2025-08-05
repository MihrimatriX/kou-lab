import java.util.*;

public class Dijkstra {
    private boolean guvenli = false;
    private String mesaj = null;

    private Graf graf;
    private Map<Dugum, Dugum> onculler;
    private Map<Dugum, Integer> mesafeler;

    private PriorityQueue<Dugum> ziyaretedilmeyen;
    private HashSet<Dugum> ziyaretedilen;

    public class dugumkarsilastir implements Comparator<Dugum>  {
        @Override
        public int compare(Dugum dugum1, Dugum dugum2) {
            return mesafeler.get(dugum1) - mesafeler.get(dugum2);
        }
    };

    public Dijkstra(Graf graf){
        this.graf = graf;
        onculler = new HashMap<>();
        mesafeler = new HashMap<>();

        for(Dugum dugum : graf.getDugums()){
            mesafeler.put(dugum, Integer.MAX_VALUE);
        }
        ziyaretedilen = new HashSet<>();

        guvenli = evaluate();
    }

    private boolean evaluate(){
        if(graf.getKaynak()==null){
            mesaj = "Kaynak grafta bulunmali";
            return false;
        }

        if(graf.getHedef()==null){
            mesaj = "Hedef grafta bulumali";
            return false;
        }

        for(Dugum dugum : graf.getDugums()){
            if(!graf.dugumerisilebilirmi(dugum)){
                mesaj = "Graf erisilemeyen dugumler icermektedir";
                return false;
            }
        }

        return true;
    }

    public void run() throws IllegalStateException {
        if(!guvenli) {
            throw new IllegalStateException(mesaj);
        }

        ziyaretedilmeyen = new PriorityQueue<>(graf.getDugums().size(), new dugumkarsilastir());

        Dugum source = graf.getKaynak();
        mesafeler.put(source, 0);
        ziyaretedilen.add(source);

        for (Kenar neighbor : getkomsu(source)){
            Dugum adjacent = getbitisik(neighbor, source);
            if(adjacent==null)
                continue;

            mesafeler.put(adjacent, neighbor.getAgirlik());
            onculler.put(adjacent, source);
            ziyaretedilmeyen.add(adjacent);
        }

        while (!ziyaretedilmeyen.isEmpty()){
            Dugum current = ziyaretedilmeyen.poll();

            mesafeguncelle(current);

            ziyaretedilmeyen.remove(current);
            ziyaretedilen.add(current);
        }

        for(Dugum dugum : graf.getDugums()) {
            dugum.setYol(getyol(dugum));
        }

        graf.setSolved(true);
        
    }

    private void mesafeguncelle(Dugum dugum){
        int mesafe = mesafeler.get(dugum);

        for (Kenar komsu : getkomsu(dugum)){
            Dugum bitisik = getbitisik(komsu, dugum);
            if(ziyaretedilen.contains(bitisik))
                continue;

            int suanki_mesafe = mesafeler.get(bitisik);
            int yeni_mesafe = mesafe + komsu.getAgirlik();

            if(yeni_mesafe < suanki_mesafe) {
                mesafeler.put(bitisik, yeni_mesafe);
                onculler.put(bitisik, dugum);
                ziyaretedilmeyen.add(bitisik);
            }
        }
    }

    private Dugum getbitisik(Kenar kenar, Dugum dugum) {
        if(kenar.getbirinci()!= dugum && kenar.getikinci()!= dugum)
            return null;

        return dugum == kenar.getikinci()? kenar.getbirinci(): kenar.getikinci();
    }

    private List<Kenar> getkomsu(Dugum dugum) {
        List<Kenar> komsular = new ArrayList<>();

        for(Kenar kenar : graf.getKenars()){
            if(kenar.getbirinci()== dugum || kenar.getikinci()== dugum)
                komsular.add(kenar);
        }

        return komsular;
    }

    public Integer gethedefmesafesi(){
        return mesafeler.get(graf.getHedef());
    }

    public Integer getmesafe(Dugum dugum){
        return mesafeler.get(dugum);
    }

    public List<Dugum> gethedefyolu() {
        return getyol(graf.getHedef());
    }

    public List<Dugum> getyol(Dugum dugum){
        List<Dugum> yol = new ArrayList<>();

        Dugum suanki = dugum;
        yol.add(suanki);
        while (suanki!= graf.getKaynak()){
            suanki = onculler.get(suanki);
            yol.add(suanki);
        }

        Collections.reverse(yol);

        return yol;
    }

}
