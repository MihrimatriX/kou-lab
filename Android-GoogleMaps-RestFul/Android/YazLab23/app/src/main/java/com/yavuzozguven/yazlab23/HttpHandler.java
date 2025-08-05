package com.yavuzozguven.yazlab23;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class HttpHandler {

    public ArrayList<Kullanicilar> makeServiceCallKullanici(String requestURL){
        String response = null;
        ArrayList<Kullanicilar> kullanicilar= new ArrayList<Kullanicilar>();
        try{
            URL url = new URL(requestURL);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            InputStream is = new BufferedInputStream(connection.getInputStream());
            response = convertStreamToString(is);
            JSONArray ja = new JSONArray(response);
            for (int i = 0;i<ja.length();i++){
                JSONObject jo = (JSONObject) ja.get(i);
                Kullanicilar kullanici = new Kullanicilar();
                kullanici.setKullaniciAd(""+jo.get("KullaniciAdi"));
                kullanici.setKullaniciSifre(""+jo.get("Kullanicisifre"));
                kullanicilar.add(kullanici);
            }
        }
        catch (Exception e){

        }
        return kullanicilar;
    }

    public ArrayList<Kampanyalar> MakeServiceCallKampanya(String requestURL){
        String response = null;
        ArrayList<Kampanyalar> kampanyalar= new ArrayList<Kampanyalar>();
        try{
            URL url = new URL(requestURL);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            InputStream is = new BufferedInputStream(connection.getInputStream());
            response = convertStreamToString(is);
            JSONArray ja = new JSONArray(response);
            for (int i = 0;i<ja.length();i++){
                JSONObject jo = (JSONObject) ja.get(i);
                Kampanyalar kampanya = new Kampanyalar();
                kampanya.setFirmaAdi(""+jo.get("FirmaAdi"));
                kampanya.setFirmaicerik(""+jo.get("KampanyaIcerik"));
                kampanya.setTarih(""+jo.get("KampanyaTarih"));
                kampanya.setTur(""+jo.get("Tur"));
                kampanya.setFirmaX(Integer.parseInt(""+jo.get("FirmaLokasyonX")));
                kampanya.setFirmaY(Integer.parseInt(""+jo.get("FirmaLokasyonY")));
                kampanya.setSure(Integer.parseInt(""+jo.get("KampanyaSuresi")));
                kampanyalar.add(kampanya);
            }
        }
        catch (Exception e){

        }
        return kampanyalar;
    }



    private String convertStreamToString(InputStream is){
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String str="";

        try {
            while ((str = br.readLine()) != null) {
                sb.append(str).append("\n");
            }
        }catch (Exception e){

        }finally {
            try{
                is.close();
            }catch (Exception e){

            }
        }
        return sb.toString();
    }



}
