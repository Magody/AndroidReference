package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.common.api.Response;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Cliente;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiClient;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiInterface;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.callback.Callback;

import retrofit2.Call;



public class MainInteractor extends MainRegistrarCliente implements MainContracts.Interactor {

    public static final String TAG = "MainInteractor";

    Context context;

    MainContracts.Presentador callbackMainPresenter;
    MainRegistrarCliente mainRegistrarCliente = new MainRegistrarCliente();

    public MainInteractor(MainContracts.Presentador callbackMainPresenter, Context context){
        this.context = context;
        this.callbackMainPresenter = callbackMainPresenter;
    }


    @Override
    public void insertarRegistro() {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Cliente> call;
        //call = apiInterface.crearCliente("Pepe", "pepe@dg.com", "185448562", "Pedro", "Ecuador", "099656547", "1545478854", 1999-08-08);

        call = apiInterface.crearCliente(txtUser.getText(), txtCorreo.getText(), txtcedula.getText(), txtNombre.getText(), txtdireccion.getText(), txttelefono.getText(), txttarjeta.getText(), txtfechanacimiento.getText());


        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(@NonNull Call<Cliente> call, @NonNull Response<Cliente> response) {

                if(response.isSuccesfull() && response.body() != null){

                    final Cliente cliente = response.body();

                    callbackMainPresenter.enInsertarExitoso("ID: " + cliente.id);

                }else{
                    callbackMainPresenter.enInsertarFallido(context.getString(R.string.textoDebug));
                }

            }

            @Override
            public void onFailure(@NonNull Call<Cliente> call, @NonNull Throwable t) {
                callbackMainPresenter.enInsertarExitoso(t.toString());
                Log.e(TAG, "insertarRegistrodeCliente: onFailure" + t.toString());
            }

        });



    }
}
