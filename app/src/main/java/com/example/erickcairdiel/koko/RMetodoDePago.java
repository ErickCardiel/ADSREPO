package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RMetodoDePago extends AppCompatActivity {

    Button tarjeta,siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rmetodo_de_pago);

        tarjeta = (Button)findViewById(R.id.btnTarjeta);
        tarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguientePantalla = new Intent(RMetodoDePago.this,RDatosTarjeta.class);
                startActivity(siguientePantalla);
            }
        });

        siguiente = (Button)findViewById(R.id.btnSiguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguientePantalla2 = new Intent(RMetodoDePago.this,RTipoDeCuenta.class);
                startActivity(siguientePantalla2);
            }
        });

    }
}
