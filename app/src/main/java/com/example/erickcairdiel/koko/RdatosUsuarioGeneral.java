package com.example.erickcairdiel.koko;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RdatosUsuarioGeneral extends AppCompatActivity
{
    Button continuar;
    Usuario usuario;
    TextView txtCorreo,txtContrasena,txtNombre,txtEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdatos_usuario_general);

        txtContrasena = (TextView) findViewById(R.id.txt_IContrasena);
        txtCorreo = (TextView) findViewById(R.id.txt_ICorreo);
        txtNombre = (TextView) findViewById(R.id.txt_Inombre);
        //txtEdad = (TextView) findViewById(R.id.txtEdad);
        usuario=(Usuario)getApplication();
        continuar = findViewById(R.id.btn_continuar);

        continuar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                    usuario.contrasena = txtContrasena.getText().toString();
                    usuario.correo = txtCorreo.getText().toString();
                    usuario.nombre = txtNombre.getText().toString();
                    //usuario.edad = txtEdad.getText();

                    Intent continuar = new Intent(RdatosUsuarioGeneral.this,RImagenPerfilUsuario.class);
                    startActivity(continuar);
            }
        });

    }
}
