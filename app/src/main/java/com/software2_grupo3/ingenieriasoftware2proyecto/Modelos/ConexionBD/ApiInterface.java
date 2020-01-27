package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.ConexionBD;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Cliente;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Respuesta;
import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloAdministracion.Parametros;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {



    //MóduloGeografia
    @FormUrlEncoded
    @POST(Parametros.DIRECTORIO_PROYECTO +Parametros.DIRECTORIO_MODULO_GEOGRAFIA+"actualizarLatitudLongitudPreferidas.php")
    Call<Respuesta> actualizarLatitudLongitudPreferidas(@Field("usuario") String clienteUsuario,
                                                        @Field("latitudPreferida") double clienteLatitudPreferida,
                                                        @Field("longitudPreferida") double clienteLongitudPreferida);

    @FormUrlEncoded
    @POST("registrarCli.php")
    Call<Cliente> crearCliente(@Field("usuario") String usuario,
                               @Field("correo") String correo,
                               @Field("cedula") String cedula,
                               @Field("nombre") String nombre,
                               @Field("direccion") String direccion,
                               @Field("telefono") String telefono,
                               @Field("tarjeta") String tarjeta,
                               @Field("fechaNacimiento") String fechaNacimiento,
                               @Field("password") String password);



    /*
    @FormUrlEncoded
    @POST(Parametros.DIRECTORIO_PROYECTO +Parametros.DIRECTORIO_MODULO_TEST+"crearPersona.php")
    Call<Respuesta> crearPersona(@Field("personaNombre") String personaNombre);

    @FormUrlEncoded
    @POST(Parametros.DIRECTORIO_PROYECTO +Parametros.DIRECTORIO_MODULO_TEST+"leerPersona.php")
    Call<Persona> leerPersona(@Field("personaId") int personaId);

    @FormUrlEncoded
    @POST(Parametros.DIRECTORIO_PROYECTO +Parametros.DIRECTORIO_MODULO_TEST+"actualizarPersona.php")
    Call<Respuesta> actualizarPersona(@Field("personaId") int personaId,
                                      @Field("personaNuevoNombre") String personaNuevoNombre);

    @FormUrlEncoded
    @POST(Parametros.DIRECTORIO_PROYECTO +Parametros.DIRECTORIO_MODULO_TEST+"borrarPersona.php")
    Call<Respuesta> eliminarPersona(@Field("personaId") int personaId);

    @GET(Parametros.DIRECTORIO_PROYECTO +Parametros.DIRECTORIO_MODULO_TEST+"leerTodasLasPersonas.php")
    Call<List<Persona>> leerTodasLasPersonas();
    */

}
