package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloEstablecimiento;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiClient;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiInterface;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Respuesta;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Validacion;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.util.Log.i;

public class RegistrarEstablecimientoInteractor implements RegistrarEstablecimientoContracts.Interactor {

    public static final String TAG = "REInteractor";

    private Context mContext;

    private RegistrarEstablecimientoContracts.Presentador classCallbackPresenter;

    public RegistrarEstablecimientoInteractor(RegistrarEstablecimientoContracts.Presentador presenter, Context mContext){
        this.classCallbackPresenter = presenter;
        this.mContext = mContext;
    }



    @Override
    public void insertarRegistroEstablecimiento(String RUC, String nombre, String password, String direccion, String telefonoFijo, String cuentaBancaria, String correo) {

        String[]campos = new String[]{RUC, nombre, password, direccion, telefonoFijo, cuentaBancaria, correo};
        if(!Validacion.camposLlenos(campos)){
            classCallbackPresenter.enInsertarFallido(mContext.getString(R.string.msgExistenCamposVacios));
            return;
        }

        if(!Validacion.esRUCValido(RUC)){
            classCallbackPresenter.enInsertarFallido("RUC inválida");
            return;
        }

        if(!Validacion.esCorreoValido(correo)){
            classCallbackPresenter.enInsertarFallido("Correo inválido");
            return;
        }

        if(!Validacion.estaLongitudStringEnRango(direccion, 3, 50)){
            classCallbackPresenter.enInsertarFallido("La dirección no debe ser mayor a 50 caracteres ni menor a 3");
            return;
        }

        if(!Validacion.estaLongitudStringEnRango(password, 3, 16)){
            classCallbackPresenter.enInsertarFallido("La contraseña no debe ser mayor a 16 caracteres ni menor a 3");
            return;
        }

        if(!Validacion.esTelefonoConvencionalValido(telefonoFijo)){
            classCallbackPresenter.enInsertarFallido("El teléfono no parece ser válido");
            return;
        }

        if(!Validacion.estaLongitudStringEnRango(nombre, 3, 50)){
            classCallbackPresenter.enInsertarFallido("El Nombre no debe ser mayor a 50 caracteres ni menor a 2");
            return;
        }


        if(!Validacion.esTarjetaValida(cuentaBancaria)){
            classCallbackPresenter.enInsertarFallido("La tarjeta es inválida");
            return;
        }



        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Respuesta> call = apiInterface.registrarEstablecimiento(RUC, nombre, password, direccion, telefonoFijo, cuentaBancaria, correo);
        call.enqueue(new Callback<Respuesta>() {
        	@Override
        	public void onResponse(@NonNull Call<Respuesta> call, @NonNull Response<Respuesta> response) {

        		if(response.isSuccessful() && response.body() != null){

        			final Respuesta data = response.body();
                    i(TAG, "onResponse: " + data);

                    classCallbackPresenter.enInsertarExitoso("Ingreso exitoso. Confirme el correo");


        		}
        	}

        	@Override
        	public void onFailure(@NonNull Call<Respuesta> call, @NonNull Throwable t) {
                classCallbackPresenter.enInsertarFallido(t.toString());
        		Log.e(TAG, t.toString());
        	}
        });
    }
}
