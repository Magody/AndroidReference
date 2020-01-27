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

public class CambiarEstadosInteractor implements CambiarEstadosContracts.Interactor {

    public static final String TAG = "CambiarEstadosInteractor";

    private Context mContext;

    private CambiarEstadosContracts.Presentador cambiarEstadosCallbackPresenter;

    public CambiarEstadosInteractor(CambiarEstadosContracts.Presentador cambiarEstadosCallbackPresenter, Context mContext){
        this.cambiarEstadosCallbackPresenter = cambiarEstadosCallbackPresenter;
        this.mContext = mContext;
    }


    @Override
    public void cambiarEstado(int id, int estado) {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Pedido> call = apiInterface.cambiarEstado(id, estado);
        call.enqueue(new Callback<Pedido>() {
            @Override
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                if (response.isSuccessful() && response.body() != null) {
                    final Pedido pedido = response.body();
                    cambiarEstadosCallbackPresenter.enCambiarEstadoExitoso(pedido.codigo);
                }
            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                cambiarEstadosCallbackPresenter.enCambiarEstadoFallido(t.toString());
                Log.e(TAG, "cambiarAtendido: onFailure" + t.toString());
            }
        });
    }
}
