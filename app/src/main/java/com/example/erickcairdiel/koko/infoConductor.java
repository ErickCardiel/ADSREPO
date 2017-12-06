package com.example.erickcairdiel.koko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class infoConductor extends AppCompatActivity {

    Button cancelar,raite;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_conductor);

        ratingBar = (RatingBar) findViewById(R.id.ICalificacion);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(infoConductor.this,"Start: "+ v,Toast.LENGTH_SHORT).show();
            }
        });

        cancelar = (Button)findViewById(R.id.btnCancelarRaite);
        cancelar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent siguientePantalla = new Intent(infoConductor.this,mainEstudiante.class);
                startActivity(siguientePantalla);
            }
        });
       raite = (Button)findViewById(R.id.btnRaiteEnProgreso);
        raite.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent siguientePantalla = new Intent(infoConductor.this,raiteEnProgreso.class);
                startActivity(siguientePantalla);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
}
