package com.example.erickcairdiel.koko;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RdatosUsuarioGeneral extends AppCompatActivity
{
    Button continuar;
    Usuario usuario;
    TextView txtCorreo,txtContrasena,txtNombre,txtEdad;
    String strCorreo,strContrasena,strNombre,strEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdatos_usuario_general);

        usuario = (Usuario)getApplication();
        txtContrasena = (TextView) findViewById(R.id.IContrasena);
        txtCorreo = (TextView) findViewById(R.id.ICorreo);
        txtNombre = (TextView) findViewById(R.id.Inombre);
        txtEdad = (TextView) findViewById(R.id.IEdad);
        continuar = findViewById(R.id.btn_continuar);

        continuar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                strNombre = txtNombre.getText().toString();
                strCorreo = txtCorreo.getText().toString();
                strContrasena = txtContrasena.getText().toString();
                strEdad = txtEdad.getText().toString();

                if((TextUtils.isEmpty(strNombre)==false)&&(TextUtils.isEmpty(strCorreo)==false)&&(TextUtils.isEmpty(strContrasena)==false)&&(TextUtils.isEmpty(strEdad)==false))
                {
                    usuario.registraDatosGenerales(strNombre, strCorreo, strContrasena, Integer.parseInt(strEdad),usuario.asignarId());
                    Intent continuar = new Intent(RdatosUsuarioGeneral.this, RImagenPerfilUsuario.class);
                    startActivity(continuar);
                }
            }
        });

    }
}
