package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloEntregador;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.software2_grupo3.ingenieriasoftware2proyecto.MainActivity;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

public class EntregadorActivity extends Activity implements EntregadorContracts.View {

    EntregadorContracts.Presentador entregadorPresentador;
    EditText txtUser, txtPwd, txtNombre, txtCorreo, txtcedula, txttelefono, txtfechanacimiento;
    Button btnRegistrar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registrar_entregador);

        entregadorPresentador = new EntregadorPresenter(this, this);

        txtNombre = findViewById(R.id.txtnombre);
        txtCorreo = findViewById(R.id.txtcorreo);
        txtcedula = findViewById(R.id.txtCedula);
        txttelefono = findViewById(R.id.txtTelefono);
        txtfechanacimiento = findViewById(R.id.txtFechaNacimiento);
        txtUser = findViewById(R.id.txtuser);
        txtPwd = findViewById(R.id.txtpwd);
        btnRegistrar = findViewById(R.id.btnregistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    entregadorPresentador.botonAceptarRegistro(txtNombre.getText().toString(),
                        txtcedula.getText().toString(),
                        txtCorreo.getText().toString(),
                        txtfechanacimiento.getText().toString(),
                        txttelefono.getText().toString(),
                        txtUser.getText().toString(),
                        txtPwd.getText().toString());
                }catch(Exception error){
                    System.out.println("Error Entregador Activity");
                }
            }
        });
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    public void mostrarMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
