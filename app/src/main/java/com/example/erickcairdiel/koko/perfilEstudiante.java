package com.example.erickcairdiel.koko;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class perfilEstudiante extends AppCompatActivity {
    TextView nombre,correo,edad;
    Usuario usuario;
    RatingBar ratingBar;
    Button btn_cambio;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView mNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_estudiante);

        //ACTIONBAR MENU
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutEst);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.Abierto,R.string.Cerrado);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mNavigationView = (NavigationView) findViewById(R.id.navMenuPerfilEst);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                int id = menuItem.getItemId();
                if(id == R.id.nav_mapa){
                    Intent Activity = new Intent(perfilEstudiante.this, mainEstudiante.class);
                    startActivity(Activity);

                }else if(id == R.id.nav_metodoPago){
                    Intent Activity = new Intent(perfilEstudiante.this, formasPago.class);
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

        ratingBar = findViewById(R.id.ICalificacion);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(perfilEstudiante.this,"Start: "+ v,Toast.LENGTH_SHORT).show();
            }
        });

        btn_cambio = findViewById(R.id.btn_cambio);
        btn_cambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent btn_cambio = new Intent(perfilEstudiante.this,RConductorDatosAutomovil.class);
                startActivity(btn_cambio);

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}