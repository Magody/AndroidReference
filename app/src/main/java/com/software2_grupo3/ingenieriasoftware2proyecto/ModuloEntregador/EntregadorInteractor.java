package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloEntregador;

import android.content.Context;
import android.util.Log;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiClient;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiInterface;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Entregador;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntregadorInteractor implements EntregadorContracts.Interactor {

    public static final String TAG = "EntregadorInteractor";
    Context context;
    EntregadorContracts.Presentador callbackEntregadorPresentador;

    public EntregadorInteractor(EntregadorContracts.Presentador callbackEntregadorPresentador, Context context) {
        this.context = context;
        this.callbackEntregadorPresentador = callbackEntregadorPresentador;
    }

    @Override
    public void aceptarRegistro(String nombre, String cedula, String correo, String fechanacimiento, String telefono, String usuario, String pwd) {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Entregador> call;
        call = apiInterface.registrarEntregador(nombre, correo, cedula, telefono, fechanacimiento, usuario, pwd);
        call.enqueue(new Callback<Entregador>() {
            @Override
            public void onResponse(Call<Entregador> call, Response<Entregador> response) {
                if (response.isSuccessful() && response.body() != null) {

                    //final Entregador entregador = response.body();
                    callbackEntregadorPresentador.enRegistroExitoso("cedula: ");

                } else {
                    callbackEntregadorPresentador.enRegistroFallido(context.getString(R.string.textoDebug));
                }
            }

            @Override
            public void onFailure(Call<Entregador> call, Throwable t) {
                callbackEntregadorPresentador.enRegistroFallido(t.toString());
                Log.e(TAG, "insertarRegistrodeEntregador: onFailure " + t.toString());
            }
        });
    }
}
