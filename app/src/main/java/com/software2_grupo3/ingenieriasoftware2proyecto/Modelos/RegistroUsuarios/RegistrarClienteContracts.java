package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios;

public interface RegistrarClienteContracts {

    interface View{
        void mostrarMensaje(String mensaje);
        void navegarMainActivity();

        void navegarRegistrarClienteCodigoActivity();
    }

    interface Presentador{
        void enBotonPresionado(String cedula, String correo, String direccion, String fechaNacimiento, String password, String tarjeta, String telefono, String usuario, String nombre, String codigoVerificacion);

        void enInsertarExitoso(String data);
        void enInsertarFallido(String error);

    }

    interface  Interactor{

        void insertarRegistro(String cedula, String correo, String direccion, String fechaNacimiento, String password, String tarjeta, String telefono, String usuario, String nombre, String codigoVerificacion);


    }


}
