package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.actualizarUsuario;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Cliente;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiClient;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiInterface;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActualizarInteractor extends ActualizarUsuarioActivity implements ActualizarContracts.Interactor{


    public static final String TAG  = "ActualizarInteractor";

    Context context;
    ActualizarContracts.Presentador callbackActualizarPresenter;

    public ActualizarInteractor(ActualizarContracts.Presentador callbackActualizarPresenter, Context context){
        this.context = context;
        this.callbackActualizarPresenter= callbackActualizarPresenter;
    }

    @Override
    public void actualizarRegistro(final String cedula, String correo, String direccion, String fechaNacimiento, String password, String tarjeta, String telefono, String usuario, String nombre) {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Cliente> call;
        //call = apiInterface.crearCliente("JUAN", "pepe@dg.com", "185448562", "Pedro", "Ecuador", "099656547", "1545478854", "1999-08-08");
        call = apiInterface.crearCliente(usuario, correo, cedula, nombre, direccion, telefono, tarjeta, fechaNacimiento, password);

        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if(response.isSuccessful() && response.body() != null){

                    final Cliente cliente = response.body();

                    callbackActualizarPresenter.enInsertarExitoso("cedula: " + cliente.cedula);

                    Log.i(TAG,"onRespnse: "+cedula);

                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                    SharedPreferences.Editor editor= sharedPreferences.edit();

                    //editor.putString(key,value);

                    editor.apply();
                }else{
                    callbackActualizarPresenter.enInsertarFallido(context.getString(R.string.textoDebug));
                }

            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                callbackActualizarPresenter.enInsertarExitoso(t.toString());
                Log.e(TAG, "insertarRegistrodeCliente: onFailure" + t.toString());
            }
        });
    }
}
