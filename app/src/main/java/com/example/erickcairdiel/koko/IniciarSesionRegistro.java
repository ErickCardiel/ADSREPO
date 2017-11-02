package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IniciarSesionRegistro extends AppCompatActivity {

    Button iniciarSesion,registrarse;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion_registro);

        registrarse = (Button)findViewById(R.id.btnRegistro);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent nuevo2 = new Intent(IniciarSesionRegistro.this,IngreseNumeroTelefonoMovil.class);
                startActivity(nuevo2);
            }
        });
    }
}
