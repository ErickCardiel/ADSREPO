package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class formasPago extends AppCompatActivity {

    Button Agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formas_pago);

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
}
