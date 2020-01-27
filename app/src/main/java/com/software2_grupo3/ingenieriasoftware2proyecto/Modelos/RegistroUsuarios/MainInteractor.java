package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios;

import android.content.Context;
import android.util.Log;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Cliente;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiClient;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD.ApiInterface;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainInteractor extends MainRegistrarCliente implements MainContracts.Interactor {

    public static final String TAG = "MainInteractor";

    Context context;

    MainContracts.Presentador callbackMainPresenter;
    //MainRegistrarCliente mainRegistrarCliente = new MainRegistrarCliente();

    public MainInteractor(MainContracts.Presentador callbackMainPresenter, Context context){
        this.context = context;
        this.callbackMainPresenter = callbackMainPresenter;
    }


    @Override
    public void insertarRegistro() {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Cliente> call;
        //call = apiInterface.crearCliente("Pepe", "pepe@dg.com", "185448562", "Pedro", "Ecuador", "099656547", "1545478854", 1999-08-08);
        call = apiInterface.crearCliente(txtUser.getText().toString(), txtCorreo.getText().toString(), txtcedula.getText().toString(), txtNombre.getText().toString(), txtdireccion.getText().toString(), txttelefono.getText().toString(), txttarjeta.getText().toString(), txtfechanacimiento.getText().toString());

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
