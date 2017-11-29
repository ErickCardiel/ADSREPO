package com.example.erickcairdiel.koko;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CodigoDeVerificacion extends AppCompatActivity
{
    Usuario usuario;
    Button continuar;
    EditText codigoVerificacion;
    TextView numero;
    int prueba = 1234;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_de_verificacion);

        usuario = (Usuario)getApplication();
        continuar = findViewById(R.id.btn_continuar);

        numero = (TextView)findViewById(R.id.txtColocarNumero);
        numero.setText(usuario.telefono);

        codigoVerificacion = (EditText)findViewById(R.id.ICodigo);



        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if((TextUtils.isEmpty(codigoVerificacion.getText().toString())==false)&&((Integer.parseInt(codigoVerificacion.getText().toString()))==prueba))
                {
                    Intent continuar = new Intent(CodigoDeVerificacion.this,RdatosUsuarioGeneral.class);
                    startActivity(continuar);
                }
            }
        });

    }
}