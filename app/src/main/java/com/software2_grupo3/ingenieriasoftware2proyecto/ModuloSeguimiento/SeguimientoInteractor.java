package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloSeguimiento;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiClient;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiInterface;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Pedido;
import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloAdministracion.Parametros;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.util.Log.e;
import static android.util.Log.i;

public class SeguimientoInteractor implements SeguimientoContracts.Interactor {

    public static final String TAG = "SeguimientoInteractor";

    Context context;

    SeguimientoContracts.Presentador callbackSeguimientoPresentador;

    private int id;

    public SeguimientoInteractor(SeguimientoContracts.Presentador callbackSeguimientoPresentador, Context context) {
        this.context = context;
        this.callbackSeguimientoPresentador = callbackSeguimientoPresentador;

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        id = sharedPreferences.getInt(Parametros.DIRECTORIO_CODIGO, 8);

        hiloEstado.start();
    }

    Thread hiloEstado = new Thread(new Runnable() {
        @Override
        public void run() {


            try {
                consultarEstado();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    @Override
    public void consultarEstado() {


        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Pedido> call = apiInterface.consultarEstadoPedido(id);
        call.enqueue(new Callback<Pedido>() {
        	@Override
        	public void onResponse(@NonNull Call<Pedido> call, @NonNull Response<Pedido> response) {

        		if(response.isSuccessful() && response.body() != null){

        			final Pedido pedido = response.body();

                    i(TAG, "onResponse: " + response.body());
        			callbackSeguimientoPresentador.enConsultaEstadoExitoso(pedido.estado);


        		}else{
                    e(TAG, "onResponse: " + " Error con null");
                }
        	}

        	@Override
        	public void onFailure(@NonNull Call<Pedido> call,@NonNull Throwable t) {
                callbackSeguimientoPresentador.enConsultaEstadoFallido(t.toString());
        		e(TAG, t.toString());
        	}
        });



    }


}
