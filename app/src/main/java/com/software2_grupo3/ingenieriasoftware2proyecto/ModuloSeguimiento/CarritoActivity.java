package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.software2_grupo3.ingenieriasoftware2proyecto.R;

public class CarritoActivity extends FragmentActivity implements SeguimientoContracts.View {

    ProgressBar progressBar;
    Button button;
    Button botonCambiarEstado;
    SeguimientoContracts.Presentador seguimientoPresentador;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        seguimientoPresentador = new SeguimientoPresenter(this, getBaseContext());

        progressBar = findViewById(R.id.progressBarCarrito);
        button = findViewById(R.id.buttonGenPedido);
        botonCambiarEstado =  findViewById(R.id.buttonCambiarEstado);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seguimientoPresentador.botonGenerarCodigo();
            }
        });
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    public void mostrarProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    public void mostrarCambiarEstado(View view){
        startActivity(new Intent(this, CambiarEstadosActivity.class));
    }
}
