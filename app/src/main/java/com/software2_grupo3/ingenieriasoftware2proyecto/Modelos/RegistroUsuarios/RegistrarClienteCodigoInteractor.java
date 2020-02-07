package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Cliente;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiClient;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiInterface;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrarClienteCodigoInteractor implements RegistrarClienteCodigoContracts.Interactor{

    public static final String TAG = "RegistrarClienteCodigoInteractor";
    Context context;

    RegistrarClienteCodigoContracts.Presentador callbackRegistrarClienteCodigoPresentador;

    public RegistrarClienteCodigoInteractor(RegistrarClienteCodigoContracts.Presentador callbackRegistrarClienteCodigoPresentador, Context context ){
        this.context = context;
        this.callbackRegistrarClienteCodigoPresentador = callbackRegistrarClienteCodigoPresentador;

    }


    @Override
    public int aceptarCodigo(String codigoVerificacion, String cedula) {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        final int[] resultado = new int[1]; //probar

        Call<Cliente> call;
        call = apiInterface.crearCodigoCliente(codigoVerificacion, cedula);


        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if (response.isSuccessful() && response.body() != null) {

                    final Cliente cliente = response.body();

                    callbackRegistrarClienteCodigoPresentador.aceptarExitoso("Correo Verificado");
                    resultado[0] = 1;//probar


                } else {
                    callbackRegistrarClienteCodigoPresentador.aceptarFallido(context.getString(R.string.textoDebug));
                    resultado[0] = 0; //probar
                }

            }



            @SuppressLint("LongLogTag")
            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                callbackRegistrarClienteCodigoPresentador.aceptarFallido(t.toString());
                Log.e(TAG, "RegistrarClienteCodigoInteractor: Onfailure" + t.toString());
            }
        });

        return resultado[0];
    }
}
