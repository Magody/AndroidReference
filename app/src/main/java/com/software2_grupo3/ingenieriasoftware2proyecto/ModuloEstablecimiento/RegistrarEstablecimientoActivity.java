package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloEstablecimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.software2_grupo3.ingenieriasoftware2proyecto.MainActivity;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

public class RegistrarEstablecimientoActivity extends AppCompatActivity implements RegistrarEstablecimientoContracts.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_establecimiento);
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    public void navegarComprobacionCorreo() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
