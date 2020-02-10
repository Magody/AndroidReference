package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.software2_grupo3.ingenieriasoftware2proyecto.MainActivity;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

public class RegistrarClienteActivity extends AppCompatActivity implements RegistrarClienteContracts.View {

    EditText txtUser, txtPwd, txtNombre, txtCorreo, txtdireccion, txtcedula, txttelefono, txtfechanacimiento, txttarjeta;
    Button btnRegistrar;

    RegistrarClienteContracts.Presentador mainPresenter;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registrar);

        txtUser = findViewById(R.id.txtuser);
        txtPwd = findViewById(R.id.txtpwd);
        txtNombre = findViewById(R.id.txtnombre);
        txtCorreo = findViewById(R.id.txtcorreo);
        txtdireccion = findViewById(R.id.txtDireccion);
        txtcedula = findViewById(R.id.txtCedula);
        txttelefono = findViewById(R.id.txtTelefono);
        txtfechanacimiento = findViewById(R.id.txtFechaNacimiento);
        txttarjeta = findViewById(R.id.txtTarjeta);

        btnRegistrar = findViewById(R.id.btnregistrar);

        mainPresenter = new RegistrarClientePresenter(this, this);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mainPresenter.enBotonPresionado(txtcedula.getText().toString(),
                        txtCorreo.getText().toString(),
                        txtdireccion.getText().toString(),
                        txtfechanacimiento.getText().toString(),
                        txtPwd.getText().toString(),
                        txttarjeta.getText().toString(),
                        txttelefono.getText().toString(),
                        txtUser.getText().toString(),
                        txtNombre.getText().toString(),
                        ""
                );



            }
        });


    }

    @Override
    public void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    public void navegarMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void navegarRegistrarClienteCodigoActivity() {
        Intent pasarDatos = new Intent(RegistrarClienteActivity.this, RegistrarClienteCodigoActivity.class);
        pasarDatos.putExtra("cedula", txtcedula.getText().toString());
        startActivity(pasarDatos);
    }



}
