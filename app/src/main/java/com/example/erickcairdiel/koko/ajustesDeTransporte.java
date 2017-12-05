package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class ajustesDeTransporte extends AppCompatActivity {

    Button registrarRuta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes_de_transporte);

        registrarRuta = (Button)findViewById(R.id.btnRegistrarRuta);
        registrarRuta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent siguientePantalla = new Intent(ajustesDeTransporte.this,registrarRuta.class);
                startActivity(siguientePantalla);
            }
        });

    }
}
