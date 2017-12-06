package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class raiteEnProgreso extends AppCompatActivity {

    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raite_en_progreso);

        volver =(Button)findViewById(R.id.btnVolver);
        volver.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view)
            {
                Intent siguientePantalla = new Intent(raiteEnProgreso.this, mainEstudiante.class);
                startActivity(siguientePantalla);
            }
        });
    }



}
