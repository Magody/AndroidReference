package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos;

public class GestorDeErrores {


    public static String obtenerMensajeAPartirDeError(Throwable throwable){
        //todo: comprobar si es JSON Exception, SocketException, etc y dar un mensaje adecuado

        return throwable.toString();


    }



}
