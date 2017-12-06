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
import android.widget.Toast;

public class modRuta extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView mNavigationView;
    Button gR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_ruta);

        //ACTIONBAR MENU
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.Abierto,R.string.Cerrado);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mNavigationView = (NavigationView) findViewById(R.id.navMenuRR);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                int id = menuItem.getItemId();
                if(id == R.id.nav_perfil){
                    Intent Activity = new Intent(modRuta.this, perfilConductor.class);
                    startActivity(Activity);

                }
                if(id == R.id.nav_pasajeros){
                    Intent Activity = new Intent(modRuta.this, pasajeros.class);
                    startActivity(Activity);

                }
                return true;
            }
        });

        gR = (Button)findViewById(R.id.btnModGuardarRuta);
        gR.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent Activity = new Intent(modRuta.this, MainConductor.class);
                startActivity(Activity);
                Toast.makeText(modRuta.this,"Ruta guardada",Toast.LENGTH_SHORT).show();
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
