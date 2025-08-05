package com.yavuzozguven.yazlab23;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    ArrayList<Kullanicilar> kullanicilar = new ArrayList<Kullanicilar>();
    EditText gelenAd;
    EditText gelenSifre;
    RelativeLayout rl;
    RelativeLayout rl2;
    EditText eksen_x;
    EditText eksen_y;
    EditText esik;
    Button konumal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = (Button) findViewById(R.id.login);
        Button kaydol = (Button) findViewById(R.id.kaydol);
        gelenAd = (EditText) findViewById(R.id.gelenAd);
        gelenSifre = (EditText) findViewById(R.id.gelenSifre);
        rl = (RelativeLayout) findViewById(R.id.son_lay);
        rl2 = (RelativeLayout) findViewById(R.id.ilk_lay);
        eksen_x = (EditText) findViewById(R.id.eksen_x);
        eksen_y = (EditText) findViewById(R.id.eksen_y);
        esik = (EditText) findViewById(R.id.esik_deger);
        konumal = (Button) findViewById(R.id.konum_al);

        rl.setVisibility(View.INVISIBLE);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getUsers().execute();
            }
        });

        kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new postUsers().execute();
            }
        });







    }

    class getUsers extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler httpHandler = new HttpHandler();
            kullanicilar = httpHandler.makeServiceCallKullanici("https://yazlab23.azurewebsites.net/api/Kullanici");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            String ad = gelenAd.getText().toString();
            String sifre = gelenSifre.getText().toString();
            int cntrl = 0;
            for (int i = 0 ; i < kullanicilar.size() ; i++){
                if (kullanicilar.get(i).getKullaniciAd().equals(ad)){
                    if(kullanicilar.get(i).getKullaniciSifre().equals(sifre)){
                       // Intent intent = new Intent(getBaseContext(),MapsActivity.class);
                        cntrl = 1;
                        //startActivity(intent);
                        //finish();
                        rl.setVisibility(View.VISIBLE);
                        rl2.setVisibility(View.INVISIBLE);
                        konumal.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getBaseContext(),MapsActivity.class);
                                intent.putExtra("x_eksen",eksen_x.getText().toString());
                                intent.putExtra("y_eksen",eksen_y.getText().toString());
                                intent.putExtra("esik",esik.getText().toString());
                                startActivity(intent);
                            }
                        });




                    }
                }
            }
            if(cntrl == 0){
                Toast.makeText(getApplicationContext(),"Başarısız Giriş",Toast.LENGTH_SHORT).show();
            }
            super.onPostExecute(aVoid);
        }
    }

    class postUsers extends AsyncTask<Void,Void,Void>{
        boolean cntrl = true;
        @Override
        protected Void doInBackground(Void... voids) {
            new getUsers().execute();
            cntrl = true;
            for (int i = 0;i<kullanicilar.size();i++){
                if (kullanicilar.get(i).getKullaniciAd().equals(gelenAd))
                    cntrl = false;
            }
            if(gelenAd.getText().toString().equals("") || gelenSifre.getText().toString().equals("")){
                cntrl = false;
            }
            if(cntrl) {
                ArrayList params = new ArrayList();
                HttpHandler httpHandler = new HttpHandler();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://yazlab23.azurewebsites.net/api/Kullanici", new Response.Listener<String>() {
                    public void onResponse(String response) {
                        Log.d("kayit", response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                Log.d("snow", "onErrorResponse: " + error.getMessage().toString());
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("KullaniciAdi", gelenAd.getText().toString());
                        params.put("Kullanicisifre", gelenSifre.getText().toString());
                        return params;
                    }
                };

                runOnUiThread(new Runnable(){

                    @Override
                    public void run(){
                        if(cntrl == false)
                            Toast.makeText(LoginActivity.this,"Hatalı giriş",Toast.LENGTH_SHORT).show();
                        if(cntrl == true)
                            Toast.makeText(LoginActivity.this,"Başarıyla kaydolundu",Toast.LENGTH_SHORT).show();
                    }
                });

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(stringRequest);
            }
            return null;
        }
    }

    class PutUsers extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            new getUsers().execute();
            HttpHandler handler = new HttpHandler();
            //StringRequest stringRequest



            return null;
        }
    }





}
