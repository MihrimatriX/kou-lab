package com.alumation.maze;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JComboBox;

/**
 * PathFinding sınıfı, A* algoritması kullanarak labirent çözme uygulamasını yönetir.
 * Kullanıcı arayüzü ve algoritma mantığını içerir.
 */
public class PathFinding {

    // GUI Bileşenleri
    private JFrame frame;
    private JPanel toolP;
    private Map canvas;
    
    // Temel değişkenler
    private int cells = 20;
    private int delay = 30;
    private double dense = .5;
    private double density = (cells * cells) * .5;
    private int startx = -1;
    private int starty = -1;
    private int finishx = -1;
    private int finishy = -1;
    private int tool = 0;
    private int checks = 0;
    private int length = 0;
    private int curAlg = 0;
    private int WIDTH = 850;
    private final int HEIGHT = 650;
    private final int MSIZE = 600;
    private int CSIZE = MSIZE / cells;
    
    // Yardımcı diziler
    private String[] algorithms = {"A*"};
    private String[] tools = {"Start", "Finish", "Wall", "Eraser"};
    
    // Durum değişkenleri
    private boolean solving = false;
    
    // Yardımcı nesneler
    private Node[][] map;
    private Algorithm Alg = new Algorithm();
    private Random r = new Random();
    
    // GUI Kontrolleri
    private JSlider size = new JSlider(1, 5, 2);
    private JSlider speed = new JSlider(0, 500, delay);
    private JSlider obstacles = new JSlider(1, 100, 50);
    
    // Etiketler
    private JLabel algL = new JLabel("Algorithm");
    private JLabel toolL = new JLabel("Toolbox");
    private JLabel sizeL = new JLabel("Size:");
    private JLabel cellsL = new JLabel(cells + "x" + cells);
    private JLabel delayL = new JLabel("Delay:");
    private JLabel msL = new JLabel(delay + "ms");
    private JLabel obstacleL = new JLabel("Dens:");
    private JLabel densityL = new JLabel(obstacles.getValue() + "%");
    private JLabel checkL = new JLabel("Checks: " + checks);
    private JLabel lengthL = new JLabel("Path Length: " + length);
    
    // Butonlar
    private JButton searchB = new JButton("Start Search");
    private JButton resetB = new JButton("Reset");
    private JButton genMapB = new JButton("Generate Map");
    private JButton clearMapB = new JButton("Clear Map");
    private JButton creditB = new JButton("Credit");
    
    // Açılır menüler
    private JComboBox<String> algorithmsBx = new JComboBox<>(algorithms);
    private JComboBox<String> toolBx = new JComboBox<>(tools);
    
    // Kenarlık
    private Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

    public static void main(String[] args) {   
        new PathFinding();
    }

    public PathFinding() {
        clearMap();
        initialize();
    }

    public void generateMap() { 
        clearMap();    
        for (int i = 0; i < density; i++) {
            Node current;
            do {
                int x = r.nextInt(cells);
                int y = r.nextInt(cells);
                current = map[x][y];    
            } while (current.getType() == 2);  
            current.setType(2);    
        }
    }

    public void clearMap() {
        finishx = -1;   
        finishy = -1;
        startx = -1;
        starty = -1;
        map = new Node[cells][cells];  
        for (int x = 0; x < cells; x++) {
            for (int y = 0; y < cells; y++) {
                map[x][y] = new Node(3, x, y);   
            }
        }
        reset();   
    }

    public void resetMap() { 
        for (int x = 0; x < cells; x++) {
            for (int y = 0; y < cells; y++) {
                Node current = map[x][y];
                if (current.getType() == 4 || current.getType() == 5)  
                    map[x][y] = new Node(3, x, y);  
            }
        }
        if (startx > -1 && starty > -1) {
            map[startx][starty] = new Node(0, startx, starty);
            map[startx][starty].setHops(0);
        }
        if (finishx > -1 && finishy > -1)
            map[finishx][finishy] = new Node(1, finishx, finishy);
        reset();
    }

    private void initialize() { 
        frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle("Path Finding");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // toolP'yi başlat
        toolP = new JPanel();
        toolP.setBorder(BorderFactory.createTitledBorder(loweredetched, "Controls"));
        int space = 25;
        int buff = 45;

        toolP.setLayout(null);
        toolP.setBounds(10, 10, 210, 600);

        searchB.setBounds(40, space, 120, 25);
        toolP.add(searchB);
        space += buff;

        resetB.setBounds(40, space, 120, 25);
        toolP.add(resetB);
        space += buff;

        genMapB.setBounds(40, space, 120, 25);
        toolP.add(genMapB);
        space += buff;

        clearMapB.setBounds(40, space, 120, 25);
        toolP.add(clearMapB);
        space += 40;

        algL.setBounds(40, space, 120, 25);
        toolP.add(algL);
        space += 25;

        algorithmsBx.setBounds(40, space, 120, 25);
        toolP.add(algorithmsBx);
        space += 40;

        toolL.setBounds(40, space, 120, 25);
        toolP.add(toolL);
        space += 25;

        toolBx.setBounds(40, space, 120, 25);
        toolP.add(toolBx);
        space += buff;

        sizeL.setBounds(15, space, 40, 25);
        toolP.add(sizeL);
        size.setMajorTickSpacing(10);
        size.setBounds(50, space, 100, 25);
        toolP.add(size);
        cellsL.setBounds(160, space, 40, 25);
        toolP.add(cellsL);
        space += buff;

        delayL.setBounds(15, space, 50, 25);
        toolP.add(delayL);
        speed.setMajorTickSpacing(5);
        speed.setBounds(50, space, 100, 25);
        toolP.add(speed);
        msL.setBounds(160, space, 40, 25);
        toolP.add(msL);
        space += buff;

        obstacleL.setBounds(15, space, 100, 25);
        toolP.add(obstacleL);
        obstacles.setMajorTickSpacing(5);
        obstacles.setBounds(50, space, 100, 25);
        toolP.add(obstacles);
        densityL.setBounds(160, space, 100, 25);
        toolP.add(densityL);
        space += buff;

        checkL.setBounds(15, space, 100, 25);
        toolP.add(checkL);
        space += buff;

        lengthL.setBounds(15, space, 100, 25);
        toolP.add(lengthL);
        space += buff;

        creditB.setBounds(40, space, 120, 25);
        toolP.add(creditB);

        frame.getContentPane().add(toolP);

        canvas = new Map();
        canvas.setBounds(230, 10, MSIZE + 1, MSIZE + 1);
        frame.getContentPane().add(canvas);

        searchB.addActionListener(e -> {
            reset();
            if ((startx > -1 && starty > -1) && (finishx > -1 && finishy > -1))
                solving = true;
        });

        resetB.addActionListener(e -> {
            resetMap();
            Update();
        });

        genMapB.addActionListener(e -> {
            generateMap();
            Update();
        });

        clearMapB.addActionListener(e -> {
            clearMap();
            Update();
        });

        algorithmsBx.addItemListener(e -> {
            curAlg = algorithmsBx.getSelectedIndex();
            Update();
        });

        toolBx.addItemListener(e -> tool = toolBx.getSelectedIndex());

        size.addChangeListener(e -> {
            cells = size.getValue() * 10;
            clearMap();
            reset();
            Update();
        });

        speed.addChangeListener(e -> {
            delay = speed.getValue();
            Update();
        });

        obstacles.addChangeListener(e -> {
            dense = (double) obstacles.getValue() / 100;
            Update();
        });

        creditB.addActionListener(e -> 
            JOptionPane.showMessageDialog(frame,
                "                          Koü Prolab\n" +
                "          Build Date:  March 25, 2018   ", 
                "Credit", 
                JOptionPane.PLAIN_MESSAGE, 
                new ImageIcon("")
            )
        );

        startSearch();
    }

    public void startSearch() {
        if (solving) {
            switch (curAlg) {
                case 0:
                    Alg.AStar();
                    break;
            }
        }
        pause();
    }

    public void pause() {
        int i = 0;
        while (!solving) {
            i++;
            if (i > 500)
                i = 0;
            try {
                Thread.sleep(1);
            } catch (Exception ignored) {}
        }
        startSearch();
    }

    public void Update() {
        density = (cells * cells) * dense;
        CSIZE = MSIZE / cells;
        canvas.repaint();
        cellsL.setText(cells + "x" + cells);
        msL.setText(delay + "ms");
        lengthL.setText("Path Length: " + length);
        densityL.setText(obstacles.getValue() + "%");
        checkL.setText("Checks: " + checks);
    }

    public void reset() { 
        solving = false;
        length = 0;
        checks = 0;
    }

    public void delay() {   
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
        }
    }

    /**
     * Map sınıfı, labirentin görsel temsilini ve kullanıcı etkileşimini yönetir.
     * JPanel'den türetilmiş ve fare olaylarını dinleyen bir sınıftır.
     */
    class Map extends JPanel implements MouseListener, MouseMotionListener {
        /**
         * Map sınıfının yapıcı metodu.
         * Fare dinleyicilerini ekler.
         */
        public Map() {
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        /**
         * Labirenti çizer.
         * Her bir düğümün tipine göre farklı renkler kullanır.
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            for (int x = 0; x < cells; x++) {
                for (int y = 0; y < cells; y++) {
                    drawNode(g, x, y, map[x][y].getType());
                }
            }
        }

        /**
         * Verilen koordinatlardaki düğümü çizer.
         * @param g Grafik bağlamı
         * @param x X koordinatı
         * @param y Y koordinatı
         * @param type Düğüm tipi
         */
        private void drawNode(Graphics g, int x, int y, int type) {
            g.setColor(getNodeColor(type));
            g.fillRect(x * CSIZE, y * CSIZE, CSIZE, CSIZE);
            g.setColor(Color.BLACK);
            g.drawRect(x * CSIZE, y * CSIZE, CSIZE, CSIZE);
        }

        /**
         * Düğüm tipine göre renk döndürür.
         * @param type Düğüm tipi
         * @return Düğüm rengi
         */
        private Color getNodeColor(int type) {
            return switch (type) {
                case 0 -> Color.GREEN;  // Başlangıç
                case 1 -> Color.RED;    // Bitiş
                case 2 -> Color.BLACK;  // Duvar
                case 3 -> Color.WHITE;  // Boş
                case 4 -> Color.CYAN;   // Kontrol edildi
                case 5 -> Color.YELLOW; // Final yol
                default -> Color.WHITE;
            };
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            try {
                int x = e.getX() / CSIZE;
                int y = e.getY() / CSIZE;
                Node current = map[x][y];
                
                if ((tool == 2 || tool == 3) && (current.getType() != 0 && current.getType() != 1)) {
                    current.setType(tool);
                }
                Update();
            } catch (Exception ignored) {}
        }

        @Override
        public void mouseMoved(MouseEvent e) {}

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {
            resetMap();
            try {
                int x = e.getX() / CSIZE;
                int y = e.getY() / CSIZE;
                Node current = map[x][y];
                
                switch (tool) {
                    case 0 -> handleStartNode(current, x, y);
                    case 1 -> handleFinishNode(current, x, y);
                    default -> {
                        if (current.getType() != 0 && current.getType() != 1) {
                            current.setType(tool);
                        }
                    }
                }
                Update();
            } catch (Exception ignored) {}
        }

        /**
         * Başlangıç düğümünü işler.
         */
        private void handleStartNode(Node current, int x, int y) {
            if (current.getType() != 2) {
                if (startx > -1 && starty > -1) {
                    map[startx][starty].setType(3);
                    map[startx][starty].setHops(-1);
                }
                current.setHops(0);
                startx = x;
                starty = y;
                current.setType(0);
            }
        }

        /**
         * Bitiş düğümünü işler.
         */
        private void handleFinishNode(Node current, int x, int y) {
            if (current.getType() != 2) {
                if (finishx > -1 && finishy > -1) {
                    map[finishx][finishy].setType(3);
                }
                finishx = x;
                finishy = y;
                current.setType(1);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {}
    }

    /**
     * Algorithm sınıfı, A* algoritmasının implementasyonunu içerir.
     * Labirent çözme mantığını ve yol bulma işlemlerini yönetir.
     */
    class Algorithm {
        /**
         * A* algoritmasını çalıştırır.
         * Başlangıç noktasından bitiş noktasına en kısa yolu bulur.
         */
        public void AStar() {
            ArrayList<Node> priority = new ArrayList<>();
            priority.add(map[startx][starty]);
            
            while (solving) {
                if (priority.isEmpty()) {
                    solving = false;
                    break;
                }
                
                int hops = priority.get(0).getHops() + 1;
                ArrayList<Node> explored = exploreNeighbors(priority.get(0), hops);
                
                if (!explored.isEmpty()) {
                    priority.remove(0);
                    priority.addAll(explored);
                    Update();
                    delay();
                } else {
                    priority.remove(0);
                }
                
                sortQue(priority);
            }
        }

        /**
         * Öncelik kuyruğunu sıralar.
         * A* algoritması için f(n) = g(n) + h(n) değerine göre sıralama yapar.
         * @param sort Sıralanacak düğüm listesi
         * @return Sıralanmış düğüm listesi
         */
        public ArrayList<Node> sortQue(ArrayList<Node> sort) {
            for (int c = 0; c < sort.size(); c++) {
                int sm = c;
                for (int i = c + 1; i < sort.size(); i++) {
                    if (sort.get(i).getEuclidDist() + sort.get(i).getHops() < 
                        sort.get(sm).getEuclidDist() + sort.get(sm).getHops()) {
                        sm = i;
                    }
                }
                if (c != sm) {
                    Node temp = sort.get(c);
                    sort.set(c, sort.get(sm));
                    sort.set(sm, temp);
                }
            }
            return sort;
        }

        /**
         * Verilen düğümün komşularını keşfeder.
         * @param current Mevcut düğüm
         * @param hops Başlangıçtan itibaren atılan adım sayısı
         * @return Keşfedilen komşu düğümlerin listesi
         */
        public ArrayList<Node> exploreNeighbors(Node current, int hops) {
            ArrayList<Node> explored = new ArrayList<>();
            
            for (int a = -1; a <= 1; a++) {
                for (int b = -1; b <= 1; b++) {
                    int xbound = current.getX() + a;
                    int ybound = current.getY() + b;
                    
                    if (isValidPosition(xbound, ybound)) {
                        Node neighbor = map[xbound][ybound];
                        if (isValidNeighbor(neighbor, hops)) {
                            explore(neighbor, current.getX(), current.getY(), hops);
                            explored.add(neighbor);
                        }
                    }
                }
            }
            return explored;
        }

        /**
         * Verilen koordinatların geçerli olup olmadığını kontrol eder.
         */
        private boolean isValidPosition(int x, int y) {
            return (x > -1 && x < cells) && (y > -1 && y < cells);
        }

        /**
         * Komşu düğümün geçerli olup olmadığını kontrol eder.
         */
        private boolean isValidNeighbor(Node neighbor, int hops) {
            return (neighbor.getHops() == -1 || neighbor.getHops() > hops) && neighbor.getType() != 2;
        }

        /**
         * Bir düğümü keşfeder ve gerekli işlemleri yapar.
         * @param current Keşfedilecek düğüm
         * @param lastx Önceki düğümün x koordinatı
         * @param lasty Önceki düğümün y koordinatı
         * @param hops Başlangıçtan itibaren atılan adım sayısı
         */
        public void explore(Node current, int lastx, int lasty, int hops) {
            if (current.getType() != 0 && current.getType() != 1) {
                current.setType(4);
            }
            current.setLastNode(lastx, lasty);
            current.setHops(hops);
            checks++;
            
            if (current.getType() == 1) {
                backtrack(current.getLastX(), current.getLastY(), hops);
            }
        }

        /**
         * Bitiş noktasından başlangıç noktasına doğru geri izleme yapar.
         * @param lx Başlangıç x koordinatı
         * @param ly Başlangıç y koordinatı
         * @param hops Toplam adım sayısı
         */
        public void backtrack(int lx, int ly, int hops) {
            length = hops;
            while (hops > 1) {
                Node current = map[lx][ly];
                current.setType(5);
                lx = current.getLastX();
                ly = current.getLastY();
                hops--;
            }
            solving = false;
        }
    }

    /**
     * Node sınıfı, labirentteki her bir hücreyi temsil eder.
     * Her düğüm, konumu, tipi ve A* algoritması için gerekli bilgileri içerir.
     */
    class Node {
        /**
         * Düğüm tipleri:
         * 0 = başlangıç
         * 1 = bitiş
         * 2 = duvar
         * 3 = boş
         * 4 = kontrol edildi
         * 5 = final yol
         */
        private int cellType;
        private int hops;
        private final int x;
        private final int y;
        private int lastX;
        private int lastY;
        private double dToEnd = 0;

        /**
         * Yeni bir düğüm oluşturur
         * @param type Düğümün tipi
         * @param x X koordinatı
         * @param y Y koordinatı
         */
        public Node(int type, int x, int y) {
            this.cellType = type;
            this.x = x;
            this.y = y;
            this.hops = -1;
        }

        /**
         * Bitiş noktasına olan Öklid mesafesini hesaplar
         * @return Bitiş noktasına olan mesafe
         */
        public double getEuclidDist() {
            int xdif = Math.abs(x - finishx);
            int ydif = Math.abs(y - finishy);
            dToEnd = Math.sqrt((xdif * xdif) + (ydif * ydif));
            return dToEnd;
        }

        // Getter metodları
        public int getX() { return x; }
        public int getY() { return y; }
        public int getLastX() { return lastX; }
        public int getLastY() { return lastY; }
        public int getType() { return cellType; }
        public int getHops() { return hops; }

        // Setter metodları
        public void setType(int type) { this.cellType = type; }
        public void setLastNode(int x, int y) {
            this.lastX = x;
            this.lastY = y;
        }
        public void setHops(int hops) { this.hops = hops; }
    }
}