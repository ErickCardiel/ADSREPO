package com.example.erickcairdiel.koko;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class ajustesDeTransporte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes_de_transporte);

//      Switch ON/OFF\
        Switch sw1;
        TextView labelTarifa;
        sw1 = (Switch) findViewById(R.id.switch1);
        labelTarifa = (TextView) findViewById(R.id.lblseleccionarTarifa);
        if (sw1.isEnabled())
            labelTarifa.setVisibility(View.VISIBLE);
        else
            labelTarifa.setVisibility(View.INVISIBLE);
    }
}
