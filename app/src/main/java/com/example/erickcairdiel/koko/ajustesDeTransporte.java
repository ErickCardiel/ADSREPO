package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.NumberPicker;

import org.w3c.dom.Text;

public class ajustesDeTransporte extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    Switch sw = null;
    Button registrarRuta;
    TextView tarifa;
    NumberPicker numTar,numAsientos,npUNI;

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

        //SWITCH ACTION
        sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(this);

        tarifa = (TextView) findViewById(R.id.lblseleccionarTarifa);
        numTar = (NumberPicker) findViewById(R.id.InumeroTarifa);
        numAsientos = (NumberPicker) findViewById(R.id.InumeroAsientos);
        npUNI = (NumberPicker) findViewById(R.id.npUni);
        npUNI.setMinValue(0);
        npUNI.setMaxValue(1);
        npUNI.setDisplayedValues(new String[] {"UABC","TEC"});
        npUNI.setWrapSelectorWheel(true);
        numTar.setMinValue(1);
        numTar.setMaxValue(100);
        numTar.setWrapSelectorWheel(true);
        numAsientos.setMinValue(0);
        numAsientos.setMaxValue(6);
        numAsientos.setWrapSelectorWheel(true);

    }
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            //Toast.makeText(ajustesDeTransporte.this,"SWITCH IS ON",Toast.LENGTH_LONG).show();
            tarifa.setVisibility(View.VISIBLE);
            numTar.setVisibility(View.VISIBLE);
        } else {
            //Toast.makeText(ajustesDeTransporte.this,"SWITCH IS OFF",Toast.LENGTH_LONG).show();
            tarifa.setVisibility(View.INVISIBLE);
            numTar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
