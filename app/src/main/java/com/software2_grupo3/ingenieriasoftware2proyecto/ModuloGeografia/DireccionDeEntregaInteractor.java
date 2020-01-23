package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloGeografia;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Cliente;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiClient;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiInterface;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.GestorDeErrores;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Respuesta;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Validacion;
import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloAdministracion.Parametros;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.util.Log.i;

public class DireccionDeEntregaInteractor implements DireccionDeEntregaContracts.Interactor {

    private static final String TAG = "DirEntregaInteractor";

    private Context mContext;
    private Cliente cliente;

    private DireccionDeEntregaContracts.Presenter mapaDirCallbackPresenter;

    public DireccionDeEntregaInteractor(DireccionDeEntregaContracts.Presenter presenter, Context mContext){
        this.mapaDirCallbackPresenter = presenter;
        this.mContext = mContext;

        //TODO: cambiar esto cuando se cree la autenticación de usuario, sino jalar de SharedPreferences
        cliente = new Cliente("admin", "meliodasfistery@gmail.com");


    }

    @Override
    public void actualizarPosicionPreferida(final double latitud, final double longitud) {


        i(TAG, "actualizarPosicionPreferida: " + "latitud: "+ latitud + " longitud:"+longitud);


        if(!Validacion.puntoDentroDeQuito(latitud, longitud)){
            mapaDirCallbackPresenter.enActualizarPosicionPFallido(mContext.getString(R.string.msgFueraDeLosLimitesDeQuito));
            return;
        }


        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Respuesta> call = apiInterface.actualizarLatitudLongitudPreferidas(cliente.getUsuario(), latitud, longitud);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(@NonNull Call<Respuesta> call, @NonNull Response<Respuesta> response) {

                if(response.isSuccessful() && response.body() != null){

                    Respuesta respuesta = response.body();

                    i(TAG, "actualizarPosicionPreferida: onResponse: " + respuesta);

                    if(respuesta.getCodigo() == Parametros.CODIGO_MENSAJE_CORRECTO){
                        // se realizó correctamente
                        cliente.setLatitud_preferida(latitud);
                        cliente.setLongitud_preferida(longitud);
                        //todo: actualizar el usuario con la nueva posicion preferida en SharedPreference



                        mapaDirCallbackPresenter.enActualizarPosicionPExitoso(mContext.getString(R.string.msgUbicacionActualizada));

                    }else if(respuesta.getCodigo() == Parametros.CODIGO_MENSAJE_ERROR_SERVIDOR){
                        // se realizó correctamente
                        mapaDirCallbackPresenter.enActualizarPosicionPFallido(respuesta.getMensaje());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Respuesta> call,@NonNull Throwable t) {
                mapaDirCallbackPresenter.enActualizarPosicionPFallido(GestorDeErrores.obtenerMensajeAPartirDeError(t));
                Log.e(TAG, "actualizarPosicionPreferida: onFailure: " + t.toString());
            }
        });
    }


}
