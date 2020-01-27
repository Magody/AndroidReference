package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.RegistroUsuarios;

public interface MainContracts {

    interface View{
        void mostrarMensaje(String mensaje);

    }

    interface Presentador{
        void enBotonPresionado();
        void enInsertarExitoso(String data);
        void enInsertarFallido(String error);

    }

    interface  Interactor{
        void insertarRegistro();

    }


}
