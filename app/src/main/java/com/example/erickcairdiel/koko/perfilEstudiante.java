package com.example.erickcairdiel.koko;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class perfilEstudiante extends AppCompatActivity {
    TextView nombre,correo,edad;
    Usuario usuario;
    Button btn_cambio;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_estudiante);


        usuario = (Usuario)getApplication();

        nombre = findViewById(R.id.cNombre);
        nombre.setText(usuario.nombre);

        correo = findViewById(R.id.cCorreo);
        correo.setText(usuario.correo);

        edad = findViewById(R.id.cEdad);
        edad.setText(String.valueOf(usuario.edad));

        btn_cambio = findViewById(R.id.btn_cambio);
        btn_cambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent btn_cambio = new Intent(perfilEstudiante.this,perfilConductor.class);
                startActivity(btn_cambio);

            }
        });
    }
}