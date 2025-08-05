package Tesseract;

import java.io.*;
import java.util.Scanner;

public class ParseIslem 
{
    public static String IsletmeAra(String line) {
        String s = line;
        String limit = "A.S.";
        if (s.indexOf(limit) == -1) 
        {
            return "0";
        }
        String token = s.substring(0, s.indexOf(limit));
         token = token.substring(token.lastIndexOf("\n")+1, token.length());
        token = token + limit;
        return token;
    }

    public static String TarihAra(String line) {
        String s = line;
        String delimiter = "Tarih ";
        if (s.indexOf(delimiter) == -1) 
        {
            return "0";
        }
        String token = s.substring(s.indexOf(delimiter), s.indexOf("\n",s.lastIndexOf(delimiter)));
        delimiter = ":";
        if (token.indexOf(delimiter) != -1) 
        {
            s = token.substring(token.indexOf(delimiter) +2, token.length());
            return s;
        }
        return token;
    }

    public static String MiktarAra(String line) {
        String s = line;
        String delimiter = " x ";
        if (line.indexOf(" x ") != -1) 
        { // Adetli deger
            if (line.indexOf("/") != -1) 
            { //tl/kg deger
                String token = s.substring(0, s.indexOf(delimiter));
                return token;
            }
            else
            {
                //System.out.println("gottem");
                String addett = s.substring(0, s.indexOf(delimiter));
                String adet = addett.replaceAll("[^0-9]", "");
                return adet;
            }
        }
        return "1";
    }

    public static String UrunAra(String line) {
        String s = line;
        String delimiter = "%";
        if (line.indexOf(delimiter) == -1) //KDVli satir, ornegin urun adi-urun kdvsi-urun fiyati
        {
            s = s.concat("?");
            return s;
        }
        
        return "%08";
    }

    public static String FisNoAra(String line) {
        String s = line;
        String delimiter = "FIS NO";
        if (s.indexOf(delimiter) == -1) 
        {
            return "0";
        }
        String token = s.substring(s.lastIndexOf(delimiter), s.length());
        delimiter = ":";
        if (token.indexOf(delimiter) != -1) 
        {
            s = token.substring(token.lastIndexOf(delimiter) + 2, token.indexOf("\n",token.lastIndexOf(delimiter)));
            return s;
        }
        return token;
    }

    public static String ToplamAra(String line) {
        String s = line;
        String limit = "TOPLAM";
        if (s.indexOf(limit) == -1) 
        {
            return "0";
        }
        String token = s.substring(s.lastIndexOf(limit) + 6, s.indexOf("\n",s.lastIndexOf(limit)));
        token = token.replaceAll(" ", "");
        return token;
    }
}
