package com.yavuzozguven.yazlab23;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {


    static final LatLng ist = new LatLng(41.10, 29.01);
    LocationManager locationManager;
    String provider;
    Location location;
    static int Rm = 3961;
    static int Rk = 6373;
    ArrayList<Kampanyalar> kampanyalar = new ArrayList<Kampanyalar>();
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        location = locationManager.getLastKnownLocation(provider);
        new getKampanyalar().execute();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }

        mMap.setMyLocationEnabled(true);
        UiSettings uis = googleMap.getUiSettings();
        uis.setMyLocationButtonEnabled(true);
        uis.setCompassEnabled(true);
        uis.setZoomControlsEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ist, 4));



    }


    class getKampanyalar extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler httpHandler = new HttpHandler();
            kampanyalar = httpHandler.MakeServiceCallKampanya("https://yazlab23.azurewebsites.net/api/Kampanya");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Bundle extras = getIntent().getExtras();
        String esik = ((Bundle) extras).getString("esik");
        String eksen_x = ((Bundle) extras).getString("x_eksen");
        String eksen_y = ((Bundle) extras).getString("y_eksen");
        Date currenttime = Calendar.getInstance().getTime();
        mMap.clear();

        if(esik.charAt(0) == 'E'){
            for (int i = 0;i<kampanyalar.size();i++){
                if(item.getTitle().toString().toLowerCase().equals(kampanyalar.get(i).getTur().toLowerCase())) {
                    mMap.clear();
                    LatLng latLng = new LatLng(kampanyalar.get(i).getFirmaX(),kampanyalar.get(i).getFirmaY());
                    mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .title(kampanyalar.get(i).getFirmaAdi())
                            .snippet(kampanyalar.get(i).getFirmaicerik()));
                }
            }
            if(item.getTitle().equals("Hepsi")){
                mMap.clear();
                for (int i = 0;i<kampanyalar.size();i++){
                    LatLng latLng = new LatLng(kampanyalar.get(i).getFirmaX(),kampanyalar.get(i).getFirmaY());
                    mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .title(kampanyalar.get(i).getFirmaAdi())
                            .snippet(kampanyalar.get(i).getFirmaicerik()));
                }
            }
        }

        if(esik.charAt(0) != 'E'){
            if(eksen_x.charAt(0) == 'X') {
                for (int i = 0; i < kampanyalar.size(); i++) {
                    double bulunan = findDistance(kampanyalar.get(i).getFirmaX(), kampanyalar.get(i).getFirmaY(), (int) location.getLatitude(), (int) location.getLongitude());
                    if (item.getTitle().toString().toLowerCase().equals(kampanyalar.get(i).getTur().toLowerCase()) && bulunan < Integer.parseInt(esik)) {
                        mMap.clear();
                        LatLng latLng = new LatLng(kampanyalar.get(i).getFirmaX(), kampanyalar.get(i).getFirmaY());
                        mMap.addMarker(new MarkerOptions()
                                .position(latLng)
                                .title(kampanyalar.get(i).getFirmaAdi())
                                .snippet(kampanyalar.get(i).getFirmaicerik()));
                    }
                    if (item.getTitle().equals("Hepsi") && bulunan < Integer.parseInt(esik)) {
                        mMap.clear();
                        LatLng latLng = new LatLng(kampanyalar.get(i).getFirmaX(), kampanyalar.get(i).getFirmaY());
                        mMap.addMarker(new MarkerOptions()
                                .position(latLng)
                                .title(kampanyalar.get(i).getFirmaAdi())
                                .snippet(kampanyalar.get(i).getFirmaicerik()));
                    }
                }
            }
            else{
                mMap.clear();
                LatLng latLng1 = new LatLng(Integer.parseInt(eksen_x),Integer.parseInt(eksen_y));
                mMap.addMarker(new MarkerOptions().position(latLng1)
                .title("Konumum")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
                );
                for (int i = 0; i < kampanyalar.size(); i++) {
                    double bulunan = findDistance(kampanyalar.get(i).getFirmaX(), kampanyalar.get(i).getFirmaY(), Integer.parseInt(eksen_x), Integer.parseInt(eksen_y));
                    if (item.getTitle().toString().toLowerCase().equals(kampanyalar.get(i).getTur().toLowerCase()) && bulunan < Integer.parseInt(esik)) {
                        LatLng latLng = new LatLng(kampanyalar.get(i).getFirmaX(), kampanyalar.get(i).getFirmaY());
                        mMap.addMarker(new MarkerOptions()
                                .position(latLng)
                                .title(kampanyalar.get(i).getFirmaAdi())
                                .snippet(kampanyalar.get(i).getFirmaicerik()));
                    }
                    if (item.getTitle().equals("Hepsi") && bulunan < Integer.parseInt(esik)) {
                        LatLng latLng = new LatLng(kampanyalar.get(i).getFirmaX(), kampanyalar.get(i).getFirmaY());
                        mMap.addMarker(new MarkerOptions()
                                .position(latLng)
                                .title(kampanyalar.get(i).getFirmaAdi())
                                .snippet(kampanyalar.get(i).getFirmaicerik()));
                    }
                }
            }

        }








        return super.onOptionsItemSelected(item);
    }


    public double findDistance(int firstlat,int firstlong,int secondlat,int secondlong){
        double lat1,lon1,lat2,lon2,dlat,dlon,a,c,dm,dk,mi,km;


        lat1 = firstlat * Math.PI/180;
        lon1 = firstlong * Math.PI/180;
        lat2 = secondlat *Math.PI/180;
        lon2 = secondlong * Math.PI/180;

        dlat = lat2-lat1;
        dlon = lon2-lon1;

        a = Math.pow(Math.sin(dlat / 2),2)+Math.cos(lat1)*Math.cos(lat2)* Math.pow(Math.sin(dlon/2),2);
        c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

        dk = c* Rk;
        km = Math.round(dk);
        System.out.println("YAVUZ"+dk);
        return km;
    }



}
