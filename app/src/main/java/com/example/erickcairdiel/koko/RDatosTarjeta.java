package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RDatosTarjeta extends AppCompatActivity
{

    Button continuar;
    Usuario usuario;
    String strNumTarjeta,getStrNumTarjeta,strCodigoSeguridad,strAnio,strMes;
    TextView numTarjeta,codigoSeguridad,anio,mes;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdatos_tarjeta);
        usuario=(Usuario)getApplication();

        numTarjeta = (TextView) findViewById(R.id.InumeroTarjeta);
        codigoSeguridad = (TextView) findViewById(R.id.IcodigoSeguridad);
        anio = (TextView) findViewById(R.id.Ianio);
        mes = (TextView) findViewById(R.id.Imes);

        continuar = findViewById(R.id.btn_continuar);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                strNumTarjeta = numTarjeta.getText().toString();
                strCodigoSeguridad = codigoSeguridad.getText().toString();
                strAnio = anio.getText().toString();
                strMes = mes.getText().toString();

                if(TextUtils.isEmpty(strNumTarjeta)==false&&TextUtils.isEmpty(strCodigoSeguridad)==false&&TextUtils.isEmpty(strAnio)==false
                        &&TextUtils.isEmpty(strMes)==false)
                {
                    Intent continuar = new Intent(RDatosTarjeta.this,RTipoDeCuenta.class);
                    startActivity(continuar);
                    usuario.registrarTarjeta(strNumTarjeta,Integer.parseInt(strCodigoSeguridad),Integer.parseInt(strAnio),Integer.parseInt(strMes),"prueba");
                }
            }
        });
    }
}
