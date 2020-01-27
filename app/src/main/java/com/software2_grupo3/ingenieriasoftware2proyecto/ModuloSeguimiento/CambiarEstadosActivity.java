package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.software2_grupo3.ingenieriasoftware2proyecto.R;

public class CambiarEstadosActivity extends Activity implements CambiarEstadosContracts.View {

    CambiarEstadosContracts.Presentador cambiarEstadosPresenter;
    EditText editText;
    Button botonAtendido;
    Button botonEnCamino;
    Button botonHaLlegado;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_estado);
        cambiarEstadosPresenter = new CambiarEstadosPresenter(this, this);

        editText = findViewById(R.id.editText);
        botonAtendido = findViewById(R.id.buttonAtendido);
        botonEnCamino = findViewById(R.id.buttonEnCamino);
        botonHaLlegado = findViewById(R.id.buttonHaLlegado);
        progressBar = findViewById(R.id.progressBarCambiarEstados);

        botonAtendido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    cambiarEstadosPresenter.enBotonAtendidoPresionado(Integer.parseInt(editText.getText().toString()));
                }catch(Exception error){

                }

            }
        });

        botonEnCamino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    cambiarEstadosPresenter.enBotonEnCaminoPresionado(Integer.parseInt(editText.getText().toString()));
                }catch(Exception error){

                }
            }
        });

        botonHaLlegado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    cambiarEstadosPresenter.enBotonHaLlegadoPresionado(Integer.parseInt(editText.getText().toString()));
                }catch(Exception error){

                }
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
}
