package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloEntregador;

public interface EntregadorContracts {

    interface View{
        void mostrarMensaje(String mensaje);
        void mostrarMainActivity();
    }

    interface Presentador{
        void botonAceptarRegistro(String nombre,
                                  String cedula,
                                  String correo,
                                  String fechanacimiento,
                                  String telefono,
                                  String usuario,
                                  String pwd);
        void enRegistroExitoso(String mensaje);
        void enRegistroFallido(String error);
    }

    interface Interactor{
        void aceptarRegistro(String nombre,
                             String cedula,
                             String correo,
                             String fechanacimiento,
                             String telefono,
                             String usuario,
                             String pwd);
    }
}