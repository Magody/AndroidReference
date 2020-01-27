package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.software2_grupo3.ingenieriasoftware2proyecto.R;

public class CambiarEstadosActivity extends Activity implements SeguimientoContracts.View {

    SeguimientoContracts.Presentador seguimientoPresentador;
    EditText editText;
    Button botonAtendido;
    Button botonEnCamino;
    Button botonHaLlegado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_estado);
        seguimientoPresentador = new SeguimientoPresenter(this, getBaseContext());

        editText = findViewById(R.id.editText);
        botonAtendido = findViewById(R.id.buttonAtendido);
        botonEnCamino = findViewById(R.id.buttonEnCamino);
        botonHaLlegado = findViewById(R.id.buttonHaLlegado);

        botonAtendido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seguimientoPresentador.botonAtendido(editText.getText().toString());
            }
        });

        botonEnCamino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seguimientoPresentador.botonEnCamino(editText.getText().toString());
            }
        });

        botonHaLlegado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seguimientoPresentador.botonHaLlegado(editText.getText().toString());
            }
        });
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    public void mostrarProgressBar() {

    }

    @Override
    public void ocultarProgressBar() {

    }
}
