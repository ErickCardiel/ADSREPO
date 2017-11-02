package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IngreseNumeroTelefonoMovil extends AppCompatActivity {
    Button siguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingrese_numero_telefono_movil);

        siguiente = (Button)findViewById(R.id.btnSiguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguientePantalla = new Intent(IngreseNumeroTelefonoMovil.this,CodigoDeVerificacion.class);
                startActivity(siguientePantalla);
            }
        });

    }
}
