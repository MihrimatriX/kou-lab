package data;

import static helpers.Artist.DrawQuadTex;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import okulister.Karakter;

public class TileGrid {

    public Tile[][] map;
    BufferedReader reader;

    public ArrayList karakterOku() throws IOException {

        ArrayList<Karakter> kotu = new ArrayList();

        String line[] = null;
        String line2[] = null;
        String line3[] = null;
        int x = 0, y = 0;

        File file = new File("C:\\Users\\AFU\\Desktop\\DEV\\Software\\Netbeans\\SmurfMaze\\src\\res\\harita.txt");
        BufferedReader bf = null;
        bf = new BufferedReader(new FileReader(file));
        String satir = bf.readLine();

        while (satir != null) {

            line = satir.split(",");

            if (line.length > 1) {
                line2 = line[0].split(":");
                line3 = line[1].split(":");

                if (line3[1].equals("A")) {
                    x = 50;
                    y = 50 + 50 * 5;
                } else if (line3[1].equals("B")) {
                    x = 50 + 50 * 4;
                    y = 50;
                } else if (line3[1].equals("C")) {
                    x = 50 + 50 * 12;
                    y = 50;
                } else if (line3[1].equals("D")) {
                    x = 50 + 50 * 13;
                    y = 50 + 50 * 5;
                } else if (line3[1].equals("E")) {
                    x = 50 + 50 * 4;
                    y = 50 + 50 * 10;
                }
/*
                if (line2[1].equalsIgnoreCase("DarthVader")) {
                    DarthVader k = new DarthVader(line2[1], "kotu", x, y);
                    kotu.add(k);
                } else if (line2[1].equalsIgnoreCase("Kylo Ren")) {
                    KyloRen k1 = new KyloRen(line2[1], "kotu", x, y);
                    kotu.add(k1);
                } else if (line2[1].equalsIgnoreCase("stormtrooper")) {
                    Stormtrooper k2 = new Stormtrooper(line2[1], "kotu", x, y);
                    kotu.add(k2);
                }
*/
            }
            satir = bf.readLine();

        }
        bf.close();

        return kotu;
    }

    public static int[][] matrisOku() throws IOException {
        int matris[][] = new int[13][11];

        for (int k = 0; k < 13; k++) {
            for (int l = 0; l < 11; l++) {
                matris[k][l] = 0;
            }
        }

        File file = new File("C:\\Users\\AFU\\Desktop\\DEV\\Software\\Netbeans\\SmurfMaze\\src\\res\\harita.txt");
        BufferedReader bf = null;
        bf = new BufferedReader(new FileReader(file));
        String satir = bf.readLine();

        String line[] = null;
        int sayac = 0;
        while (satir != null) {

            line = satir.split("\t");

            if (line[0].equals("1") || line[0].equals("0") && sayac < 11) {
                System.out.println(sayac);
                for (int i = 0; i < line.length; i++) {
                    matris[i][sayac] = Integer.valueOf(line[i]);
                }

                sayac++;
            }

            satir = bf.readLine();
        }
        bf.close();
        return matris;
    }

   public void setTile(int xCoor, int yCoor, TileType type) throws IOException
   {
       map[xCoor][yCoor] = new Tile(xCoor*64, yCoor*64, 64, 64, type);
   }
   
   public Tile getTile(int xCoor, int yCoor)
   {
       return map[xCoor][yCoor];
   }
    
    public TileGrid(int[][] newMap) throws IOException {
        map = new Tile[13][11];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (newMap[i][j] == 0) 
                {
                     map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Duvar);
                }
                else{
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Yol);
                }
                
            }
        }
    }

    public TileGrid() throws IOException {
        map = new Tile[13][11];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Duvar);
            }
        }
    }

    public void Draw() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Tile t = map[i][j];
                DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeigth());
            }
        }
    }
}
