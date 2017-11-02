package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button activar;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activar = (Button)findViewById(R.id.btnActivar);
        activar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent siguientePantalla = new Intent(MainActivity.this,IniciarSesionRegistro.class);
                startActivity(siguientePantalla);
            }
        });
    }
}