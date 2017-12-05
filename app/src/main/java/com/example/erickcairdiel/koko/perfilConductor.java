package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RatingBar;
import android.widget.Toast;

public class perfilConductor extends AppCompatActivity {

    Usuario usuario;
    TextView nombre,correo,edad,marca,modelo,anio;
    Button btn_cambio;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_conductor);

        usuario = (Usuario)getApplication();

        nombre = findViewById(R.id.cNombre);
        nombre.setText(usuario.nombre);

        correo = findViewById(R.id.cCorreo);
        nombre.setText(usuario.correo);

        edad = findViewById(R.id.cEdad);
        edad.setText(String.valueOf(usuario.edad));

        marca = findViewById(R.id.cMarca);
        marca.setText(usuario.conductor.automovil.marca);

        modelo = findViewById(R.id.cModelo);
        modelo.setText(usuario.conductor.automovil.modelo);

        anio = findViewById(R.id.cAnio);
        anio.setText(String.valueOf(usuario.conductor.automovil.anio));

        btn_cambio = findViewById(R.id.btn_cambio);
        btn_cambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent btn_cambio = new Intent(perfilConductor.this,perfilEstudiante.class);
                startActivity(btn_cambio);

            }
        });
    }
}