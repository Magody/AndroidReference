package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiClient;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiInterface;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Pedido;
import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloAdministracion.Parametros;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarritoInteractor implements CarritoContracts.Interactor {

    public static final String TAG = "CarritoInteractor";

    private Context mContext;

    private CarritoContracts.Presentador carritoCallbackPresenter;

    public CarritoInteractor(CarritoContracts.Presentador presenter, Context mContext){
        this.carritoCallbackPresenter = presenter;
        this.mContext = mContext;
    }

    @Override
    public void generarCodigo() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Pedido> call = apiInterface.generarCodigo("BBB", "admin", 0);
        call.enqueue(new Callback<Pedido>() {
            @Override
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                if (response.isSuccessful() && response.body() != null) {
                    final Pedido pedido = response.body();
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt(Parametros.DIRECTORIO_CODIGO, pedido.id);
                    editor.apply();

                    carritoCallbackPresenter.generarExitoso("Codigo: " + pedido.id);

                } else {
                    carritoCallbackPresenter.generarFallido(mContext.getString(R.string.debugMsg));
                }
            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                carritoCallbackPresenter.generarFallido(t.toString());
                Log.e(TAG, "generarCodigo: onFailure" + t.toString());
            }
        });
    }
}
