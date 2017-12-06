package com.example.erickcairdiel.koko;

import android.Manifest;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainConductor extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    LocationRequest mLocationRequest;
    SupportMapFragment mapFragment;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView mNavigationView;
    ImageButton ajustesTransporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_conductor);

        //ACTIONBAR MENU
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.Abierto,R.string.Cerrado);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mNavigationView = (NavigationView) findViewById(R.id.navMenu);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                int id = menuItem.getItemId();
                if(id == R.id.nav_perfil){
                    Intent Activity = new Intent(MainConductor.this, perfilConductor.class);
                    startActivity(Activity);

                }
                if(id == R.id.nav_pasajeros){
                    Intent Activity = new Intent(MainConductor.this, pasajeros.class);
                    startActivity(Activity);

                }
                return true;
            }
        });

        //BOTON AJUSTES DE TRANSPORTE
        ajustesTransporte = (ImageButton)findViewById(R.id.btnAT);
        ajustesTransporte.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent siguientePantalla = new Intent(MainConductor.this,ajustesDeTransporte.class);
                startActivity(siguientePantalla);
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainConductor.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_REQUEST_CODE );
        }else{
            mapFragment.getMapAsync(this);
        }
//
       // AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        //alertDialogBuilder.setMessage("       *** Solicitud de transporte *** \n\n                      ★ ★ ★ ★ ★ \n\nNombre: Alexis Gutierrez Kinto\nUniversidad: UABC\nCorreo: alexis@uabc.edu.mx\nEdad: 21 años")
        //alertDialogBuilder.setMessage("Cancelacion de transporte\n\nEl conductor ha rechazado su solicitud")
       // alertDialogBuilder.setMessage("Ingresa una calificacion para el estudiante\n\n        Califica al estudiante ' Bianca '\n\n                      ★ ★ ★ ★ ★")
          //  .setCancelable(false)
         //       .setPositiveButton("Aceptar",
       //                 new DialogInterface.OnClickListener(){
       //                     public void onClick(DialogInterface dialog, int id){
     //                           Intent callGPSSettingIntent = new Intent(
      //                                  android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
      //                          startActivity(callGPSSettingIntent);
      //                      }
      //                  });
      //  alertDialogBuilder.setNegativeButton("",
      //          new DialogInterface.OnClickListener(){
                 //   public void onClick(DialogInterface dialog, int id){
                        //dialog.cancel();
                    //}
              //  });
      //  AlertDialog alert = alertDialogBuilder.create();
      //  alert.show();

    }

    public boolean onOptionsItemSelected(MenuItem item){

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainConductor.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_REQUEST_CODE );
        }
        buildGoogleApiClient();
        mMap.setMyLocationEnabled(true);
        // Marker at UABC
        LatLng Uabc = new LatLng(32.50699311964751, -116.88700497150421);
        //mMap.addMarker(new MarkerOptions().position(Uabc).title("Tu"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Uabc));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    protected synchronized void buildGoogleApiClient(){
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mGoogleApiClient.connect();
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainConductor.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
            }
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    final int LOCATION_REQUEST_CODE =1;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case LOCATION_REQUEST_CODE:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    mapFragment.getMapAsync(this);
                }else{
                    Toast.makeText(getApplicationContext(),"Por favor dar permiso.", Toast.LENGTH_LONG).show();
                }

                break;
            }
        }
    }
}
