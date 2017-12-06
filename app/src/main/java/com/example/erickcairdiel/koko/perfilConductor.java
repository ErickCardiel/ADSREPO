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
import android.widget.TextView;

public class perfilConductor extends AppCompatActivity {

    Usuario usuario;
    TextView nombre,correo,edad,marca,modelo,anio;
    Button btn_cambio;
    private DrawerLayout mDrawerLayout3;
    private ActionBarDrawerToggle mToggle3;
    NavigationView mNavigationView3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_conductor);

        //ACTIONBAR MENU
        mDrawerLayout3 = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle3 = new ActionBarDrawerToggle(this,mDrawerLayout3,R.string.Abierto,R.string.Cerrado);
        mDrawerLayout3.addDrawerListener(mToggle3);
        mToggle3.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mNavigationView3 = (NavigationView) findViewById(R.id.navMenuPerfilCon);
        mNavigationView3.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                int id = menuItem.getItemId();
                if(id == R.id.nav_mapa){
                    Intent Activity = new Intent(perfilConductor.this, MainConductor.class);
                    startActivity(Activity);

                }
                if(id == R.id.nav_pasajeros2){
                    Intent Activity = new Intent(perfilConductor.this, pasajeros.class);
                    startActivity(Activity);

                }
                return true;
            }
        });

        usuario = (Usuario)getApplication();

        nombre = findViewById(R.id.cNombre);
        nombre.setText(usuario.nombre);

        correo = findViewById(R.id.cCorreo);
        correo.setText(usuario.correo);

        edad = findViewById(R.id.cEdad);
        edad.setText(String.valueOf(usuario.edad));

        marca = findViewById(R.id.cMarca);
        marca.setText(usuario.conductor.automovil.marca);

        modelo = findViewById(R.id.cModelo);
        modelo.setText(usuario.conductor.automovil.modelo);

        anio = findViewById(R.id.cAnio);
        anio.setText(String.valueOf(usuario.conductor.automovil.anio));

        btn_cambio = findViewById(R.id.btn_cambio);
        btn_cambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent btn_cambio = new Intent(perfilConductor.this,mainEstudiante.class);
                startActivity(btn_cambio);

            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){

        if(mToggle3.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}