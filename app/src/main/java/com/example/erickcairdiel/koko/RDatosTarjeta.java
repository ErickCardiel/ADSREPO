package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RDatosTarjeta extends AppCompatActivity
{

    Button continuar;
    Usuario usuario;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdatos_tarjeta);


        usuario=(Usuario)getApplication();
        continuar = findViewById(R.id.btn_continuar);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent continuar = new Intent(RDatosTarjeta.this,RTipoDeCuenta.class);
                startActivity(continuar);

            }
        });
    }
}
