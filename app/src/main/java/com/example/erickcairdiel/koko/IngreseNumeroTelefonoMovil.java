package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IngreseNumeroTelefonoMovil extends AppCompatActivity
{
    Usuario usuario;
    EditText numero;
    Button continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingrese_numero_telefono_movil);

        usuario = (Usuario)getApplication();
        numero = (EditText)findViewById(R.id.INumero);

        continuar = findViewById(R.id.btn_continuar);
        continuar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                        if(TextUtils.isEmpty(numero.getText().toString())==false)
                        {
                            usuario.registraTelefono(numero.getText().toString());
                            Intent continuar = new Intent(IngreseNumeroTelefonoMovil.this, CodigoDeVerificacion.class);
                            startActivity(continuar);
                        }
            }
        });

    }
}