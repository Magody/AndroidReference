package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios;

public interface RegistrarClienteCodigoContracts {

    interface View{
        void mostrarMensaje(String mensaje);
        void navegarMainActivity();
    }

    interface Presentador{
        void botonAceptarCodigo(String codigoVerificacion, String cedula);
        void aceptarExitoso(String mensaje);
        void aceptarFallido(String error);

    }

    interface Interactor{
        void aceptarCodigo(String codigoVerificacion, String cedula);


    }



}
