package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.software2_grupo3.ingenieriasoftware2proyecto.R;

public class CarritoActivity extends FragmentActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
    }

    public void abrirSeguimiento(View seguimiento) {
        startActivity(new Intent(this, SeguimientoActivity.class));
    }
}
