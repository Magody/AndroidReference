package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios;

public interface RegistrarClienteCodigoContracts {

    interface View{
        void mostrarMensaje();
    }

    interface Presentador{
        int botonAceptarCodigo(String codigoVerificacion, String cedula);
        void aceptarExitoso(String mensaje);
        void aceptarFallido(String error);

    }

    interface Interactor{
        int aceptarCodigo(String codigoVerificacion, String cedula);


    }



}
