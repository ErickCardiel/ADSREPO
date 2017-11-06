package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RTipoDeCuenta extends AppCompatActivity {

    Button conductor,estudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtipo_de_cuenta);

        conductor = (Button)findViewById(R.id.btnConductor);
        estudiante = (Button)findViewById(R.id.btnEstudiante);


        conductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent siguientePantalla = new Intent(RTipoDeCuenta.this,RConductorDatosAutomovil.class);
                startActivity(siguientePantalla);
            }
        });

        estudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent siguientePantalla2 = new Intent(RTipoDeCuenta.this,PrincipalEstudiante.class);
                startActivity(siguientePantalla2);
            }
        });
    }
}