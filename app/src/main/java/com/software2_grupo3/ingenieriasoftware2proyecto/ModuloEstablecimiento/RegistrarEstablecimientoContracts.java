package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloEstablecimiento;

public interface RegistrarEstablecimientoContracts {

    interface View{
        void mostrarMensaje(String mensaje);
        void navegarComprobacionCorreo();

    }

    interface Presentador{
        void enBotonPresionado(String RUC, String nombre, String password, String direccion, String telefonoFijo, String cuentaBancaria, String correo);
        void enInsertarExitoso(String data);
        void enInsertarFallido(String error);
    }

    interface  Interactor{

        void insertarRegistroEstablecimiento(String RUC, String nombre, String password, String direccion, String telefonoFijo, String cuentaBancaria, String correo);


    }


}
