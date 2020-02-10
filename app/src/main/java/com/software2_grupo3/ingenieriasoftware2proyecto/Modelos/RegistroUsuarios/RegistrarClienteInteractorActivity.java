package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios;

import android.content.Context;
import android.util.Log;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Cliente;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiClient;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiInterface;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Validacion;

import com.software2_grupo3.ingenieriasoftware2proyecto.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrarClienteInteractorActivity extends RegistrarClienteActivity implements RegistrarClienteContracts.Interactor {


    public static final String TAG = "ReInteractorActivity";


    Context context;

    RegistrarClienteContracts.Presentador callbackMainPresenter;
    RegistrarClienteActivity registrarClienteActivity = new RegistrarClienteActivity();

    public RegistrarClienteInteractorActivity(RegistrarClienteContracts.Presentador callbackMainPresenter, Context context){
        this.context = context;
        this.callbackMainPresenter = callbackMainPresenter;
    }


    @Override

    public void insertarRegistro(String cedula, String correo, String direccion, String fechaNacimiento,
                                 String password, String tarjeta, String telefono, String usuario,
                                 String nombre, String codigoVerificacion) {
        String[]campos = new String[]{cedula, correo, direccion, fechaNacimiento, password, tarjeta, telefono, usuario, nombre};
        if(!Validacion.camposLlenos(campos)){
            callbackMainPresenter.enInsertarFallido(context.getString(R.string.msgExistenCamposVacios));
            return;
        }

        if(!Validacion.esCedulaValida(cedula)){
            callbackMainPresenter.enInsertarFallido("Cédula inválida");
            return;
        }

        if(!Validacion.esCorreoValido(correo)){
            callbackMainPresenter.enInsertarFallido("Correo inválido");
            return;
        }

        if(!Validacion.estaLongitudStringEnRango(direccion, 3, 50)){
            callbackMainPresenter.enInsertarFallido("La dirección no debe ser mayor a 50 caracteres ni menor a 3");
            return;
        }

        if(!Validacion.esFechaDeNacimientoValida(fechaNacimiento)){
            callbackMainPresenter.enInsertarFallido("La fecha de nacimiento es inválida");
            return;
        }

        if(!Validacion.estaLongitudStringEnRango(password, 3, 16)){
            callbackMainPresenter.enInsertarFallido("La contraseña no debe ser mayor a 16 caracteres ni menor a 3");
            return;
        }

        if(!Validacion.esTelefonoConvencionalValido(telefono)){
            callbackMainPresenter.enInsertarFallido("El teléfono no parece ser válido");
            return;
        }

        if(!Validacion.estaLongitudStringEnRango(usuario, 3, 16)){
            callbackMainPresenter.enInsertarFallido("El usuario no debe ser mayor a 16 caracteres ni menor a 3");
            return;
        }

        if(!Validacion.esNombreApellidoValido(nombre)){
            callbackMainPresenter.enInsertarFallido("El nombre no debe ser mayor a 50 caracteres ni menor a 3");
            return;
        }

        if(!Validacion.esTarjetaValida(tarjeta)){
            callbackMainPresenter.enInsertarFallido("La tarjeta es inválida");
            return;
        }


        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Cliente> call;
        //call = apiInterface.crearCliente("JUANJO", "pepe@dg.com", "185448562", "Pedro", "Ecuador", "099656547", "1545478854", "1999-08-08", "intel", "0000");
        call = apiInterface.crearCliente(usuario, correo, cedula, nombre, direccion, telefono, tarjeta, fechaNacimiento, password, "0000");




        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if(response.isSuccessful() && response.body() != null){

                    final Cliente cliente = response.body();

                    callbackMainPresenter.enInsertarExitoso("cedula: " + cliente.cedula);

                }else{
                    callbackMainPresenter.enInsertarFallido(context.getString(R.string.textoDebug));
                }

            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                callbackMainPresenter.enInsertarExitoso(t.toString());
                Log.e(TAG, "insertarRegistrodeCliente: onFailure" + t.toString());
            }
        });



    }
}
