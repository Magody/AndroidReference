package com.software2_grupo3.ingenieriasoftware2proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloAdministracion.Parametros;
import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloCuenta.CuentaFragment;
import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloGeografia.DireccionDeEntregaActivity;
import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloHome.InicioFragment;
import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloPedido.PedidoFragment;
import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento.CarritoActivity;

import static android.util.Log.d;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    private Fragment inicioFragment;
    private Fragment pedidoFragment;
    private Fragment cuentaFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurarToolBar();
        inicializarVariables();
        crearBottomNav();
    }


    private void inicializarVariables(){
        inicioFragment = new InicioFragment();
        pedidoFragment = new PedidoFragment();
        cuentaFragment = new CuentaFragment();
    }

    private void configurarToolBar(){

        Toolbar bar = findViewById(R.id.tool_bar_main);
        bar.setTitleTextColor(getColor(R.color.colorVerde));
        setSupportActionBar(bar);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){
            actionBar.setTitle(R.string.app_name);
            actionBar.setIcon(R.mipmap.ic_launcher);
        }
    }


    private void crearBottomNav(){

        BottomNavigationView nav = findViewById(R.id.bottomNavigationViewCliente); //usa la dependencia: implementation 'com.google.android.material:material:1.0.0'

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.itemNavInicio:
                        cambiarFragmento(inicioFragment);
                        return true;
                    case R.id.itemNavPedido:
                        cambiarFragmento(pedidoFragment);
                        return true;
                    case R.id.itemNavCuenta:
                        cambiarFragmento(cuentaFragment);
                        return true;
                    default:
                        return false;

                }
            }
        });

        //El botón seleccionado por defecto es el Inicio
        nav.setSelectedItemId(R.id.itemNavInicio);
    }

    private void cambiarFragmento(Fragment fragmento){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameClienteMain, fragmento);
        fragmentTransaction.commit();
        d(TAG, "cambiarFragmento: Fragmento cambiado");
    }

    // mostrar y ocultar el menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cliente, menu);  // se elije mi menú que se agregará al ToolBar
        return true;
    }

    // item seleccionado de menú
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){


        int id = menuItem.getItemId();

        switch (id) {

            case R.id.itemMenuClienteCarritoDeCompras:
                //Utilidad.mostrarToast(this, ""+1, Toast.LENGTH_SHORT);
                startActivity(new Intent(this, CarritoActivity.class));
                return true;
            case R.id.itemMenuClienteDireccionDeEntrega:
                startActivity(new Intent(this, DireccionDeEntregaActivity.class));

                return true;
            case R.id.itemMenuClienteSalir:
                cerrarAplicacion();
                return true;
            case R.id.itemMenuClienteReiniciarSeguimiento:
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Parametros.DIRECTORIO_CODIGO, null);

                editor.apply();
                return true;



            default:
                Log.w(TAG, "onOptionsItemSelected: No se seleccionó un item previamente definido para el menu. HACK");
                return super.onOptionsItemSelected(menuItem);

        }
    }

    private void cerrarAplicacion() {
        //todo: avisarle a la anterior actividad que se va a salir de todo, no volver
        finish();
        d(TAG, "cerrarAplicacion: " + "Cerrando la aplicación");
    }


}
