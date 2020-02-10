package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.actualizarUsuario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.software2_grupo3.ingenieriasoftware2proyecto.R;

public class ActualizarUsuarioActivity extends AppCompatActivity implements ActualizarContracts.View {

    EditText txtUser, txtPwd, txtNombre, txtCorreo, txtdireccion, txtcedula, txttelefono, txtfechanacimiento, txttarjeta;

    ActualizarContracts.Presentador actualizarPresenter;
    Button btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_actualizar);
        txtUser = findViewById(R.id.txt_usuario);
        txtPwd = findViewById(R.id.txt_password);
        txtNombre = findViewById(R.id.txt_nombre);
        txtCorreo = findViewById(R.id.txt_correo);
        txtdireccion = findViewById(R.id.txt_direccion);
        txtcedula = findViewById(R.id.txt_cedula);
        txttelefono = findViewById(R.id.txt_telefono);
        txtfechanacimiento = findViewById(R.id.txt_fehca);
        txttarjeta = findViewById(R.id.txt_tarjeta);

        btnActualizar= findViewById(R.id.btnActualizar);

        actualizarPresenter = new ActualizarPresenter(this,this);

        btnActualizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                actualizarPresenter.enBotonPresionado(txtcedula.getText().toString(),
                        txtCorreo.getText().toString(),
                        txtdireccion.getText().toString(),
                        txtfechanacimiento.getText().toString(),
                        txtPwd.getText().toString(),
                        txttarjeta.getText().toString(),
                        txttelefono.getText().toString(),
                        txtUser.getText().toString(),
                        txtNombre.getText().toString());
            }
        });
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }


    @Override
    public void navegarMainActivity() {

    }
}
