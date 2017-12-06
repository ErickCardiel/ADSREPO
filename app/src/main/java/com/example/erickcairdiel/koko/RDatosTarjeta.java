package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RDatosTarjeta extends AppCompatActivity
{

    Button continuar;
    Usuario usuario;
    String strNumTarjeta,strCodigoSeguridad,strAnio,strMes;
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

                if(!TextUtils.isEmpty(strNumTarjeta)&&!TextUtils.isEmpty(strCodigoSeguridad)&&!TextUtils.isEmpty(strAnio)&&!TextUtils.isEmpty(strMes))
                {
                    if(validaNumSeg(strCodigoSeguridad)&&validaNumTarjeta(strNumTarjeta)&&validaAnioyMes(Integer.parseInt(strAnio),Integer.parseInt(strMes)))
                    {
                        usuario.registrarTarjeta(strNumTarjeta,Integer.parseInt(strCodigoSeguridad),Integer.parseInt(strAnio),Integer.parseInt(strMes),"prueba");
                        Intent continuar = new Intent(RDatosTarjeta.this,RTipoDeCuenta.class);
                        startActivity(continuar);
                    }
                }
            }
        });
    }

    boolean validaNumTarjeta(String dato)
    {
        int contador = 0;
        for( int i=0; i<dato.length(); i++ )
                contador++;

        if(contador==16) return true;
        else return false;
    }


    boolean validaNumSeg(String dato)
    {
        int contador = 0;
        for( int i=0; i<dato.length(); i++ )
                 contador++;

        if(contador==3) return true;
        else return false;
    }

    boolean validaAnioyMes(int anio, int mes)
    {
       if(anio>2017&&anio<2040&&mes>0&&mes<13) return true;
       else return false;
    }


}
