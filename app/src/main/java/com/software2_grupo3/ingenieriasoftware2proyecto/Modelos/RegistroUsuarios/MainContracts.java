package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios;

public interface MainContracts {

    interface View{
        void mostrarMensaje(String mensaje);

    }

    interface Presentador{
        void enBotonPresionado(String cedula, String correo, String direccion, String fechaNacimiento, String password, String tarjeta, String telefono, String usuario, String nombre);
        void enInsertarExitoso(String data);
        void enInsertarFallido(String error);

    }

    interface  Interactor{
        void insertarRegistro(String cedula, String correo, String direccion, String fechaNacimiento, String password, String tarjeta, String telefono, String usuario, String nombre);

    }


}
