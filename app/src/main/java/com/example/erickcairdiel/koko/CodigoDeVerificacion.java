package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CodigoDeVerificacion extends AppCompatActivity
{
    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_de_verificacion);

        siguiente = (Button)findViewById(R.id.btnSiguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent siguientePantalla = new Intent(CodigoDeVerificacion.this,RdatosUsuarioGeneral.class);
                startActivity(siguientePantalla);
            }
        });
    }
}