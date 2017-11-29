package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RConductorDatosAutomovil extends AppCompatActivity {

    Button continuar;
    Usuario usuario;
    String strMarca,strModelo,strAnio,strMatricula,strAsientos;
    TextView marca,modelo,anio,matricula,asientos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rconductor_datos_automovil);

        usuario = (Usuario)getApplication();
        marca = (TextView) findViewById(R.id.Imarca);
        modelo = (TextView) findViewById(R.id.Imodelo);
        anio = (TextView) findViewById(R.id.IAnio);
        matricula = (TextView) findViewById(R.id.Imatricula);
        asientos = (TextView) findViewById(R.id.IAsientos);

        continuar = findViewById(R.id.btn_continuar);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                strMarca = marca.getText().toString();
                strModelo = modelo.getText().toString();
                strAnio = anio.getText().toString();
                strMatricula = matricula.getText().toString();
                strAsientos = asientos.getText().toString();

                if((TextUtils.isEmpty(strMarca)==false)&&(TextUtils.isEmpty(strModelo)==false)&&(TextUtils.isEmpty(strAnio)==false)&&(TextUtils.isEmpty(strMatricula)==false)&&(TextUtils.isEmpty(strAsientos)==false))
                {
                    usuario.registroConductor(strModelo,strMarca,usuario.asignarId(),Integer.parseInt(strAsientos),Integer.parseInt(strAnio));
                    Intent continuar = new Intent(RConductorDatosAutomovil.this, MainConductor.class);
                    startActivity(continuar);
                }
            }
        });

    }
}
