package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class botonesPrueba extends AppCompatActivity {

    Button P1;
    Button P2;
    Button P3;
    Button P4;
    Button P5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones_prueba);

        P1 = findViewById(R.id.btn_a1);
        P1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent P1 = new Intent(botonesPrueba.this,formasPago.class);
                startActivity(P1);

            }
        });

        P2 = findViewById(R.id.btn_a2);
        P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent P2 = new Intent(botonesPrueba.this,infoConductor.class);
                startActivity(P2);

            }
        });

        P3 = findViewById(R.id.btn_a3);
        P3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent P3 = new Intent(botonesPrueba.this,pasajeros.class);
                startActivity(P3);

            }
        });

        P4 = findViewById(R.id.btn_a4);
        P4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent P4 = new Intent(botonesPrueba.this,perfilConductor.class);
                startActivity(P4);

            }
        });

        P5 = findViewById(R.id.btn_a5);
        P5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent P5 = new Intent(botonesPrueba.this,perfilEstudiante.class);
                startActivity(P5);

            }
        });
    }
}
