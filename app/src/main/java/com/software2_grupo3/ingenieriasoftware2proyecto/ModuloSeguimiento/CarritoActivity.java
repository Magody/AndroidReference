package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloAdministracion.Parametros;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

public class CarritoActivity extends AppCompatActivity implements CarritoContracts.View{

    ProgressBar progressBar;
    Button button, buttonVerPedido;
    Button botonCambiarEstado;
    CarritoContracts.Presentador carritoPresentador;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        progressBar = findViewById(R.id.progressBarCarrito);
        button = findViewById(R.id.buttonGenPedido);
        buttonVerPedido = findViewById(R.id.buttonVerPedido);
        botonCambiarEstado =  findViewById(R.id.buttonCambiarEstado);




    }

    @Override
    protected void onResume() {
        super.onResume();

        carritoPresentador = new CarritoPresenter(this, this);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int codigo = sharedPreferences.getInt(Parametros.DIRECTORIO_CODIGO, -1);

        if(codigo == -1){
            button.setVisibility(View.VISIBLE);
            buttonVerPedido.setVisibility(View.INVISIBLE);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    carritoPresentador.botonGenerarCodigo();
                }
            });
        }else{
            button.setVisibility(View.INVISIBLE);
            buttonVerPedido.setVisibility(View.VISIBLE);
            buttonVerPedido.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(CarritoActivity.this, SeguimientoActivity.class));
                }
            });
        }
    }

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

    @Override
    public void mostrarPantallaSeguimiento() {
        startActivity(new Intent(this, SeguimientoActivity.class));
    }


    public void mostrarCambiarEstado(View view){
        startActivity(new Intent(this, CambiarEstadosActivity.class));
    }
}
