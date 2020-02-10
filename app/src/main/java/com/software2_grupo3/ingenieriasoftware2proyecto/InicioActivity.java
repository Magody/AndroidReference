package com.software2_grupo3.ingenieriasoftware2proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios.RegistrarClienteActivity;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        findViewById(R.id.buttonInicioRegistrarse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InicioActivity.this, RegistrarClienteActivity.class));
            }
        });

        findViewById(R.id.buttonInicioIngresar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InicioActivity.this, MainActivity.class));
            }
        });

    }
}
