package com.example.erickcairdiel.koko;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IniciarSesionRegistro extends AppCompatActivity {

    Button iniciarSesion;
    Button registrarse;
    Button prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion_registro);

        registrarse = findViewById(R.id.btn_Registrar);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent nuevo2 = new Intent(IniciarSesionRegistro.this,IngreseNumeroTelefonoMovil.class);
                startActivity(nuevo2);
            }
        });

        iniciarSesion = findViewById(R.id.btn_IniciarSesion);
        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent iniciarSesion = new Intent(IniciarSesionRegistro.this,ingreseNumeroTelefonoMovilInisiarSesion.class);
                startActivity(iniciarSesion);
            }
        });

        prueba = findViewById(R.id.btn_a1);
        prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent prueba = new Intent(IniciarSesionRegistro.this,botonesPrueba.class);
                startActivity(prueba);
            }
        });
    }

}
