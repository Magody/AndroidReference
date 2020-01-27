package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.software2_grupo3.ingenieriasoftware2proyecto.R;

public class MainRegistrarCliente extends AppCompatActivity implements MainContracts.View {

    EditText txtUser, txtPwd, txtNombre, txtCorreo, txtdireccion, txtcedula, txttelefono, txtfechanacimiento, txttarjeta;
    Button btnRegistrar;

    MainContracts.Presentador mainPresenter;


   protected void onCreateView(Bundle savedInstanceState) {

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

        mainPresenter = new MainPresenter(this, this);

        btnRegistrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                    mainPresenter.enBotonPresionado();
            }
        });

    }

    @Override
    public void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }



}
