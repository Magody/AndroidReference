package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.software2_grupo3.ingenieriasoftware2proyecto.R;

public class SeguimientoActivity extends Activity implements SeguimientoContracts.View {

    SeguimientoContracts.Presentador seguimientoPresentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguimiento);
        seguimientoPresentador = new SeguimientoPresenter(this, getBaseContext());
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

    @Override
    public void mostrarEstado(int estado) {
        if(estado == 1){
            findViewById(R.id.buttonSeguimientoAtendido).setBackgroundColor(getColor(R.color.colorVerde));
            findViewById(R.id.buttonSeguimientoEnCamino).setBackgroundColor(getColor(R.color.colorNegro));
            findViewById(R.id.buttonSeguimientoHaLlegado).setBackgroundColor(getColor(R.color.colorNegro));
        }else if(estado == 2){
            findViewById(R.id.buttonSeguimientoAtendido).setBackgroundColor(getColor(R.color.colorVerde));
            findViewById(R.id.buttonSeguimientoEnCamino).setBackgroundColor(getColor(R.color.colorVerde));
            findViewById(R.id.buttonSeguimientoHaLlegado).setBackgroundColor(getColor(R.color.colorNegro));
        }else if(estado == 3){
            findViewById(R.id.buttonSeguimientoAtendido).setBackgroundColor(getColor(R.color.colorVerde));
            findViewById(R.id.buttonSeguimientoEnCamino).setBackgroundColor(getColor(R.color.colorVerde));
            findViewById(R.id.buttonSeguimientoHaLlegado).setBackgroundColor(getColor(R.color.colorVerde));
        }else{
            findViewById(R.id.buttonSeguimientoAtendido).setBackgroundColor(getColor(R.color.colorNegro));
            findViewById(R.id.buttonSeguimientoEnCamino).setBackgroundColor(getColor(R.color.colorNegro));
            findViewById(R.id.buttonSeguimientoHaLlegado).setBackgroundColor(getColor(R.color.colorNegro));
        }
    }


    public void volver(View view){
        onBackPressed();
    }

}
