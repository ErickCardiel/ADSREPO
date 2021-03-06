package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class formasPago extends AppCompatActivity {

    Button Agregar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView mNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formas_pago);

        //ACTIONBAR MENU
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutEst);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.Abierto,R.string.Cerrado);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mNavigationView = (NavigationView) findViewById(R.id.navMenuEstFP);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                int id = menuItem.getItemId();
                if(id == R.id.nav_perfilEst){
                    Intent Activity = new Intent(formasPago.this, perfilEstudiante.class);
                    startActivity(Activity);

                }else if(id == R.id.nav_mapa){
                    Intent Activity = new Intent(formasPago.this,mainEstudiante.class);
                    startActivity(Activity);
                }

                return true;
            }
        });

        Agregar = findViewById(R.id.btn_agregarTarjeta);
        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent Agregar = new Intent(formasPago.this,RDatosTarjeta.class);
                startActivity(Agregar);

            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
