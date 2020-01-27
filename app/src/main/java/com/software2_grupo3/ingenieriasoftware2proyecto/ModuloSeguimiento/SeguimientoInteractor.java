package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.content.Context;
import android.util.Log;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiClient;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiInterface;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Pedido;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeguimientoInteractor implements SeguimientoContracts.Interactor {

    public static final String TAG = "SeguimientoInteractor";

    Context context;

    SeguimientoContracts.Presentador callbackSeguimientoPresentador;

    public SeguimientoInteractor(SeguimientoContracts.Presentador callbackSeguimientoPresentador, Context context) {
        this.context = context;
        this.callbackSeguimientoPresentador = callbackSeguimientoPresentador;
    }


    @Override
    public void generarCodigo() {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Pedido> call = apiInterface.generarCodigo("JJM", "admin", 1);
        call.enqueue(new Callback<Pedido>() {
            @Override
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                if (response.isSuccessful() && response.body() != null) {
                    final Pedido pedido = response.body();
                    callbackSeguimientoPresentador.generarExitoso("ID: " + pedido.id);
                } else {
                    callbackSeguimientoPresentador.generarFallido(context.getString(R.string.debugMsg));
                }
            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                callbackSeguimientoPresentador.generarFallido(t.toString());
                Log.e(TAG, "generarCodigo: onFailure" + t.toString());
            }
        });
    }
}
