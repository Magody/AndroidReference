package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD;

import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloAdministracion.Parametros;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static Retrofit retrofit;

    public static Retrofit getApiClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Parametros.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
