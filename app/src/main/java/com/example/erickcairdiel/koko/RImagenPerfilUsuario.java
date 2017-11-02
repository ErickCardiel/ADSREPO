package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RImagenPerfilUsuario extends AppCompatActivity
{

    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rimagen_perfil_usuario);

        siguiente = (Button)findViewById(R.id.btnSiguiente);
        siguiente.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent siguientePantalla = new Intent(RImagenPerfilUsuario.this,RMetodoDePago.class);
                startActivity(siguientePantalla);
            }
        });
    }
}
